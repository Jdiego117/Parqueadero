/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author juand
 */
public class Carro extends Vehiculo {
    private boolean remolque;

    public Carro(String placa, String color, int modelo, Conductor conductor) {
        super(placa, color, modelo, conductor);
    }

    public boolean isRemolque() {
        return remolque;
    }

    public void setRemolque(boolean remolque) {
        this.remolque = remolque;
    }
}
