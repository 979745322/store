package com.example.store;

import com.example.store.controller.WebConstant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoreApplication.class, args);
    }

    @Bean
    MultipartConfigElement multipartConfigElement() { // 设置临时路径
        // 上传地址
//        String path = "C:/Users/rex.li/IdeaProjects/blog/src/main/webapp/uploadImg/";
//        String path = "E:/uploadImg/";
        // linux地址
//        String path = "/usr/local/java/blog/uploadImg/";
        String path = WebConstant.FILE_PATH;
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setLocation(path);
        return factory.createMultipartConfig();
    }
}
