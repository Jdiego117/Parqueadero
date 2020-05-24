/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juand
 */
public class Factura implements Serializable{
    private Conductor cliente;
    private Vehiculo vehiculo;
    private int Segundos = 0;
    private double valor = 0;

    public Factura(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
        this.cliente = vehiculo.getConductor();
    }
    
    public Factura() {
        DB db = new DB();
        try {
            this.vehiculo = db.buscar("123");
            this.cliente = this.vehiculo.getConductor();
        } catch (IOException ex) {
            Logger.getLogger(Factura.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Factura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void CalcularFactura(Date hora) {
        long diferencia = new Date().getTime() - hora.getTime();
        Segundos = (int) TimeUnit.MILLISECONDS.toSeconds(diferencia);
        this.valor = vehiculo.calcularTarifa(Segundos);
        DB db = new DB();
        db.AgregarFacturaHistorial(this);      
    }
    
    public String imprimirFactura() {
        String factura = "";
        
        factura += "===================================\n";
        factura += "===Parqueadero centro comercial====\n";
        factura += "===================================\n";
        factura += "C.C: " + cliente.getCedula() + "   \n";
        factura += "Conductor: " +cliente.getNombre()+"\n";
        factura += "Edad: " + cliente.getEdad() + "    \n";
        factura += "===================================\n";
        
        if(vehiculo instanceof Carro){
            factura += "Vehiculo: Carro           \n";
        } else {
            factura += "Vehiculo: Moto           \n";
        }
            
        factura += "Placa: " + vehiculo.getPlaca() + " \n";
        factura += "Color: " + vehiculo.getColor() + " \n";
        factura += "Modelo: " + vehiculo.getModelo()+ "\n";
        
        if(vehiculo instanceof Carro){
            if(((Carro) vehiculo).isRemolque()) {
                factura += "Tiene remolque: SI\n";
            } else {
                factura += "Tiene remolque: NO\n";
            }
        } else {
            factura += "Cascos: "+ ((Moto)vehiculo).getNroCascos()+"\n";
        } 
        
        factura += "===================================\n";
        factura += "Segundos en parqueadero: "+Segundos+"\n";
        factura += "Valor a pagar: " + valor + "         \n";
        return factura;
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
