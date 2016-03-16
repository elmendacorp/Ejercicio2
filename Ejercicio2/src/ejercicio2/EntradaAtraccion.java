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
public class EntradaAtraccion implements Runnable{
    Semaphore torno;
    ColaEspera atraccion;
    Pasajero p;
    static int tamanio;
    EntradaAtraccion(ColaEspera micola){
        this.atraccion=micola;
    }
    @Override
    public void run(){
        while(true){
            Pasajero in= new Pasajero();
            atraccion.llegadaPasajero(in);
        }
    }
    
}
