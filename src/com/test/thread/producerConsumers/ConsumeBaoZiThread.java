/**
 * 
 */
package com.test.thread.producerConsumers;

/**
 * �����������߳�
 */
public class ConsumeBaoZiThread implements Runnable {

	BaoZi bz;

	/**
	 * @param bz
	 */
	public ConsumeBaoZiThread(BaoZi bz) {
		this.bz = bz;
	}

	@Override
	public void run() {
		synchronized (bz) {
			
			while(true){
				
				if(!bz.flag){
					try {
						bz.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				
				System.out.println(bz.getName() + "-----" + bz.getPrice());
				bz.flag = false;
				bz.notify();
			}
			
		}
		

	}

}
