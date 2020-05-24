/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.Serializable;

/**
 *
 * @author juand
 */
public class Moto extends Vehiculo implements Serializable{
    private int nroCascos;

    public Moto(String placa, String color, int modelo, Conductor conductor, int nroCascos) {
        super(placa, color, modelo, conductor);
        this.nroCascos = nroCascos;
    }


    public int getNroCascos() {
        return nroCascos;
    }

    public void setNroCascos(int nroCascos) {
        this.nroCascos = nroCascos;
    }
}
