/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package people;

import people.Human.Sex;

/**
 *
 * @author student
 */
public class PersonDialog extends javax.swing.JDialog {
    private Human person;
    private String actionButton = "Storno";
    /**
     * Creates new form PersonDialog
     */
    public PersonDialog(java.awt.Frame parent, boolean modal, Human person) {
        super(parent, modal);
        initComponents();
        this.person=person;
        name.setText(person.getName());
        vekSpinner.setValue(person.getAge());
        vaha.setValue(person.getWeight());
        if(person.getSex()==Sex.MAN)
            pohlaviMuz.setSelected(true);
        else
            pohlaviZena.setSelected(true);
    }
    
    public String ShowDialog(){
        this.setVisible(true);
        return actionButton;
    }
    
    public Human getPerson(){
        this.person.setName(name.getText());
        this.person.setAge((int)vekSpinner.getValue());
        this.person.setWeight((int)vaha.getValue());
        return this.person;
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSlider1 = new javax.swing.JSlider();
        sex = new javax.swing.ButtonGroup();
        name = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        OKbutton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        vekSpinner = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        vaha = new javax.swing.JSlider();
        vahaLabel = new javax.swing.JLabel();
        pohlaviMuz = new javax.swing.JRadioButton();
        pohlaviZena = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setFocusTraversalPolicyProvider(true);
        setModal(true);

        jLabel1.setText("Jméno");

        OKbutton.setText("OK");
        OKbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKbuttonActionPerformed(evt);
            }
        });

        cancelButton.setText("CANCEL");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Věk");

        jLabel3.setText("Váha");

        vaha.setMajorTickSpacing(10);
        vaha.setMaximum(150);
        vaha.setMinimum(50);
        vaha.setMinorTickSpacing(5);
        vaha.setPaintLabels(true);
        vaha.setPaintTicks(true);
        vaha.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                vahaStateChanged(evt);
            }
        });

        vahaLabel.setBackground(new java.awt.Color(150, 150, 150));
        vahaLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        sex.add(pohlaviMuz);
        pohlaviMuz.setText("Muž");
        pohlaviMuz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pohlaviMuzActionPerformed(evt);
            }
        });

        sex.add(pohlaviZena);
        pohlaviZena.setText("Žena");
        pohlaviZena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pohlaviZenaActionPerformed(evt);
            }
        });

        jLabel4.setText("Pohlaví");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(OKbutton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelButton)
                        .addGap(39, 39, 39))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel4))
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(vekSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(vaha, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(vahaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(pohlaviMuz)
                                        .addGap(29, 29, 29)
                                        .addComponent(pohlaviZena))))
                            .addComponent(jLabel3))
                        .addContainerGap(93, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(vekSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(vaha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pohlaviMuz)
                            .addComponent(pohlaviZena)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addComponent(vahaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OKbutton)
                    .addComponent(cancelButton))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OKbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKbuttonActionPerformed
        actionButton = "OK";
        this.dispose();
    }//GEN-LAST:event_OKbuttonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        actionButton = "Storno";
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void vahaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_vahaStateChanged
        vahaLabel.setText(Integer.toString(vaha.getValue()));
    }//GEN-LAST:event_vahaStateChanged

    private void pohlaviMuzActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pohlaviMuzActionPerformed
        this.person.setSex(Sex.MAN);
    }//GEN-LAST:event_pohlaviMuzActionPerformed

    private void pohlaviZenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pohlaviZenaActionPerformed
        this.person.setSex(Sex.WOMAN);
    }//GEN-LAST:event_pohlaviZenaActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton OKbutton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTextField name;
    private javax.swing.JRadioButton pohlaviMuz;
    private javax.swing.JRadioButton pohlaviZena;
    private javax.swing.ButtonGroup sex;
    private javax.swing.JSlider vaha;
    private javax.swing.JLabel vahaLabel;
    private javax.swing.JSpinner vekSpinner;
    // End of variables declaration//GEN-END:variables
}
