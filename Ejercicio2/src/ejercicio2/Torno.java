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
    Semaphore Semtorno;
    Semaphore Semcoche;
    Torno(ColaEspera cola ,Semaphore torno,Semaphore coche){
        this.colaAtraccion = cola;
        pasajero = new Pasajero();
        this.Semtorno=torno;
        this.Semcoche=coche;
    }
    @Override
    public void run(){
        while(true){
            pasajero= colaAtraccion.salida(Semtorno);
            plataforma.entrada(pasajero,Semcoche);
        }
    }
    
}
