package org.geoint.ic.amass.config;


import java.io.Serializable;
import java.util.HashMap;
import org.geoint.ic.iadataprocessor.spi.Plugin;
import java.util.Map;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 *
 */
@XmlType(name = "properties")
@XmlAccessorType(XmlAccessType.FIELD)
public class PluginProperties implements Serializable {  //DONE PluginConfiguration

    @XmlAttribute(name = "class")
    private String type;
    @XmlAttribute(name = "enabled")
    private boolean enabled;
    @XmlElement(name = "confProperties")
    @XmlJavaTypeAdapter(MapAdapter.class)
    private Map<String, String> confProperties;

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.type);
        hash = 17 * hash + (this.enabled ? 1 : 0);
        hash = 17 * hash + Objects.hashCode(this.confProperties);
        return hash;
    }

    @Override
    public String toString() {
        return "PluginProperties{" + "type=" + type + ", enabled=" + enabled + ", configProperties=" + confProperties + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PluginProperties other = (PluginProperties) obj;
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (this.enabled != other.enabled) {
            return false;
        }
        if (!Objects.equals(this.confProperties, other.confProperties)) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return @throws Exception
     */
    public Plugin getInstance() throws Exception {

        Class f = Class.forName(this.getType());
        Plugin mf = (Plugin) f.newInstance();
        return mf;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Map<String, String> getConfProperties() {

        if (confProperties == null) {
            confProperties = new HashMap<>();
        }
        return confProperties;
    }

    public void setConfProperties(Map<String, String> confProperties) {
        this.confProperties = confProperties;
    }
}
