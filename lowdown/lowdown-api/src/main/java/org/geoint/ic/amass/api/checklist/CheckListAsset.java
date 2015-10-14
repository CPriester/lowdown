
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
 */
@XmlRootElement(name = "ASSET")
@XmlAccessorType(XmlAccessType.FIELD)
public class CheckListAsset implements Serializable {

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "ASSET_TYPE", required = false)
    private String assetType;
    @XmlElement(name = "HOST_NAME", required = false)
    private String hostName;
    @XmlElement(name = "HOST_IP", required = false)
    private String hostIP;
    @XmlElement(name = "HOST_MAC", required = false)
    private String hostMac;
    @XmlElement(name = "HOST_GUID", required = false)
    private String hostGuid;
    @XmlElement(name = "TARGET_KEY", required = false)
    private String targetKey;
    @XmlElement(name = "ASSET_VAL", required = false)
    private String AssetVal;
    
     public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getHostIP() {
        return hostIP;
    }

    public void setHostIP(String hostIP) {
        this.hostIP = hostIP;
    }

    public String getHostMac() {
        return hostMac;
    }

    public void setHostMac(String hostMac) {
        this.hostMac = hostMac;
    }

    public String getHostGuid() {
        return hostGuid;
    }

    public void setHostGuid(String hostGuid) {
        this.hostGuid = hostGuid;
    }

    public String getTargetKey() {
        return targetKey;
    }

    public void setTargetKey(String targetKey) {
        this.targetKey = targetKey;
    }

    public String getAssetVal() {
        return AssetVal;
    }

    public void setAssetVal(String AssetVal) {
        this.AssetVal = AssetVal;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.assetType);
        hash = 71 * hash + Objects.hashCode(this.hostName);
        hash = 71 * hash + Objects.hashCode(this.hostIP);
        hash = 71 * hash + Objects.hashCode(this.hostMac);
        hash = 71 * hash + Objects.hashCode(this.hostGuid);
        hash = 71 * hash + Objects.hashCode(this.targetKey);
        hash = 71 * hash + Objects.hashCode(this.AssetVal);
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
        final CheckListAsset other = (CheckListAsset) obj;
        if (!Objects.equals(this.assetType, other.assetType)) {
            return false;
        }
        if (!Objects.equals(this.hostName, other.hostName)) {
            return false;
        }
        if (!Objects.equals(this.hostIP, other.hostIP)) {
            return false;
        }
        if (!Objects.equals(this.hostMac, other.hostMac)) {
            return false;
        }
        if (!Objects.equals(this.hostGuid, other.hostGuid)) {
            return false;
        }
        if (!Objects.equals(this.targetKey, other.targetKey)) {
            return false;
        }
        if (!Objects.equals(this.AssetVal, other.AssetVal)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CheckListAsset{" + "assetType=" + assetType + ", hostName=" 
                + hostName + ", hostIP=" + hostIP + ", hostMac=" + hostMac 
                + ", hostGuid=" + hostGuid + ", targetKey=" + targetKey 
                + ", AssetVal=" + AssetVal + '}';
    }

    
    
}
