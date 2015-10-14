package org.geoint.ic.amass.dataprocessor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.geoint.ic.iadataprocessor.api.objects.ExcelFormat;

public class DataInputParser {

    private final static Logger logger = Logger.getLogger(DataInputParser.class.getName());
    private String poam;
   
    public Map<String, ExcelFormat> processData(String poam) throws FileNotFoundException {
    this.poam = poam;
    

        FileInputStream fis = new FileInputStream(poam);
        try {
            fis = new FileInputStream(poam);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Row row;
            Cell cell;

            Iterator ite = sheet.rowIterator();
            while (ite.hasNext()) {
                row = (Row) ite.next();
                Iterator cells = row.cellIterator();
                while (cells.hasNext()) {

                    cell = (Cell) cells.next();
                    switch (cell.getCellType()) {

                        case Cell.CELL_TYPE_STRING:
                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                            break;
                        case Cell.CELL_TYPE_BLANK:
                            break;
                        case Cell.CELL_TYPE_BOOLEAN:
                            break;
                        case Cell.CELL_TYPE_ERROR:
                            break;
                        case Cell.CELL_TYPE_FORMULA:
                            break;

                    }

                }

            }

        } catch (FileNotFoundException ex) {
            logger.log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            logger.log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                logger.log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

}
