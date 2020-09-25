/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kpi.reentrantlock;

/**
 *
 * @author sds
 */
public class ProcessProducer extends Thread {
    Queue queue;

    public ProcessProducer(Queue queue) {
        this.queue = queue;
    }
    public void run(){
        while(!isInterrupted()){
            queue.push( new Product(5) );
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                return;
            }
        }
    }
}
