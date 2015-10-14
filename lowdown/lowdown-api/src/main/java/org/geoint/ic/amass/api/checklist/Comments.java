
package org.geoint.ic.amass.api.checklist;

import java.io.Serializable;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "COMMENTS")
@XmlAccessorType(XmlAccessType.FIELD)
public class Comments implements Serializable{

        private final static long serialVersionUID = 1L;
    @XmlElement(name = "COMMENTS", required = false)
    private String comment;
    @XmlElement(name = "POC", required = false)
    private String poc;
    @XmlElement(name = "RESCOURCES_REQUIRED", required = false)
    private String rescourcesRequired;
    @XmlElement(name = "SCHEDULED_COMPLETION_DATE", required = false)
    private String scheduledCompletionDate;
    @XmlElement(name = "MILESTONES_WITH_COMPLETION_DATE", required = false)
    private String mileStoneCompletionDate;
    @XmlElement(name = "MILESTONE_CHANGES", required = false)
    private String mileStoneChanges;
    @XmlElement(name = "IDENTIFIED_AUDIT_OR_REVIEW", required = false)
    private String identifiedAuditReview;
    @XmlElement(name = "MITIGATION", required = false)
    private String mitigation;
    @XmlElement(name = "COST_TO_FIX", required = false)
    private String costToFix;
    @XmlElement(name = "TYPE", required = false)
    private String type;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPoc() {
        return poc;
    }

    public void setPoc(String poc) {
        this.poc = poc;
    }

    public String getRescourcesRequired() {
        return rescourcesRequired;
    }

    public void setRescourcesRequired(String rescourcesRequired) {
        this.rescourcesRequired = rescourcesRequired;
    }

    public String getScheduledCompletionDate() {
        return scheduledCompletionDate;
    }

    public void setScheduledCompletionDate(String scheduledCompletionDate) {
        this.scheduledCompletionDate = scheduledCompletionDate;
    }

    public String getMileStoneCompletionDate() {
        return mileStoneCompletionDate;
    }

    public void setMileStoneCompletionDate(String mileStoneCompletionDate) {
        this.mileStoneCompletionDate = mileStoneCompletionDate;
    }

    public String getMileStoneChanges() {
        return mileStoneChanges;
    }

    public void setMileStoneChanges(String mileStoneChanges) {
        this.mileStoneChanges = mileStoneChanges;
    }

    public String getIdentifiedAuditReview() {
        return identifiedAuditReview;
    }

    public void setIdentifiedAuditReview(String identifiedAuditReview) {
        this.identifiedAuditReview = identifiedAuditReview;
    }

    public String getMitigation() {
        return mitigation;
    }

    public void setMitigation(String mitigation) {
        this.mitigation = mitigation;
    }

    public String getCostToFix() {
        return costToFix;
    }

    public void setCostToFix(String costToFix) {
        this.costToFix = costToFix;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.comment);
        hash = 71 * hash + Objects.hashCode(this.poc);
        hash = 71 * hash + Objects.hashCode(this.rescourcesRequired);
        hash = 71 * hash + Objects.hashCode(this.scheduledCompletionDate);
        hash = 71 * hash + Objects.hashCode(this.mileStoneCompletionDate);
        hash = 71 * hash + Objects.hashCode(this.mileStoneChanges);
        hash = 71 * hash + Objects.hashCode(this.identifiedAuditReview);
        hash = 71 * hash + Objects.hashCode(this.mitigation);
        hash = 71 * hash + Objects.hashCode(this.costToFix);
        hash = 71 * hash + Objects.hashCode(this.type);
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
        final Comments other = (Comments) obj;
        if (!Objects.equals(this.comment, other.comment)) {
            return false;
        }
        if (!Objects.equals(this.poc, other.poc)) {
            return false;
        }
        if (!Objects.equals(this.rescourcesRequired, other.rescourcesRequired)) {
            return false;
        }
        if (!Objects.equals(this.scheduledCompletionDate, other.scheduledCompletionDate)) {
            return false;
        }
        if (!Objects.equals(this.mileStoneCompletionDate, other.mileStoneCompletionDate)) {
            return false;
        }
        if (!Objects.equals(this.mileStoneChanges, other.mileStoneChanges)) {
            return false;
        }
        if (!Objects.equals(this.identifiedAuditReview, other.identifiedAuditReview)) {
            return false;
        }
        if (!Objects.equals(this.mitigation, other.mitigation)) {
            return false;
        }
        if (!Objects.equals(this.costToFix, other.costToFix)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Comments{" + "comment=" + comment + ", poc=" + poc +
                ", rescourcesRequired=" + rescourcesRequired + ", severityOverride=" + 
                scheduledCompletionDate + ", mileStoneCompletionDate=" + mileStoneCompletionDate + 
                ", mileStoneChanges=" + mileStoneChanges + ", identifiedAuditReview=" + identifiedAuditReview + 
                ", mitigation=" + mitigation + ", costToFix=" + costToFix + ", type=" + type + '}';
    }

    
}
