package com.witsky.website.picture.controller;

import com.witsky.website.base.*;
import com.witsky.website.common.OnlyIdService;
import com.witsky.website.picture.utils.ImageUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.*;
import java.io.IOException;

import static com.witsky.website.common.WitSkyErrorCode.*;

/**
 * @author YSJ
 * @date 2022/07/20 17:24
 */
@RestController
public class PictureController {

    @Value("${witsky.picture-path}")
    private String PICTURE_PATH;

    @Resource
    private OnlyIdService onlyIdService;

    private static final Logger L = LoggerFactory.getLogger(PictureController.class);

    @PostMapping("/picture")
    public ApiResult<String> upLoadPicture(MultipartFile multipartFile) {

        if (multipartFile.isEmpty() || StringUtils.isBlank(multipartFile.getOriginalFilename())) {
            throw ApiException.of(PICTURE_UPLOAD_ERROR);
        }
        String contentType = multipartFile.getContentType();
        if (!contentType.contains("")) {
            throw ApiException.of(PICTURE_UPLOAD_ERROR);
        }
        String root_fileName = multipartFile.getOriginalFilename();
        L.info("上传图片:name={},type={}", root_fileName, contentType);
        String file_name;
        long pictureNo = onlyIdService.getId();
        try {
             file_name = ImageUtil.saveImg(multipartFile,pictureNo, PICTURE_PATH);
        } catch (IOException e) {
            throw ApiException.of(PICTURE_UPLOAD_ERROR,e.getMessage());
        }
        if (StringUtils.isBlank(file_name)) {
            throw ApiException.of(PICTURE_UPLOAD_ERROR);
        }
        return ApiResult.success(String.valueOf(pictureNo));
    }


    @GetMapping("/pictures/{picture-no}")
    public ApiResult<String> getPicture(@PathVariable("picture-no") String pictureNo, HttpServletResponse response, HttpServletRequest request){
        String pictureBase64 = ImageUtil.getPictureBase64(PICTURE_PATH, pictureNo, response);
        return ApiResult.success(pictureBase64);
    }


}
