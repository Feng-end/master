package com.witsky.website.web.interceptor;

import com.witsky.website.base.ApiResult;
import com.witsky.website.common.WitSkyErrorCode;
import com.witsky.website.web.annotation.WebSignatureRequired;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.*;

import javax.servlet.http.*;



/**
 * @author YSJ
 * @date 2022/01/06 14:37
 */
public class WebSignatureRequiredInterceptor extends AnnotationRequiredInterceptor<WebSignatureRequired>{

    public static final Logger L = LoggerFactory.getLogger(WebSignatureRequiredInterceptor.class);

    public static final String HEAD_JWT ="jwt";
    private boolean signSwitch;



    public WebSignatureRequiredInterceptor() {
        super(WebSignatureRequired.class);
    }

    @Override
    protected boolean doInterceptor(HttpServletRequest request, HttpServletResponse response, WebSignatureRequired annotation, Object handler) throws Exception {
        if (!signSwitch) {
            return true;
        }
        //token
        String token = request.getHeader(HEAD_JWT);
        if (StringUtils.isBlank(token)) {
            L.warn("{} 未找到 jwt " ,request);
            ApiResult<?> result = ApiResult.ofCode(WitSkyErrorCode.HEADER_LOST_JWT,"未找到 jwt" );
            SendMessageUtil.sendJsonMessage(response,result );
            return false;
        }

        return true;
    }

    public boolean isSignSwitch() {
        return signSwitch;
    }

    public void setSignSwitch(boolean signSwitch) {
        this.signSwitch = signSwitch;
    }
}