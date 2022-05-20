package com.panghu.vip.mall.search.util;

import com.panghu.vip.mall.search.model.SkuEs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

/**
 * @author 胖虎
 * @date 2022/5/18 下午 8:54
 */
public class ESSearchUtil {
    @Autowired
    private ElasticsearchRestTemplate template;

    public void createIndex(){
        //创建索引库
        template.createIndex(SkuEs.class);
        template.putMapping(SkuEs.class);
    }
}
