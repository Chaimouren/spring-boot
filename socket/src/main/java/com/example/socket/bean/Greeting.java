package com.example.socket.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * @author wx
 * 在接收到消息并提取名称后，服务将通过创建问候语并在客户端订阅的单独队列上发布该问候语来处理它
 * {
 *     "content": "Hello, Fred!"
 * }
 */
@Getter
@Setter
public class Greeting {

    private String content;

    public Greeting() {
    }

    public Greeting(String content) {
        this.content = content;
    }
}
