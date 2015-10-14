package org.geoint.ic.amass.api.checklist;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "VULN")
@XmlAccessorType(XmlAccessType.FIELD)
public class Vulnerabilities implements Serializable{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "STIG_DATA")
    private List<StigData> stigdata;
    @XmlElement(name = "STATUS", required = false)
    private String status;
    @XmlElement(name = "FINDING_DETAILS", required = false)
    private String findingDetails;
    @XmlElement(name = "COMMENTS", required = false)
    private String Comment;
    @XmlElement(name = "SEVERITY_OVERRIDE", required = false)
    private String severityOverride;
    @XmlElement(name = "SEVERITY_JUSTIFICATION", required = false)
    private String severityJustification;

    public List<StigData> getStigdata() {
        if(stigdata == null)
        {
        stigdata = new ArrayList<>();
        }
        return stigdata;
    }

    public void setStigdata(List<StigData> stigdata) {
        this.stigdata = stigdata;
    }

        public Vulnerabilities addStigData(StigData stigData) {
        getStigdata().add(stigData);
        return this;
    }
        
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFindingDetails() {
        return findingDetails;
    }

    public void setFindingDetails(String findingDetails) {
        this.findingDetails = findingDetails;
    }

    public String getComment() {
    
        return Comment;
    }

    public void setComment(String Comment) {
        this.Comment = Comment;
    }



    public String getSeverityOverride() {
        return severityOverride;
    }

    public void setSeverityOverride(String severityOverride) {
        this.severityOverride = severityOverride;
    }

    public String getSeverityJustification() {
        return severityJustification;
    }

    public void setSeverityJustification(String severityJustification) {
        this.severityJustification = severityJustification;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.stigdata);
        hash = 37 * hash + Objects.hashCode(this.status);
        hash = 37 * hash + Objects.hashCode(this.findingDetails);
        hash = 37 * hash + Objects.hashCode(this.Comment);
        hash = 37 * hash + Objects.hashCode(this.severityOverride);
        hash = 37 * hash + Objects.hashCode(this.severityJustification);
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
        final Vulnerabilities other = (Vulnerabilities) obj;
        if (!Objects.equals(this.stigdata, other.stigdata)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.findingDetails, other.findingDetails)) {
            return false;
        }
        if (!Objects.equals(this.Comment, other.Comment)) {
            return false;
        }
       
        if (!Objects.equals(this.severityOverride, other.severityOverride)) {
            return false;
        }
        if (!Objects.equals(this.severityJustification, other.severityJustification)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vulnerabilities{" + "stigdata=" + stigdata + ", status=" + status 
                + ", findingDetails=" + findingDetails 
                + ", Comment=" + Comment 
                + ", severityOverride=" + severityOverride
                + ", severityJustification=" + severityJustification + '}';
    }

    
    
}
