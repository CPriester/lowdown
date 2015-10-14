package org.geoint.ic.amass.dataprocessor;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package org.geoint.ic.dataprocessor;
//
//import java.util.Map;
//import org.geoint.ic.iadataprocessor.api.checklist.Checklist;
//import org.geoint.ic.iadataprocessor.api.checklist.StigData;
//import org.geoint.ic.iadataprocessor.api.checklist.Vulnerabilities;
//import org.geoint.ic.iadataprocessor.api.objects.ExcelFormat;
//
///**
// *
// *
// */
//public class ChecklistSummary {
//
//    private Map<String, String> config;
//    private String fileExtension = "org.geoint.ic.file.extension";
//
//    public ChecklistSummary() {
//    }
//
//    public Map<String, ExcelFormat> processSummary(Checklist dd, Map<String, ExcelFormat> master) {
//        ExcelFormat obj = new ExcelFormat();
//        StringBuilder ss;
//        String statusId = new String();
//        String Vulnnu = new String();
//
//        for (Vulnerabilities vul : dd.getVulnerabilities()) {
//            ss = new StringBuilder();
//            for (StigData vulnNumber : vul.getStigdata()) {
//
//                if (vulnNumber.getVulnAttribute().contains("Vuln_Num")) {
//                    if (vulnNumber.getVulnData() != null) {
//                        ss.append(vulnNumber.getVulnData());
//                    }
//                    if (vul.getStatus() != null) {
//                        ss.append(vul.getStatus());
//                    }
//
//                    if (vul.getComment() != null) {
//                        ss.append(vul.getComment());
//                    }
//
//                    obj.setId(ss.toString());
//                    statusId = ss.toString();
//                }
//            }
//
//
//            if (master.keySet().contains(statusId)) {
//                ExcelFormat excFormat = (ExcelFormat) master.get(statusId);
//                obj.addMachineAffected(dd.getChecklistAsset().getHostName());
//                master.put(statusId, excFormat);
//            } else {
//
//                obj.setStatus(vul.getStatus());
//                obj.addMachineAffected(dd.getChecklistAsset().getHostName());
//                obj.addFile(dd.getFile());
//
//                for (StigData vulnNum : vul.getStigdata()) {
//                    if (vulnNum.getVulnAttribute().contains("Vuln_Num")) {
//                        obj.setVulnerabilities(vulnNum.getVulnData());
//                    }
//                }
//                for (StigData severity : vul.getStigdata()) {
//                    if (severity.getVulnAttribute().contains("Severity")) {
//                        obj.setCategory(severity.getVulnData());
//                    }
//                }
//
//                for (StigData ruleTitle : vul.getStigdata()) {
//                    if (ruleTitle.getVulnAttribute().contains("Rule_Title")) {
//                        obj.setWeakness(ruleTitle.getVulnData());
//
//                    }
//                }
//
//                if (vul.getComment() != null) {
//                    obj.setComments(vul.getComment());
//                }
//
//            }
//            master.put(statusId, obj);
//        }
//
//        return master;
//    }
//
//    public void loadConfiguration(Map<String, String> props
//    ) {
//        this.config = props;
//    }
//
//}
