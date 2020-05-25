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
import java.io.Serializable;
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
public class Parqueadero extends javax.swing.JFrame implements Serializable {

    public Cubiculo cubiculos[] = new Cubiculo[10]; 
    
    public String nombre = "Parqueadero c.c";
    
    /**
     * Creates new form Parqueadero
     */
    public Parqueadero() {
        initComponents();
        iniciarCubiculos();
        cargarParqueadero();
    }
    
    public void cargarParqueadero() {
        DB db = new DB();
        Cubiculo[] guardado = db.CargarCubiculos();
        if (guardado == null) {
            return;
        }
        this.cubiculos = guardado;
        this.actualizarInformacion();
    }
    
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
        this.nroRemolquesTxt.setText(String.valueOf(contarCarrosRemolque()));
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
      
    public String mayorNroCascos() {
        String placa = "";
        int numeroCascos = 0;
        for (int i = 0; i < cubiculos.length; i++) {
            if (cubiculos[i] != null) {
                if (cubiculos[i].vehiculo instanceof Moto) {
                    if (((Moto)cubiculos[i].vehiculo).getNroCascos()>numeroCascos) {
                        placa = cubiculos[i].vehiculo.getPlaca();
                        numeroCascos= ((Moto)cubiculos[i].vehiculo).getNroCascos();
                    }       
                }              
            }             
        }
        return placa;
    }
      
    public int contarCarrosRemolque() { 
        int contador = 0;
        for (int i = 0; i < cubiculos.length; i++){
            if(cubiculos[i] != null) {
                if (cubiculos[i].vehiculo instanceof Carro) {
                    if (((Carro)cubiculos[i].vehiculo).isRemolque()){
                        contador++;
                    }
                }    
            } 
        }
        return contador;  
    }
    
    public void iniciarCubiculos() {
        for (int i = 0; i < 10; i++) {
            this.cubiculos[i] = null;
        }
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
    
    
    public String mayorFactura() { 
        String nombre = "";
        double mayor = 0;
        DB db = new DB();
        LinkedList<Factura> facturas = db.CargarHistorialFacturas();
        
        for (int i = 0; i < facturas.size(); i++) {
            if(facturas.get(i).getValor() > mayor) {
                mayor = facturas.get(i).getValor();
                nombre = facturas.get(i).getCliente().getNombre();
            }
        }
        
        return nombre;
    }
    
    public String mayorModeloCarro() { 
        String placa = "";
        int mayorModelo = 0;
        for (int i = 0; i < cubiculos.length; i++) {
            if (cubiculos[i] != null) {
                if(cubiculos[i].vehiculo instanceof Carro) {
                    if (cubiculos[i].vehiculo.getModelo()>mayorModelo) {
                        mayorModelo = cubiculos[i].vehiculo.getModelo();
                        placa = cubiculos[i].vehiculo.getPlaca();
                    }
                }   
            }               
        }
        return placa;
    } 
    
    public String menorModeloCarro() { 
        String nombre = "";
        int menorModelo = 0;
        for (int i = 0; i < cubiculos.length; i++) {
            if (cubiculos[i] != null) {
                if(cubiculos[i].vehiculo instanceof Carro) {
                    if (cubiculos[i].vehiculo.getModelo()<menorModelo || i==0) {
                        menorModelo = cubiculos[i].vehiculo.getModelo();
                        nombre = cubiculos[i].vehiculo.getConductor().getNombre();
                    } 
                }     
            }          
        }
        return nombre;  
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
        nroRemolquesTxt = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        agregarBtn = new javax.swing.JButton();
        expulsarBtn = new javax.swing.JButton();
        reporteBtn = new javax.swing.JButton();
        mayorBtn = new javax.swing.JButton();
        menorBtn = new javax.swing.JButton();
        mayorCascosBtn = new javax.swing.JButton();
        modificarBtn = new javax.swing.JButton();
        mayorPagoBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        parquederoNombre.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        parquederoNombre.setText("Parqueadero c.c");

        jLabel1.setText("Cubiculos disponibles:");

        cubiculosDisponiblesTxt.setText("10/10");

        jLabel2.setText("Carros:");

        nroCarrosTxt.setText("0");

        jLabel3.setText("Motos:");

        nroMotosTxt.setText("0");

        nroRemolquesTxt.setText("0");

        jLabel4.setText("Carros con remolque:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nroRemolquesTxt)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(nroRemolquesTxt))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        mayorBtn.setText("Carro de mayor modelo");
        mayorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mayorBtnActionPerformed(evt);
            }
        });

        menorBtn.setText("Carro con menor modelo");
        menorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menorBtnActionPerformed(evt);
            }
        });

        mayorCascosBtn.setText("Moto con mas cascos");
        mayorCascosBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mayorCascosBtnActionPerformed(evt);
            }
        });

        modificarBtn.setText("Modificar vehiculo");
        modificarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarBtnActionPerformed(evt);
            }
        });

        mayorPagoBtn.setText("Mayor pago");
        mayorPagoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mayorPagoBtnActionPerformed(evt);
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
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(menorBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(mayorBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(mayorCascosBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(mayorPagoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(modificarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(reporteBtn)))
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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mayorBtn)
                    .addComponent(mayorCascosBtn))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(menorBtn)
                    .addComponent(mayorPagoBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reporteBtn)
                    .addComponent(modificarBtn))
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

    private void mayorBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mayorBtnActionPerformed
        String placa = mayorModeloCarro();
        if (placa == "") {
            JOptionPane.showMessageDialog(this, "No hay carros");
        } else {
            JOptionPane.showMessageDialog(this, "La placa del carro con el mayor modelo es:" + placa);
        }
    }//GEN-LAST:event_mayorBtnActionPerformed

    private void menorBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menorBtnActionPerformed
        String nombre = menorModeloCarro();
        if (nombre == "") {
            JOptionPane.showMessageDialog(this, "No hay carros");
        } else {
            JOptionPane.showMessageDialog(this, "El nombre de la persona con el carro de menor modelo es:" + nombre);
        }
    }//GEN-LAST:event_menorBtnActionPerformed

    private void mayorCascosBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mayorCascosBtnActionPerformed
        String placa = mayorNroCascos();
        if (placa == "") {
            JOptionPane.showMessageDialog(this, "No hay motos");
        } else {
            JOptionPane.showMessageDialog(this, "La placa de la moto con mas cascos es:" + placa);
        }
    }//GEN-LAST:event_mayorCascosBtnActionPerformed

    private void modificarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarBtnActionPerformed
        Buscar buscar = new Buscar("actualizar");
        buscar.setVisible(true);
    }//GEN-LAST:event_modificarBtnActionPerformed

    private void mayorPagoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mayorPagoBtnActionPerformed
        String nombre = mayorFactura();
        if (nombre == "") {
            JOptionPane.showMessageDialog(this, "No hay historial de facturas aun");
        } else {
            JOptionPane.showMessageDialog(this, "La persona que mas ha pagado por un servicio es: " + nombre);
        }
    }//GEN-LAST:event_mayorPagoBtnActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        DB db = new DB();
        db.GuardarCubiculos(this.cubiculos);
    }//GEN-LAST:event_formWindowClosing

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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton mayorBtn;
    private javax.swing.JButton mayorCascosBtn;
    private javax.swing.JButton mayorPagoBtn;
    private javax.swing.JButton menorBtn;
    private javax.swing.JButton modificarBtn;
    private javax.swing.JLabel nroCarrosTxt;
    private javax.swing.JLabel nroMotosTxt;
    private javax.swing.JLabel nroRemolquesTxt;
    private javax.swing.JLabel parquederoNombre;
    private javax.swing.JButton reporteBtn;
    // End of variables declaration//GEN-END:variables
}
