package com.witsky.website.data.domain.article;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.annotation.Id;

/**
 * @author YSJ
 * @date 2022/07/21 16:43
 */
@Schema(description = "文章")
public class Article {

    @Id
    private long id;

    @Schema(description = "文章标题")
    private String title;

    @Schema(description = "内容简介")
    private String simpleContent;

    @Schema(description = "文章")
    private String pictureNo;

    @Schema(description = "关键词")
    private String keywords;

    @Schema(description = "描述")
    private String des;

    @Schema(description = "点击数")
    private long onClickNum;

    @Schema(description = "来源网站")
    private String webSource;

    @Schema(description = "author")
    private String author;

    @Schema(description = "发布时间")
    private String publishTime;

    @Schema(description = "排序")
    private int priority;

    @Schema(description = "自定义url")
    private String userDefinedUrl;

    @Schema(description = "文章属性")
    private String attribute;

    @Schema(description = "内容模板")
    private String theTemplate;


}
