/**
 * 
 */
package com.test.socket.udp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author LiuYanliang
 * 
 */
public class SendThread implements Runnable {

	private DatagramSocket sendDs;


	public SendThread( DatagramSocket sendDs) {
		this.sendDs = sendDs;
	}

	@Override
	public void run() {
		try {
			//��װ����¼������
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String line = null;
	        while((line = br.readLine())!= null){
	            if("886".equals(line)){
	                break;
	            }
	            // �������ݣ��������ݴ��
	            byte[] bys = line.getBytes();
	            DatagramPacket dp = new DatagramPacket(bys, bys.length,InetAddress.getByName("192.168.9.255"), 8888);
	            // ����Socket��send�������������ݰ�
	            sendDs.send(dp);
	        }
	        // �ͷ���Դ
	        sendDs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
			
		}

	}

