package com.witsky.website.data.dto;

import com.witsky.website.data.domain.param.LeaveWordParam;
import com.witsky.website.data.po.leaveWord.LeaveWord;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * @author YSJ
 * @date 2022/07/22 10:26
 */
@Schema(description = "留言DTO",required = true)
public class LeaveWordDTO implements LeaveWordParam {

    @Schema(description = "唯一标识")
    private long id;
    @Schema(description = "姓名")
    private String name;
    @Schema(description = "联系电话")
    private String phoneNum;
    @Schema(description = "邮箱")
    private String email;
    @Schema(description = "公司名称")
    private String companyName;
    @Schema(description = "行业")
    private String industry;
    @Schema(description = "留言内容")
    private String content;
    @Schema(description = "分类,0:默认|1:重要|2:普通|3:无效")
    private String classifyType;
    @Schema(description = "留言时间")
    private long issueTime;

    public LeaveWordDTO setId(long id) {
        this.id = id;
        return this;
    }

    public LeaveWordDTO setName(String name) {
        this.name = name;
        return this;
    }

    public LeaveWordDTO setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
        return this;
    }

    public LeaveWordDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public LeaveWordDTO setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public LeaveWordDTO setIndustry(String industry) {
        this.industry = industry;
        return this;
    }

    public LeaveWordDTO setContent(String content) {
        this.content = content;
        return this;
    }

    public LeaveWordDTO setClassifyType(String classifyType) {
        this.classifyType = classifyType;
        return this;
    }

    public LeaveWordDTO setIssueTime(long issueTime) {
        this.issueTime = issueTime;
        return this;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getIndustry() {
        return industry;
    }

    public String getContent() {
        return content;
    }

    public String getClassifyType() {
        return String.valueOf(classifyType);
    }

    public long getIssueTime() {
        return issueTime;
    }

    public static LeaveWordDTO leaveWord2DTO(LeaveWord leaveWord){

       return new LeaveWordDTO().setId(leaveWord.getId())
                .setName(leaveWord.getName())
                .setPhoneNum(leaveWord.getPhoneNum())
                .setEmail(leaveWord.getEmail())
                .setCompanyName(leaveWord.getCompanyName())
                .setIndustry(leaveWord.getIndustry())
                .setContent(leaveWord.getContent())
                .setClassifyType(leaveWord.getClassifyType())
                .setIssueTime(leaveWord.getIssueTime());

    }
}
