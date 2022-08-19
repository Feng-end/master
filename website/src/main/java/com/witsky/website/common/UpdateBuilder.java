package com.witsky.website.common;


import org.apache.commons.lang3.StringUtils;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.util.CollectionUtils;

import java.util.*;

public class UpdateBuilder {

    private Update update;

    private UpdateBuilder() {
    }

    public static UpdateBuilder newBuilder() {
        return new UpdateBuilder();
    }

    private Update update() {
        if (update == null)
            return update = new Update();
        return update;
    }

    public UpdateBuilder set(String key, Object value) {
        update().set(key, value);
        return this;
    }

    public UpdateBuilder setIfNotBlank(String key, String value) {
        if (StringUtils.isBlank(value))
            return this;
        update().set(key, value);
        return this;
    }

    public UpdateBuilder setIfNotNull(String key, Object value) {
        if (value == null)
            return this;
        update().set(key, value);
        return this;
    }

    public <T> UpdateBuilder setIfNot(String key, T value, T expect) {
        if (!Objects.equals(expect, value))
            return this;
        update().set(key, value);
        return this;
    }

    public <T> UpdateBuilder setIfEmpty(String key, Collection<T> collection) {
        if (!CollectionUtils.isEmpty(collection))
            return this;
        update().set(key, collection);
        return this;
    }

    public Update build() {
        Update update = update();
        this.update = null;
        return update;
    }

}
