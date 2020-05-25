/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author juand
 */
public class Cubiculo implements Serializable{
    public Vehiculo vehiculo;
    private Date hora;

    public Cubiculo(Vehiculo vehiculo, Date hora) {
        this.vehiculo = vehiculo;
        this.hora = hora;
    }
    
    //Getters y Setters
    
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }
    
    
}
