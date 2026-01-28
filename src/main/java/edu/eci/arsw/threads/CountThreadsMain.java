/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.threads;

/**
 *
 * @author hcadavid
 */
public class CountThreadsMain {
    
    public static void main(String a[]){
        Thread firstThread = new CountThread(0, 99);
        Thread secondThread = new CountThread(99, 199);
        Thread thirdThread = new CountThread(200,299);

        firstThread.start();
        secondThread.start();
        thirdThread.start();
    }
    
}
