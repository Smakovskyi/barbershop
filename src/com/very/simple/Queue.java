/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.very.simple;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Денис
 */
public class Queue {
    protected LinkedList<Integer> list = new LinkedList<>();
    protected final int LIMIT = 10;

    public synchronized void push(Integer val) {
    	while( list.size() >= LIMIT ){
            try {
                wait();
            } catch (InterruptedException ex) {
                return ;
            }
        }

        list.add(val);
        notifyAll();
    }
    
    public synchronized Integer pop(){
        if( list.size() == 0 ){
            return null;
        }
        while(  list.size() == 0 ){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Queue.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        Integer temp = list.pop();
        
        notifyAll();
        return temp;
        
    }
    
}
