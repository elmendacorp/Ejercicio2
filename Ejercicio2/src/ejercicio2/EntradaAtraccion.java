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
    Semaphore coche;
    Torno entrar;
    Coche cacharrico;
    ColaEspera atraccion;
    Pasajero p;
    static int tamanio;
    EntradaAtraccion(){
        atraccion = new ColaEspera();
        p= new Pasajero();
        torno = new Semaphore(tamanio);
        entrar = new Torno(atraccion,torno,coche);
    }
    @Override
    public void run(){
        while(true){
            Pasajero in= new Pasajero();
           atraccion.llegadaPasajero(in, torno);
        }
    }
    
}
