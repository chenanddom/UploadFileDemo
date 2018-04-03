package com.dom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: chendom
 * Date: 2018-03-21
 * Time: 9:16
 */
@SpringBootApplication
@EnableAutoConfiguration
public class WebApplication {
public static void main(String[] args){
    SpringApplication.run(WebApplication.class,args);
}
}
