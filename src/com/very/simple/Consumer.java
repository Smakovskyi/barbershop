/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.very.simple;

import static java.lang.Thread.interrupted;
import static java.lang.Thread.sleep;
import java.util.Random;

/**
 *
 * @author Денис
 */
public class Consumer extends Thread{
    
    Queue queue;

    public Consumer(Queue queue) {
        this.queue = queue;
    }
    
    public void run(){
        while(!interrupted()){
        	Integer task;
        	task = queue.pop();
        
        	if( task == null) {
        		continue;
        	}
            System.out.println("value = "+ task);
            try {
                sleep(200);
                task = null;
            } catch (InterruptedException ex) {
                return ;
            }
        }
    }

/*	public synchronized boolean  directConsume(int newTask) {
		if( task == null) {
			task = newTask;
			this.notify();
			return true;
		}
		return false;
	}*/


    
}
