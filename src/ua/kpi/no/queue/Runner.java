/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kpi.no.queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 *
 * @author Денис
 */
public class Runner {
    public static void main(String[] args) throws InterruptedException {
        //Queue queue = new Queue();
    	//List list = Collections.synchronizedList(new ArrayList());
    	
    	Consumer first = new Consumer();
    	first.start();
    	
        
        Producer producer = new Producer(first);
        producer.start();
        Thread.sleep(10000);
        
        producer.interrupt();
        first.interrupt();
        
        System.out.println("main is finished");
                
    }
    
}
