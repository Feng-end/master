package com.witsky.website.data.domain.article;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * @author YSJ
 * @date 2022/07/25 09:43
 */
public class SEOArticle extends Article{

    private final ArticleType articleType = ArticleType.SEO;

    @Schema(description = "所属行业")
    private String industry;

}
