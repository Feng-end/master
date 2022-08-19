package com.witsky.website.data.domain.param;

import lombok.Data;

/**
 * @author YSJ
 * @date 2022/07/22 10:28
 */
public interface LeaveWordParam {

    long getId();
    String getName();
    String getPhoneNum();
    String getEmail();
    String getCompanyName();
    String getIndustry();
    String getContent();
    String getClassifyType();
    long getIssueTime();
}
