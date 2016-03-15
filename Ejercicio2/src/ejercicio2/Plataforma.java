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
    Plataforma(){
        huecos=tamanio;
        lleno=false;
    }
    public synchronized void entrada(Pasajero p,Semaphore coche){
        while(huecos==0){
            try{
                System.out.print("Pasajero esperando en plataforma\n");
                TimeUnit.SECONDS.sleep(2);
            }catch(Exception ex){}
        }
        buffer.add(p);
        huecos--;
        if(huecos==0){
            lleno=true;
            coche.release();
        }
    }
    public synchronized void subirCoche(Semaphore torno){
        while(!lleno){
            try{
                System.out.print("Vaciando la plataforma\n");
                TimeUnit.SECONDS.sleep(2);
            }catch(Exception ex){}
        }
        huecos = tamanio;
        lleno=false;
        torno.release();
    }
}
