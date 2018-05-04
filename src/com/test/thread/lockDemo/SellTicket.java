/**
 * 
 */
package com.test.thread.lockDemo;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author LiuYanliang
 */
public class SellTicket implements Runnable {
	// ����100��Ʊ
	private static int tickets = 100;
	private final ReentrantLock lock = new ReentrantLock();

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {

			try {
				// ��ȡ��
				lock.lock();
				if (tickets > 0) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()
							+ "���ڳ��۵�" + (tickets--) + "��Ʊ");
				} else {
					System.out.println(Thread.currentThread().getName()
							+ "Ʊ������");
					break;
				}
			} finally {
				// �ͷ���
				lock.unlock();
			}

		}

	}

}
