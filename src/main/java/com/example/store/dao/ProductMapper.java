package com.example.store.dao;

import com.example.store.entity.Admin;
import com.example.store.entity.Product;
import com.example.store.entity.Roles;
import com.example.store.entity.User;
import com.example.store.service.ProductQueryCondition;
import com.example.store.service.UserQueryCondition;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProductMapper {

    // 添加商品
    public long addProduct(Product product);
    // 删除商品
    public void deleteProduct(long id);
    // 修改商品信息
    public void updateProduct(Product product);
    // 查询商品
    public List<Product> productQueryPage(ProductQueryCondition condition);
    // id查询商品
    public Product selectProjectById(long id);
}
