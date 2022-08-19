package com.witsky.website.common;

import com.witsky.website.base.*;

/**
 * @author YSJ
 * @date 2022/07/20 17:31
 */
public enum WitSkyErrorCode implements ApiResultCode, IdEnum<Integer> {

    PICTURE_UPLOAD_ERROR(1 ,10001,"图片上传失败"),
    PICTURE_GET_ERROR(2 ,10002,"图片获取失败"),

    ID_NO_DATA(3 ,10003,"该id没有数据"),

    CANT_INSERT_DATA( 4,10004,"无法添加数据"),

    HEADER_LOST_JWT( 5,10005,"请求头中缺少jwt参数"),

    JWT_ERROR( 6,10006,"解析token出错")



            ;

    private final int id;
    private final int code;
    private final String message;

     WitSkyErrorCode(int id, int code, String message) {
        this.id = id;
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public HttpStatus getHttpStatus() {
       return HttpStatus.INTERNAL_SERVER_ERROR;
    }

    @Override
    public String getName() {
        return message;
    }
}
