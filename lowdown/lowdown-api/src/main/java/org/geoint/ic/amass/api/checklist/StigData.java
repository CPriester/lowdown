
package org.geoint.ic.amass.api.checklist;

import java.io.Serializable;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * 
 *  
 * 
 */
@XmlRootElement(name = "STIG_DATA")
@XmlAccessorType(XmlAccessType.FIELD)
public class StigData implements Serializable{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "VULN_ATTRIBUTE", required = false)
    private String vulnAttribute;
    @XmlElement(name = "ATTRIBUTE_DATA", required = false)
    private String vulnData;
            
    
    public String getVulnAttribute() {
        return vulnAttribute;
    }

    public void setVulnAttribute(String vulnAttribute) {
        this.vulnAttribute = vulnAttribute;
    }

    public String getVulnData() {
        return vulnData;
    }

    public void setVulnData(String vulnData) {
        this.vulnData = vulnData;
    }
    
   


    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.vulnAttribute);
        hash = 17 * hash + Objects.hashCode(this.vulnData);
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
        final StigData other = (StigData) obj;
        if (!Objects.equals(this.vulnAttribute, other.vulnAttribute)) {
            return false;
        }
        if (!Objects.equals(this.vulnData, other.vulnData)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "StigData{" + "vulnAttribute=" + vulnAttribute 
                + ", vulnData=" + vulnData + '}';
    }
   
    
}
