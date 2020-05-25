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
public class Moto extends Vehiculo implements Serializable{
    private int nroCascos;

    public Moto(String placa, String color, int modelo, Conductor conductor, int nroCascos) {
        super(placa, color, modelo, conductor);
        this.nroCascos = nroCascos;
    }

    /**
     * Sobreescritura del metodo para calcular la tarifa
     * @param segundos
     * @return tarifa segun estadia para moto
     * @author Eveline
     */
    @Override
    public double calcularTarifa(int segundos) {
        //crear una varible que contenga el precio por segundo
        double tarifa = 0.2;
        //multiplicar los segundos de estadia por la tarifa por segundo
        double total = tarifa * segundos;
        //sumar al total 500 por cada casco
        total += total + getNroCascos() * 500;
        //retornar el total
        return total;
    }

    //Getters y Setters
    
    public int getNroCascos() {
        return nroCascos;
    }

    public void setNroCascos(int nroCascos) {
        this.nroCascos = nroCascos;
    }
}
