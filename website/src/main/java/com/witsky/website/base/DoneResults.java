package com.witsky.website.base;

import java.util.function.Function;

/**
 * @author YSJ
 * @date 2022/07/20 15:40
 */
public class DoneResults {

    /**
     * 返回一个结果 可成功或失败, 由code决定
     *
     * @param value 结果值
     * @param code  结果码
     * @return 返回结果
     */
    public static <M, MC extends M, C extends ResultCode> DoneResult<M, C> done(C code, MC value) {
        return new DefaultDoneResult<>(code, value, null);
    }

    /**
     * 返回一个结果 可成功或失败, 由code决定
     *
     * @param value   结果值
     * @param code    结果码
     * @param message 消息
     * @return 返回结果
     */
    public static <M, MC extends M, C extends ResultCode> DoneResult<M, C> done(C code, MC value, String message, Object... messageParams) {
        return new DefaultDoneResult<>(code, value, StringHelper.format(message, messageParams));
    }

    /**
     * 返回一个DoneResults, 结果码为result的结果码, 返回内容为value的.
     *
     * @param result 失败结果
     * @param value  返回值
     * @param <M>    返回类型
     * @return DoneResults
     */
    public static <M, C extends ResultCode> DoneResult<M, C> change(DoneResult<?, C> result, M value) {
        return new DefaultDoneResult<>(result.getCode(), value, result.getMessage());
    }

    /**
     * 返回一个DoneResults, 其结果码为result的结果码, 返回内容为mapper的返回结果.
     *
     * @param result 失败结果
     * @param mapper 返回值的mapper函数
     * @param <M>    返回类型
     * @return DoneResults
     */
    public static <M, S> DoneResult<M, ?> map(DoneResult<S, ?> result, Function<S, M> mapper) {
        ThrowHelper.checkArgument(result.isFailure(), "code [{}] is success", result.getCode());
        return new DefaultDoneResult<>(result.getCode(), mapper.apply(result.get()), result.getMessage());
    }

}
