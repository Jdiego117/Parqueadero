/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VistaControlador;

import Modelos.Carro;
import Modelos.Conductor;
import Modelos.DB;
import Modelos.Moto;
import Modelos.Vehiculo;
import javax.swing.JOptionPane;

/**
 *
 * @author Evelin
 */
public class FormularioVehiculo extends javax.swing.JFrame {

    Parqueadero parqueadero = null;
    
    /**
     * Creates new form FormularioVehiculo
     */
    public FormularioVehiculo() {
        initComponents();
    }
    
    public FormularioVehiculo(String placa, Parqueadero parqueadero) {
        initComponents();
        this.placaTxt.setText(placa);
        this.parqueadero = parqueadero;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        parquederoNombre = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        placaTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        colorTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        modeloTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        carroRbt = new javax.swing.JRadioButton();
        motoRbt = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        remolqueCheck = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        cascosTxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cedulaTxt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        nombreTxt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        apellidoTxt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        edadTxt = new javax.swing.JTextField();
        guardarBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        parquederoNombre.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        parquederoNombre.setText("Parqueadero c.c");

        jLabel1.setText("Placa");

        placaTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                placaTxtActionPerformed(evt);
            }
        });

        jLabel2.setText("Color");

        jLabel3.setText("Modelo");

        modeloTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modeloTxtActionPerformed(evt);
            }
        });

        jLabel4.setText("Tipo Vehiculo");

        carroRbt.setText("Carro");
        carroRbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carroRbtActionPerformed(evt);
            }
        });

        motoRbt.setText("Moto");

        jLabel5.setText("Remolque");

        remolqueCheck.setText("Tiene remolque");
        remolqueCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remolqueCheckActionPerformed(evt);
            }
        });

        jLabel6.setText("Nro Cascos");

        cascosTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cascosTxtActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Datos del Conductor");

        jLabel8.setText("Cedula");

        cedulaTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cedulaTxtActionPerformed(evt);
            }
        });

        jLabel9.setText("Nombre");

        nombreTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreTxtActionPerformed(evt);
            }
        });

        jLabel10.setText("Apellido");

        apellidoTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apellidoTxtActionPerformed(evt);
            }
        });

        jLabel11.setText("Edad");

        edadTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edadTxtActionPerformed(evt);
            }
        });

        guardarBtn.setText("Guardar");
        guardarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(parquederoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(67, 67, 67)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(apellidoTxt)
                                                .addComponent(nombreTxt)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(remolqueCheck)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addComponent(carroRbt)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                                                            .addComponent(motoRbt))
                                                        .addComponent(placaTxt)
                                                        .addComponent(colorTxt)
                                                        .addComponent(modeloTxt)))
                                                .addComponent(cedulaTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(edadTxt)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(cascosTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(guardarBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(parquederoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(placaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(colorTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(modeloTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(carroRbt)
                        .addComponent(motoRbt)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(remolqueCheck))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(cascosTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(cedulaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(nombreTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(apellidoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(edadTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(guardarBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void modeloTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modeloTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modeloTxtActionPerformed

    private void carroRbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carroRbtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_carroRbtActionPerformed

    private void remolqueCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remolqueCheckActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_remolqueCheckActionPerformed

    private void cascosTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cascosTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cascosTxtActionPerformed

    private void cedulaTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cedulaTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cedulaTxtActionPerformed

    private void nombreTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreTxtActionPerformed

    private void apellidoTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apellidoTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apellidoTxtActionPerformed

    private void edadTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edadTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edadTxtActionPerformed

    private void guardarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarBtnActionPerformed
        try {
            String placa = this.placaTxt.getText();
            String color = this.nombreTxt.getText();
            int modelo = Integer.parseInt(this.modeloTxt.getText());
            
            String cedula = this.cedulaTxt.getText();
            String nombre = this.nombreTxt.getText();
            String apellido = this.apellidoTxt.getText();
            int edad = Integer.parseInt(this.edadTxt.getText());
            
            Conductor cliente = new Conductor(cedula, nombre, apellido, edad);
            Vehiculo vehiculo = null;
            
            if  (this.carroRbt.isSelected()) {
                boolean remolque = this.remolqueCheck.isSelected();
                vehiculo = new Carro(placa, color, modelo, cliente, remolque);
            } else {
                int cascos = Integer.parseInt(this.cascosTxt.getText());
                vehiculo = new Moto(placa, color, modelo, cliente, cascos);
            }
            
            DB db = new DB();
            db.GuardarCarro(vehiculo);
            FormularioConfirmacion fConfirmacion = new FormularioConfirmacion(vehiculo, this.parqueadero);
            fConfirmacion.setVisible(true);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Los datos que has ingresado no son validos, valida los tipos de datos ingresados");
        }
        
        this.setVisible(false);
    }//GEN-LAST:event_guardarBtnActionPerformed

    private void placaTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_placaTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_placaTxtActionPerformed

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
            java.util.logging.Logger.getLogger(FormularioVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioVehiculo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellidoTxt;
    private javax.swing.JRadioButton carroRbt;
    private javax.swing.JTextField cascosTxt;
    private javax.swing.JTextField cedulaTxt;
    private javax.swing.JTextField colorTxt;
    private javax.swing.JTextField edadTxt;
    private javax.swing.JButton guardarBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField modeloTxt;
    private javax.swing.JRadioButton motoRbt;
    private javax.swing.JTextField nombreTxt;
    private javax.swing.JLabel parquederoNombre;
    private javax.swing.JTextField placaTxt;
    private javax.swing.JCheckBox remolqueCheck;
    // End of variables declaration//GEN-END:variables
}
