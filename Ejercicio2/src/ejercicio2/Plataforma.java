/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Fran
 */
public class Plataforma {
    int huecos;
    boolean lleno;
    static int tamanio;
    Queue <Pasajero> buffer;
    Semaphore micoche;
    ColaEspera entrada;
    Plataforma(ColaEspera micola, Semaphore coche){
        this.entrada=micola;
        this.micoche=coche;
        huecos=tamanio;
        lleno=false;
    }
    public synchronized void entrada(Pasajero p){
        while(huecos==0){
            try{
                p.espera();
            }catch(Exception ex){}
        }
        buffer.add(p);
        huecos--;
        if(huecos==0){
            lleno=true;
            micoche.release();
        }
    }
    public synchronized void subirCoche(){
        while(lleno){
            try{
                System.out.print("Vaciando la plataforma\n");
                TimeUnit.SECONDS.sleep(2);
            }catch(Exception ex){}
        }
        buffer.clear();
        huecos = tamanio;
        lleno=false;
        
        
    }
}
