package com.example.store.service;

import com.example.store.entity.Product;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ProductService {
    // 添加商品
    public long addProduct(Product product);
    // 删除商品
    public void deleteProduct(long[] id);
    // 修改商品信息
    public void updateProduct(Product product);
    // 查询商品
    public PageInfo productQueryPage(ProductQueryCondition condition);
}
