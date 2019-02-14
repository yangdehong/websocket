package com.ydh.redsheep.chat.chat;

import com.alibaba.fastjson.JSON;
import com.ydh.redsheep.testt.chat.model.MessageInfo;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: yangdehong
 * @version: 2017/6/4.
 */
@ServerEndpoint("/chat333")
public class ChatSocket {

    private String username;
    private static List sessions = new ArrayList<Session>();
    private static List names = new ArrayList<String>();

    @OnOpen
    public void open(Session session) {

        username = session.getQueryString();

        this.sessions.add(session);
        this.names.add(username);

        String welcomeMsg = "欢迎"+username+"进入聊天室<br />";
        MessageInfo messageInfo = new MessageInfo(names, welcomeMsg);
        this.boradcast(sessions, messageInfo);

    }

    @OnClose
    public void close(Session session) {
        this.sessions.remove(session);
        this.names.remove(username);

        String welcomeMsg = username+"退出聊天室<br />";
        MessageInfo messageInfo = new MessageInfo(names, welcomeMsg);
        this.boradcast(sessions, messageInfo);
    }

    @OnMessage
    public void message(Session session, String message, boolean last) throws IOException {
        message = username + ":" + message;
        MessageInfo messageInfo = new MessageInfo(message);
        this.boradcast(sessions, messageInfo);
    }

    private void boradcast(List<Session> sessions, MessageInfo messageInfo){

        for (Session session : sessions){
            try {
                session.getBasicRemote().sendText(JSON.toJSONString(messageInfo));
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
            }
        }

    }


}
