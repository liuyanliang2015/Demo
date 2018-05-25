/**
 * 
 */
package com.test.socket.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author LiuYanliang
 * 
 */
public class ReceiveThread implements Runnable {


	private DatagramSocket receiveDs;

	public ReceiveThread(DatagramSocket receiveDs) {
		this.receiveDs = receiveDs;
	}

	@Override
	public void run() {
		while (true) {
			try {
				// ����һ�����ݰ�(��������)
				byte[] rbytes = new byte[1024];
				DatagramPacket dp1 = new DatagramPacket(rbytes, rbytes.length);
				// ����Socket��receive�������������ݰ�
				receiveDs.receive(dp1);
				String content = new String(dp1.getData(), 0, dp1.getLength());
				String message = dp1.getAddress().getHostAddress()+"->"+content;
				System.out.println(message);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

	}

}
