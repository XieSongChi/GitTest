package com.cn.xie.springboot.config;

import com.cn.xie.springboot.component.MyLocaleResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @program: spring-boot-hello-quick
 * @description: 代替之前的spring配置文件，加载自定义的组件
 * @author: Mr.Xie
 * @create: 2019-04-04 16:02
 */
@Configuration
public class Myconfig  implements WebMvcConfigurer {
    //注册自定义的拦截器
    @Autowired
    private MyLocaleResolver myLocaleResolver;
    //设置视图渲染
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/main").setViewName("index");

    }
    //登录功能拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myLocaleResolver).addPathPatterns("/main");

    }
    //放行静态资源
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
}
