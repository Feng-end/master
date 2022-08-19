package com.witsky.website.base;

import java.util.function.*;

/**
 * @author YSJ
 * @date 2022/07/20 15:38
 */
public interface DoneResult <M, C extends ResultCode> extends Done<M> {
    /**
     * @return 获取结果码
     */
    C getCode();

    /**
     * 如果失败则调用 consumer
     *
     * @param consumer 参数
     */
    void ifFailure(BiConsumer<ResultCode, ? super M> consumer);

    /**
     * 调用 consumer
     *
     * @param consumer 接收
     */
    void then(BiConsumer<ResultCode, ? super M> consumer);

    default <T> DoneResult<T, C> mapOnSuccess(Function<M, T> mapper) {
        if (this.isSuccess()) {
            return DoneResults.done(getCode(), mapper.apply(this.get()));
        }
        return DoneResults.done(getCode(), null);
    }
}
