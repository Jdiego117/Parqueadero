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
public class Factura {
    private Conductor cliente;
    private Vehiculo vehiculo;
    private int Segundos;
    private double valor;

    public Factura(Conductor cliente, Vehiculo vehiculo, int Segundos, double valor) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.Segundos = Segundos;
        this.valor = valor;
    }

    public Conductor getCliente() {
        return cliente;
    }

    public void setCliente(Conductor cliente) {
        this.cliente = cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public int getSegundos() {
        return Segundos;
    }

    public void setSegundos(int Segundos) {
        this.Segundos = Segundos;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
