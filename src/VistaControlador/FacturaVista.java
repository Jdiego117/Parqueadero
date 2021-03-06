/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VistaControlador;

import Modelos.Cubiculo;
import Modelos.Factura;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author juand
 */
public class FacturaVista extends javax.swing.JFrame {

    int cubiculo = -1;
    Parqueadero parqueadero = null;
    Factura factura = null;
    
    /**
     * Creates new form FacturaVista
     */
    public FacturaVista() {
        initComponents();
    }
    
    /**
     * Crear ventana de factura con la posicion del cubiculo que se facturara y el parqueadero
     * @param index
     * @param parqueadero 
     * @author Diego
     */
    public FacturaVista(int index, Parqueadero parqueadero) {
        initComponents();
        //igualar variables locales a las dadas
        this.cubiculo = index;
        this.parqueadero = parqueadero;
        //llamar al metodo que genera la factura
        GenerarFactura();
    }
    
    /**
     * Generar la factura y sacar el vehiculo del parqueadero
     */
    public void GenerarFactura() {
        //obtener el cubiculo donde esta el vehiculo
        Cubiculo cubiculo = this.parqueadero.getCubiculo(this.cubiculo);
        //crear la factura dando el vehiculo
        factura = new Factura(cubiculo.getVehiculo());
        //calcular la factura dando la hora a la que se registro el ingreso
        factura.CalcularFactura(cubiculo.getHora());
        //vaciar el cubiculo donde estaba el vehiculo
        this.parqueadero.setCubiculo(this.cubiculo, null);
        //llamar al metodo del parqueadero que actualiza la informacion de los cubiculos en la interfaz
        this.parqueadero.actualizarInformacion();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        parquederoNombre = new javax.swing.JLabel();
        parquederoNombre1 = new javax.swing.JLabel();
        exportarBtn = new javax.swing.JButton();
        verBtn = new javax.swing.JButton();
        cerrarBtn = new javax.swing.JButton();

        jButton3.setText("Exportar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        parquederoNombre.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        parquederoNombre.setText("Factura Generada");

        parquederoNombre1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        parquederoNombre1.setText("Parqueadero c.c");

        exportarBtn.setText("Exportar");
        exportarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportarBtnActionPerformed(evt);
            }
        });

        verBtn.setText("Ver");
        verBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verBtnActionPerformed(evt);
            }
        });

        cerrarBtn.setText("Cerrar");
        cerrarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(exportarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(verBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cerrarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(parquederoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(parquederoNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(162, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .addComponent(parquederoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exportarBtn)
                    .addComponent(verBtn)
                    .addComponent(cerrarBtn))
                .addGap(26, 26, 26))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(parquederoNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(144, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exportarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportarBtnActionPerformed
        //obtener el texto de la factura
        String factura = this.factura.imprimirFactura();
        //intentar guardar
        try {
            //mostrar ventana para seleccionar donde se quiere guardar la factura
            JFileChooser ventana = new JFileChooser();
            ventana.showSaveDialog(this);
            String ruta = ventana.getSelectedFile().toString();
            //guardar el archivo con el texto de la factura en la direccion seleccionada
            try (BufferedWriter archivo = new BufferedWriter(new FileWriter(ruta + ".txt"))) {
                   archivo.write(factura);
            }
            JOptionPane.showMessageDialog(this, "El archivo fue guardado correctamente","Informacion",JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "El archivo no fue guardado, operacion invalida","Informacion",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_exportarBtnActionPerformed

    private void verBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verBtnActionPerformed
        //crear una ventana de visualizacion de texto con la factura
        textViewer txt = new textViewer(factura.imprimirFactura());
        txt.setVisible(true);
    }//GEN-LAST:event_verBtnActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void cerrarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarBtnActionPerformed
        //cerrar esta ventana
        this.setVisible(false);
    }//GEN-LAST:event_cerrarBtnActionPerformed

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
            java.util.logging.Logger.getLogger(FacturaVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FacturaVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FacturaVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FacturaVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FacturaVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cerrarBtn;
    private javax.swing.JButton exportarBtn;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel parquederoNombre;
    private javax.swing.JLabel parquederoNombre1;
    private javax.swing.JButton verBtn;
    // End of variables declaration//GEN-END:variables
}
