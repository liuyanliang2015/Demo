/**
 * 
 */
package com.test.thread.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author LiuYanliang
 *
 */
public class ExecutorsDemo {
	public static void main(String[] args) {
		//�����̳߳ض���
		ExecutorService  executorService = Executors.newFixedThreadPool(2);
		
		//ִ���߳�
		executorService.submit(new MyThread());
		executorService.submit(new MyThread());
		
		//�����̳߳�
		executorService.shutdown();
	}
}
