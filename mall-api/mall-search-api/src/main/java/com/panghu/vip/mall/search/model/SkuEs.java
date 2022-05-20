package com.panghu.vip.mall.search.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;
import java.util.Map;

/**
 * @author 胖虎
 * @date 2022/5/16 下午 4:01
 */
@Data
@Document(indexName = "shopsearch", type = "skues")
public class SkuEs {

    @Id
    private String id;
    //分词要根据名字来模糊查询
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String name;
    private Integer price;
    private Integer num;
    private String image;
    private String images;
    private Date createTime;
    private Date updateTime;
    private String spuId;
    private Integer categoryId;
    //Keyword：不分词
    @Field(type = FieldType.Keyword)
    private String categoryName;
    private Integer brandId;
    @Field(type = FieldType.Keyword)
    private String brandName;
    @Field(type = FieldType.Keyword)
    private String skuAttribute;
    private Integer status;
    //属性映射
    private Map<String, String> attrMap;

}
