/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.very.simple;

/**
 *
 * @author Денис
 */
public class Runner {
    public static void main(String[] args) throws InterruptedException {
        Queue queue = new LockQueue();
        Consumer consumer = new Consumer(queue);
        consumer.start();
        new Producer(queue).start();
        Thread.sleep(20);
        
        new Consumer(queue).start();
        System.out.println("main is finished");
                
    }
    
}
