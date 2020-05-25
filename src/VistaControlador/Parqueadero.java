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

    //Variables de la clase principal
    public Cubiculo cubiculos[] = new Cubiculo[10]; 
    public String nombre = "Parqueadero c.c";
    
    /**
     * Creates new form Parqueadero
     */
    public Parqueadero() {
        initComponents();
        //inicia el vector de cubiculos con valores nulos para evitar errores en comprobaciones
        iniciarCubiculos();
        //carga el parqueadero a su ultimo estado
        cargarParqueadero();
    }
    
    /**
     * Carga el parqueadero al ultimo estado antes de cerrarlo
     * @author Diego
     */
    public void cargarParqueadero() {
        //crear instancia de la clase DB
        DB db = new DB();
        //Cargar los cubiculos almacenados
        Cubiculo[] guardado = db.CargarCubiculos();
        if (guardado == null) {
            return; // retornar en caso de no exister archivo alguno
        }
        this.cubiculos = guardado; // igualar vector locar de cubiculos al almacenado
        //llamar al metodo que actualiza los datos de la interfaz
        this.actualizarInformacion();
    }
    
    /**
     * Encontrar cuantos cubiculos estan disponibles
     * @return numero de cubiculos vacios
     * @author Eveline
     */
    public int cubiculosDisponibles() {
        //crear variable que tendra el numero de cubiculos disponibles
        int disponibles = 0;       
        //ciclo para recorrer el vector de cubiculos local
        for (int i = 0; i < cubiculos.length; i++) {
            //si la posicion i en el vector esta vacia (null) sumar 1 al contador de disponibles
            if(cubiculos[i] == null) {
                disponibles++;
            }
        }        
        //retornar el numero de cubiculos disponibles
        return disponibles;
    } 
    
    /**
     * Encontrar algun cubiculo disponible
     * @return posicion de un espacio vacio en el vector de cubiculos
     * @author Eveline
     */
    public int encontrarCubiculo() {
        //crear varible que tendra la posicion libre, inicializada en -1 que significa que no hay un lugar disponible
        int res = -1;
        //crear la varible i para el ciclo mientras
        int i = 0;
        //mientras la variable i sea menor a la longitud del vector de cubiculos
        while(i < this.cubiculos.length) {
            //Comprobar si el vector en la posicion i esta vacio
            if(cubiculos[i] == null) {
                //si esta vacio igualar la variable de respuesta a la posicion i
                res = i;
                //salir del metodo para dejar de buscar una posicion libre
                break;
            }
            i++;
        }
        //retornar la varible con la posicion libre, o con -1 en caso de que no se encuentre un lugar vacio
        return res;
    }
    
    /**
     * Guardar un cubiculo en una posicion dada del vector de cubiculos
     * @param index
     * @param cubiculo 
     * @Eveline
     */
    public void setCubiculo(int index, Cubiculo cubiculo) {
        //guardar en la posicion i del vector de vehiculos el objeto resibido como parametro
        this.cubiculos[index] = cubiculo; 
    }
    
    /**
     * Obtiene el cubiculo que se encuentra en una posicion dada del vector
     * @param index
     * @return cubiculo que se encuentra en la posicion
     * @author Eveline
     */
    public Cubiculo getCubiculo(int index) {
        //retornar el elemento de la posicion dada
        return this.cubiculos[index];
    }
    
    /**
     * Actualiza la informacion de la interfaz con los datos de los cubiculos
     * @author Eveline
     */
    public void actualizarInformacion() {
        //Escribir en la interfaz cuantos cubiculos hay disponibles
        int disponibles = cubiculosDisponibles();
        this.cubiculosDisponiblesTxt.setText(String.valueOf(disponibles) + "/" + cubiculos.length);
        //Escribir en la interfaz cuantos carros hay en el parqueadero
        int carros = contarCarros();
        this.nroCarrosTxt.setText(String.valueOf(carros));
        //Escribir en la interfaz cuantas motos hay en el parqueadero
        int motos = contarMotos();
        this.nroMotosTxt.setText(String.valueOf(motos));  
        //Escribir en la interfaz cuantos carros con remolques hay en el parqueadero
        this.nroRemolquesTxt.setText(String.valueOf(contarCarrosRemolque()));
    }
    
    /**
     * Contar cuantos carros hay en el vector de cubiculos del parqueadero
     * @return numero de carros en el parqueadero
     * @author Eveline
     */
    public int contarCarros() {
        //variable donde se contaran los carros
        int contador = 0;
        //ciclo que recorre el vector de cubiculos
        for (int i = 0; i < cubiculos.length; i++){
            //comprobar que el cubiculo no este vacio (diferente de null)
            if(cubiculos[i] != null) {
                //comprobar si el vehiculo es un carro
                if (cubiculos[i].vehiculo instanceof Carro){
                    //aumentar en 1 el contador
                    contador++;
                }
            }
        }
        //retornar el contador
        return contador; 
    } 
    
    /**
     * Contar cuantas motos hay en el vector de cubiculos
     * @return numero de motos en el parqueadero
     * @author Eveline
     */
    public int contarMotos() {
        //variable donde se contaran los carros
        int contador = 0;
        //ciclo que recorre el vector de cubiculos
        for (int i = 0; i < cubiculos.length; i++){
            //comprobar que el cubiculo no este vacio (diferente de null)
            if(cubiculos[i] != null) {
                //comprobar si el vehiculo es una moto
                if (cubiculos[i].vehiculo instanceof Moto){
                    //aumentar en 1 el contador
                    contador++;
                }
            }
        }
        //retornar el contador
        return contador; 
    } 
      
    /**
     * Encontar la placa de la moto con mas cascos
     * @return placa de la moto con mas cascos
     * @author Eveline
     */
    public String mayorNroCascos() {
        //varible donde se guardara la placa, si no se encuentra seguira estando vacia
        String placa = "";
        //mayor numero de cascos encontrado
        int numeroCascos = 0;
        //ciclo que recorre el vector de cubiculos
        for (int i = 0; i < cubiculos.length; i++) {
            //comprobar que el cubiculo no este vacio (diferente de null)
            if (cubiculos[i] != null) {
                //comprobar si el vehiculo es una moto
                if (cubiculos[i].vehiculo instanceof Moto) {
                    //Comprobar si el numero de cascos de la moto es mayor que el almacenado en la varible
                    if (((Moto)cubiculos[i].vehiculo).getNroCascos()>numeroCascos) {
                        //igualar la varible a la placa de moto
                        placa = cubiculos[i].vehiculo.getPlaca();
                        //igualar el mayor numero de cascos al numero de cascos que tiene la moto
                        numeroCascos= ((Moto)cubiculos[i].vehiculo).getNroCascos();
                    }       
                }              
            }             
        }
        //retornar la placa
        return placa;
    }
      
    /**
     * Contar cuantos carros del parqueadero tienen remolque
     * @return numero de carros con remolque
     * @author Eveline
     */
    public int contarCarrosRemolque() { 
        //contador de carros con remolque
        int contador = 0;
        //ciclo que recorre el vector de cubiculos
        for (int i = 0; i < cubiculos.length; i++){
            //comprobar que el cubiculo no este vacio (diferente de null)
            if(cubiculos[i] != null) {
                //comprobar si el vehiculo es un Carro
                if (cubiculos[i].vehiculo instanceof Carro) {
                    //comprobar si el carro tiene un remolque
                    if (((Carro)cubiculos[i].vehiculo).isRemolque()){
                        //aumentar en 1 el contador de carros con remolque
                        contador++;
                    }
                }    
            } 
        }
        //retornar el contador
        return contador;  
    }
    
    /**
     * Rellena todos los campos del vector de cubiculos con null
     * @author Diego
     */
    public void iniciarCubiculos() {
        //recorrer el vector de cubiculos
        for (int i = 0; i < 10; i++) {
            //igualar el vector en la posicion i a null
            this.cubiculos[i] = null;
        }
    }

    /**
     * Buscar un cubiculo que contenga un vehiculo dado su placa
     * @param placa
     * @return posicion del cubiculo encontrado en el vector
     * @author Diego
     */
    public int buscarCubiculo(String placa) {
        //iniciar varible que contendra la posicion, si conserva el valor -1 es porque el vehiculo no fue encontrado
        int index = -1;
        //ciclo que recorre el vector de cubiculos
        for (int i = 0; i < cubiculos.length; i++) {
            //comprobar que el cubiculo no este vacio (diferente de null)
            if(cubiculos[i] != null) {
                //comparar la placa del vehiculo encontrado con la placa solicitada
                if(cubiculos[i].getVehiculo().getPlaca().equals(placa)) {
                    //igualar la posicion i en la varible index si las placas son iguales
                    index = i;
                }
            }
        }
        //retornar la posicion encontrada o -1
        return index;
    }
    
    /**
     * Encontrar el nombre de la persona que mas ha pagado en una factura
     * @return el nomre de la persona
     * @author Diego
     */
    public String mayorFactura() { 
        //variable para guardar el nombre, si no hay facturas se conservara el valor vacio
        String nombre = "";
        //variable para guardar el mayor valor encontrado hasta el momento
        double mayor = 0;
        //instancia de la clase DB
        DB db = new DB();
        //crear una lista de facturas y almacenar ahi el historial de facturas guardado en los archivos del programa
        LinkedList<Factura> facturas = db.CargarHistorialFacturas();
        //recorrer la lista de facturas
        for (int i = 0; i < facturas.size(); i++) {
            //comprobar si el valor de la factura en la posicion i supera al de la variable mayor
            if(facturas.get(i).getValor() > mayor) {
                //igualar la variable mayor al valor de la factura
                mayor = facturas.get(i).getValor();
                //igualar el nombre al nombre de la persona a la cual pertenece la factura
                nombre = facturas.get(i).getCliente().getNombre();
            }
        }
        //retornar el nombre
        return nombre;
    }
    
    /**
     * Encontrar la placa del carro de mayor modelo
     * @return placa del carro
     * @author Eveline
     */
    public String mayorModeloCarro() { 
        //variable donde se guardara la placa
        String placa = "";
        //variable con el mayor modelo encontrado hasta el momento
        int mayorModelo = 0;
        //recorrer el vector de cubiculos
        for (int i = 0; i < cubiculos.length; i++) {
            //comprobar que el cubiculo no este vacio (diferente de null)
            if (cubiculos[i] != null) {
                //comprobar si el vehiculo es un carro
                if(cubiculos[i].vehiculo instanceof Carro) {
                    //comprobar si el modelo del carro es mayor que el ultimo encontrado en la variable
                    if (cubiculos[i].vehiculo.getModelo()>mayorModelo) {
                        //igualar el mayor modelo al modelo del carro
                        mayorModelo = cubiculos[i].vehiculo.getModelo();
                        //igualar la placa a la placa del carro encontrado
                        placa = cubiculos[i].vehiculo.getPlaca();
                    }
                }   
            }               
        }
        //retornar la placa del carro
        return placa;
    } 
    
    /**
     * Encontrar el nombre del dueño con el carro de menor modelo
     * @return nombre del dueño
     * @author Eveline
     */
    public String menorModeloCarro() { 
        //variable del nombre
        String nombre = "";
        //variable del menor modelo encontrado
        int menorModelo = 0;
        //recorrer el vector de cubiculos
        for (int i = 0; i < cubiculos.length; i++) {
            //comprobar que el cubiculo no este vacio (diferente de null)
            if (cubiculos[i] != null) {
                //comprobar si el vehiculo es un carro
                if(cubiculos[i].vehiculo instanceof Carro) {
                    /*
                    Comprobar si el modelo del carro es menor a el ultimo carro
                    O si es el primer carro que encuentra, ya que el modelo del primer
                    carro nunca sera menor que 0
                    */
                    if (cubiculos[i].vehiculo.getModelo()<menorModelo || i==0) {
                        //igualar el menor modelo al modelo del carro
                        menorModelo = cubiculos[i].vehiculo.getModelo();
                        //igualar el nombre al nombre del dueño del vehiculo
                        nombre = cubiculos[i].vehiculo.getConductor().getNombre();
                    } 
                }     
            }          
        }
        //retornar el nombre
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
        //crear una ventana de busqueda y darle este parqueadero
        Buscar buscar = new Buscar(this);
        buscar.setVisible(true);
    }//GEN-LAST:event_agregarBtnActionPerformed

    private void expulsarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_expulsarBtnActionPerformed
        //crear una ventana de busqueda en parqueadero para encontrar el vehiculo que se quiere expulsar
        BuscarEnParqueadero buscarP = new BuscarEnParqueadero(this);
        buscarP.setVisible(true);
    }//GEN-LAST:event_expulsarBtnActionPerformed

    private void reporteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reporteBtnActionPerformed
        //generar un reporte de los vehiculos
        
        //crear una instancia de la clase BD
        DB db = new DB();
        //llamar el metodo que carga todos los vehiculos guardados en los archivos
        LinkedList<Vehiculo> vehiculos = db.obtenerTodosVehiculos();
        
        //crear la estructura del reporte
        String reporte = "Placa;Color;Modelo;Tipo;Dueño;Cedula;Edad\n";
        
        //recorrer la lista de vehiculos
        for (int i = 0; i < vehiculos.size(); i++) {
            //obtener el vehiculo que se encuentra en la posicion i
            Vehiculo veh = vehiculos.get(i);
            //agregar la informacion del vehiculo separa por ; dependiendo del tipo
            if(veh instanceof Carro) {
                reporte += veh.getPlaca()+";"+veh.getColor()+";"+veh.getModelo()+";Carro;"+veh.getConductor().getNombre()+";"+veh.getConductor().getCedula()+";"+veh.getConductor().getEdad()+";\n";
            } else {
                reporte += veh.getPlaca()+";"+veh.getColor()+";"+veh.getModelo()+";Moto;"+veh.getConductor().getNombre()+";"+veh.getConductor().getCedula()+";"+veh.getConductor().getEdad()+";\n";
            }
        }
        
        //intentar guardar el reporte
        try {
            //crear una ventana para elegir donde se quiere guardar el archivo
            JFileChooser ventana = new JFileChooser();
            ventana.showSaveDialog(this);
            String ruta = ventana.getSelectedFile().toString();
            //intentar guardar el archivo con el reporte generado en la ruta escogida
            try (BufferedWriter archivo = new BufferedWriter(new FileWriter(ruta + ".csv"))) {
                   archivo.write(reporte);
            }
            JOptionPane.showMessageDialog(this, "El archivo fue guardado correctamente","Informacion",JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "El archivo no fue guardado, operacion invalida","Informacion",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_reporteBtnActionPerformed

    private void mayorBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mayorBtnActionPerformed
        //llamar el metodo que busca la placa del carro de mayor modelo
        String placa = mayorModeloCarro();
        if (placa == "") {
            //si no se encontro mostrar este mensaje
            JOptionPane.showMessageDialog(this, "No hay carros");
        } else {
            //si se encontro mostrar la placa en un mensaje
            JOptionPane.showMessageDialog(this, "La placa del carro con el mayor modelo es:" + placa);
        }
    }//GEN-LAST:event_mayorBtnActionPerformed

    private void menorBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menorBtnActionPerformed
        //llamar el metodo que busca el nombre del dueño del carro de menor modelo
        String nombre = menorModeloCarro();
        if (nombre == "") {
            //si no se encontro mostrar este mensaje
            JOptionPane.showMessageDialog(this, "No hay carros");
        } else {
            //si se encontro mostrar el nombre en un mensaje
            JOptionPane.showMessageDialog(this, "El nombre de la persona con el carro de menor modelo es:" + nombre);
        }
    }//GEN-LAST:event_menorBtnActionPerformed

    private void mayorCascosBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mayorCascosBtnActionPerformed
        //llamar el metodo que busca la placa de la moto con mayor numero de cascos
        String placa = mayorNroCascos();
        if (placa == "") {
            //si no se encontro mostrar este mensaje
            JOptionPane.showMessageDialog(this, "No hay motos");
        } else {
            //si se encontro mostrar la placa en un mensaje
            JOptionPane.showMessageDialog(this, "La placa de la moto con mas cascos es:" + placa);
        }
    }//GEN-LAST:event_mayorCascosBtnActionPerformed

    private void modificarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarBtnActionPerformed
        //crear ventana de busqueda dandole la accion de actualizar
        Buscar buscar = new Buscar("actualizar");
        buscar.setVisible(true);
    }//GEN-LAST:event_modificarBtnActionPerformed

    private void mayorPagoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mayorPagoBtnActionPerformed
        //llamar el metodo que busca el nombre de la persona que mas ha pagado
        String nombre = mayorFactura();
        if (nombre == "") {
            //si no se encontro mostrar este mensaje
            JOptionPane.showMessageDialog(this, "No hay historial de facturas aun");
        } else {
            //si se encontro mostrar el nombre en un mensaje
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
