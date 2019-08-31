package com.wy.concurrent.netty.sysnIO.second.TimeServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created on 2019/8/31.
 * Title: 同步阻塞客户端
 * Description:
 * Copyright: Copyright(c) 2019
 * Company:
 *
 * @author wy
 */
public class TimeClient {

    //客户端通过Socket创建，发送查询时间服务器的"QUERY TIME ORDER"指令，然后读取服务端的响应并且返回结果并打印出来，随后关闭连接，释放资源
    public static void main(String[] args) {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (Exception e) {
                //采用默认值
            }
            Socket socket = null;
            BufferedReader in = null;
            PrintWriter out = null;
            try {
                socket = new Socket("127.0.0.1", port);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
                out.println("QUERY TIME  ORDER");
                System.out.println("Send order 2 server succeed.");
                String resp = in.readLine();
                System.out.println("Now is :" + resp);
            } catch (Exception e) {
                //不需要处理
            } finally {
                if (null != out) {
                    out.close();
                    out = null;
                }
                if (null != in) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    in = null;
                }
                if (null != socket) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    socket = null;
                }
            }
        }
    }
}
