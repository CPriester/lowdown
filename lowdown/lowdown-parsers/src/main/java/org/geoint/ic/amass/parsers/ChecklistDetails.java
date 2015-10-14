
package org.geoint.ic.amass.parsers;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import org.geoint.ic.iadataprocessor.api.checklist.Checklist;
import org.geoint.ic.iadataprocessor.api.checklist.StigData;
import org.geoint.ic.iadataprocessor.api.checklist.Vulnerabilities;
import org.geoint.ic.iadataprocessor.api.objects.DocumentId;
import org.geoint.ic.iadataprocessor.api.objects.ExcelFormat;

/**
 *
 *
 */
public class ChecklistDetails {

    private final static Logger logger = Logger.getLogger(ChecklistDetails.class.getName());
    private Map<String, String> config;
    private String fileExtension = "org.geoint.ic.file.extension";
    private ExcelFormat obj = null;
    private Map<String, DocumentId> dedupe;
    private DocumentId docId = null;
    private List<ExcelFormat> detailedList;

    public ChecklistDetails(List<ExcelFormat> detailedList, Map<String, DocumentId> dedupe) {
        this.detailedList = detailedList;
        this.dedupe = dedupe;
    }

    public void processData(Checklist checklist, String fileName) {
        //Iterator iter = validData.iterator();

        for (Vulnerabilities vul : checklist.getVulnerabilities()) {
            obj = new ExcelFormat();
            docId = new DocumentId();

            for (StigData vulnNumber : vul.getStigdata()) {
                if (vulnNumber.getVulnAttribute().contains("Vuln_Num")) {
                    docId.setVulnerabilitie(vulnNumber.getVulnData());
                }
            
            if (vul.getStatus() != null) {
                docId.setStatus(vul.getStatus());
            }

            if (vul.getComment() != null) {
                docId.setComments(vul.getComment());
            }

            obj.addFile(fileName);

            obj.addMachineAffected(checklist.getChecklistAsset().getHostName());     

            if (dedupe.containsKey(fileName) == true && dedupe.containsValue(docId) == true) {
            } else {
                obj.setDocumentId(docId);
                obj.setIdentified_in_CFO_Audit_or_other_Review(checklist.getStigInformatin().getStigTitle());

                for (StigData severity : vul.getStigdata()) {
                    if (severity.getVulnAttribute().contains("Severity")) {
                        obj.setCategory(severity.getVulnData());
                    }
                }

                for (StigData ruleTitle : vul.getStigdata()) {
                    if (ruleTitle.getVulnAttribute().contains("Rule_Title")) {
                        obj.setWeakness(ruleTitle.getVulnData());
                    }
                }

                dedupe.put(fileName, docId);
                detailedList.add(obj);
            }
        }}

    }

    public void loadConfiguration(Map<String, String> props) {
        this.config = props;
    }

}
