package com.witsky.website.data.domain.article;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * @author YSJ
 * @date 2022/07/25 09:45
 */
public class CustomerArticle extends Article{

    @Schema(description = "文章类型")
    private final ArticleType articleType = ArticleType.CUSTOMER_CASE;

    @Schema(description = "所属行业")
    private String industry;

}
