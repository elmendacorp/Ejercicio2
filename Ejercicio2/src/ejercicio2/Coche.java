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
public class Coche implements Runnable{
    Semaphore coche;
    Semaphore torno;
    Plataforma plataformaAtraccion;
    Coche(Semaphore torno, Semaphore coche,Plataforma plataforma){
        this.torno=torno;
        this.coche= coche;
        this.plataformaAtraccion=plataforma;
    }
    @Override
    public void run(){
        while(true){
            plataformaAtraccion.subirCoche(torno);
            
        }
    }
}
