/**
 * 
 */
package com.test.socket.tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * @author LiuYanliang
 * 
 */
public class SendThread implements Runnable {

	private Socket socket;


	public SendThread( Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		System.out.println("s-run");
		try {
			
			//���������ַ���
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	         
	        //��ͨ���ڵ�����װһ��
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
	         
	        String line = null;
	        while((line = br.readLine()) != null){
	            if("886".equals(line)){
	                break;
	            }
	            bw.write(line);
	            bw.newLine();
	            bw.flush();
	        }
	         
	        //�ͷ���Դ
	        //bw.close();
	        //br.close();
	        socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
			
		}

	}

