package com.kgc.service.impl;

import com.kgc.client.Invitation_chatrecordClient;
import com.kgc.pojo.Invitation_chatrecord;
import com.kgc.service.Invitation_chatrecordService;
import com.kgc.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Service
public class Invitation_chatrecordServiceImpl implements Invitation_chatrecordService {
    java.net.ServerSocket ServerSocket = null;//开放的套接字
    Socket socket = null;//链接客户端的套接字
    Scanner fromKey = null;//键盘输入流
    Scanner fromClient = null;//获取从客户端读的字节流
    PrintWriter toClient = null;//获取向客户端写的字节流

    @Autowired
    private Invitation_chatrecordClient chatrecordClient;
    //分页，根据发送方和接收方编号查询所有聊天信息,并按照发送时间降序排列
    @Override
    public PageUtil<Invitation_chatrecord> getAllInvitation_chatrecord(String putid, String gainid, Integer pageIndex, Integer pageSize) {
        //封装成一个map对象
        Map<String,Object> map=new HashMap<>();
        map.put("putid",putid);
        map.put("gainid",gainid);
        map.put("pageIndex",(pageIndex-1)*pageSize);
        map.put("pageSize",pageSize);
        return chatrecordClient.getAllInvitation_chatrecord(map);
    }
    //添加聊天记录
    @Override
    public int addcontent(Invitation_chatrecord invitation_chatrecord) {
        try {
            ServerSocket = new ServerSocket(8866);
            //System.out.println("服务器已启动,等待客户端链接");
            //链接客户端的套接字
            socket = ServerSocket.accept();

            //实例化向客户端写的字节流
            toClient = new PrintWriter(socket.getOutputStream());
            toClient.println("");
            toClient.flush();
            //System.out.println("我(服务器端) : 你好啊客户端!!!");
            /*
             * 注意:服务器端与客户端不能都先获取输入流,这样会导致socket阻塞
             * */
            //实例化从服务器读的字节流
            fromClient = new Scanner(socket.getInputStream());
            //实例化键盘输入流
            fromKey = new Scanner(System.in);

            //阻塞等待客户端发送消息
            while(fromClient.hasNextLine()){
                String fromClientData = fromClient.nextLine();
                System.out.println("客户端 :" + fromClientData);
                System.out.print("我(服务器端) :");
                //获取输入的数据
                String toClientData = fromKey.nextLine();
                invitation_chatrecord.setContent(toClientData);
                //发送给客户端
                toClient.println(toClientData);
                toClient.flush();
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            try {
                fromClient.close();
                toClient.close();
                socket.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return chatrecordClient.addcontent(invitation_chatrecord);
    }


}
