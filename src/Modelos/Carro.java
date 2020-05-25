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
    
    /**
     * Sobreescritura del metodo para calcular la tarifa
     * @param segundos
     * @return tarifa segun estadia para carro
     * @author Eveline
     */
    @Override
    public double calcularTarifa(int segundos) {
        //crear una varible que contenga el precio por segundo
        double valor = 0.5;
        //multiplicar los segundos de estadia por la tarifa por segundo
        double total = valor * segundos;
        
        //comprobar si el carro tiene remolque, si lo tiene, sumar 700 al total
        if (isRemolque()) {
           total += 700; 
        }
        //retornar el total
        return total;
    }

    //Getters y Setters
    
    public boolean isRemolque() {
        return remolque;
    }

    public void setRemolque(boolean remolque) {
        this.remolque = remolque;
    }
}
