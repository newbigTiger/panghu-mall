package com.panghu.vip.mall.goods.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 胖虎
 * @date 2022/5/7 下午 5:16
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "brand")
public class Brand {
    //ID主键
    @TableId(type= IdType.AUTO,value = "id")
    private Integer id;
    //品牌名字
    private String name;
    //品牌图片
    private String image;
    //品牌首字母
    private String initial;
    //排序
    private Integer sort;

}
