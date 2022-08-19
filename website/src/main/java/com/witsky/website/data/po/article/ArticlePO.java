package com.witsky.website.data.po.article;

import com.witsky.website.data.domain.article.ArticleType;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author YSJ
 * @date 2022/07/25 09:54
 */
@Schema(description = "文章")
@Document(collection = "article")
public class ArticlePO {

    @Id
    @Schema(description = "唯一id,由后端生成")
    private String id;

    @Schema(description = "文章标题")
    private String title;

    @Schema(description = "内容简介")
    private String simpleContent;

    @Schema(description = "内容详细")
    private String simpledDetaIled;

    @Schema(description = "图片资源编号")
    private String pictureNo;

    @Schema(description = "关键词")
    private String keywords;

    @Schema(description = "描述")
    private String des;

    @Schema(description = "点击数")
    private long onClickNum;

    @Schema(description = "来源网站")
    private String webSource;

    @Schema(description = "作者")
    private String author;

    @Schema(description = "发布时间,后端生成，单位 /ms")
    private long publishTime;

    @Schema(description = "排序")
    private int priority;

    @Schema(description = "自定义url")
    private String userDefinedUrl;

    @Schema(description = "文章属性")
    private String attribute;

    @Schema(description = "内容模板")
    private String theTemplate;

    @Schema(description = "文章类型(枚举,取字符串):SEO：\"SEO文章\"|CUSTOMER_CASE：\"客户案例\"|SOLUTION：\"解决方案")
    private ArticleType articleType;

    @Schema(description = "所属行业")
    private String industry;


    public String getId() {
        return id;
    }

    public ArticlePO setId(String id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ArticlePO setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getSimpleContent() {
        return simpleContent;
    }

    public ArticlePO setSimpleContent(String simpleContent) {
        this.simpleContent = simpleContent;
        return this;
    }

    public String getPictureNo() {
        return pictureNo;
    }

    public ArticlePO setPictureNo(String pictureNo) {
        this.pictureNo = pictureNo;
        return this;
    }
    public String getsimpledDetaIled() {
        return simpledDetaIled;
    }

    public ArticlePO setsimpledDetaIled(String simpledDetaIled) {
        this.simpledDetaIled = simpledDetaIled;
        return this;
    }

    public String getKeywords() {
        return keywords;
    }

    public ArticlePO setKeywords(String keywords) {
        this.keywords = keywords;
        return this;
    }

    public String getDes() {
        return des;
    }

    public ArticlePO setDes(String des) {
        this.des = des;
        return this;
    }

    public long getOnClickNum() {
        return onClickNum;
    }

    public ArticlePO setOnClickNum(long onClickNum) {
        this.onClickNum = onClickNum;
        return this;
    }

    public String getWebSource() {
        return webSource;
    }

    public ArticlePO setWebSource(String webSource) {
        this.webSource = webSource;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public ArticlePO setAuthor(String author) {
        this.author = author;
        return this;
    }

    public long getPublishTime() {
        return publishTime;
    }

    public ArticlePO setPublishTime(long publishTime) {
        this.publishTime = publishTime;
        return this;
    }

    public int getPriority() {
        return priority;
    }

    public ArticlePO setPriority(int priority) {
        this.priority = priority;
        return this;
    }

    public String getUserDefinedUrl() {
        return userDefinedUrl;
    }

    public ArticlePO setUserDefinedUrl(String userDefinedUrl) {
        this.userDefinedUrl = userDefinedUrl;
        return this;
    }

    public String getAttribute() {
        return attribute;
    }

    public ArticlePO setAttribute(String attribute) {
        this.attribute = attribute;
        return this;
    }

    public String getTheTemplate() {
        return theTemplate;
    }

    public ArticlePO setTheTemplate(String theTemplate) {
        this.theTemplate = theTemplate;
        return this;
    }

    public ArticleType getArticleType() {
        return articleType;
    }

    public ArticlePO setArticleType(ArticleType articleType) {
        this.articleType = articleType;
        return this;
    }

    public String getIndustry() {
        return industry;
    }

    public ArticlePO setIndustry(String industry) {
        this.industry = industry;
        return this;
    }
}
