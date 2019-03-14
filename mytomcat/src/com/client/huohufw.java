package com.client;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class huohufw {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	//1.建立一个socket对象连接itcast.cn域名的80端口
		Socket socket=null;
		InputStream io=null;
		OutputStream ops=null;
			try {
				socket=new Socket("www.itcast.cn",80);
				//2.获取到输出流对象
				io=socket.getInputStream();
				 //3.获取到输入流对象
				ops=socket.getOutputStream();
				 //4.将HTTP协议的请求部分发送到服务端
				ops.write("GET /subject/about/index.html HTTP/1.1\n".getBytes());
				ops.write("HOST:www.itcast.cn\n".getBytes());
				ops.write("\n".getBytes());
				 //5.获取到来自服务器的数据打印到控制台
				int i=io.read();
				while(i!=-1) {
					System.out.println((char)i);
					i=io.read();
				}
				 //6.释放资源
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


