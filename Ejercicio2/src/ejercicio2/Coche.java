/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Fran
 */
public class Coche implements Runnable{
    Semaphore coche;
    Plataforma plataformaAtraccion;
    ColaEspera colaAtraccion;
    Coche(Plataforma plataforma, ColaEspera micola, Semaphore coche){
        this.coche=coche;
        this.plataformaAtraccion=plataforma;
        this.colaAtraccion= micola;
    }
    @Override
    public void run(){
        while(true){
            while(!coche.tryAcquire()){
                System.out.print("Coche en espera\n");
                try{
                TimeUnit.SECONDS.sleep(5);
                }catch(Exception ex){}
            }
            System.out.print("Coche saliendo");
            plataformaAtraccion.subirCoche();
            
        }
    }
}
