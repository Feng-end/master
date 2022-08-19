package com.witsky.website.web.exception.domain;

import cn.hutool.core.util.ObjectUtil;
import com.witsky.website.base.*;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author YSJ
 * @date 2022/02/04 03:19
 */
@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(value = ApiException.class)
    @ResponseBody
    public ApiResult<Object> exceptionHandler(ApiException e){
        Object body ;
        Optional<Object> optional = e.getBody();
        body = optional.orElseGet(e::getMessage);

        // return ApiResult.ofCode(e.getResultCode(), e.getMessage(), body);
        return ApiResult.of(e.getResultCode(), body);
    }

}
