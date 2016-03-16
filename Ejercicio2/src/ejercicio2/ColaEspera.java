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
    
    int huecos,ocupados;
    static int tamanio;
    Queue <Pasajero> buffer;
    
    ColaEspera(){
        huecos=tamanio;
        ocupados=0;
    }
    public synchronized void llegadaPasajero(Pasajero p){
        while(huecos==0){
            p.espera();
        }
        buffer.add(p);
        huecos--;
        ocupados++;
        try{
            
        }catch(Exception ex){}
    }
    public synchronized Pasajero salida(){
        while(ocupados == 0){
            try{
                System.out.print("Pasajero esperando en la cola\n");
            TimeUnit.SECONDS.wait(2);
            }catch(Exception ex){}
        }
        Pasajero p= buffer.remove();
        ocupados--;
        huecos++;
        return p;
    }
}
