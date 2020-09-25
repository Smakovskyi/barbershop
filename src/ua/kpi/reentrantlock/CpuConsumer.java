/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kpi.reentrantlock;

/**
 *
 * @author sds
 */
public class CpuConsumer extends Thread {
    Queue queue;

    public CpuConsumer(Queue queue) {
        this.queue = queue;
    }
    
    public void run(){
        while( ! isInterrupted()){
            Product prod = queue.pull();
            if( prod != null){
                try {
                    System.out.println("Task is performing");
                    Thread.sleep(prod.time);
                    
                } catch (InterruptedException ex) {
                   return;
                }
            }else{
                Thread.yield();
            }
        }
    }
    
}
