package com.wy.concurrent.netty.sysnIO.second.TimeServer;

import java.io.*;
import java.net.Socket;
import java.util.Date;

/**
 * Created on 2019/8/31.
 * Title: Simple
 * Description:
 * Copyright: Copyright(c) 2019
 * Company:
 *
 * @author wy
 */
public class TimeServerHandler implements Runnable {
    private Socket socket;
    public TimeServerHandler(Socket socket){
        this.socket=socket;
    }
    @Override
    public void run() {
        BufferedReader in =null;
        PrintWriter out=null;
        try {
            in=new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            out=new PrintWriter( this.socket.getOutputStream(),true);
            String currentTime=null;
            String body=null;
            while (true){
                //通过readline读取一行，如果已经读到了输入流的尾部，则返回null，退出循环
                //如果读到了非空值，则对内容进行判断，如果请求消息为查询时间的指令"QUERY TIME ORDER"，则获取当前的最新的系统时间
                //通过PintWriter的printLn函数发送给客户端，最后退出循环。
                body=in.readLine();
                if (null==body){
                    break;
                }
                System.out.println("The time server receive order:"+body);
                currentTime="QUERY TIME ORDER".equalsIgnoreCase(body)? new Date(System.currentTimeMillis()).toString(): "BAD ORDER";
                out.println(currentTime);
            }
        } catch (Exception e) {
           if (null!=in){
               try {
                   in.close();
               } catch (IOException e1) {
                   e1.printStackTrace();
               }
               if (null!=out){
                   out.close();
                   out=null;
               }
               if (null!=this.socket){
                   try {
                       this.socket.close();
                   } catch (IOException e1) {
                       e1.printStackTrace();
                   }
                   this.socket=null;
               }
           }
        }
    }
}
