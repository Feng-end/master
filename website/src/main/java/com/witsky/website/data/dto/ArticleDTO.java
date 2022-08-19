package com.witsky.website.data.dto;

import com.witsky.website.data.po.article.ArticlePO;

/**
 * @author YSJ
 * @date 2022/07/25 10:05
 */
public class ArticleDTO extends ArticlePO {
    public static ArticleDTO po2DTO(ArticlePO po) {
        return (ArticleDTO) po;
    }
}
