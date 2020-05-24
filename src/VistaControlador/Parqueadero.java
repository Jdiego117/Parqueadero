/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VistaControlador;

import Modelos.Carro;
import Modelos.Cubiculo;
import Modelos.DB;
import Modelos.Factura;
import Modelos.Moto;
import Modelos.Vehiculo;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author juand
 */
public class Parqueadero extends javax.swing.JFrame {

    public Cubiculo cubiculos[] = new Cubiculo[10]; 
    public LinkedList<Factura> facturas; 
    
    public String nombre = "Parqueadero c.c";
    
    public int cubiculosDisponibles() {
        int disponibles = 0;       
        for (int i = 0; i < cubiculos.length; i++) {
            if(cubiculos[i] == null) {
                disponibles++;
            }
        }        
        return disponibles;
    } 
    
    public int encontrarCubiculo() {
        int res = -1;
        int i = 0;
        while(i < this.cubiculos.length) {
            System.out.println(i);
            System.out.println(cubiculos[i]);
            if(cubiculos[i] == null) {
                res = i;
                break;
            }
            i++;
        }
        return res;
    }
    
    public void setCubiculo(int index, Cubiculo cubiculo) {
        this.cubiculos[index] = cubiculo; 
    }
    
    public void actualizarInformacion() {
        int disponibles = cubiculosDisponibles();
        this.cubiculosDisponiblesTxt.setText(String.valueOf(disponibles) + "/" + cubiculos.length);
        int carros = contarCarros();
        this.nroCarrosTxt.setText(String.valueOf(carros));
        int motos = contarMotos();
        this.nroMotosTxt.setText(String.valueOf(motos));  
    }
    
    public int contarCarros() { 
        int contador = 0;
        for (int i = 0; i < cubiculos.length; i++){
            if(cubiculos[i] != null) {
                if (cubiculos[i].vehiculo instanceof Carro){
                    contador++;
                }
            }
        }
        return contador; 
    } 
    
    public int contarMotos() { 
        int contador = 0;
        for (int i = 0; i < cubiculos.length; i++){
            if(cubiculos[i] != null) {
                if (cubiculos[i].vehiculo instanceof Moto){
                    contador++;
                }
            }
        }
        return contador; 
    } 
    
    /* 
        public Moto mayorNroCascos() {
        }
    */ 
    
    public int contarCarrosRemolque() { 
        int contador = 0;
        for (int i = 0; i < cubiculos.length; i++){
            if (cubiculos[i].vehiculo instanceof Carro) {
                if (((Carro)cubiculos[i].vehiculo).isRemolque()){
                    contador++;
                }
            }
        }
        return contador;  
    }
    
    public void iniciarCubiculos() {
        for (int i = 0; i < 10; i++) {
            this.cubiculos[i] = null;
        }
        
        System.out.println(cubiculos[3]);
    }
    
    public String reporteVehiculos() { 
        return ""; 
    } 
    
    public int buscarCubiculo(String placa) {
        int index = -1;
       
        for (int i = 0; i < cubiculos.length; i++) {
            if(cubiculos[i] != null) {
                if(cubiculos[i].getVehiculo().getPlaca().equals(placa)) {
                    index = i;
                }
            }
        }
        return index;
    }
    
    public Cubiculo getCubiculo(int index) {
        return this.cubiculos[index];
    }
    
    /* 
        public Factura mayorFactura() { 
    
        }    
    
        public Carro mayorModeloCarro() { 
    
        } 
    
        public Carro menorModeloCarro() { 
    
        } 
    */
    
    
    
    /**
     * Creates new form Parqueadero
     */
    public Parqueadero() {
        initComponents();
        System.out.println(System.getenv("APPDATA"));
        iniciarCubiculos();
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
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cubiculosDisponiblesTxt = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nroCarrosTxt = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nroMotosTxt = new javax.swing.JLabel();
        agregarBtn = new javax.swing.JButton();
        expulsarBtn = new javax.swing.JButton();
        reporteBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        parquederoNombre.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        parquederoNombre.setText("Parqueadero c.c");

        jLabel1.setText("Cubiculos disponibles:");

        cubiculosDisponiblesTxt.setText("10/10");

        jLabel2.setText("Carros:");

        nroCarrosTxt.setText("0");

        jLabel3.setText("Motos:");

        nroMotosTxt.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nroMotosTxt)
                    .addComponent(nroCarrosTxt)
                    .addComponent(cubiculosDisponiblesTxt))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cubiculosDisponiblesTxt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nroCarrosTxt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nroMotosTxt))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        agregarBtn.setText("Agregar vehiculo");
        agregarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarBtnActionPerformed(evt);
            }
        });

        expulsarBtn.setText("Expulsar vehiculo");
        expulsarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expulsarBtnActionPerformed(evt);
            }
        });

        reporteBtn.setText("Reporte de los vehiculos");
        reporteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reporteBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(parquederoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(agregarBtn)
                                .addGap(18, 18, 18)
                                .addComponent(expulsarBtn))
                            .addComponent(reporteBtn))
                        .addGap(0, 134, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(parquederoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregarBtn)
                    .addComponent(expulsarBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(reporteBtn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarBtnActionPerformed
        Buscar buscar = new Buscar(this);
        buscar.setVisible(true);
    }//GEN-LAST:event_agregarBtnActionPerformed

    private void expulsarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_expulsarBtnActionPerformed
        BuscarEnParqueadero buscarP = new BuscarEnParqueadero(this);
        buscarP.setVisible(true);
        
        /*Factura fa = new Factura();
        fa.CalcularFactura(new Date());
        textViewer txt = new textViewer(fa.imprimirFactura());
        txt.setVisible(true);*/
    }//GEN-LAST:event_expulsarBtnActionPerformed

    private void reporteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reporteBtnActionPerformed
        DB db = new DB();
        LinkedList<Vehiculo> vehiculos = db.obtenerTodosVehiculos();
        
        String reporte = "Placa;Color;Modelo;Tipo;Dueño;Cedula;Edad\n";
        
        for (int i = 0; i < vehiculos.size(); i++) {
            Vehiculo veh = vehiculos.get(i);
            if(veh instanceof Carro) {
                reporte += veh.getPlaca()+";"+veh.getColor()+";"+veh.getModelo()+";Carro;"+veh.getConductor().getNombre()+";"+veh.getConductor().getCedula()+";"+veh.getConductor().getEdad()+";\n";
            } else {
                reporte += veh.getPlaca()+";"+veh.getColor()+";"+veh.getModelo()+";Moto;"+veh.getConductor().getNombre()+";"+veh.getConductor().getCedula()+";"+veh.getConductor().getEdad()+";\n";
            }
        }
        
        try {
            JFileChooser ventana = new JFileChooser();
            ventana.showSaveDialog(this);
            String ruta = ventana.getSelectedFile().toString();
            try (BufferedWriter archivo = new BufferedWriter(new FileWriter(ruta + ".csv"))) {
                   archivo.write(reporte);
            }
            JOptionPane.showMessageDialog(this, "El archivo fue guardado correctamente","Informacion",JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "El archivo no fue guardado, operacion invalida","Informacion",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_reporteBtnActionPerformed

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
            java.util.logging.Logger.getLogger(Parqueadero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Parqueadero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Parqueadero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Parqueadero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Parqueadero().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarBtn;
    private javax.swing.JLabel cubiculosDisponiblesTxt;
    private javax.swing.JButton expulsarBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nroCarrosTxt;
    private javax.swing.JLabel nroMotosTxt;
    private javax.swing.JLabel parquederoNombre;
    private javax.swing.JButton reporteBtn;
    // End of variables declaration//GEN-END:variables
}
