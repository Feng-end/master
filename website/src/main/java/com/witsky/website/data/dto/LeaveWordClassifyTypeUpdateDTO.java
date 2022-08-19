package com.witsky.website.data.dto;

import com.witsky.website.data.domain.param.LeaveWordClassifyTypeUpdateParam;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

/**
 * @author YSJ
 * @date 2022/07/22 10:45
 */
@Schema(description = "修改DTO")
public class LeaveWordClassifyTypeUpdateDTO implements LeaveWordClassifyTypeUpdateParam {

    @Schema(description = "删除的id列表")
    private List<String> ids;

    @Schema(description = "修改后的类型,0:默认|1:重要|2:普通|3:无效")
    private int classifyType;

    public List<String> getIds() {
        return ids;
    }

    public LeaveWordClassifyTypeUpdateDTO setIds(List<String> ids) {
        this.ids = ids;
        return this;
    }

    public int getClassifyType() {
        return classifyType;
    }

    public LeaveWordClassifyTypeUpdateDTO setClassifyType(int classifyType) {
        this.classifyType = classifyType;
        return this;
    }
}
