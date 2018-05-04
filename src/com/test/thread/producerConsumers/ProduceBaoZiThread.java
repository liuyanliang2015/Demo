/**
 * 
 */
package com.test.thread.producerConsumers;


/**
 *�����������߳�
 */
public class ProduceBaoZiThread implements Runnable {
	private BaoZi bz;
	private int x = 0;
	/**
	 * @param bz
	 */
	public ProduceBaoZiThread(BaoZi bz) {
		this.bz = bz;
	}

	@Override
	public void run() {
		
		while(true){
			synchronized (bz) {
				if(bz.flag){
					try {
						bz.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				if(x % 2 == 0){
					bz.setName("�����а���");
					bz.setPrice(2.0f);
				}else{
					bz.setName("�²˼�������");
					bz.setPrice(1.5f);
				}
				x++;
				bz.flag = true;
				bz.notify();
			}
			
		}
		
	}

}
