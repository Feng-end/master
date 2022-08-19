package com.witsky.website.data.domain;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.*;
import com.witsky.website.base.*;
import com.witsky.website.common.OnlyIdService;
import com.witsky.website.data.domain.param.*;
import com.witsky.website.data.dto.*;
import com.witsky.website.data.po.leaveWord.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static com.witsky.website.common.WitSkyErrorCode.*;

/**
 * @author YSJ
 * @date 2022/07/21 09:12
 */
@Service
public class LeaveWordService {

    public static final String EXCEL_PRE_NAME = "LeaveWordsExcel";

    @Resource
    private LeaveWordManager leaveWordManager;

    @Resource
    private OnlyIdService onlyIdService;

    public LeaveWord insert(LeaveWordParam param) {

        LeaveWord leaveWord = LeaveWord.newBuilder()
                .setId(onlyIdService.getId())
                .setCompanyName(param.getCompanyName())
                .setName(param.getName())
                .setPhoneNum(param.getPhoneNum())
                .setEmail(param.getEmail())
                .setIndustry(param.getIndustry())
                .setContent(param.getContent())
                .setIssueTime(System.currentTimeMillis())
                .setClassifyType(String.valueOf(param.getClassifyType()))
                .build();
        return leaveWordManager.insert(leaveWord);
    }

    public void excelOut(HttpServletResponse response) throws IOException {
        List<LeaveWord> leaveWordList = leaveWordManager.findAll();

        List<String> rowHead = CollUtil.newArrayList("唯一标识", "姓名", "联系电话", "邮箱", "公司名称", "行业", "留言内容", "留言时间", "留言分类");

        List<List<String>> rows = leaveWordList.stream().map(LeaveWord::toExcelString).collect(Collectors.toList());

        rows.add(0, rowHead);

        //通过工具类创建writer
        String fileName = EXCEL_PRE_NAME + System.currentTimeMillis() + ".xlsx";

        ExcelWriter writer = ExcelUtil.getWriter(true);
        //合并单元格后的标题行，使用默认标题样式
        writer.merge(rowHead.size() - 1, "留言列表");
        //一次性写出内容，强制输出标题
        writer.write(rows, true);

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        //test.xls是弹出下载对话框的文件名，不能为中文，中文请自行编码
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);

        ServletOutputStream out = response.getOutputStream();

        writer.flush(out, true);
        //关闭writer，释放内存
        writer.close();

        IoUtil.close(out);

    }


    public List<String> updateClassify(LeaveWordClassifyTypeUpdateParam param) {

        param.getIds().forEach(l -> {
            leaveWordManager.updateClassify(Long.parseLong(l), EnumHelper.of(LeaveWordClassifyType.class, param.getClassifyType()));
        });
        return param.getIds();
    }

    public List<Long> deleteLeaveWords(List<Long> ids) {
        ids.forEach(leaveWordManager::deleteClassify);
        return ids;
    }

    public LeaveWord getById(long id) {
        LeaveWord leaveWord = leaveWordManager.getById(id).orElseThrow(() -> ApiException.of(ID_NO_DATA));
        return leaveWord;
    }

    public PageDTO<LeaveWordDTO> getByPage(PageParamDTO param) {
        //总量
        int count = leaveWordManager.countAll();

        List<LeaveWord> leaveWords = leaveWordManager.getByConditions(param);

        List<LeaveWordDTO> dtos = leaveWords.stream().map(LeaveWordDTO::leaveWord2DTO).collect(Collectors.toList());
        //添加成数组形式
        for (LeaveWordDTO dto : dtos) {
            dto.setClassifyType("[" + dto.getClassifyType() + "]");
        }
        PageDTO<LeaveWordDTO> pageDTO = new PageDTO<>();
        pageDTO.setData(dtos);
        pageDTO.setPageNo(param.getPageNo());
        pageDTO.setPageSize(param.getPageSize());
        pageDTO.setTotalCount(count);
        pageDTO.setPageCount(count / param.getPageSize() + 1);

        return pageDTO;


    }
}
