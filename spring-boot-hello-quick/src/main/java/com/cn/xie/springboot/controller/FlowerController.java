package com.cn.xie.springboot.controller;

import com.cn.xie.springboot.bean.Flower;
import com.cn.xie.springboot.mapper.FlowerMapper;
import com.cn.xie.springboot.service.FlowerService;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: spring-boot-hello-quick
 * @description:
 * @author: Mr.Xie
 * @create: 2019-04-09 11:18
 */
@Controller
public class FlowerController {
    @Autowired
    FlowerService flowerService;
    //显示所有数据
    @GetMapping("/flowers")
    public String selectFlowerAll(Model model){
        List<Flower> flowers = flowerService.selectFlowerAll();
        model.addAttribute("flowers",flowers);
        return "table-basic";
    }
    //跳转到添加页面
    @GetMapping("/flower")
    public String addFlower(){

        return "flower/add";
    }

    //跳转到修改页面
    @GetMapping("/flower/{id}")
    public String upFlower(@PathVariable("id") Integer id, Model model){
        Flower flower = flowerService.selFlowerById(id);
        model.addAttribute("flower",flower);
        return "flower/update";
    }

    //添加数据
    @PostMapping("/insertFlower")
    public String insertFlower(Flower flower){
        flowerService.insetFlower(flower);
        System.out.println(flower.getUpdatetime());
        return "redirect:/flowers";
    }
    //修改数据
    @PutMapping("/updateFlower")
    public String updateFlower(Flower flower){
        flowerService.updateFlowerById(flower);
        return "redirect:/flowers";
    }
    //删除数据
    @DeleteMapping("/flower/{id}")
    public String deleteFlower(@PathVariable("id") Integer id){
        flowerService.deleteFlowerById(id);
        return "redirect:/flowers";
    }
}
