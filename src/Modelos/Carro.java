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
public class Carro extends Vehiculo implements Serializable{
    private boolean remolque;

    public Carro(String placa, String color, int modelo, Conductor conductor, boolean remolque) {
        super(placa, color, modelo, conductor);
        this.remolque = remolque;
    }

    public boolean isRemolque() {
        return remolque;
    }

    public void setRemolque(boolean remolque) {
        this.remolque = remolque;
    }

    @Override
    public double calcularTarifa(Date hora) {
        return 0;
    }
}
