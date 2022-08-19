package com.witsky.website.base;

import java.util.Optional;
import java.util.function.*;

/**
 * @author YSJ
 * @date 2022/07/20 15:42
 */
public abstract class BaseDoneResult <M, D extends BaseDoneResult<M, D, C>, C extends ResultCode>
        implements DoneResult<M, C>, DoneMessage<M, D> {

    protected C code;
    protected M returnValue;
    protected String message;

    protected BaseDoneResult(C code, M returnValue) {
        this.code = code;
        this.returnValue = returnValue;
        this.message = null;
    }

    protected BaseDoneResult(C code, M returnValue, String message) {
        this.code = code;
        this.returnValue = returnValue;
        if (StringHelper.isNoneBlank(message)) {
            this.message = message;
        }
    }

    /**
     * @return 是否成功 code == ResultCode.SUCCESS
     */
    @Override
    public boolean isSuccess() {
        return this.code.isSuccess();
    }

    /**
     * @return 是否成功 code != ResultCode.SUCCESS
     */
    @Override
    public boolean isFailure() {
        return !this.isSuccess();
    }

    /**
     * @return 是否有结果值呈现
     */
    @Override
    public boolean isPresent() {
        return this.returnValue != null;
    }

    /**
     * 设置消息产生
     *
     * @param message 消息, 可用占位符 {}
     * @param params  消息参数列表, 替换占位符
     * @return 返回
     */
    @SuppressWarnings("unchecked")
    @Override
    public D withMessage(String message, Object... params) {
        this.message = StringHelper.format(message, params);
        return (D)this;
    }

    /**
     * 设置 code message 填充参数
     *
     * @param params 消息参数列表
     * @return 返回
     */
    @SuppressWarnings("unchecked")
    @Override
    public D withMessageParams(Object... params) {
        this.message = StringHelper.format(this.code.getMessage(), params);
        return (D)this;
    }

    /**
     * 是否成功
     *
     * @param consumer 数值填充
     */
    @Override
    public void ifSuccess(Consumer<? super M> consumer) {
        if (this.isSuccess()) {
            consumer.accept(get());
        }
    }

    @Override
    public void ifFailure(BiConsumer<ResultCode, ? super M> consumer) {
        if (!this.isSuccess()) {
            consumer.accept(this.code, get());
        }
    }

    @Override
    public void then(BiConsumer<ResultCode, ? super M> consumer) {
        consumer.accept(this.code, get());
    }

    /**
     * @return 获取结果值
     */
    @Override
    public C getCode() {
        return this.code;
    }

    /**
     * @return 获取返回结果
     */
    @Override
    public M get() {
        return this.returnValue;
    }

    @Override
    public Optional<M> getOpt() {
        return Optional.ofNullable(this.returnValue);
    }

    @Override
    public String getMessage() {
        if (this.message != null) {
            return this.message;
        } else {
            return this.code.getMessage();
        }
    }

    @Override
    public String toString() {
        return "ResultDone [code=" + this.code + ", returnValue=" + this.returnValue + "]";
    }

}
