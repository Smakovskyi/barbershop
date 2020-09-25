/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kpi.no.queue;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Денис
 */
public class Producer extends Thread{
    //Queue queue;
	
	private Consumer consumer;
	private int deleted;
	

    public Producer(Consumer consumer) {
      
    	this.consumer = consumer;
    	
    }
    
    public void run(){
        while(!isInterrupted()){
            if( !consumer.put( new Random().nextInt())){
            	deleted++;
            }
           
        	
            try {
                sleep(100);
            } catch (InterruptedException ex) {
            	break;
            }
        }
        System.out.println("Deleted items "+deleted);
    }
    
    
}
