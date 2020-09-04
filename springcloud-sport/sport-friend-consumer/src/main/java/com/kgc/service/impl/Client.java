package com.kgc.service.impl;

import com.kgc.client.Invitation_chatrecordClient;
import com.kgc.pojo.Invitation_chatrecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Invitation_chatrecordClient chatrecordClient = null;
        Socket socket = null;//与服务器链接的套接字
        Scanner fromKey = null;//键盘输入流
        Scanner fromServer = null;//获取服务器发送的字节流
        PrintWriter toServer = null;//向服务器发送的字节流

        try {
            //链接服务器的套接字
            socket = new Socket("localhost",8866);

            /*
             * 注意:服务器端与客户端不能都先获取输入流,这样会导致socket阻塞
             * */
            //实例化从服务器读的字节流
            fromServer = new Scanner(socket.getInputStream());
            //实例化向服务器写的字节流
            toServer = new PrintWriter(socket.getOutputStream());
            //实例化键盘输入流
            fromKey = new Scanner(System.in);

            while(fromServer.hasNextLine()){
                //阻塞等待服务器发送消息
                String fromServerData = fromServer.nextLine();
                System.out.println("服务器 :" + fromServerData);
                System.out.print("我(客户端) :");
                //获取输入的数据
                String toServerData = fromKey.nextLine();
                //发送给服务器
                toServer.println(toServerData);
                toServer.flush();
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            try {
                fromServer.close();
                toServer.close();
                socket.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }


    }
}
