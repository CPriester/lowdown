/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.geoint.ic.amass.spi.exceptions;

import java.util.Objects;

/**
 *
 * 
 */
public class FileFailed {
    private String fileName;
    private String fileLength;
    private String exceptionMessage;
    
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileLength() {
        return fileLength;
    }

    public void setFileLength(String fileLength) {
        this.fileLength = fileLength;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.fileName);
        hash = 79 * hash + Objects.hashCode(this.fileLength);
        hash = 79 * hash + Objects.hashCode(this.exceptionMessage);
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
        final FileFailed other = (FileFailed) obj;
        if (!Objects.equals(this.fileName, other.fileName)) {
            return false;
        }
        if (!Objects.equals(this.fileLength, other.fileLength)) {
            return false;
        }
        if (!Objects.equals(this.exceptionMessage, other.exceptionMessage)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FailedFile{" + "fileName=" + fileName + ", fileLength=" + fileLength + ", exceptionMessage=" + exceptionMessage + '}';
    }
    
   
    
    
}
