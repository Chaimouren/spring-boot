package com.example.socket.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * @author wx
 * 该服务将接受包含STOMP消息中名称的消息，该消息的主体是JSON对象。
 * {
 *     "name": "Fred"
 * }
 */
@Getter
@Setter
public class HelloMessage {

    private String name;

    public HelloMessage() {
    }

    public HelloMessage(String name) {
        this.name = name;
    }
}
