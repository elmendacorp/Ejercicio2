/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Fran
 */
public class Torno implements Runnable {
    ColaEspera colaAtraccion;
    Plataforma plataforma;
    Pasajero pasajero;
    Semaphore torno;
    Torno(ColaEspera cola, Plataforma miplataforma,Semaphore torno ){
        this.torno=torno;
        this.colaAtraccion = cola;
        pasajero = new Pasajero();
        this.plataforma=miplataforma;
       
    }
    @Override
    public void run(){
        while(true){
            while(!torno.tryAcquire()){
                System.out.print("Torno bloqueado\n");
            }
            pasajero= colaAtraccion.salida();
            plataforma.entrada(pasajero);
        }
    }
    
}
