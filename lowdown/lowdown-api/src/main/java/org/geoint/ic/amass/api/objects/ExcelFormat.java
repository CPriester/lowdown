
package org.geoint.ic.amass.api.objects;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *The data required for the current POAM Format. This
 * may be subject to Change to include or exclude additional
 * fields in the future. 
 * 
 */
public class ExcelFormat implements Serializable{

    private DocumentId documentId;    
    private Set<String> files;
    private Set<String> machines_Affected;
    private String weakness;
    private String category;
    private String POC;
    private String resources_Required;
    private String scheduled_completion_date;
    private String milestones_With_completion_Dates;
    private String milestone_Changes;
    private String identified_in_CFO_Audit_or_other_Review;
    private String mitigation_in_place;
    private String estimated_cost_to_fix;
    private String type;
    private String id;
    
   private enum valid {valid, invalid};

    public DocumentId getDocumentId() {
        return documentId;
    }

    public void setDocumentId(DocumentId documentId) {
        this.documentId = documentId;
    }

    public String getWeakness() {
        return weakness;
    }

    public void setWeakness(String weakness) {
        this.weakness = weakness;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPOC() {
        return POC;
    }

    public void setPOC(String POC) {
        this.POC = POC;
    }

    public String getResources_Required() {
        return resources_Required;
    }

    public void setResources_Required(String resources_Required) {
        this.resources_Required = resources_Required;
    }

    public String getScheduled_completion_date() {
        return scheduled_completion_date;
    }

    public void setScheduled_completion_date(String scheduled_completion_date) {
        this.scheduled_completion_date = scheduled_completion_date;
    }

    public String getMilestones_With_completion_Dates() {
        return milestones_With_completion_Dates;
    }

    public void setMilestones_With_completion_Dates(String milestones_With_completion_Dates) {
        this.milestones_With_completion_Dates = milestones_With_completion_Dates;
    }

    public String getMilestone_Changes() {
        return milestone_Changes;
    }

    public void setMilestone_Changes(String milestone_Changes) {
        this.milestone_Changes = milestone_Changes;
    }

    public String getIdentified_in_CFO_Audit_or_other_Review() {
        return identified_in_CFO_Audit_or_other_Review;
    }

    public void setIdentified_in_CFO_Audit_or_other_Review(String identified_in_CFO_Audit_or_other_Review) {
        this.identified_in_CFO_Audit_or_other_Review = identified_in_CFO_Audit_or_other_Review;
    }

    public String getMitigation_in_place() {
        return mitigation_in_place;
    }

    public void setMitigation_in_place(String mitigation_in_place) {
        this.mitigation_in_place = mitigation_in_place;
    }

    public String getEstimated_cost_to_fix() {
        return estimated_cost_to_fix;
    }

    public void setEstimated_cost_to_fix(String estimated_cost_to_fix) {
        this.estimated_cost_to_fix = estimated_cost_to_fix;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
        public Set<String> getMachines_Affected() {
         if (machines_Affected == null) {
            machines_Affected = new HashSet<>();
        }
        return machines_Affected;
    }

    public void setMachines_Affected(Set<String> machine_Affected) {
        this.machines_Affected = machine_Affected;
    }
    
    public ExcelFormat addMachineAffected(String machine) {
        getMachines_Affected().add(machine);
        return this;
     
    }

     public Set<String> getFiles() {
        if(files == null){
        files = new HashSet<>();
        }
        return files;
    }

    public void setFiles(Set<String> files) {
        this.files = files;
    }
    
        public ExcelFormat addFile(String file) {
            getFiles().add(file);
        return this;
     
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.documentId);
        hash = 41 * hash + Objects.hashCode(this.files);
        hash = 41 * hash + Objects.hashCode(this.weakness);
        hash = 41 * hash + Objects.hashCode(this.category);
        hash = 41 * hash + Objects.hashCode(this.POC);
        hash = 41 * hash + Objects.hashCode(this.resources_Required);
        hash = 41 * hash + Objects.hashCode(this.scheduled_completion_date);
        hash = 41 * hash + Objects.hashCode(this.milestones_With_completion_Dates);
        hash = 41 * hash + Objects.hashCode(this.milestone_Changes);
        hash = 41 * hash + Objects.hashCode(this.identified_in_CFO_Audit_or_other_Review);
        hash = 41 * hash + Objects.hashCode(this.mitigation_in_place);
        hash = 41 * hash + Objects.hashCode(this.estimated_cost_to_fix);
        hash = 41 * hash + Objects.hashCode(this.type);
        hash = 41 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ExcelFormat other = (ExcelFormat) obj;
        if (!Objects.equals(this.documentId, other.documentId)) {
            return false;
        }
        if (!Objects.equals(this.files, other.files)) {
            return false;
        }
        if (!Objects.equals(this.weakness, other.weakness)) {
            return false;
        }
        if (!Objects.equals(this.category, other.category)) {
            return false;
        }
        if (!Objects.equals(this.POC, other.POC)) {
            return false;
        }
        if (!Objects.equals(this.resources_Required, other.resources_Required)) {
            return false;
        }
        if (!Objects.equals(this.scheduled_completion_date, other.scheduled_completion_date)) {
            return false;
        }
        if (!Objects.equals(this.milestones_With_completion_Dates, other.milestones_With_completion_Dates)) {
            return false;
        }
        if (!Objects.equals(this.milestone_Changes, other.milestone_Changes)) {
            return false;
        }
        if (!Objects.equals(this.identified_in_CFO_Audit_or_other_Review, other.identified_in_CFO_Audit_or_other_Review)) {
            return false;
        }
        if (!Objects.equals(this.mitigation_in_place, other.mitigation_in_place)) {
            return false;
        }
        if (!Objects.equals(this.estimated_cost_to_fix, other.estimated_cost_to_fix)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ExcelFormat{" + "documentId=" + documentId + ", files=" + files 
                + ", weakness=" + weakness + ", category=" + category + ", POC="
                + POC + ", resources_Required=" + resources_Required + ", scheduled_completion_date=" 
                + scheduled_completion_date + ", milestones_With_completion_Dates=" 
                + milestones_With_completion_Dates + ", milestone_Changes=" + milestone_Changes 
                + ", identified_in_CFO_Audit_or_other_Review=" + identified_in_CFO_Audit_or_other_Review
                + ", mitigation_in_place=" + mitigation_in_place + ", estimated_cost_to_fix="
                + estimated_cost_to_fix + ", type=" + type + ", id=" + id + '}';
    }
 
   
}