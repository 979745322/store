package com.example.store.service;

import com.example.store.entity.Image;
import com.example.store.entity.Order;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ImageService {

    /**
     * 添加图片
     * @param image
     */
    public long addImage(Image image);

    /**
     * 修改图片
     * @param image
     */
    public void updateImage(Image image);

    /**
     * 删除图片
     * @param id
     */
    public void deleteImage(long[] id);

    /**
     * 按条件查询图片
     *
     * @param condition 查询条件
     * @return 返回查询结果
     */
    PageInfo imageQueryPage(ImageQueryCondition condition);
}
