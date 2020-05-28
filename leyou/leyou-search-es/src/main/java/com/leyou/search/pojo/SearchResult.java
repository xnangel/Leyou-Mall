package com.leyou.search.pojo;

import com.leyou.common.vo.PageResult;
import com.leyou.item.pojo.Brand;
import com.leyou.item.pojo.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * @description: 搜索后的返回结果
 * @data: 2020/3/1 21:47
 * @author:
 */
@Data
public class SearchResult extends PageResult<Goods> {

    /**
     * 分类待选项
     */
    private List<Category> categories;

    /**
     * 品牌待选项
     */
    private List<Brand> brands;

    /**
     * 规格参数 key及待选项
     */
    private List<Map<String, Object>> specs;

    public SearchResult() {
    }

    public SearchResult(Long total, Integer totalPage, List<Goods> items, List<Category> categories, List<Brand> brands, List<Map<String, Object>> specs) {
        super(total, totalPage, items);
        this.categories = categories;
        this.brands = brands;
        this.specs = specs;
    }
}
