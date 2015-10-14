
package org.geoint.ic.amass.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * 
 */
public class MapAdapter extends XmlAdapter<MapAdapter.AdaptedProperties, Map<String, String>> {

    public MapAdapter(Map<String, String> strings) {
    }

    private MapAdapter() {
    }

    public static class AdaptedProperties {

        public List<Prop> property = new ArrayList<Prop>();
    }

    @Override
    public Map<String, String> unmarshal(AdaptedProperties vt) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AdaptedProperties marshal(Map<String, String> bt) throws Exception {
        if (null == bt) {
            return null;
        }
        
        
        MapAdapter.AdaptedProperties adaptedProperties = new MapAdapter.AdaptedProperties();
       
        for(String key : bt.keySet()){
        MapAdapter.Prop prop = new MapAdapter.Prop();
        prop.name = key;
        prop.value = bt.get(key);
        adaptedProperties.property.add(prop);
        }
       
        return adaptedProperties;
    }

    public static class Prop {

        @XmlAttribute
        private String name;
        @XmlValue
        private String value;

    }

}
