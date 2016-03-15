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
public class ColaEspera {
    
    int cola,huecos,ocupados;
    static int tamanio;
    Queue <Pasajero> buffer;
    
    ColaEspera(){
        cola=0;
        huecos=tamanio;
        ocupados=0;
    }
    public synchronized void llegadaPasajero(Pasajero p,Semaphore torno){
        while(huecos==0){
            p.espera();
        }
        buffer.add(p);
        cola = (cola+1)%tamanio;
        huecos--;
        ocupados++;
        try{
            torno.acquire();
        }catch(Exception ex){}
    }
    public synchronized Pasajero salida(Semaphore torno){
        while(ocupados == 0){
            try{
                System.out.print("Pasajero esperando en la cola\n");
            TimeUnit.SECONDS.wait(2);
            }catch(Exception ex){}
        }
        Pasajero p= buffer.remove();
        ocupados--;
        huecos++;
        torno.release(1);
        return p;
    }
}
