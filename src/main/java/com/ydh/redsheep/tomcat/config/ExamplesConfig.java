package com.ydh.redsheep.tomcat.config;

import com.ydh.redsheep.testt.tomcat.drawboard.DrawboardEndpoint;
import com.ydh.redsheep.testt.tomcat.echo.EchoEndpoint;

import javax.websocket.Endpoint;
import javax.websocket.server.ServerApplicationConfig;
import javax.websocket.server.ServerEndpointConfig;
import java.util.HashSet;
import java.util.Set;

public class ExamplesConfig implements ServerApplicationConfig {

    @Override
    public Set<ServerEndpointConfig> getEndpointConfigs(Set<Class<? extends Endpoint>> scanned) {

        Set<ServerEndpointConfig> result = new HashSet<>();

        if (scanned.contains(EchoEndpoint.class)) {
            result.add(ServerEndpointConfig.Builder.create(EchoEndpoint.class, "/echoProgrammatic").build());
        }

        if (scanned.contains(DrawboardEndpoint.class)) {
            result.add(ServerEndpointConfig.Builder.create(DrawboardEndpoint.class, "/drawboard").build());
        }

        return result;
    }


    @Override
    public Set<Class<?>> getAnnotatedEndpointClasses(Set<Class<?>> scanned) {

        Set<Class<?>> results = new HashSet<>();
        for (Class<?> clazz : scanned) {
            if (clazz.getPackage().getName().startsWith("com.")) {
                results.add(clazz);
            }
        }
        System.out.println("scanned = [" + scanned.size() + "]");
        return results;
    }
}
