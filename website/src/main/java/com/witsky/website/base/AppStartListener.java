package com.witsky.website.base;

import org.slf4j.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author YSJ
 * @date 2022/07/22 14:57
 */
@Component
public class AppStartListener implements InitializingBean {

    private final static Logger logger = LoggerFactory.getLogger(AppStartListener.class);

    @Autowired
    private DataLoadService reloadChangeService;

    @Override
    public void afterPropertiesSet() throws Exception {
        try {
            reloadChangeService.startLoader();
        } catch (Exception e) {
            logger.error("系统错误", e);
        }
    }
}
