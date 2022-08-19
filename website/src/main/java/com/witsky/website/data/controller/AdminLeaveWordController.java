package com.witsky.website.data.controller;

import com.witsky.website.base.*;
import com.witsky.website.common.WebConstant;
import com.witsky.website.data.domain.LeaveWordService;
import com.witsky.website.data.dto.*;
import com.witsky.website.data.po.leaveWord.LeaveWord;
import com.witsky.website.web.annotation.WebSignatureRequired;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author YSJ
 * @date 2022/07/22 10:17
 */
@Tag(name = "管理员留言列表接口")
@RestController
@RequestMapping(WebConstant.PATH_ADMIN+"/leavawords")
public class AdminLeaveWordController {

    @Resource
    private LeaveWordService leaveWordService;

    @Operation(summary = "导出excel")
    @GetMapping("/excel")
    public ApiResult<String> outputAllExcel(HttpServletResponse response) throws IOException {
        leaveWordService.excelOut(response);
        return ApiResult.success("成功");
    }

    @Operation(summary = "修改留言分类")
    @PutMapping("/leaveword-classify")
    public ApiResult<List<String>> updateLeaveWordClassify(@RequestBody LeaveWordClassifyTypeUpdateDTO dto) {
        List<String> successList = leaveWordService.updateClassify(dto);
        return ApiResult.success(successList);
    }

    @Operation(summary = "删除留言")
    @DeleteMapping("/leaveword")
    public ApiResult<List<String>> deleteLeaveWord(@RequestParam @Parameter(description = "要删除的id") List<String> ids) {
        List<Long> longList = ids.stream().map(Long::parseLong).collect(Collectors.toList());
        leaveWordService.deleteLeaveWords(longList);
        return ApiResult.success(ids);
    }

    @Operation(summary = "查看留言")
    @GetMapping("/{leaveword-id}")
    public ApiResult<LeaveWordDTO> getLeaveWord(@PathVariable("leaveword-id") @Parameter(description = "留言的id") String id) {
        LeaveWord leaveWord = leaveWordService.getById(Long.parseLong(id));

        return ApiResult.success(LeaveWordDTO.leaveWord2DTO(leaveWord));
    }

    @Operation(summary = "分页查看留言")
    @PostMapping("/leaveword")
    public ApiResult<PageDTO<LeaveWordDTO>> getLeaveWordByPage(@RequestBody PageParamDTO param) {
        PageDTO<LeaveWordDTO> byPage = leaveWordService.getByPage(param);
        return ApiResult.success(byPage);
    }
}
