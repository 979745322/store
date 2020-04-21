package com.example.store.dao;

import com.example.store.entity.Image;
import com.example.store.entity.Order;
import com.example.store.service.ImageQueryCondition;
import com.example.store.service.OrderQueryCondition;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ImageMapper {

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
    public void deleteImage(long id);

    /**
     * 按条件查询图片
     *
     * @param condition 查询条件
     * @return 返回查询结果
     */
    List<Image> imageQueryPage(ImageQueryCondition condition);

    List<Image> selectImageByProjectId(long product_id);
}
