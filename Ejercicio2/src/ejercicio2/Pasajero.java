/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author Fran
 */
public class Pasajero extends Thread{
    Pasajero(){
    }
    void espera(){
        try{
        System.out.print("Pasajero esperando en plataforma\n");
        TimeUnit.SECONDS.sleep(2);
        }catch(Exception ex){}
    }
}
