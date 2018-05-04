/**
 * 
 */
package com.test.thread;

/**
 * @author LiuYanliang
 *
 */
public class ThreadDemo {
	public static void main(String[] args) {
		//�̳�Thread��
		new Thread(){
			public void run() {
				for(int i = 0 ;i<100;i++){
					System.out.println(Thread.currentThread().getName()+":"+i);
				}
			};
			
		}.start();
		
		
		//ʵ��Runnable�ӿ�
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 0 ;i<100;i++){
					System.out.println(Thread.currentThread().getName()+":"+i);
				}
			}
		}){
			
		}.start();
	}

}
