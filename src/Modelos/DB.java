/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import VistaControlador.Parqueadero;
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
    
    public Vehiculo buscar(String placa) throws IOException, ClassNotFoundException{
        File file = new File(DIR + "/vehiculos/" + placa + ".bin");
        
        if (!file.exists()) {
            return null;
        }
        
        FileInputStream fos = new FileInputStream(DIR + "/vehiculos/" + placa + ".bin");
        ObjectInputStream ois = new ObjectInputStream(fos);
        Vehiculo resultado = (Vehiculo) ois.readObject();

        return resultado;
    }
    
    public LinkedList<Vehiculo> obtenerTodosVehiculos() {
        String[] archivos = ListarCarpeta(DIR + "/vehiculos");
        
        if(archivos == null || archivos.length == 0) {
            return null;
        }
        
        LinkedList<Vehiculo> vehiculos = new LinkedList<Vehiculo>();
        
        for (int i = 0; i < archivos.length; i++) {
            try {
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
        
        return vehiculos;
    }
    
    public String[] ListarCarpeta(String dir) {
        File carpeta = new File(dir);
        String[] listado = carpeta.list();
        
        return listado;
    }
    
    public void GuardarCarro(Vehiculo vehiculo) {
        if(!new File(DIR + "/vehiculos").exists()) {
            new File(DIR + "/vehiculos").mkdirs();
        }
        try {
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
    
    public void GuardarCubiculos(Cubiculo[] cubiculos) {
        try {
            FileOutputStream fos = new FileOutputStream(DIR + "/cubiculos.bin");
            ObjectOutputStream oss = new ObjectOutputStream(fos);
            oss.writeObject(cubiculos);
            oss.close();
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
    }
    
    public Cubiculo[] CargarCubiculos() {
        File file = new File(DIR + "/cubiculos.bin");
        
        if (!file.exists()) {
            return null;
        }
        
        try {
            
            FileInputStream fos = new FileInputStream(DIR + "/cubiculos.bin");
            ObjectInputStream ois = new ObjectInputStream(fos);
            Cubiculo[] resultado = (Cubiculo[]) ois.readObject();
            return resultado;
            
        } catch (FileNotFoundException ex) {          
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }
        return null;
    }
    
    public void AgregarFacturaHistorial(Factura factura) {
        LinkedList<Factura> facturas = CargarHistorialFacturas();
        if(facturas == null) {
            facturas = new LinkedList<Factura>();
        }
        
        facturas.add(factura);
        
        GuardarHistorialFacturas(facturas);
    }
    
    public void GuardarHistorialFacturas(LinkedList<Factura> facturas) {
        
        if(!new File(DIR + "/facturas").exists()) {
            new File(DIR + "/facturas").mkdirs();
        }
        
        try {
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
    
    public LinkedList<Factura> CargarHistorialFacturas() {
        File file = new File(DIR + "/facturas/historial.bin");
        
        if (!file.exists()) {
            return null;
        }
        
        try {
            
            FileInputStream fos = new FileInputStream(DIR + "/facturas/historial.bin");
            ObjectInputStream ois = new ObjectInputStream(fos);
            LinkedList<Factura> resultado = (LinkedList<Factura>) ois.readObject();
            return resultado;
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
