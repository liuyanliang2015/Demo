/**
 * 
 */
package com.test.socket.tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author LiuYanliang
 * 
 */
public class ReceiveThread implements Runnable {


	private ServerSocket serverSocket;

	public ReceiveThread(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}

	@Override
	public void run() {
		System.out.println("r-run");
		while (true) {
			try {
				// �����ͻ������ӣ�����һ����Ӧ��Socket����
		        Socket socket = serverSocket.accept();
		        // ��ȡ����(��ȡ�������������ݣ���ʾ�ڿ���̨)-��װͨ�����ݵ���
		        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		        String line = null;
		        while ((line = br.readLine()) != null) {
		            String ip = socket.getInetAddress().getHostAddress();
		            System.out.println(ip + "->" + line);
		        }
		        //�ͷ���Դ
		        socket.close();
		        //serverSocket.close(); ���������ر�
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

	}

}
