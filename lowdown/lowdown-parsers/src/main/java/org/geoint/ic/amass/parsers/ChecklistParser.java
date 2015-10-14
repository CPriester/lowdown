package org.geoint.ic.amass.parsers;

import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.geoint.ic.iadataprocessor.api.checklist.Checklist;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.geoint.ic.iadataprocessor.api.checklist.CheckListAsset;
import org.geoint.ic.iadataprocessor.api.checklist.StigData;
import org.geoint.ic.iadataprocessor.api.checklist.StigInformation;
import org.geoint.ic.iadataprocessor.api.checklist.Vulnerabilities;
import org.geoint.ic.iadataprocessor.api.objects.DocumentId;
import org.geoint.ic.iadataprocessor.api.objects.ExcelFormat;

/**
 *
 *
 */
public class ChecklistParser {

    private final static Logger logger = Logger.getLogger(ChecklistParser.class.getName());
    private File fileResult;
    private Checklist checklist;
    Map<String, String> config;
    private ChecklistDetails detailed;
    private List<ExcelFormat> detailedData = new ArrayList<>();
    private List<Vulnerabilities> vulnerabilities = new ArrayList<>();
    private Map<String, DocumentId> dedupe = new HashMap<>();

    public ChecklistParser() {

    }

    public List<ExcelFormat> filterFile(File file) {
                detailed = new ChecklistDetails(detailedData, dedupe);

        try {
            Files.walkFileTree(file.toPath(), new SimpleFileVisitor<Path>() {

                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                    fileResult = file.toFile();
                    if (fileResult.getAbsolutePath().endsWith(".ckl")) {

                        try {

                            SAXParserFactory factory = SAXParserFactory.newInstance();
                            SAXParser saxParser = factory.newSAXParser();
                            SaxHandler handler = new SaxHandler();
                            saxParser.parse(fileResult, handler);
                            checklist = handler.getChecklist();
                            detailed.processData(checklist, fileResult.getAbsolutePath());

                        } catch (IOException | SAXException | ParserConfigurationException ex) {
                            System.out.println("ex" + ex);
                            Checklist obj = new Checklist();
                            obj.setStatus(Checklist.Status.UNABLE_TO_PROCESS);
                            obj.setFile(file.getFileName().toString());
                            // templists.add(obj.toStrindetailedDatag());
                            logger.log(Level.SEVERE, "JAXB ExceptionProblem parsing file"
                                    + fileResult.getAbsolutePath(), ex);
                        }
                    }
                    return FileVisitResult.CONTINUE;
                }
            });

        } catch (IOException ex) {
            System.out.println("unmarshalling faiiled" + ex);
            logger.log(Level.SEVERE, "Failed to parse directory"
                    + file.getAbsolutePath() + "   "
                    + ex.getMessage() + "  " + ex.getCause().getMessage(), ex);
        }
            
      
        return detailedData;
                
    }

    /**
     *
     */
    public class SaxHandler extends DefaultHandler {

        private final StringBuilder tempVal = new StringBuilder();        // XML tag names
        private static final String CHECKLIST = "CHECKLIST", SV_VERSION = "SV_VERSION",
                ASSET = "ASSET", ASSET_TYPE = "ASSET_TYPE", HOST_NAME = "HOST_NAME",
                HOST_IP = "HOST_IP", HOST_MAC = "HOST_MAC", HOST_GUID = "HOST_GUID", ASSET_VAL = "ASSET_VAL",
                TARGET_KEY = "TARGET_KEY", STIG_INFO = "STIG_INFO", STIG_TITLE = "STIG_TITLE",
                VULN = "VULN", STIG_DATA = "STIG_DATA", VULN_ATTRIBUTE = "VULN_ATTRIBUTE",
                ATTRIBUTE_DATA = "ATTRIBUTE_DATA", STATUS = "STATUS",
                FINDING_DETAILS = "FINDING_DETAILS", COMMENTS = "COMMENTS",
                SEVERITY_OVERRIDE = "SEVERITY_OVERRIDE", SEVERITY_JUSTIFICATION = "SEVERITY_JUSTIFICATION";

        private List<StigData> listStigs = new ArrayList<>();

        private Vulnerabilities currentVuln;
        private StigData currentStigData;

        CheckListAsset checklistAsset = new CheckListAsset();
        StigInformation stigInformation = new StigInformation();
        ExcelFormat exc = new ExcelFormat();

        @Override
        public void characters(char[] ch, int start, int length)
                throws SAXException {
            // add characters to the buffer

            tempVal.append(ch, start, length);
        }

        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            if (null != qName) {

                if (SV_VERSION.equals(qName)) {
                    checklist.setVersion(tempVal.toString());
                }

                if (ASSET_TYPE.equals(qName)) {
                    checklistAsset.setAssetType(tempVal.toString().trim());

                }
                if (ASSET_VAL.equals(qName)) {
                    checklistAsset.setAssetVal(tempVal.toString().trim());

                }
                if (HOST_GUID.equals(qName)) {
                    checklistAsset.setHostGuid(tempVal.toString().trim());
                }
                if (HOST_MAC.equals(qName)) {
                    checklistAsset.setHostMac(tempVal.toString().trim());
                }
                if (HOST_NAME.equals(qName)) {
                    checklistAsset.setHostName(tempVal.toString().trim());
                }
                if (TARGET_KEY.equals(qName)) {
                    checklistAsset.setTargetKey(tempVal.toString().trim());

                }
                checklist.setChecklistAsset(checklistAsset);

                if (STIG_TITLE.equals(qName)) {
                    stigInformation.setStigTitle(tempVal.toString().trim());

                }
                checklist.setStigInformatin(stigInformation);

                if (COMMENTS.equals(qName)) {
                    currentVuln.setComment(tempVal.toString().trim());

                }
                if (FINDING_DETAILS.equals(qName)) {
                    currentVuln.setFindingDetails(tempVal.toString().trim());
                }
                if (SEVERITY_JUSTIFICATION.equals(qName)) {
                    currentVuln.setSeverityJustification(tempVal.toString().trim());
                }
                if (STATUS.equals(qName)) {
                    currentVuln.setStatus(tempVal.toString().trim());

                }
                if (VULN_ATTRIBUTE.equals(qName)) {
                    currentStigData.setVulnAttribute(tempVal.toString().trim());
                }

                if (ATTRIBUTE_DATA.equals(qName)) {

                    currentStigData.setVulnData(tempVal.toString().trim());

                }

            }

        }

        @Override
        public void startElement(String uri, String localName,
                String qName, Attributes attributes) throws SAXException {
            tempVal.delete(0, tempVal.length());

            if (CHECKLIST.equals(qName)) {
                checklist = new Checklist();
                listStigs.clear();
            } else if (ASSET.equals(qName)) {
                checklistAsset = new CheckListAsset();
            } else if (STIG_INFO.equals(qName)) {

                stigInformation = new StigInformation();

            } else if (VULN.equals(qName)) {
                if (currentVuln == null) {
                    currentVuln = new Vulnerabilities();
                } else {
                    checklist.addVuln(currentVuln);
                    currentVuln = new Vulnerabilities();

                }
            } else if (STIG_DATA.equals(qName)) {
                if(currentStigData == null){
                currentStigData = new StigData();}else{
                    currentVuln.addStigData(currentStigData);
                    currentStigData = new StigData();
                    
                    
                
                }
            }

        }

        public Checklist getChecklist() {
            return checklist;

        }
    }

    public void initialize(Map<String, String> props) {
        this.config = props;
    }

}
