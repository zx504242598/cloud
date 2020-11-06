package com.zx.cloud.security.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.http.HttpServlet;

/**
 * @author zhaoxuan
 * @date 2020-09-23 10:36
 **/

/**
 * 配置 Druid 的监控
 */
@Configuration
public class DruidConfig {


    /**
     * 配置一个管理后台的Servlet
     */
    @Bean
    public ServletRegistrationBean<HttpServlet> statViewServlet(){
        ServletRegistrationBean<HttpServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(),"/druid/*");
        Map<String,String> map = new HashMap<>();
        map.put("loginUsername","admin");
        map.put("loginPassword","123456");
        //不写 或者为null 默认允许所有
        //map.put("allow","127.0.0.1");
        //map.put("deny","192.168.1.122");
        bean.setInitParameters(map);
        return  bean;
    }

    /**
     * 配置一个监控的Filter
     * @return
     */
    @Bean
    public FilterRegistrationBean<Filter> webStatFilter(){
        FilterRegistrationBean<Filter> initParam = new FilterRegistrationBean<>();
        initParam.setFilter(new WebStatFilter());
        Map<String,String> map = new HashMap<>();
        //初始化不拦截请求的参数
        map.put("exclusions","*.css,*.png,*.jpg,*.js,/druid/*");
        initParam.setInitParameters(map);
        return initParam;
    }

}
