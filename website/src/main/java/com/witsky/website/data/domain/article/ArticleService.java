package com.witsky.website.data.domain.article;

import com.witsky.website.base.*;
import com.witsky.website.common.WitSkyErrorCode;
import com.witsky.website.data.dto.*;
import com.witsky.website.data.po.article.ArticlePO;
import com.witsky.website.data.po.leaveWord.LeaveWordClassifyType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author YSJ
 * @date 2022/07/25 10:04
 */
@Service
public class ArticleService {

    @Resource
    private ArticleManager articleManager;

    //添加文章
    public ArticleDTO insert(ArticleDTO dto){
        if (!canAbleInsert(dto)) {
            throw  ApiException.of(WitSkyErrorCode.CANT_INSERT_DATA, StringHelper.format("文章 {} 在该类型中已经存在无法添加", dto.getTitle()));
        }
        dto.setPublishTime(System.currentTimeMillis());
        dto.setOnClickNum(0);
        ArticlePO po = articleManager.insert(dto);
        return ArticleDTO.po2DTO(po);
    }

    //根据id去获取
    public ArticleDTO getById(String id){
        ArticlePO po = articleManager.findById(id).orElseThrow(() -> ApiException.of(WitSkyErrorCode.ID_NO_DATA));
        return ArticleDTO.po2DTO(po);
    }

    //user根据id去获取并增加点击量   不具有原子性 用户显示的点击量不一定准确
    public ArticleDTO getById4User(String id){
        articleManager.countOnClick4User(id);
        ArticleDTO dto = this.getById(id);
        return dto;
    }

    //根据id修改
    public ArticleDTO updateArticle(String id,ArticleDTO dto){
        ArticlePO articlePO = articleManager.updateArticle(id, dto).orElseThrow(() -> ApiException.of(WitSkyErrorCode.ID_NO_DATA));
        return ArticleDTO.po2DTO(articlePO);
    }

    //分页获取SEO文章
    public PageDTO<ArticleDTO> getSEOArticles(PageParamDTO param){
        List<ArticlePO> pos = articleManager.findSEOArticles(param);
        int count = articleManager.countByType(ArticleType.SEO);
        PageDTO<ArticleDTO> pageDTO = new PageDTO<>();
        pageDTO.setData(pos.stream().map(ArticleDTO::po2DTO).collect(Collectors.toList()));
        pageDTO.setPageNo(param.getPageNo());
        pageDTO.setPageSize(param.getPageSize());
        pageDTO.setTotalCount(count);
        pageDTO.setPageCount(count / param.getPageSize() + 1);
        return pageDTO;
    }

    private boolean canAbleInsert(ArticlePO po) {
        ArticleType articleType = po.getArticleType();
        if (!(articleType == ArticleType.SOLUTION)){
            return true;
        }
        String industry = po.getIndustry();
        Optional<ArticlePO> optional = articleManager.findByArticleTypeAndIndustry(ArticleType.SOLUTION, industry);
        if (optional.isPresent()){
            return false;
        }
        return true;
    }
}
