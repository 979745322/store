package com.example.store.controller;

import com.example.store.entity.Image;
import com.example.store.entity.Product;
import com.example.store.service.ImageQueryCondition;
import com.example.store.service.ImageService;
import com.example.store.service.ProductQueryCondition;
import com.example.store.utils.SaveFile;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Slf4j
@CrossOrigin
@org.springframework.stereotype.Controller
@RequestMapping("/image")
public class ImageController {

    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @ResponseBody
    @RequestMapping("/uploadImage")
    public Map<String, Object> uploadImage(@RequestHeader("X-Token") String XToken, MultipartFile[] fileList) {
        log.info("uploadImage()XToken:" + XToken);
        Map<String, Object> map = Maps.newHashMap();
        if (XToken.equals(WebConstant.X_TOKEN)) {
            List<Long> list = Lists.newArrayList();
            for (int i = 0; i < fileList.length; i++) {
                try {
                    Image image = new Image();
                    image.setName(SaveFile.saveFile(fileList[i]));
                    image.setUrl(WebConstant.FILE_PATH_URL + image.getName());
                    list.add(imageService.addImage(image));
                } catch (IOException e) {
                    log.error("e:{}", e);
                    map.put("state", "fail");
                    return map;
                }
            }
            log.info(list.toString());
            map.put("state", "success");
            map.put("imageIds", list);
        } else {
            map.put("state", "fail");
            map.put("message", "非管理员账户");
        }
        return map;
    }

    @ResponseBody
    @RequestMapping("/deleteImage")
    public Map<String, Object> deleteImage(@RequestHeader("X-Token") String XToken, long[] id) {
        log.info("deleteImage()XToken:" + XToken);
        log.info("deleteImage()id:" + id);
        for (long ida : id) {
            log.info("deleteImage()id:" + ida);
        }
        Map<String, Object> map = Maps.newHashMap();
        if (XToken.equals(WebConstant.X_TOKEN)) {
            imageService.deleteImage(id);
            map.put("state", "success");
        } else {
            map.put("state", "fail");
            map.put("message", "非管理员账户");
        }
        return map;
    }

    @ResponseBody
    @RequestMapping("/selectImage")
    public Map<String, Object> selectImage(ImageQueryCondition condition) {
        log.info("selectImage()condition:" + condition.toString());
        Map<String, Object> map = Maps.newHashMap();
        map.put("state", "success");
        map.put("pageInfo", imageService.imageQueryPage(condition));
        return map;
    }

}
