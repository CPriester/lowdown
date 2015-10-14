package org.geoint.ic.amass.config;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.logging.Level;

/**
 *
 * <p>
 * Configuration
 *
 * Mail Service Configuration </p>
 */
@XmlRootElement(name = "data-processor")
@XmlAccessorType(XmlAccessType.FIELD)
public class DataProcessorConfig {

    @XmlElement(name = "logFile")
    private String logFile = System.getProperty("java.io.tmpdir" + File.separator + "iaDataProcessor.log");
    @XmlElement(name = "logLevel", defaultValue = "WARNING")
    private String logLevel = Level.WARNING.getName();
    @XmlElementWrapper(name = "dataPArsers")
    @XmlElement(name = "dataParser")
    private PluginProperties dataParsers;
    @XmlElementWrapper(name = "fileFilters")
    @XmlElement(name = "fileFilters")
    private List<PluginProperties> filters;
    @XmlElementWrapper(name = "dataProcessors")
    @XmlElement(name = "dataProcessor")
    private List<PluginProperties> dataProcessors;
    @XmlElementWrapper(name = "dataOutput")
    @XmlElement(name = "dataOutput")
    private List<PluginProperties> dataOutput;

    public String getLogFile() {
        return logFile;
    }

    public void setLogFile(String logFile) {
        this.logFile = logFile;
    }

    public String getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    public PluginProperties getDataParsers() {

  
        return dataParsers;
    }

    public void setDataParsers(PluginProperties dataParsers) {
        this.dataParsers = dataParsers;
    }

    public DataProcessorConfig addDataParser(PluginProperties dataParser) {
        getFilters().add(dataParser);
        return this;
    }

    public List<PluginProperties> getDataProcessors() {
        if (dataProcessors == null) {
            dataProcessors = new ArrayList<>();

        }
        return dataProcessors;
    }

    public void setDataProcessors(List<PluginProperties> dataProcessors) {
        this.dataProcessors = dataProcessors;
    }

    public DataProcessorConfig addDataProcessor(PluginProperties dataProcessor) {
        getDataProcessors().add(dataProcessor);
        return this;
    }

    public List<PluginProperties> getFilters() {
        if (filters == null) {
            filters = new ArrayList<>();
        }
        return filters;
    }

    public void setFilters(List<PluginProperties> filters) {
        this.filters = filters;
    }

    public DataProcessorConfig addFilter(PluginProperties filter) {
        getFilters().add(filter);
        return this;
    }

    public List<PluginProperties> getDataOutput() {
        if (dataOutput == null) {
            dataOutput = new ArrayList();

        }
        return dataOutput;
    }

    public void setDataOutput(List<PluginProperties> dataOutput) {
        this.dataOutput = dataOutput;
    }

    public DataProcessorConfig addDataOutput(PluginProperties dataOutput) {
        getFilters().add(dataOutput);
        return this;
    }

}
