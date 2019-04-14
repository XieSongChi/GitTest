package com.cn.xie.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootHelloQuickApplicationTests {
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    AmqpAdmin amqpAdmin;
    @Test
    public void context(){
        Map<String,Object> map=new HashMap<>();
        map.put("jianren","tangqiufeng");
        map.put("jianren1","tangqiufeng1");
        map.put("jianren2","tangqiufeng2");
        rabbitTemplate.convertAndSend("exchange.direct","hajian.news",map);
    }

    @Test
    public void receive(){
        Object o = rabbitTemplate.receiveAndConvert("hajian.news");
        System.out.println(o);
    }

    @Test
    public void admin(){
        //amqpAdmin.declareExchange(new FanoutExchange("amqpadmin.exchange"));
        //amqpAdmin.declareQueue(new Queue("atdashu.haha",true));
        amqpAdmin.declareBinding(new Binding("atdashu.haha",Binding.DestinationType.QUEUE,"amqpadmin.exchange",
                "atdashu.haha",null));
    }

}
