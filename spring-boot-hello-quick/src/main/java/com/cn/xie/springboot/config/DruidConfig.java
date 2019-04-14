package com.cn.xie.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: spring-boot-hello-quick
 * @description: 数据源配置
 * @author: Mr.Xie
 * @create: 2019-04-09 10:04
 */
@Configuration
public class DruidConfig {
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }

    //配置druid的监控
    //配置一个管理后台的servlet
    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        //设置初始化参数
        Map<String,String> initpar=new HashMap();
        initpar.put("loginUsername","root");
        initpar.put("loginPassword","123456");
        initpar.put("allow","");//允许所有访问
        initpar.put("deny","127.0.0.1");//拒绝所有访问
        bean.setInitParameters(initpar);
        return bean;
    }

    //配置一个web监控的filter
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        //设置初始化参数
        Map<String,String> initpar=new HashMap();
        initpar.put("exclusions","*.css,*.js,/druid/*");
        bean.setInitParameters(initpar);
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }
}
