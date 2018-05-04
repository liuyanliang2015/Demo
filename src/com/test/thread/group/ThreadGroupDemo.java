/**
 * 
 */
package com.test.thread.group;


/**
 * @author LiuYanliang
 *
 */
public class ThreadGroupDemo {
	public static void main(String[] args) {
		MyThread my = new MyThread();
		ThreadGroup group = new ThreadGroup("test");
		Thread t1 = new Thread(group,my,"�߳�1");
		Thread t2 = new Thread(group,my,"�߳�2");
		System.out.println(t1.getThreadGroup().getName()); //test
		System.out.println(t2.getThreadGroup().getName()); //test
		
		//�������������߳�Ϊ�ػ��߳�
		group.setDaemon(true);
		//�������������̵߳�������ȼ�
		group.setMaxPriority(10);
	}

}
