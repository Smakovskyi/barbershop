package com.very.simple;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import javax.management.RuntimeErrorException;

public class LockQueue extends Queue {

	private ReentrantLock lock = new ReentrantLock();
	private Condition fullCondition = lock.newCondition();
	private Condition emptyCondition = lock.newCondition();
	
	@Override
	public  void push(Integer val) {
		lock.lock();
		try {
			while( list.size() >= LIMIT ) {
				fullCondition.await();
			}
			list.add(val);
			emptyCondition.signal();
			
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}finally {
			lock.unlock();
		}
		
	}

	@Override
	public  Integer pop() {
		lock.lock();
		try {
			while( list.size() == 0 ) {
				emptyCondition.await();
			}
			Integer result = list.removeFirst();
			fullCondition.signal();
			return result;
		}catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			lock.unlock();
		}
		
	}

}
