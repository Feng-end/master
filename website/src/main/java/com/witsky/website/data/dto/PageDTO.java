package com.witsky.website.data.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

/**
 * @author YSJ
 * @date 2022/01/05 10:12
 */
@Schema(description = "分页返回DTO")
public class PageDTO<T> {

    @Schema(description = "当前页 " ,example = "1")
    private int pageNo;

    @Schema(description = "每页显示数 ",example = "10")
    private int pageSize;

    @Schema(description = "结果集 ")
    private List<T> data;


    @Schema(description = "总页数 ")
    private int pageCount;

    @Schema(description = "总记录数 ")
    private int totalCount;

    public int getPageNo() {
        return pageNo;
    }

    public PageDTO<T> setPageNo(int pageNo) {
        this.pageNo = pageNo;
        return this;
    }

    public int getPageSize() {
        return pageSize;
    }

    public PageDTO<T> setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public List<T> getData() {
        return data;
    }

    public PageDTO<T> setData(List<T> data) {
        this.data = data;
        return this;
    }

    public int getPageCount() {
        return pageCount;
    }

    public PageDTO<T> setPageCount(int pageCount) {
        this.pageCount = pageCount;
        return this;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public PageDTO<T> setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        return this;
    }
}
