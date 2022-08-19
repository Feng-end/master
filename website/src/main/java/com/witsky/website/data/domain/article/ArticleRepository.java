package com.witsky.website.data.domain.article;

import com.witsky.website.data.po.article.ArticlePO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * @author YSJ
 * @date 2022/07/25 09:57
 */
@Repository
public interface ArticleRepository extends MongoRepository<ArticlePO, String> {

    Optional<ArticlePO> findByArticleTypeAndIndustry(ArticleType articleType, String industry);

    List<ArticlePO> findAllByArticleType(ArticleType articleType, Pageable pageable);

    int countAllByArticleType(ArticleType articleType);

    int countAllByArticleTypeAndIndustry(ArticleType articleType, String industry);

}
