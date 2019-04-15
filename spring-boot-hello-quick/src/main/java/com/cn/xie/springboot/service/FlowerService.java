package com.cn.xie.springboot.service;

import com.cn.xie.springboot.bean.Flower;
import com.cn.xie.springboot.mapper.FlowerMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: spring-boot-hello-quick
 * @description:
 * @author: Mr.Xie
 * @create: 2019-04-10 11:42
 */
@Service("flowerService")
public class FlowerService {
    @Autowired
    FlowerMapper flowerMapper;
    @Autowired
    RedisTemplate redisTemplate;

    @Cacheable(cacheNames = {"selFlowerById"})
    public Flower selFlowerById(Integer id){
        return flowerMapper.selFlowerById(id);
    }

    public List<Flower> selectFlowerAll(){
        return flowerMapper.selectFlowerAll();
    }

    public void insetFlower(Flower flower){
        flowerMapper.insetFlower(flower);
    }

    public void updateFlowerById(Flower flower){
        flowerMapper.updateFlowerById(flower);
    }

    public void deleteFlowerById(Integer id){
        flowerMapper.deleteFlowerById(id);
    }
    @RabbitListener(queues = "hajian.news")
    public void receive(Object o){
        System.out.println("收到+"+o);
    }
}
