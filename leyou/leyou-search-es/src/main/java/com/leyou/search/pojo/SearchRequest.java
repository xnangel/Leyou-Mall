package com.leyou.search.pojo;

import java.util.Map;

/**
 * @description: 搜索请求参数类
 * @data: 2020/2/29 23:00
 * @author:
 */
public class SearchRequest {

    /**
     * 搜索字段
     */
    private String key;
    /**
     * 当前页
     */
    private Integer page;

    private Map<String, String> filter;
    /**
     * 每页数据大小，不从页面接收，而是固定大小
     */
    private static final int DEFAULT_ROWS = 20;
    /**
     * 默认页
     */
    private static final int DEFAULT_PAGE = 1;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getPage() {
        if (page == null) {
            return DEFAULT_PAGE;
        }
        // 获取页码时做一些校验，不能小于1
        return Math.max(DEFAULT_PAGE, page);
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public int getSize() {
        return DEFAULT_ROWS;
    }

    public Map<String, String> getFilter() {
        return filter;
    }

    public void setFilter(Map<String, String> filter) {
        this.filter = filter;
    }
}
