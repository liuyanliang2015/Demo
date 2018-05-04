/**
 * 
 */
package com.test.thread.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author LiuYanliang
 * 
 */
public class CallableDemo {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// �����̳߳ض���
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		//ִ��Callable
		Future<Integer> result1 = executorService.submit(new MyCallable(10));
		System.out.println(result1.get()); //55
		
		Future<Integer> result2 = executorService.submit(new MyCallable(100));
		System.out.println(result2.get());//5050
		//�ر��̳߳�
		executorService.shutdown();
	}

}
