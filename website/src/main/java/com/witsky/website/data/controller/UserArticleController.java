package com.witsky.website.data.controller;

import com.witsky.website.base.ApiResult;
import com.witsky.website.common.WebConstant;
import com.witsky.website.data.domain.article.ArticleService;
import com.witsky.website.data.dto.*;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author YSJ
 * @date 2022/07/25 13:19
 */
@RestController
@RequestMapping(WebConstant.PATH_USER+WebConstant.PATH_ARTICLE)
public class UserArticleController {

    @Resource
    private ArticleService articleService;

    @Operation(summary = "分页获取SEO文章")
    @PostMapping("/seos")
    public ApiResult<PageDTO<ArticleDTO>> getSEOs(@RequestBody PageParamDTO param){

        PageDTO<ArticleDTO> pageDTO = articleService.getSEOArticles(param);
        return ApiResult.success(pageDTO);
    }

    @Operation(summary = "根据id查看文章")
    @GetMapping("/{article-id}")
    public ApiResult<ArticleDTO> getById(@PathVariable("article-id") String id){
        ArticleDTO dto = articleService.getById4User(id);
        return ApiResult.success(dto);
    }


}
