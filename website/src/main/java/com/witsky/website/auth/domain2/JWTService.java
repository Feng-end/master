package com.witsky.website.auth.domain2;

import cn.hutool.jwt.JWT;
import com.witsky.website.base.ApiException;
import com.witsky.website.common.WitSkyErrorCode;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author YSJ
 * @date 2022/07/25 16:15
 */
@Service
public class JWTService {

    public static final String JWT_KEY="sad";

    public String generateToken(UserDetails userDetails) {
        byte[] bytes = "witskyhhhhhhhhhh".getBytes();
        String sign = JWT.create().setPayload("sub", userDetails.getUsername())
                .setPayload("create", String.valueOf(System.currentTimeMillis()))
                .setKey(bytes)
                .sign();
        return sign;
    }

    public static void main(String[] args) {
        byte[] bytes = "sad".getBytes();
        String sign = JWT.create().setPayload("sub", "ysjUSER")
                .setPayload("create", String.valueOf(System.currentTimeMillis()))
                .setKey(bytes)
                .sign();
        System.out.println("sign = " + sign);
    }

    public String getUsername(String token) {
        JWT jwt = JWT.of(token);

        //todo yanzheng token
        // if (!jwt.setKey(JWT_KEY.getBytes()).verify()) {
        //     throw ApiException.of(WitSkyErrorCode.JWT_ERROR);
        // }
        Object username = jwt.getPayload("sub");
        return (String)username;
    }
}
