package com.witsky.website.data.controller;

import com.witsky.website.base.ApiResult;
import com.witsky.website.common.WebConstant;
import com.witsky.website.data.domain.article.ArticleService;
import com.witsky.website.data.dto.ArticleDTO;
import com.witsky.website.data.po.leaveWord.LeaveWordClassifyType;
import com.witsky.website.web.annotation.WebSignatureRequired;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author YSJ
 * @date 2022/07/25 13:24
 */
@Tag(name = "管理员文章管理")
@RestController
@RequestMapping(WebConstant.PATH_ADMIN+WebConstant.PATH_ARTICLE)
public class AdminArticleController {

    @Resource
    private ArticleService articleService;

    @Operation(summary = "添加文章")
    @PostMapping("/article")
    public ApiResult<ArticleDTO> insertArticle(@RequestBody ArticleDTO articleDTO){
        ArticleDTO insert = articleService.insert(articleDTO);
        return ApiResult.success(insert);
    }

    @Operation(summary = "修改文章,需要传递完整的DTO,没传递的字段会视为跟新为null")
    @PutMapping("/{article-id}")
    public ApiResult<ArticleDTO> insertArticle(@PathVariable("article-id") String id ,
                                               @RequestBody ArticleDTO articleDTO){
        ArticleDTO dto = articleService.updateArticle(id, articleDTO);
        return ApiResult.success(dto);
    }

    @Operation(summary = "文章属性下拉")
    @PostMapping("/articleContent")
    public ApiResult<Map<String,String>> articleContent(){
      Map<String,String> stringMap=new HashMap<>();
        LeaveWordClassifyType[] leaveWordClassifyTypes=LeaveWordClassifyType.values();
        for (LeaveWordClassifyType type : leaveWordClassifyTypes) {
            stringMap.put(String.valueOf(type.getId()),type.getName());
        }
        return ApiResult.success(stringMap);
    }
}
