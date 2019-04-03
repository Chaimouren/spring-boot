package com.example.socket.controller;

import com.example.socket.bean.Greeting;
import com.example.socket.bean.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

/**
 * @author wx
 * Spring将使用Jackson JSON库自动将类型实例Greeting封送到JSON中。
 * 创建一个控制器来接收问候消息并发送问候消息。
 * 在Spring使用STOMP消息传递的方法中，STOMP消息可以路由到@Controller类。
 */
@Controller
public class GreetingController {


    /**
     * 该@MessageMapping注解确保如果一个消息被发送到目的地“/hello ”，则该greeting()方法被调用。
     *
     * 消息的有效负载绑定到HelloMessage传入的对象greeting()。
     *
     * 在内部，该方法的实现通过使线程休眠1秒来模拟处理延迟。这是为了演示客户端发送消息后，只要需要异步处理消息，服务器就可以使用。客户可以继续进行它需要做的任何工作而无需等待响应。
     *
     * 在1秒延迟之后，该greeting()方法创建一个Greeting对象并返回它。返回值被广播给所有订阅者，如@SendTo注释中指定的那样“/ topic / greetings” 。请注意，输入消息中的名称已被清理，因为在这种情况下，它将被回显并在客户端的浏览器DOM中重新呈现。
     * @param message
     * @return
     * @throws Exception
     */
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
//        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }
}
