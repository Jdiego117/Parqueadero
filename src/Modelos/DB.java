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
    
    public void GuardarCarro(Vehiculo vehiculo) {
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
}
