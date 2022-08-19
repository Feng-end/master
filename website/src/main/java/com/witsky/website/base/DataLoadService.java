package com.witsky.website.base;

import org.slf4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.*;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.witsky.website.base.StringHelper.*;
import static org.slf4j.LoggerFactory.*;

/**
 * @author YSJ
 * @date 2022/07/22 14:54
 */
@Service
public class DataLoadService implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    private volatile boolean start = false;

    public static final Logger LOGGER = getLogger(DataLoadService.class);



    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext =applicationContext;

    }

    public void startLoader() {
        if (start)
            return;
        synchronized (this) {
            if (start)
                return;
            Map<String, Starter> starterMap = applicationContext.getBeansOfType(Starter.class);
            for (Starter starter : starterMap.values()) {
                try {
                    starter.onStart();
                } catch (Exception e) {
                    throw new RuntimeException(format("{} onStart exception", starter.getClass()), e);
                }
            }
        }
}
}
