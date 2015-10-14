/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.geoint.ic.amass.spi;

import java.io.File;
import java.util.Map;

/**
 * Accepts the File directory to be processed. It will unmarshall the files of 
 * the configured type and place them in a Map for further processing.
 * 
 */
public interface FileFilter extends Plugin {
//        Map<String, Map<String, DataObject>> validateData(Map<String, Map<String, DataObject>> validData);
    
}
