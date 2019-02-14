package com.ydh.redsheep.chat.model;

import java.io.Serializable;
import java.util.List;

/**
 * @description:
 * @author: yangdehong
 * @version: 2017/6/21.
 */
public class MessageInfo implements Serializable{

    private List<String> names;
    private String welcomeMsg;
    private String content;

    public MessageInfo(List<String> names, String welcomeMsg) {
        this.names = names;
        this.welcomeMsg = welcomeMsg;
    }

    public MessageInfo(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public String getWelcomeMsg() {
        return welcomeMsg;
    }

    public void setWelcomeMsg(String welcomeMsg) {
        this.welcomeMsg = welcomeMsg;
    }
}
