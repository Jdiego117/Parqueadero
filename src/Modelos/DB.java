/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juand
 */
public class DB {
    private String DIR;

    public DB() {
        this.DIR = System.getenv("APPDATA") + "/parqueadero";
        if(!new File(DIR).exists()) {
            new File(DIR).mkdirs();
        }
    }
    
    /**
     * Este metodo busca un vehiculo por su placa en los archivos almacenados
     * @param placa
     * @return El vehiculo encontrado
     * @author Diego 
     */
    public Vehiculo buscar(String placa) throws IOException, ClassNotFoundException{
        //comprobar si el archivo del vehiculo existe, en caso de no encontrarse retonar null
        File file = new File(DIR + "/vehiculos/" + placa + ".bin");
        
        if (!file.exists()) {
            return null;
        }
        
        //si el archivo existe, cargar el binario y castearlo a la clase vehiculo para despues retornarlo
        FileInputStream fos = new FileInputStream(DIR + "/vehiculos/" + placa + ".bin");
        ObjectInputStream ois = new ObjectInputStream(fos);
        Vehiculo resultado = (Vehiculo) ois.readObject();

        return resultado;
    }
    
    /**
     * Este metodo busca todos los vehiculos existentes en los archivos almacenados
     * @return Lista de vehiculos encontrados
     * @author Diego 
     */
    public LinkedList<Vehiculo> obtenerTodosVehiculos() {
        //Obtener todos los archivos en la carpeta vehiculos, si no hay ninguno retornar null
        String[] archivos = ListarCarpeta(DIR + "/vehiculos");
        
        if(archivos == null || archivos.length == 0) {
            return null;
        }
        
        //crear lista para almacenar los vehiculos que se cargaran
        LinkedList<Vehiculo> vehiculos = new LinkedList<Vehiculo>();
        
        //Ciclo que recorre el vector de todos los archivos encontrados
        for (int i = 0; i < archivos.length; i++) {
            try {
                //cargar el archivo binario, castearlo a la clase Vehiculo y agregarlo a la lista
                FileInputStream fos = new FileInputStream(DIR + "/vehiculos/" + archivos[i]);
                ObjectInputStream ois = new ObjectInputStream(fos);
                Vehiculo resultado = (Vehiculo) ois.readObject();
                vehiculos.add(resultado);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return vehiculos; //retornar la lista de vehiculos
    }
    
    /**
     * Este metodo busca todos los archivos existentes en una carpeta
     * @param dir donde se desea buscar
     * @return Lista de string con los archivos existentes
     * @author Diego 
     */
    public String[] ListarCarpeta(String dir) {
        //Obtener la carpeta del directorio solicitado
        File carpeta = new File(dir);
        //Almacenar en un vector cada nombre de archivo encontrado
        String[] listado = carpeta.list();
        //retornar el vector con los archivos
        return listado;
    }
    
    /**
     * Este metodo guarda un carro en los archivos del programa
     * @param vehiculo
     * @author Diego 
     */
    public void GuardarCarro(Vehiculo vehiculo) {
        //verificar si la carpeta vehiculos existe, de lo contrario crearla
        if(!new File(DIR + "/vehiculos").exists()) {
            new File(DIR + "/vehiculos").mkdirs();
        }
        try {
            //guardar vehiculo como archivo binario en la carpeta vehiculos, el nombre del archivo sera el de la placa
            FileOutputStream fos = new FileOutputStream(DIR + "/vehiculos/" + vehiculo.getPlaca() + ".bin");
            ObjectOutputStream oss = new ObjectOutputStream(fos);
            oss.writeObject(vehiculo);
            oss.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    
    /**
     * Este metodo guarda el vector de cubiculos en los archivos del programa
     * @param cubiculos
     * @author Diego 
     */
    public void GuardarCubiculos(Cubiculo[] cubiculos) {
        try {
            //Guardar vector de cubiculos recibido como parametro 
            FileOutputStream fos = new FileOutputStream(DIR + "/cubiculos.bin");
            ObjectOutputStream oss = new ObjectOutputStream(fos);
            oss.writeObject(cubiculos);
            oss.close();
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
    }
    
    /**
     * Este metodo carga el vector de cubiculos en los archivos del programa
     * @return Vector de cubiculos encontrados
     * @author Diego 
     */
    public Cubiculo[] CargarCubiculos() {
        //Comprobar si el archivo cubiculos existe, de lo contrario retornar null
        File file = new File(DIR + "/cubiculos.bin");
        
        if (!file.exists()) {
            return null;
        }
        
        try {        
            //Cargar el archivo binario y castearlo a un vector de cubiculos
            FileInputStream fos = new FileInputStream(DIR + "/cubiculos.bin");
            ObjectInputStream ois = new ObjectInputStream(fos);
            Cubiculo[] resultado = (Cubiculo[]) ois.readObject();
            //retornar el vector de cubiculos
            return resultado;       
        } catch (FileNotFoundException ex) {          
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }
        //retornar null en caso de un fallo al cargar
        return null;
    }
    
    /**
     * Este metodo agrega una factura al historial de facturas
     * @param factura 
     * @author Diego 
     */
    public void AgregarFacturaHistorial(Factura factura) {
        //Cargar en una lista el historial de facturas almacenado en los archivos
        LinkedList<Factura> facturas = CargarHistorialFacturas();
        //En caso de que el historial sea nulo iniciar uno nuevo
        if(facturas == null) {
            facturas = new LinkedList<Factura>();
        }
        
        //agregar la factura al historial
        facturas.add(factura);
        
        //llamar al metodo que guardara el nuevo historial actualizado
        GuardarHistorialFacturas(facturas);
    }
    
    /**
     * Este metodo guarda el historial de facturas en los archivos del programa
     * @param facturas
     * @author Diego 
     */
    public void GuardarHistorialFacturas(LinkedList<Factura> facturas) {
        //Comprobar si la carpeta facturas existe, de lo contrario crearla
        if(!new File(DIR + "/facturas").exists()) {
            new File(DIR + "/facturas").mkdirs();
        }
        
        try {
            //Guardar el historial de facturas como archivo binario
            FileOutputStream fos = new FileOutputStream(DIR + "/facturas/historial.bin");
            ObjectOutputStream oss = new ObjectOutputStream(fos);
            oss.writeObject(facturas);
            oss.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
    /**
     * Este metodo carga el historial de facturas almacenado en los archivos del programa
     * @return lista de facturas
     * @author Diego
     */
    public LinkedList<Factura> CargarHistorialFacturas() {
        //Comprobar si hay un historial guardado, de lo contrario retornar null
        File file = new File(DIR + "/facturas/historial.bin");   
        if (!file.exists()) {
            return null;
        }
        
        try {
            //Cargar el archivo binario y castearlo a una lista de facturas
            FileInputStream fos = new FileInputStream(DIR + "/facturas/historial.bin");
            ObjectInputStream ois = new ObjectInputStream(fos);
            LinkedList<Factura> resultado = (LinkedList<Factura>) ois.readObject();
            //retornar el historial
            return resultado;         
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        //retornar null en caso de error
        return null;
    }
}
