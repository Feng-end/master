package com.witsky.website.data.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author YSJ
 * @date 2022/01/05 19:09
 */
@Schema(description = "基础分页查询参数")
public class PageParamDTO {

    @Schema(description = "页数",example = "1")
    private int pageNo;

    @Schema(description = "一页的数据量",example = "10")
    private int pageSize;

    public int getPageNo() {
        return pageNo;
    }

    public PageParamDTO setPageNo(int pageNo) {
        this.pageNo = pageNo;
        return this;
    }

    public int getPageSize() {
        return pageSize;
    }

    public PageParamDTO setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }
}
