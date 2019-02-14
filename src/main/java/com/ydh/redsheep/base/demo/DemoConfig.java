package com.ydh.redsheep.base.demo;

import javax.websocket.Endpoint;
import javax.websocket.server.ServerApplicationConfig;
import javax.websocket.server.ServerEndpointConfig;
import java.util.Set;

public class DemoConfig implements ServerApplicationConfig {

	// 注解
	@Override
	public Set<Class<?>> getAnnotatedEndpointClasses(Set<Class<?>> scanned) {
		System.out.println("DemoConfig......启动！"+scanned.size());
		return scanned;
	}

	// 接口
	@Override
	public Set<ServerEndpointConfig> getEndpointConfigs(Set<Class<? extends Endpoint>> scanned) {
		return null;
	}

}
