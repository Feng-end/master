package com.witsky.website.data.domain.article;

import com.mongodb.client.result.UpdateResult;
import com.witsky.website.base.Done;
import com.witsky.website.data.dto.PageParamDTO;
import com.witsky.website.data.po.article.ArticlePO;
import org.springframework.data.domain.*;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.*;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author YSJ
 * @date 2022/07/25 10:03
 */
@Repository
public class ArticleManager {

    @Resource
    private ArticleRepository articleRepository;

    @Resource
    private MongoTemplate mongoTemplate;

    public ArticlePO insert(ArticlePO po){
        ArticlePO insert = articleRepository.insert(po);
        return insert;
    }

    public Optional<ArticlePO> findByArticleTypeAndIndustry(ArticleType articleType, String industry){
        Optional<ArticlePO> optional = articleRepository.findByArticleTypeAndIndustry(articleType, industry);
        return optional;
    }

    public Optional<ArticlePO> findById(String id){
        Optional<ArticlePO> optional = articleRepository.findById(id);
        return optional;
    }

    public List<ArticlePO> findSEOArticles(PageParamDTO param){
        Pageable pageable = PageRequest.of(param.getPageNo()-1, param.getPageSize());
        List<ArticlePO> pos = articleRepository.findAllByArticleType(ArticleType.SEO, pageable);
        return pos;
    }

    public int countByType(ArticleType articleType){
         return articleRepository.countAllByArticleType(articleType);
    }

    public int getCountByTypeAndIndustry(){
        return 1;
    }

    public Optional<ArticlePO> updateArticle(String id,ArticlePO po){
        if (!articleRepository.existsById(id)) {
            return Optional.empty();
        }
        po.setId(id);
        ArticlePO savaPo = articleRepository.save(po);
        return Optional.of(savaPo);
    }


    public void countOnClick4User(String id) {
        UpdateResult result = mongoTemplate.updateFirst(Query.query(Criteria.where("id").is(id)),
                new Update().inc("onClickNum", 1),
                ArticlePO.class);
    }
}
