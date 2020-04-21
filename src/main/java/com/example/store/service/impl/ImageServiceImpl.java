package com.example.store.service.impl;

import com.example.store.dao.ImageMapper;
import com.example.store.entity.Image;
import com.example.store.service.ImageQueryCondition;
import com.example.store.service.ImageService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    private final ImageMapper imageMapper;

    @Autowired
    public ImageServiceImpl(ImageMapper imageMapper) {
        this.imageMapper = imageMapper;
    }

    @Override
    public long addImage(Image image) {
        imageMapper.addImage(image);
        return image.getId();
    }

    @Override
    public void updateImage(Image image) {
        imageMapper.updateImage(image);
    }

    @Override
    public void deleteImage(long[] id) {
        for (long ida:id) {
            imageMapper.deleteImage(ida);
        }
    }

    @Override
    public PageInfo imageQueryPage(ImageQueryCondition condition) {
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
        final List<Image> list = imageMapper.imageQueryPage(condition);
        return new PageInfo(list, condition.getNavigatePages());
    }
}
