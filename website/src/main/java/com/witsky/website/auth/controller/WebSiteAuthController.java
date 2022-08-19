package com.witsky.website.auth.controller;

import com.witsky.website.auth.domain2.AuthService;
import com.witsky.website.auth.dto.LoginDTO;
import com.witsky.website.base.ApiResult;
import com.witsky.website.common.WebConstant;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.support.ManagedMap;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author YSJ
 * @date 2022/07/19 16:13
 */
@Tag(name = "登录认证")
@RestController
@RequestMapping
public class WebSiteAuthController {


    @Resource
    private AuthService authService;

    @Operation(summary = "账号密码登录认证")
    @PostMapping(path = "/authentication" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult<Map<String,String>> webSiteAuthentication(@RequestBody LoginDTO dto){
        String token = authService.authentication(dto.getUsername(), dto.getPassword());
        Map<String,String> stringMap=new ManagedMap<>();
        stringMap.put("token",token);
        stringMap.put("userName",dto.getUsername());
        return ApiResult.success(stringMap);
    }



    @GetMapping(path = WebConstant.PATH_ADMIN+"/aaa")
    public String t1(){
        return "dengluchengogng------------------------";
    }


    @GetMapping(path = WebConstant.PATH_USER+"/aaa")
    public String t2(){
        return "dengluchengogng------------------------";
    }
}
