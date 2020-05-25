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

    /**
     * Constructor de la clase factura con el vehiculo al cual se cobrara
     * @param vehiculo 
     * @author Eveline
     */
    public Factura(Vehiculo vehiculo) {
        //igualar las variables locales a los parametros
        this.vehiculo = vehiculo;
        this.cliente = vehiculo.getConductor();
    }

    /**
     * Calcula el tiempo en segundos que estuvo el vehiculo y calcular el valor a pagar 
     * @param hora 
     * @Author Eveline
     */
    public void CalcularFactura(Date hora) {
        //obtener la diferencia de hora entre la actual y la entregada en el metodo
        long diferencia = new Date().getTime() - hora.getTime();
        //convertir la diferencia a segundos y almacenarla en la varible locar "Segundos"
        Segundos = (int) TimeUnit.MILLISECONDS.toSeconds(diferencia);
        //Llamar al metodo del vehiculo que calcula la tarifa y almacenarla en la variable local "valor"
        this.valor = vehiculo.calcularTarifa(Segundos);
        //crear un objecto DB y llamar al metodo que almacena la factura en el historial
        DB db = new DB();
        db.AgregarFacturaHistorial(this);      
    }
    
    /**
     * Genera el texto de la factura con todos los datos
     * @return string con la factura
     * @author Eveline
     */
    public String imprimirFactura() {
        String factura = "";
        
        factura += "===================================\n";
        factura += "===Parqueadero centro comercial====\n";
        factura += "===================================\n";
        factura += "C.C: " + cliente.getCedula() + "   \n";
        factura += "Conductor: " +cliente.getNombre()+"\n";
        factura += "Edad: " + cliente.getEdad() + "    \n";
        factura += "===================================\n";
        
        //Comprobar si el vehiculo es un carro o moto para imprimir el tipo de vehiculo en la factura
        if(vehiculo instanceof Carro){
            factura += "Vehiculo: Carro           \n";
        } else {
            factura += "Vehiculo: Moto           \n";
        }
            
        factura += "Placa: " + vehiculo.getPlaca() + " \n";
        factura += "Color: " + vehiculo.getColor() + " \n";
        factura += "Modelo: " + vehiculo.getModelo()+ "\n";
        
        //Comprobar el tipo de vehiculo para poner el remolque o el numero de cascos
        if(vehiculo instanceof Carro){
            //comprobar si el carro trae un remolque y escribir un SI o NO 
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
        //retornar el texto de la factura
        return factura;
    }
    
    //getters y setters

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
