package com.ydh.redsheep.base.socket;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint("/echo")
public class EchoSocket {

	@OnOpen
	public void open(Session session) {
		System.out.println("sessionId:"+session.getId()+"开启");
	}

	@OnClose
	public void close(Session session){
		System.out.println("sessionId:"+session.getId()+"关闭");
	}
	
	@OnMessage
	public void message(Session session, String message, boolean last) throws IOException {
		System.out.println("sessionId:"+session.getId()+"-------"+message);
		session.getBasicRemote().sendText("接受成功");
	}

}
