package com.witsky.website.data.po.leaveWord;

import cn.hutool.core.date.*;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;

/**
 * @author YSJ
 * @date 2022/07/21 09:02
 */
@Document(collection = "leaveWord")
@Schema(description = "留言")
public class LeaveWord {
    @Schema(description = "唯一标识")
    @Id
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

    @Schema(description = "分类")
    private String classifyType;

    @Schema(description = "留言时间")
    private long issueTime;

    public List<String> toExcelString() {
        DateTime dateTime = DateUtil.date(getIssueTime());
        String formatDateTime = DateUtil.formatDateTime(dateTime);
        List<String> list = new ArrayList<>();
        list.add(String.valueOf(getId()));
        list.add(getName());
        list.add(getPhoneNum());
        list.add(getEmail());
        list.add(getCompanyName());
        list.add(getIndustry());
        list.add(getContent());
        list.add(formatDateTime);
        list.add(getClassifyType());
        return list;
    }

    public long getId() {
        return id;
    }

    public LeaveWord setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public LeaveWord setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public LeaveWord setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public LeaveWord setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public LeaveWord setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public String getIndustry() {
        return industry;
    }

    public LeaveWord setIndustry(String industry) {
        this.industry = industry;
        return this;
    }

    public String getContent() {
        return content;
    }

    public LeaveWord setContent(String content) {
        this.content = content;
        return this;
    }

    public long getIssueTime() {
        return issueTime;
    }

    public LeaveWord setIssueTime(long issueTime) {
        this.issueTime = issueTime;
        return this;
    }

    public String getClassifyType() {
        return classifyType;
    }

    public LeaveWord setClassifyType(String classifyType) {
        this.classifyType = classifyType;
        return this;
    }

    public static LeaveWordBuilder newBuilder() {
        return new LeaveWordBuilder();
    }

    public static final class LeaveWordBuilder {
        private long id;
        private String name;
        private String phoneNum;
        private String email;
        private String companyName;
        private String industry;
        private String content;
        private String classifyType;
        private long issueTime;

        private LeaveWordBuilder() {
        }


        public LeaveWordBuilder setId(long id) {
            this.id = id;
            return this;
        }

        public LeaveWordBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public LeaveWordBuilder setPhoneNum(String phoneNum) {
            this.phoneNum = phoneNum;
            return this;
        }

        public LeaveWordBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public LeaveWordBuilder setCompanyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public LeaveWordBuilder setIndustry(String industry) {
            this.industry = industry;
            return this;
        }

        public LeaveWordBuilder setContent(String content) {
            this.content = content;
            return this;
        }

        public LeaveWordBuilder setClassifyType(String classifyType) {
            this.classifyType = classifyType;
            return this;
        }

        public LeaveWordBuilder setIssueTime(long issueTime) {
            this.issueTime = issueTime;
            return this;
        }

        public LeaveWord build() {
            LeaveWord leaveWord = new LeaveWord();
            leaveWord.setId(id);
            leaveWord.setName(name);
            leaveWord.setPhoneNum(phoneNum);
            leaveWord.setEmail(email);
            leaveWord.setCompanyName(companyName);
            leaveWord.setIndustry(industry);
            leaveWord.setContent(content);
            leaveWord.setClassifyType(classifyType);
            leaveWord.setIssueTime(issueTime);
            return leaveWord;
        }
    }
}
