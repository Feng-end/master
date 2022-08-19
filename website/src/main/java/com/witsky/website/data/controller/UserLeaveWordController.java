package com.witsky.website.data.controller;

import com.witsky.website.base.ApiResult;
import com.witsky.website.common.WebConstant;
import com.witsky.website.data.domain.LeaveWordService;
import com.witsky.website.data.dto.LeaveWordDTO;
import com.witsky.website.data.po.leaveWord.LeaveWord;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author YSJ
 * @date 2022/07/21 09:55
 */
@Tag(name = "用户留言列表接口")
@RestController
@RequestMapping(WebConstant.PATH_USER+"/leavewords")
public class UserLeaveWordController {

    @Resource
    private LeaveWordService leaveWordService;


    @Operation(summary = "添加留言")
    @PostMapping("/leaveword")
    public ApiResult<LeaveWord> insertLeaveWord(@RequestBody LeaveWordDTO leaveWord){

        LeaveWord res = leaveWordService.insert(leaveWord);

        return ApiResult.success(res);

    }


}
