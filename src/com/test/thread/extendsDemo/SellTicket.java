/**
 * 
 */
package com.test.thread.extendsDemo;

/**
 * @author LiuYanliang
 */
public class SellTicket extends Thread {
	
	//����100��Ʊ(����̹߳�����Դ)
	private static int tickets = 100;
			
	@Override
	public void run() {
		while(true){
			if(tickets > 0){
				System.out.println(getName()+"���ڳ��۵�"+(tickets--)+"��Ʊ");
			}else{
				System.out.println("Ʊ������");
				break;
			}
		}
		
	}

}
