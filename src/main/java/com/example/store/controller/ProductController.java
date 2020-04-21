package com.example.store.controller;

import com.example.store.entity.Image;
import com.example.store.entity.Product;
import com.example.store.service.ImageService;
import com.example.store.service.ProductQueryCondition;
import com.example.store.service.ProductService;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@CrossOrigin
@org.springframework.stereotype.Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;
    private final ImageService imageService;

    @Autowired
    public ProductController(ProductService productService, ImageService imageService) {
        this.productService = productService;
        this.imageService = imageService;
    }

    @ResponseBody
    @RequestMapping("/addProduct")
    public Map<String, Object> addProduct(@RequestHeader("X-Token")String XToken, Product product) {
        log.info("selectUser()XToken:" + XToken);
        log.info("addProduct()product:" + product.toString());
        Map<String, Object> map = Maps.newHashMap();
        if(XToken.equals(WebConstant.X_TOKEN)){
            long priject_id = productService.addProduct(product);
            for (int i = 0; i < product.getImage().length; i++) {
                Image image = new Image();
                image.setId(product.getImage()[i]);
                image.setProduct_id(priject_id);
                imageService.updateImage(image);
            }
            map.put("state", "success");
        }else{
            map.put("state", "fail");
            map.put("message", "非管理员账户");
        }
        return map;
    }

    @ResponseBody
    @RequestMapping("/updateProduct")
    public Map<String, Object> updateProduct(@RequestHeader("X-Token")String XToken, Product product) {
        log.info("updateProduct()XToken:" + XToken);
        log.info("updateProduct()product:" + product.toString());
        Map<String, Object> map = Maps.newHashMap();
        if(XToken.equals(WebConstant.X_TOKEN)){
            productService.updateProduct(product);
            map.put("state", "success");
        }else{
            map.put("state", "fail");
            map.put("message", "非管理员账户");
        }
        return map;
    }

    @ResponseBody
    @RequestMapping("/deleteProduct")
    public Map<String, Object> deleteProduct(@RequestHeader("X-Token")String XToken, long[] id) {
        log.info("selectUser()XToken:" + XToken);
        log.info("deleteProduct()id:" + id);
        for (long ida:id) {
            log.info("deleteProduct()id:" + ida);
        }
        Map<String, Object> map = Maps.newHashMap();
        if(XToken.equals(WebConstant.X_TOKEN)){
            productService.deleteProduct(id);
            map.put("state", "success");
        }else{
            map.put("state", "fail");
            map.put("message", "非管理员账户");
        }
        return map;
    }

    @ResponseBody
    @RequestMapping("/selectProduct")
    public Map<String, Object> selectProduct(ProductQueryCondition condition) {
        log.info("selectProduct()condition:" + condition.toString());
        Map<String, Object> map = Maps.newHashMap();
        map.put("state", "success");
        map.put("pageInfo", productService.productQueryPage(condition));
        return map;
    }

}
