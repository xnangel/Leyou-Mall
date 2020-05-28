package com.leyou.search.repository;

import com.leyou.search.pojo.Goods;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @description:
 * @data: 2020/2/29 16:15
 * @author:
 */
public interface GoodsRepository extends ElasticsearchRepository<Goods, Long> {
}
