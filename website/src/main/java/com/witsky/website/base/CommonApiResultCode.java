package com.witsky.website.base;

import java.util.Objects;

/**
 * @author YSJ
 * @date 2022/07/20 15:56
 */
public enum CommonApiResultCode implements ApiResultCode {

    SUCCESS(ResultCode.SUCCESS_CODE, HttpStatus.OK),

    // TT ==================== Http 错误 : 200 - 999 ==================== TT

    HTTP_401_UNAUTHORIZED(401, HttpStatus.UNAUTHORIZED),

    HTTP_404_NOT_FOUND(404, HttpStatus.NOT_FOUND),

    HTTP_500_INTERNAL_SERVER_ERROR(500, HttpStatus.INTERNAL_SERVER_ERROR),

    // TT ==================== 公共 : 1_00_00 - 1_99_99 ==================== TT

    /** 服务器错误 */
    SERVER_ERROR(1_00_00, "服务器错误"),

    /** 非法参数 */
    ILLEGAL_PARAMETER(1_00_01, "非法参数"),

    /** 缺少参数 */
    MISSING_PARAMETER(1_00_02, "缺少参数"),

    /** 服务器繁忙 */
    SERVER_BUSY(1_00_03, "服务器繁忙"),

    /** 三方服务器繁忙 */
    REMOTE_CALL_ERROR(1_00_04, "三方服务器繁忙"),

    /** 签名校验错误 */
    CHECK_SIGNATURE_FAILED(1_00_05, "签名校验错误"),

    /** 请求已处理 */
    REQUEST_PROCESSED(1_00_06, "请求已处理"),

    /** 请求缺少header */
    REQUEST_MISS_HEADER(1_00_07, "请求缺少header"),

    /** 验证码校错误 */
    CHECK_CAPTCHA_FAILED(1_00_08, "验证码校错误"),

    /** 无访问权限 */
    PERMISSION_DENIED(1_00_09, "无访问权限"),

    // ================= 公共非法参数 1_01_XX ===========================

    /** 参数为空 */
    NULL_PARAMETER(1_01_01, "参数为空"),

    /** 参数不为空 */
    NOT_NULL_PARAMETER(1_01_02, "参数不为空"),

    /** 参数为空字符串 */
    BLANK_PARAMETER(1_01_03, "参数为空字符串"),

    /** 参数为空列表 */
    EMPTY_PARAMETER(1_01_04, "参数为空列表"),

    /** 参数时间早于当前时间 */
    PARAMETER_AFTER_CURRENT_TIME(1_01_05, "参数时间早于当前时间"),

    /** 参数时间早于当前时间 */
    PARAMETER_BEFORE_CURRENT_TIME(1_01_06, "参数时间早于当前时间"),

    /** 参数小于等于0 */
    PARAMETER_LESS_THAN_OR_EQUAL_ZERO(1_01_07, "参数小于等于0"),

    /** 参数大于等于0 */
    PARAMETER_GREATER_THAN_OR_EQUAL_ZERO(1_01_08, "参数大于等于0"),

    /** 参数小于0 */
    PARAMETER_LESS_THAN_ZERO(1_01_09, "参数小于0"),

    /** 参数大于0 */
    PARAMETER_GREATER_THAN_ZERO(1_01_10, "参数大于0"),

    /** 非法数字 */
    ILLEGAL_NUMBER(1_01_11, "非法数字"),

    /** 参数超过限制 */
    PARAMETER_GREATER_THAN_MAX(1_01_12, "参数超过限制"),

    /** 参数低于限制 */
    PARAMETER_LESS_THAN_MIN(1_01_13, "参数低于限制"),

    /** 参数非法长度 */
    PARAMETER_ILLEGAL_SIZE(1_01_14, "参数非法长度"),

    /** 非法手机号码 */
    ILLEGAL_PHONE_NUMBER(1_01_15, "非法手机号码"),

    /** 非法邮箱地址 */
    ILLEGAL_EMAIL(1_01_16, "非法邮箱地址"),

    /** 参数必须为true */
    PARAMETER_MUST_BE_TRUE(1_01_17, "参数必须为true"),

    /** 参数必须为false */
    PARAMETER_MUST_BE_FALSE(1_01_18, "参数必须为false"),

    /** 参数无法解密 */
    PARAMETER_DECIPHER_FAILED(1_01_19, "参数无法解密"),

    // ================= TopicResultCode 1_02_XX ===========================

    ;

    private final int code;

    private final String message;

    private final HttpStatus httpStatus;

    //    CommonResultCode(int code) {
    //        this(code, null, HttpStatus.OK);
    //    }

    CommonApiResultCode(int code, String message) {
        this(code, message, HttpStatus.OK);
    }

    CommonApiResultCode(int code, HttpStatus httpStatus) {
        this(code, httpStatus.getReasonPhrase(), httpStatus);
    }

    CommonApiResultCode(int code, String message, HttpStatus httpStatus) {
        this.code = code;
        // this.message = Objects.requireNonNullElseGet(message, () -> String.valueOf(code));
        this.message = message;
        this.httpStatus = httpStatus;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public Integer getId() {
        return this.code;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }

}

