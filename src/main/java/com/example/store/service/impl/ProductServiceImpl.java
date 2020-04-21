package com.example.store.service.impl;

import com.example.store.dao.ImageMapper;
import com.example.store.dao.ProductMapper;
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
        return productMapper.addProduct(product);
    }

    @Override
    public void deleteProduct(long[] id) {
        for (long ida:id) {
            productMapper.deleteProduct(ida);
        }

    }

    @Override
    public void updateProduct(Product product) {
        productMapper.updateProduct(product);
    }

    @Override
    public PageInfo productQueryPage(ProductQueryCondition condition) {
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
        final List<Product> list = productMapper.productQueryPage(condition);
        list.forEach((ob)->{
            ob.setImageList(imageMapper.selectImageByProjectId(ob.getId()));
        });
        return new PageInfo(list, condition.getNavigatePages());
    }
}
