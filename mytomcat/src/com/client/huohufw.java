package com.client;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class huohufw {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	//1.����һ��socket��������itcast.cn������80�˿�
		Socket socket=null;
		InputStream io=null;
		OutputStream ops=null;
			try {
				socket=new Socket("www.itcast.cn",80);
				//2.��ȡ�����������
				io=socket.getInputStream();
				 //3.��ȡ������������
				ops=socket.getOutputStream();
				 //4.��HTTPЭ������󲿷ַ��͵������
				ops.write("GET /subject/about/index.html HTTP/1.1\n".getBytes());
				ops.write("HOST:www.itcast.cn\n".getBytes());
				ops.write("\n".getBytes());
				 //5.��ȡ�����Է����������ݴ�ӡ������̨
				int i=io.read();
				while(i!=-1) {
					System.out.println((char)i);
					i=io.read();
				}
				 //6.�ͷ���Դ
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		finally {
			
			if(null!=io) {
				io.close();
				io=null;
			}

			if(null!=ops) {
				ops.close(); 
				ops=null;
			}
			if(null!=socket) {
				socket.close();
				socket=null;
			}
		}
		}
		
		
	}


