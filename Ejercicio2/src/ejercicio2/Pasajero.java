/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

/**
 *
 * @author Fran
 */
public class Pasajero extends Thread{
    Thread entrar;
    Pasajero(){
        entrar=new Thread();
        entrar.start();
    }
    void espera(){
        try{
        entrar.wait(2000);
        }catch(Exception ex){}
    }
}
