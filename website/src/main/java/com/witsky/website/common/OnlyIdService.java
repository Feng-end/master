package com.witsky.website.common;

import cn.hutool.core.util.IdUtil;
import org.springframework.stereotype.Service;

/**
 * @author YSJ
 * @date 2022/07/19 15:58
 */
@Service
public class OnlyIdService implements IdServer {

    @Override
    public long getId() {
        return IdUtil.getSnowflakeNextId();
    }
}
