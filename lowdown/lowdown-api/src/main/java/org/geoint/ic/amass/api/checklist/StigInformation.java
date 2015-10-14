
package org.geoint.ic.amass.api.checklist;

import java.io.Serializable;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "STIG_INFO")
@XmlAccessorType(XmlAccessType.FIELD)
public class StigInformation implements Serializable {
    
    private final static long serialVersionUID = 1L;
    @XmlElement(name = "STIG_TITLE", required = false)
    private String stigTitle;

    public String getStigTitle() {
        return stigTitle;
    }

    public void setStigTitle(String stigTitle) {
        this.stigTitle = stigTitle;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.stigTitle);
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
        final StigInformation other = (StigInformation) obj;
        if (!Objects.equals(this.stigTitle, other.stigTitle)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "StigInformation{" + "stigTitle=" + stigTitle + '}';
    }
    
}
