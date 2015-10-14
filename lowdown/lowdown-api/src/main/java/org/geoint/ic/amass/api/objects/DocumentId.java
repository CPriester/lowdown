
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
public class DocumentId implements Serializable{

        

    private String status;
    private String comments;
    private String vulnerabilitie;

   

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }



 
    public String getVulnerabilitie() {
        return vulnerabilitie;
    }

    public void setVulnerabilitie(String vulnerabilitie) {
        this.vulnerabilitie = vulnerabilitie;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.status);
        hash = 97 * hash + Objects.hashCode(this.comments);
        hash = 97 * hash + Objects.hashCode(this.vulnerabilitie);
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
        final DocumentId other = (DocumentId) obj;
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.comments, other.comments)) {
            return false;
        }
 
        if (!Objects.equals(this.vulnerabilitie, other.vulnerabilitie)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DocumentId{" + "status=" + status + ", comments=" + comments + 
               ", vulnerabilitie=" + vulnerabilitie + '}';
    }
   
}
