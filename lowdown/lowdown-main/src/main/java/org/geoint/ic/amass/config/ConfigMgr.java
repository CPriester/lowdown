package org.geoint.ic.amass.config;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

/**
 *Loads configuration across the service
 *
 */
public class ConfigMgr {

    private static DataProcessorConfig config;
    private static final String PROPERTY_CONFIG_FILE = "";
    private final static Logger logger = Logger.getLogger(ConfigMgr.class.getName());

    public static DataProcessorConfig getConfig() throws IOException {
        synchronized (ConfigMgr.class) {
            if (config == null) {
                String fn = System.getProperty(PROPERTY_CONFIG_FILE);
                if (fn == null) {
                    throw new RuntimeException("Unable to locate configuration "
                            + "file, the " + PROPERTY_CONFIG_FILE
                            + " JVM property " + "has not been set.");
                }
                File configuration = new File(fn);
                if (!configuration.exists()) {
                    throw new RuntimeException("Invalid configuration file, " + "file not found at " + fn + "'");
                }
                try (InputStream in = new BufferedInputStream(new FileInputStream(configuration))) {
                    JAXBContext jc = JAXBContext.newInstance(DataProcessorConfig.class);
                    config = (DataProcessorConfig) jc.createUnmarshaller().unmarshal(in);

                } catch (JAXBException ex) {
                    throw new IOException("Unable to load configuration file", ex);
                }
            }
        }

        return config;

    }

    protected static void setConfig(DataProcessorConfig c) {
        config = c;
    }
}
