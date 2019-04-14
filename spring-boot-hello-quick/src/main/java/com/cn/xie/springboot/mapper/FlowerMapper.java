package com.cn.xie.springboot.mapper;

import com.cn.xie.springboot.bean.Flower;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @program: spring-boot-hello-quick
 * @description:
 * @author: Mr.Xie
 * @create: 2019-04-09 11:14
 */
@Mapper
public interface FlowerMapper {
    public Flower selFlowerById(Integer id);

    public List<Flower> selectFlowerAll();

    public void insetFlower(Flower flower);

    public void updateFlowerById(Flower flower);

    public void deleteFlowerById(Integer id);
}
