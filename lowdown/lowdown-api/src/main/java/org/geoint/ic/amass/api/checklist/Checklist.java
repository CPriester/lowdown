package org.geoint.ic.amass.api.checklist;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * OO Representation of a Checklist.
 * 
 * File and FilterComments were added to be updated 
 * throughout processing. They will not be populated 
 * at unmarshalling
 * 
 */
@XmlRootElement(name = "CHECKLIST")
@XmlAccessorType(XmlAccessType.FIELD)
public class Checklist implements Serializable{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "SV_VERSION", required = false)
    private String version;
    @XmlElement(name = "ASSET", required = false)
    private CheckListAsset checklistAsset;
    @XmlElement(name = "STIG_INFO", required = false)
    private StigInformation stigInformatin;
    @XmlElement(name = "VULN")
    private List<Vulnerabilities> vulnerabilities;
    @XmlElement(name = "file")
    private String file;
    @XmlAttribute(name = "status", required = false)
    private Status status = Status.PROCESSED;
    @XmlElement(name = "FilterComments")
    private List<String> FilterComments;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public CheckListAsset getChecklistAsset() {
        return checklistAsset;
    }

    public void setChecklistAsset(CheckListAsset checklistAsset) {
        this.checklistAsset = checklistAsset;
    }

    public StigInformation getStigInformatin() {
        return stigInformatin;
    }

    public void setStigInformatin(StigInformation stigInformatin) {
        this.stigInformatin = stigInformatin;
    }

    public List<Vulnerabilities> getVulnerabilities() {
        if(vulnerabilities==null){ 
        vulnerabilities = new ArrayList<>();
        }
        return vulnerabilities;
    }

    public void setVulnerabilities(List<Vulnerabilities> vulnerabilities) {
        this.vulnerabilities = vulnerabilities;
    }

    public Checklist addVuln(Vulnerabilities vuln) {
        getVulnerabilities().add(vuln);
        return this;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
        
    public List<String> getFilterComments() {
        return FilterComments;
    }

    public void setFilterComments(List<String> filterComments) {
        this.FilterComments = filterComments;
    }

    public Checklist addFilterComment(String filterComment) {
        getFilterComments().add(filterComment);
        return this;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.version);
        hash = 89 * hash + Objects.hashCode(this.checklistAsset);
        hash = 89 * hash + Objects.hashCode(this.stigInformatin);
        hash = 89 * hash + Objects.hashCode(this.vulnerabilities);
        hash = 89 * hash + Objects.hashCode(this.file);
        hash = 89 * hash + Objects.hashCode(this.status);
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
        final Checklist other = (Checklist) obj;
        if (!Objects.equals(this.version, other.version)) {
            return false;
        }
        if (!Objects.equals(this.checklistAsset, other.checklistAsset)) {
            return false;
        }
        if (!Objects.equals(this.stigInformatin, other.stigInformatin)) {
            return false;
        }
        if (!Objects.equals(this.vulnerabilities, other.vulnerabilities)) {
            return false;
        }
        if (!Objects.equals(this.file, other.file)) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Checklist{" + "version=" + version + ", checklistAsset=" + checklistAsset
                + ", stigInformatin=" + stigInformatin + ", vulnerabilities="
                + vulnerabilities + ", file=" + file + ", status=" + status + '}';
    }

    public enum Status {

        PROCESSED,
        UNABLE_TO_PROCESS,
        PROCESSED_WITH_ERRORS

    }

}
