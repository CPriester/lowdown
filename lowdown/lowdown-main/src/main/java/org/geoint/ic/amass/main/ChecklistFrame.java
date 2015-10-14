package org.geoint.ic.amass.main;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import org.geoint.ic.dataprocessor.ChecklistOutputData;
import org.geoint.ic.iadataprocessor.api.objects.ExcelFormat;
import org.geoint.ic.amass.config.DataProcessorConfig;
import org.geoint.ic.iadataprocessor.parsers.ChecklistParser;

/**
 *
 *
 */
public class ChecklistFrame extends javax.swing.JFrame implements Runnable {

    private File inputFile;
    private File outputFile;
    private File poam;
    private final static Logger logger = Logger.getLogger(ChecklistFrame.class.getName());
    private static DataProcessorConfig config;
    public static final String CONFIGURATION_DEFAULT_FILENAME = "org.geoint.ic.config";
    private static Thread myThread;
    private volatile boolean run = true;
    public static ChecklistFrame checklistFrame = new ChecklistFrame();
    private static ExecutorService executor;
    private JTextArea outputTextArea;
    private Task task;
    private OpenDocument op = new OpenDocument();

    /**
     * Creates new form CompareFrame
     *
     * @param config
     */

    public ChecklistFrame() {
        myThread = Thread.currentThread();
        initComponents();

    }

    public ChecklistFrame(DataProcessorConfig config) {
        this.config = config;

    }

    public static ChecklistFrame defaultService() {
        return new ChecklistFrame(loadConfiguration());

    }

    private static DataProcessorConfig loadConfiguration() {

//        String configFileLocation = System.getProperty(CONFIGURATION_DEFAULT_FILENAME);
//         if (configFileLocation != null) {
//            File file = new File(configFileLocation);
//            try (InputStream cis = new FileInputStream(file)) {
//                JAXBContext jc = JAXBContext.newInstance(DataProcessorConfig.class);
//                Unmarshaller um = jc.createUnmarshaller();
//                return (DataProcessorConfig) um.unmarshal(cis);
//            } catch (IOException ex) {
//                logger.log(Level.SEVERE, "Unable to find service configuration"
//                        + configFileLocation + ".    Service Halted", ex);
//                System.exit(1);
//            } catch (JAXBException ex) {
//                logger.log(Level.SEVERE,  "Problem parsing service configuration, service"
//                        + "Halted Error:" + ex.getMessage(), ex);
//                System.exit(1);
//            }
//        }logger.log(Level.INFO, "The Systems Config File Location is null, "
//                + "returning the default instance of MailSvcConfig");
//        return new DataProcessorConfig();
        return null;
    }

    private void setupLogging() {
    }

    public void start() throws Exception {
//        
//        List<FileFilter> dataFilters = new ArrayList<>();
//        List<DataProcessor> dataProcessors = new ArrayList<>();
//        List<DataOutput> dataOutput = new ArrayList<>();
//
//        
//        if (config.getDataParsers()!= null) {
//            PluginProperties clis = config.getDataParsers();
//                if (clis.isEnabled() == true) {
//                    try {
//                        DataParser cli = (DataParser) clis.getInstance();
//                        cli.initialize(clis.getConfProperties());
//                    } catch (Throwable ex) {
//                        //intentionally catching Throwable to also catch runtime 
//                        //exceptions and errors from the MailMsgReceiver#start
//                        logger.log(Level.SEVERE, "Unable to initialize DataParser "
//                                + "DataParser '" + clis.getType() + "'",
//                                ex);
//                    }
//
//                }
//            }
//        
//        if (config.getFilters()!= null) {
//            List<PluginProperties> filter = config.getFilters();
//
//            for (PluginProperties m : filter) {
//                if (m.isEnabled() == true) {
//                    try {
//                        FileFilter rh = (FileFilter) m.getInstance();
//                        dataFilters.add(rh);
//                        rh.initialize(m.getConfProperties());
//                    } catch (InstantiationException | IllegalAccessException |
//                            IllegalArgumentException | InvocationTargetException |
//                            ClassNotFoundException ex) {
//                        logger.log(Level.SEVERE, "Unable to instantiate DataParser", ex);
//                    }
//
//                }
//            }
//        }
//        
//        
//         if (config.getDataProcessors()!= null) {
//            List<PluginProperties> processors = config.getDataProcessors();
//
//            for (PluginProperties m : processors) {
//                if (m.isEnabled() == true) {
//                    try {
//                        DataProcessor rh = (DataProcessor) m.getInstance();
//                        dataProcessors.add(rh);
//                        rh.initialize(m.getConfProperties());
//                    } catch (InstantiationException | IllegalAccessException |
//                            IllegalArgumentException | InvocationTargetException |
//                            ClassNotFoundException ex) {
//                        logger.log(Level.SEVERE, "Unable to instantiate DataParser", ex);
//                    }
//
//                }
//            }
//        }
//        
//         
//            if (config.getDataOutput()!= null) {
//            List<PluginProperties> processors = config.getDataOutput();
//
//            for (PluginProperties m : processors) {
//                if (m.isEnabled() == true) {
//                    try {
//                        DataOutput rh = (DataOutput) m.getInstance();
//                        dataOutput.add(rh);
//                        rh.initialize(m.getConfProperties());
//                    } catch (InstantiationException | IllegalAccessException |
//                            IllegalArgumentException | InvocationTargetException |
//                            ClassNotFoundException ex) {
//                        logger.log(Level.SEVERE, "Unable to instantiate DataParser", ex);
//                    }
//
//                }
//            }
//        }
//        
//        
//        
//         File directory = new File(inputFile.getAbsolutePath());
//            ChecklistParser parser = new ChecklistParser();
//            ChecklistDetails detailed = new ChecklistDetails();
//            ChecklistSummary summarize = new ChecklistSummary();
//            Map<String, Map<String, ExcelFormat>> excel = new HashMap<>();
//        //    Map<String, Checklist> objects = parser.filterFile(directory);
//            
//            
//           Set<String> keys= objects.keySet();
//         for(String k : keys){
//        Checklist da = (Checklist) objects.get(k);
//
//         }
//            
//
//           excel.put("DetailedData", detailed.processData(objects));
//           excel.put("Summary", summarize.processSummary(objects));
//           
//           
//           ChecklistOutputData outputData = new ChecklistOutputData(outputFile.getPath(), excel);
//           
//           String file = outputData.outputData();
//            Desktop dt = Desktop.getDesktop();
//            dt.open(new File(outputFile, file));
//    
//    
//    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        popupMenu1 = new java.awt.PopupMenu();
        popupMenu2 = new java.awt.PopupMenu();
        popupMenu3 = new java.awt.PopupMenu();
        jFileChooser1 = new javax.swing.JFileChooser();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        baseFileButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        newFileButton = new javax.swing.JButton();
        compareButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        newFileButton1 = new javax.swing.JButton();
        progressBar = new javax.swing.JProgressBar();

        popupMenu1.setLabel("popupMenu1");

        popupMenu2.setLabel("popupMenu2");

        popupMenu3.setLabel("popupMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(java.awt.Color.white);
        setForeground(java.awt.Color.white);

        jLabel1.setText("Select Checklist Directory");

        baseFileButton.setText("Select File");
        baseFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                baseFileButtonActionPerformed(evt);
            }
        });

        jLabel2.setBackground(java.awt.Color.white);
        jLabel2.setText("Select Output Directory");

        newFileButton.setText("Select File");
        newFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newFileButtonActionPerformed(evt);
            }
        });

        compareButton.setText("Process Files");
        compareButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compareButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        jLabel3.setText("IA Checklist Processor");

        jLabel5.setText("Update with POA&M data");

        newFileButton1.setText("Select file");
        newFileButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newFileButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(newFileButton1)
                            .addComponent(newFileButton)
                            .addComponent(baseFileButton))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(25, 25, 25))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(compareButton)
                        .addGap(85, 85, 85))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(baseFileButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newFileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newFileButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addComponent(compareButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void baseFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_baseFileButtonActionPerformed

        if (evt.getSource() == baseFileButton) {
            final JFileChooser fc = new JFileChooser();
            fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

            int returnVal = fc.showOpenDialog(this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File chosenFile = fc.getSelectedFile();
                if (!chosenFile.exists()) {
                    JOptionPane.showMessageDialog(this, "File does not exist!");
                }
                if (!chosenFile.canRead()) {
                    JOptionPane.showMessageDialog(this, "Cannot read file.");
                }
                inputFile = new File(chosenFile.getAbsolutePath());
                baseFileButton.setText(inputFile.getName());
            }
        }
    }//GEN-LAST:event_baseFileButtonActionPerformed

    private void newFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newFileButtonActionPerformed
        if (evt.getSource() == newFileButton) {
            final JFileChooser fc = new JFileChooser((inputFile != null) ? inputFile.getParent() : "");
            fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            int returnVal = fc.showOpenDialog(this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File chosenFile = fc.getSelectedFile();
                if (!chosenFile.exists()) {
                    JOptionPane.showMessageDialog(this, "File does not exist!");
                }
                if (!chosenFile.canRead()) {
                    JOptionPane.showMessageDialog(this, "Cannot read file.");
                }
                outputFile = new File(chosenFile.getAbsolutePath());
                newFileButton.setText(outputFile.getName());
            }
        }
    }//GEN-LAST:event_newFileButtonActionPerformed

    private void compareButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compareButtonActionPerformed
        if (outputFile == null) {
            JOptionPane.showMessageDialog(this, "Compare file hasn't been set.");
            return;
        }
        if (inputFile == null) {
            JOptionPane.showMessageDialog(this, "Base file has not been set.");
        }

        compareButton.setEnabled(false);

        try {
//executor = Executors.newSingleThreadExecutor();   
//        final boolean isTerminated = executor.isTerminated();
//        executor.shutdownNow();

            this.run();

        } catch (Throwable ex) {
            System.out.println("EXCEPTION DETAILS" + ex);
            JOptionPane.showMessageDialog(this, "Unable to open File!" + ex.getMessage());

            logger.log(Level.SEVERE, "Problems comparing file", ex);
        }
        compareButton.setEnabled(true);

    }//GEN-LAST:event_compareButtonActionPerformed

    private void newFileButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newFileButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newFileButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChecklistFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChecklistFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChecklistFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChecklistFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                myThread.setDaemon(true);
                checklistFrame.setVisible(true);
            }

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton baseFileButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton compareButton;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton newFileButton;
    private javax.swing.JButton newFileButton1;
    private java.awt.PopupMenu popupMenu1;
    private java.awt.PopupMenu popupMenu2;
    private java.awt.PopupMenu popupMenu3;
    private javax.swing.JProgressBar progressBar;
    // End of variables declaration//GEN-END:variables

   
    @Override
    public void run() {
        myThread = Thread.currentThread();
        try {
          File directory = new File(inputFile.getAbsolutePath());
            ChecklistParser parser = new ChecklistParser();
            List<ExcelFormat> checklists = parser.filterFile(directory);
            System.out.println("parsing complete - output data");
            ChecklistOutputData outputData = new ChecklistOutputData(outputFile.getPath(), checklists);
            String file = outputData.outputData();
            checklistFrame.dispatchEvent(new WindowEvent(checklistFrame, WindowEvent.WINDOW_CLOSING));
            checklistFrame.setVisible(false);
            op.setDaemon(true);
            op.start();
            op.openDoc(file);
            this.run = false;
            try {
                System.exit(0);
            } catch (Exception e) {
                System.out.println("nope not working");
            }
//            op.interrupt();
            myThread.interrupt();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("mainFrame" + e);
            logger.log(Level.SEVERE, "could not process file directory", e.getMessage());
        }

    }

    private void showProgressBarDemo() {

        progressBar = new JProgressBar(0, 100);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
        outputTextArea = new JTextArea("", 5, 20);

        JScrollPane scrollPane = new JScrollPane(outputTextArea);
        compareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                task = new Task();
                task.start();
            }
        });

    }

    private class OpenDocument extends Thread {

        public OpenDocument() {
        }
        private String file;

        public void openDoc(String file) {
            try {
                Desktop desktop = Desktop.getDesktop();
                desktop.open(new File(outputFile, file));
                System.exit(0);

            } catch (IOException ex) {
                logger.log(Level.FINE, "Unable to open File", ex);
            }
        }

    }

    private class Task extends Thread {

        public Task() {
        }

        @Override
        public void run() {
            for (int i = 0; i <= 100; i += 10) {

                final int progress = i;
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        progressBar.setValue(progress);
                        outputTextArea.setText(outputTextArea.getText()
                                + String.format("Completed %d%% of task.\n", progress));
                    }
                });
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
        }
    }

}
