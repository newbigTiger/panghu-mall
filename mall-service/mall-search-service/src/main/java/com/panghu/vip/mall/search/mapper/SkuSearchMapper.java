package com.panghu.vip.mall.search.mapper;


import com.panghu.vip.mall.search.model.SkuEs;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author θθ
 * @date 2022/5/16 δΈε 4:23
 */
public interface SkuSearchMapper extends ElasticsearchRepository<SkuEs,String> {
}
