/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import src.Patient;
import src.PatientReport;
import src.Person;

/**
 *
 * @author Trisha
 */
public class OverviewOfAllPatients extends javax.swing.JFrame {

transient ArrayList<PatientReport> latestReport;
transient ArrayList<Person> personArr;
    DefaultTableModel modelPatientOverview;
transient ArrayList<Patient> patientArr;
//ArrayList<String> patientDetails = new ArrayList<String>();
HashMap<String,ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

 String abnormalBPPatientKey = "";
 String abnormalSugarPatientKey = "";
 String abnormalThyroidPatientKey = "";
 String abnormalBMIPatientKey = "";
 String abnormalHemoglobinPatientKey = "";
 String abnormalWBCPatientKey = "";
 String abnormalRBCPatientKey = "";
 String abnormalPulseRatePatientKey = "";
 String abnormalBodyTempraturePatientKey = "";
 String abnormalRespirationRatePatientKey = "";
    /**
     * Creates new form OverviewOfAllPatients
     */
    public OverviewOfAllPatients() {
        initComponents();
latestReport = new ArrayList<PatientReport>();
personArr =  new ArrayList<Person>();
patientArr = new ArrayList<>();
modelPatientOverview = (DefaultTableModel) jTable1.getModel();
populatePersonArrayList();
populatePatientArrayList();
populateLatestReportArrayList();
displayPatientCount();
displayPatientDetails();
    }

public void displayPatientDetails(){
modelPatientOverview.setRowCount(0);
for(PatientReport lr : latestReport){
Long tempPersonId = 0L;
for(Patient p1 : patientArr){
if(p1.getPatientId() == lr.getPatientId()){
tempPersonId = p1.getPersonId();
}}
for(Person p : personArr){
if(tempPersonId != 0L && p.getPersonId() == tempPersonId){
modelPatientOverview.insertRow(modelPatientOverview.getRowCount(), new Object[]{lr.getPatientId(),p.getName(),p.getCommunityName(),p.getCity()});
ArrayList<String> patientDetails = new ArrayList<String>();
patientDetails.add(lr.getPatientId()+"");
patientDetails.add(p.getName());
patientDetails.add(p.getCommunityName());
patientDetails.add(p.getCity());
map.put(lr.getPatientId()+"", patientDetails);
}
}

}
}

public void populatePersonArrayList() {
        try {
            FileInputStream file = new FileInputStream("Person.dat");
            ObjectInputStream ipfile = new ObjectInputStream(file);

            boolean eof = false;
            while (!eof) {
                try {
                    personArr.add((Person) ipfile.readObject());
                } catch (EOFException eoe) {
                    eof = true;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
            ipfile.close();
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, ioe.getMessage());
        }
    }

public void populatePatientArrayList() {
        try {
            FileInputStream file = new FileInputStream("Patient.dat");
            ObjectInputStream ipfile = new ObjectInputStream(file);

            boolean eof = false;
            while (!eof) {
                try {
                    patientArr.add((Patient) ipfile.readObject());
                } catch (EOFException eoe) {
                    eof = true;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
            ipfile.close();
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, ioe.getMessage());
        }
    }

public void populateLatestReportArrayList() {
        try {
            FileInputStream file = new FileInputStream("LatestReport.dat");
            ObjectInputStream ipfile = new ObjectInputStream(file);

            boolean eof = false;
            while (!eof) {
                try {
                    latestReport.add((PatientReport) ipfile.readObject());
                } catch (EOFException eoe) {
                    eof = true;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
            ipfile.close();
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, ioe.getMessage());
        }
    }

public void displayPatientCount(){

 Long abnormalBP = 0L;
 Long abnormalSugar = 0L;
 Long abnormalThyroid = 0L;
 Long abnormalBMI = 0L;
 Long abnormalHemoglobin = 0L;
 Long abnormalWBC = 0L;
 Long abnormalRBC = 0L;
 Long abnormalPulseRate = 0L;
 Long abnormalBodyTemprature = 0L;
 Long abnormalRespirationRate = 0L;

for(PatientReport lr : latestReport){
if(lr.getAbnormalBP().equals(Boolean.TRUE)){
abnormalBP++;
abnormalBPPatientKey = abnormalBPPatientKey+","+lr.getPatientId();
}
if(lr.getAbnormalSugar().equals(Boolean.TRUE)){
abnormalSugar++;
abnormalSugarPatientKey = abnormalSugarPatientKey+","+lr.getPatientId();
}
if(lr.getAbnormalThyroid().equals(Boolean.TRUE)){
abnormalThyroid++;
abnormalThyroidPatientKey = abnormalThyroidPatientKey+","+lr.getPatientId();
}
if(lr.getAbnormalBMI().equals(Boolean.TRUE)){
abnormalBMI++;
abnormalBMIPatientKey = abnormalBMIPatientKey+","+lr.getPatientId();
}
if(lr.getAbnormalHemoglobin().equals(Boolean.TRUE)){
abnormalHemoglobin++;
abnormalHemoglobinPatientKey = abnormalHemoglobinPatientKey+","+lr.getPatientId();
}
if(lr.getAbnormalWBC().equals(Boolean.TRUE)){
abnormalWBC++;
abnormalWBCPatientKey = abnormalWBCPatientKey+","+lr.getPatientId();
}
if(lr.getAbnormalRBC().equals(Boolean.TRUE)){
abnormalRBC++;
abnormalRBCPatientKey = abnormalRBCPatientKey+","+lr.getPatientId();
}
if(lr.getAbnormalPulseRate().equals(Boolean.TRUE)){
abnormalPulseRate++;
abnormalPulseRatePatientKey = abnormalPulseRatePatientKey+","+lr.getPatientId();
}
if(lr.getAbnormalBodyTemprature().equals(Boolean.TRUE)){
abnormalBodyTemprature++;
abnormalBodyTempraturePatientKey = abnormalBodyTempraturePatientKey+","+lr.getPatientId();
}
if(lr.getAbnormalRespirationRate().equals(Boolean.TRUE)){
abnormalRespirationRate++;
abnormalRespirationRatePatientKey = abnormalRespirationRatePatientKey+","+lr.getPatientId();
}
}
 this.jTextField1.setText(abnormalBP.toString());
 this.jTextField2.setText(abnormalSugar.toString());
 this.jTextField3.setText(abnormalThyroid.toString());
 this.jTextField4.setText(abnormalBMI.toString());
 this.jTextField5.setText(abnormalHemoglobin.toString());
 this.jTextField6.setText(abnormalWBC.toString());
 this.jTextField7.setText(abnormalRBC.toString());
 this.jTextField8.setText(abnormalPulseRate.toString());
 this.jTextField9.setText(abnormalBodyTemprature.toString());
 this.jTextField10.setText(abnormalRespirationRate.toString());
 this.jTextField11.setText(latestReport.size()+"");
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1900, 1020));

        jPanel1.setPreferredSize(new java.awt.Dimension(1139, 768));

        jLabel1.setText("BP : ");

        jButton1.setText("Display Details");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Sugar : ");

        jButton2.setText("Display Details");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Thyroid : ");

        jLabel4.setText("BMI : ");

        jLabel5.setText("Hemoglobin");

        jLabel6.setText("WBC");

        jLabel7.setText("RBC");

        jLabel8.setText("Pulse Rate: ");

        jLabel9.setText("High Body Temprature :");

        jLabel10.setText("Respiration Rate");

        jLabel11.setText("Total Patient");

        jLabel12.setText("Vital Signs");

        jLabel13.setText("Patient Count");

        jButton3.setText("Display Details");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Display Details");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Display Details");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Display Details");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Display Details");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Display Details");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Display Details");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("Display Details");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setText("Display Details");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient ID", "Name", "Community", "City"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel14.setText("(including other issues)");

        jLabel15.setText("Patients :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel11))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGap(60, 60, 60)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jTextField6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jTextField8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jTextField9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(61, 61, 61)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel13)
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                                                        .addComponent(jTextField2)
                                                        .addComponent(jTextField3)))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton2)
                                            .addComponent(jButton1)
                                            .addComponent(jButton3)
                                            .addComponent(jButton4)
                                            .addComponent(jButton5)
                                            .addComponent(jButton6)
                                            .addComponent(jButton7)
                                            .addComponent(jButton8)
                                            .addComponent(jButton9)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(60, 60, 60)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton11)
                                            .addComponent(jButton10)))))
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(28, 28, 28))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel15))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(208, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1))
                            .addComponent(jLabel1))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton7)))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton8))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton9)))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton10))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addGap(57, 57, 57))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        modelPatientOverview.setRowCount(0);
jLabel15.setText("BP Patients: ");
        String[] bpKeyArr = abnormalBPPatientKey.split(",");
for(String key : bpKeyArr){
if(!key.equals("")){
ArrayList data = map.get(key);
modelPatientOverview.insertRow(modelPatientOverview.getRowCount(), new Object[]{data.get(0),data.get(1),data.get(2),data.get(3)});
}}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
                modelPatientOverview.setRowCount(0);
jLabel15.setText("Diabetic Patients: ");
        String[] bpKeyArr = abnormalSugarPatientKey.split(",");
for(String key : bpKeyArr){
if(!key.equals("")){
ArrayList data = map.get(key);
modelPatientOverview.insertRow(modelPatientOverview.getRowCount(), new Object[]{data.get(0),data.get(1),data.get(2),data.get(3)});
}}
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
                       modelPatientOverview.setRowCount(0);
jLabel15.setText("Thyroid Patients: ");
        String[] bpKeyArr = abnormalThyroidPatientKey.split(",");
for(String key : bpKeyArr){
if(!key.equals("")){
ArrayList data = map.get(key);
modelPatientOverview.insertRow(modelPatientOverview.getRowCount(), new Object[]{data.get(0),data.get(1),data.get(2),data.get(3)});
}}
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
                        modelPatientOverview.setRowCount(0);
jLabel15.setText("Abnormal BMI Patients: ");
        String[] bpKeyArr = abnormalBMIPatientKey.split(",");
for(String key : bpKeyArr){
if(!key.equals("")){
ArrayList data = map.get(key);
modelPatientOverview.insertRow(modelPatientOverview.getRowCount(), new Object[]{data.get(0),data.get(1),data.get(2),data.get(3)});
}}
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
                        modelPatientOverview.setRowCount(0);
jLabel15.setText("Abnormal Hemoglobin Patients: ");
        String[] bpKeyArr = abnormalHemoglobinPatientKey.split(",");
for(String key : bpKeyArr){
if(!key.equals("")){
ArrayList data = map.get(key);
modelPatientOverview.insertRow(modelPatientOverview.getRowCount(), new Object[]{data.get(0),data.get(1),data.get(2),data.get(3)});
}}
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
                                modelPatientOverview.setRowCount(0);
jLabel15.setText("Abnormal WBC Patients: ");
        String[] bpKeyArr = abnormalWBCPatientKey.split(",");
for(String key : bpKeyArr){
if(!key.equals("")){
ArrayList data = map.get(key);
modelPatientOverview.insertRow(modelPatientOverview.getRowCount(), new Object[]{data.get(0),data.get(1),data.get(2),data.get(3)});
}}
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
                        modelPatientOverview.setRowCount(0);
jLabel15.setText("Abnormal RBC Patients: ");
        String[] bpKeyArr = abnormalRBCPatientKey.split(",");
for(String key : bpKeyArr){
if(!key.equals("")){
ArrayList data = map.get(key);
modelPatientOverview.insertRow(modelPatientOverview.getRowCount(), new Object[]{data.get(0),data.get(1),data.get(2),data.get(3)});
}}
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
                        modelPatientOverview.setRowCount(0);
jLabel15.setText("Abnormal Pulse Rate Patients: ");
        String[] bpKeyArr = abnormalPulseRatePatientKey.split(",");
for(String key : bpKeyArr){
if(!key.equals("")){
ArrayList data = map.get(key);
modelPatientOverview.insertRow(modelPatientOverview.getRowCount(), new Object[]{data.get(0),data.get(1),data.get(2),data.get(3)});
}}
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
                        modelPatientOverview.setRowCount(0);
jLabel15.setText("Abnormal Body Temprature Patients: ");
        String[] bpKeyArr = abnormalBodyTempraturePatientKey.split(",");
for(String key : bpKeyArr){
if(!key.equals("")){
ArrayList data = map.get(key);
modelPatientOverview.insertRow(modelPatientOverview.getRowCount(), new Object[]{data.get(0),data.get(1),data.get(2),data.get(3)});
}}
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
                        modelPatientOverview.setRowCount(0);
jLabel15.setText("Abnormal Respiration Rate Patients: ");
        String[] bpKeyArr = abnormalRespirationRatePatientKey.split(",");
for(String key : bpKeyArr){
if(!key.equals("")){
ArrayList data = map.get(key);
modelPatientOverview.insertRow(modelPatientOverview.getRowCount(), new Object[]{data.get(0),data.get(1),data.get(2),data.get(3)});
}}
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        displayPatientDetails();
    }//GEN-LAST:event_jButton11ActionPerformed

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
            java.util.logging.Logger.getLogger(OverviewOfAllPatients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OverviewOfAllPatients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OverviewOfAllPatients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OverviewOfAllPatients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OverviewOfAllPatients().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
