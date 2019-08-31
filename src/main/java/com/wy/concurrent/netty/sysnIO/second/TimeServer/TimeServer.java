package com.wy.concurrent.netty.sysnIO.second.TimeServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created on 2019/8/31.
 * Title: Simple
 * Description:同步阻塞IO服务端
 * Copyright: Copyright(c) 2019
 * Company:
 *
 * @author wy
 */
public class TimeServer {

    public static void main(String[] args) throws IOException {
        //TimeServer 根据传入的参数设置监听端口，如果没有参数，使用默认端口8080.
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                //采用默认值
            }
        }
        ServerSocket server = null;
        try {
            //通过构造函数创建ServerSocket，如果端口合法且没有被占用，服务端监听成功
            server=new ServerSocket(port);
            System.out.println("The time server is start in port :"+port);
            Socket socket=null;
            //通过一个无限循环来监听客户端的连接，如果客户端没有接入，则主线程阻塞在ServerSocket的accept上面操作上。
            while (true){
                socket=server.accept();
                //当有客户端连接进来，会执行下面的代码
                //以Socket为参数构造TimeServerHandler对象，TimeServerHandler是一个Runable，使用它为构造函数的参数创建一个新的
                //客户端线程处理这条Socket链路。
                new Thread(new TimeServerHandler(socket));
            }
        } catch (Exception e) {
        }finally {
            if (null!=server){
                System.out.println("The time server close");
                server.close();
                server=null;
            }
        }
    }
}
