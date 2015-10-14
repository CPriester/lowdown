///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package org.geoint.ic.iadataprocessor.api.objects;
//
//import java.util.HashSet;
//import java.util.Set;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author courtney_priester
// */
//public class DocumentIdTest {
//    
//    public DocumentIdTest() {
//    }
//    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//    }
//    
//    @After
//    public void tearDown() {
//    }
//
//    /**
//     * Test of getStatus method, of class DocumentId.
//     */
//    @Test
//    public void testContent() {
//        
//        
//        System.out.println("testing Content");
//        Set<DocumentId> documents = new HashSet<>();
//        
//        DocumentId doc1 = new DocumentId(); 
//        doc1.setComments("commnents");
//        doc1.setMachine_Affected("machine");
//        doc1.setStatus("status");
//        doc1.setVulnerabilitie("vuln");
//        
//        DocumentId doc2 = new DocumentId(); 
//        doc2.setComments("commnents");
//        doc2.setMachine_Affected("machine");
//        doc2.setStatus("status");
//        doc2.setVulnerabilitie("vuln");
//        documents.add(doc1);
//        documents.add(doc2);
//        
//        DocumentId doc3 = new DocumentId(); 
//        doc3.setComments("commnents");
//        doc3.setMachine_Affected("machine");
//        doc3.setStatus("status");
//        doc3.setVulnerabilitie("vuln");
//        
//  
//            if(documents.contains(doc3)){
//                System.out.println("checks for Content not instance");
//            
//            
//            }else{
//                System.out.println("Does Not check content");
//            }
//    }
//
//  
//    
//}
