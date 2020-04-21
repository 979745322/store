package com.example.store.service.impl;

import com.example.store.dao.ImageMapper;
import com.example.store.dao.ProductMapper;
import com.example.store.entity.Image;
import com.example.store.entity.Product;
import com.example.store.service.ProductQueryCondition;
import com.example.store.service.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;
    private final ImageMapper imageMapper;

    @Autowired
    public ProductServiceImpl(ProductMapper productMapper, ImageMapper imageMapper) {
        this.productMapper = productMapper;
        this.imageMapper = imageMapper;
    }

    @Override
    public long addProduct(Product product) {
        productMapper.addProduct(product);
        return product.getId();
    }

    @Override
    public void deleteProduct(long[] id) {
        for (long ida : id) {
            productMapper.deleteProduct(ida);
        }

    }

    @Override
    public void updateProduct(Product product) {
        productMapper.updateProduct(product);
        List<Image> list = imageMapper.selectImageByProjectId(product.getId());
        // n->o 1.break 0.add
        for (int i = 0; i < product.getImage().length; i++) {
            boolean flag = true;
            for (int j = 0; j < list.size(); j++) {
                if (product.getImage()[i] == list.get(j).getId()) {
                    // 图片还在，不操作
                    flag = false;
                    j = list.size();
                }
            }
            if(flag){
                // 图片新增
                Image image = new Image();
                image.setId(product.getImage()[i]);
                image.setProduct_id(product.getId());
                imageMapper.updateImage(image);
            }
        }
        // o->n 1.break 0.delete
        for (int i = 0; i < list.size(); i++) {
            boolean flag = true;
            for (int j = 0; j < product.getImage().length; j++) {
                if (product.getImage()[j] == list.get(i).getId()) {
                    // 图片还在，不操作
                    flag = false;
                    j = product.getImage().length;
                }
            }
            if(flag){
                // 图片不在了，删除
                imageMapper.deleteImage(list.get(i).getId());
            }
        }
    }

    @Override
    public PageInfo productQueryPage(ProductQueryCondition condition) {
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
        final List<Product> list = productMapper.productQueryPage(condition);
        list.forEach((ob) -> {
            ob.setImageList(imageMapper.selectImageByProjectId(ob.getId()));
        });
        return new PageInfo(list, condition.getNavigatePages());
    }
}
