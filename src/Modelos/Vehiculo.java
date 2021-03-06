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
public abstract class Vehiculo implements Serializable{
    private String placa;
    private String color;
    private int modelo;
    private Conductor conductor;

    public Vehiculo(String placa, String color, int modelo, Conductor conductor) {
        this.placa = placa;
        this.color = color;
        this.modelo = modelo;
        this.conductor = conductor;
    } 
    
    /**
     * Metodo que debera ser sobreescrito para calcular la tarifa
     * @param segundos
     * @return la tarifa segun el tiempo de estadia
     * @author Eveline
     */
    public abstract double calcularTarifa(int segundos);
    
    
    //Getters y Setters
    
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }
    
    
}
