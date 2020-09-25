/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kpi.no.queue;

import static java.lang.Thread.interrupted;
import static java.lang.Thread.sleep;
import java.util.Random;

/**
 *
 * @author Денис
 */
public class Consumer extends Thread{
    
     //  Queue queue;
	
	private volatile Integer task;
	
    public Consumer() {
       
    }
    
    public synchronized boolean  put(Integer newTask){
    	if( task != null ){
    		return false;
    	}
    	task = newTask;
    	notify();
    	return true;
    }
    
    public void run(){
        while(!interrupted()){
            Integer i;
            while( (i = task) == null){
            	synchronized(this){
            		try {
						wait();
					} catch (InterruptedException e) {
						return ;
					}  
            	}
            }
            System.out.println("value = "+ i);
            try {
                sleep(200);
                
            } catch (InterruptedException ex) {
                return ;
            }
            task = null;
        }
    }


    
}
