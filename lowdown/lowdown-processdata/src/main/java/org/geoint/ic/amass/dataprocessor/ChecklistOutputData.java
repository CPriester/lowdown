package org.geoint.ic.amass.dataprocessor;

import org.geoint.ic.iadataprocessor.spi.DataOutput;

import java.io.File;
import java.util.logging.Level;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.geoint.ic.iadataprocessor.api.objects.DocumentId;
import org.geoint.ic.iadataprocessor.api.objects.ExcelFormat;

/**
 *
 *
 */
public class ChecklistOutputData implements DataOutput {

    private final static Logger logger = Logger.getLogger(ChecklistOutputData.class.getName());
    private String outputFile;
    private List<ExcelFormat> outm;
    private String fileName = "checklists";
    private String fileExtension = ".xlsx";
    private Map<String, String> props;
    private final SXSSFWorkbook workbook = new SXSSFWorkbook(-1);
    private Cell cell;
    private Row row;
    private int cellNumber;
    private int rowNumber;

    private ChecklistOutputData() {
    }

    public ChecklistOutputData(String outputFile, List<ExcelFormat> outm) {
        this.outputFile = outputFile;
        this.outm = outm;

    }

    @Override
    public String outputData() {
        WriteDataToExcel(outm, "DetailedData");
        Collection<ExcelFormat> summary = summarizeData(outm);
        WriteDataToExcel(summary, "Summary");
        java.util.Date date = new java.util.Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HHmmss-SSSZ");
        sdf.format(date.getTime());
        String time = sdf.format(date.getTime());

        try (
                // open an OutputStream to save written data into Excel file
                FileOutputStream os = new FileOutputStream(new File(outputFile, (fileName + time + fileExtension)))) {
            workbook.write(os);
            os.close();
            workbook.dispose();
            logger.log(Level.INFO, "Writing on Excel file Finished ...");
        } catch (FileNotFoundException fe) {
            logger.log(Level.SEVERE, "Problem locating File", fe.getMessage());
        } catch (IOException ie) {
            logger.log(Level.SEVERE, ""
                    + "Problem adding records to excel", ie.getMessage());
        }

        return (fileName + time + fileExtension);
    }

    private void WriteDataToExcel(Collection<ExcelFormat> excFormat, String name) {
        cellNumber = 0;
        rowNumber = 0;
        Sheet sheet = workbook.createSheet(name);
        row = sheet.createRow(rowNumber++);

        createCell("Weakness");
        createCell("Category");
        createCell("POC");
        createCell("Resources_Required");
        createCell("Scheduled_Completion_Date");
        createCell("Milestones_With_Completion_Date");
        createCell("MileStone_Changes");
        createCell("Identified_in_CFO_Audit_or_other_Review");
        createCell("Status");
        createCell("Comments");
        createCell("Machines_Affected");
        createCell("Vulnerabilities");
        createCell("Mitigation_In_Place");
        createCell("Estimated_Cost_To_Fix");
        createCell("Type");
        createCell("file");

        for (int i = 0; i < rowNumber; i++) {
            sheet.autoSizeColumn(i);
            if (sheet.getColumnWidth(i) > 8000) {
                sheet.setColumnWidth(i, 8000);

            }
        }
        System.out.println("writing to excel    " + name);

        for (ExcelFormat obj : excFormat) {
            cellNumber = 0;
            row = sheet.createRow(rowNumber++);

            try {
                createCell(obj.getWeakness());
                createCell(obj.getCategory());
                createCell(obj.getPOC());
                createCell(obj.getResources_Required());
                createCell(obj.getScheduled_completion_date());
                createCell(obj.getMilestones_With_completion_Dates());
                createCell(obj.getMilestone_Changes());
                createCell(obj.getIdentified_in_CFO_Audit_or_other_Review());
                createCell(obj.getDocumentId().getStatus());
                createCell(obj.getDocumentId().getComments());

                StringBuilder machinesAffected = new StringBuilder();
                for (String s : (Set<String>) obj.getMachines_Affected()) {
                    machinesAffected.append(s).append(" ");
                }
                createCell(machinesAffected.toString());
                createCell(obj.getDocumentId().getVulnerabilitie());
                createCell(obj.getMitigation_in_place());
                createCell(obj.getEstimated_cost_to_fix());
                createCell(obj.getType());

                StringBuilder files = new StringBuilder();
                for (String s : (Set<String>) obj.getFiles()) {
                    files.append(s).append(" ");
                }
                createCell(files.toString());

                // manually control how rows are flushed to disk 
                if (rowNumber % 100 == 0) {
                    ((SXSSFSheet) sheet).flushRows(100); // retain 100 last rows and flush all others

                // ((SXSSFSheet)sh).flushRows() is a shortcut for ((SXSSFSheet)sh).flushRows(0),
                    // this method flushes all rows
                }

            } catch (Exception ex) {
                System.out.println("COULDN'T ADD TO EXCEL FILE" + ex);
                logger.log(Level.SEVERE, null, ex);
            }
        }

        System.out.println("finished with detailed data");
    }

    private void createCell(String string) {
        cell = row.createCell(cellNumber++);
        cell.setCellValue(string);
    }

    public Collection<ExcelFormat> summarizeData(List<ExcelFormat> summarize) {
        ExcelFormat excelFormat;

        Map<DocumentId, ExcelFormat> summary = new HashMap<>();
        for (ExcelFormat ee : summarize) {

            if (summary.containsKey(ee.getDocumentId())) {
                excelFormat = summary.get(ee.getDocumentId());
                for (String s : ee.getMachines_Affected()) {
                    excelFormat.addMachineAffected(s);
                }

                for (String s : ee.getFiles()) {
                    excelFormat.addFile(s);
                }
                summary.put(excelFormat.getDocumentId(), excelFormat);
            } else {
                summary.put(ee.getDocumentId(), ee);
            }

        }
        return summary.values();
    }

    @Override
    public void initialize(Map<String, String> props) {
        this.props = props;
    }

}
