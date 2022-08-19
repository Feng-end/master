package com.witsky.website.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Optional;
import java.util.function.*;

import static com.witsky.website.base.ObjectHelper.*;

/**
 * @author YSJ
 * @date 2022/07/20 15:30
 */
public class ApiResult<O> {
    @JsonProperty
    private int code;

    @JsonProperty
    private String message;

    @JsonProperty
    private String description;

    @JsonProperty
    private O body;

    public static <O> ApiResult<O> exception(ApiResultException cause) {
        return new ApiResult<>(cause.getCode(), cause.getMessage(), cause.getMessage(), null);
    }

    public static <O> ApiResult<O> exception(ApiException cause) {
        ResultCode code = cause.getResultCode();
        return new ApiResult<>(code.getCode(), code.getMessage(), cause.getMessage(), as(cause.getBody()));
    }

    public static <O> ApiResult<O> ofCode(ResultCode code) {
        return new ApiResult<>(code.getCode(), code.getMessage(), "", null);
    }

    public static <O> ApiResult<O> ofCode(ResultCode code, String description, Object... params) {
        return new ApiResult<>(code.getCode(), code.getMessage(), StringHelper.format(description, params), null);
    }

    public static <O> ApiResult<O> of(ResultCode code, O object) {
        return new ApiResult<>(code.getCode(), code.getMessage(), "", object);
    }

    public static <O> ApiResult<O> of(ResultCode code, O object, String description, Object... params) {
        return new ApiResult<>(code.getCode(), code.getMessage(), StringHelper.format(description, params), object);
    }

    public static <O> ApiResult<O> of(int code, String message, String description, Object... params) {
        return new ApiResult<>(code, message, StringHelper.format(description, params), null);
    }

    public static <O> ApiResult<O> ofDescription(ResultCode code, String description, Object... params) {
        return new ApiResult<>(code.getCode(), code.getMessage(), StringHelper.format(description, params), null);
    }

    public static <O> ApiResult<O> ofResult(DoneResult<?, ApiResultCode> done) {
        ResultCode code = done.getCode();
        return new ApiResult<>(code.getCode(), code.getMessage(), done.getMessage(), null);
    }

    public static <V, D> ApiResult<D> mapOn(DoneResult<V, ApiResultCode> done, D successBody, D failureBody) {
        if (done.isFailure()) {
            return ApiResult.map(done, failureBody);
        }
        return ApiResult.success(successBody);
    }

    public static <V, D> ApiResult<D> mapOnSuccess(DoneResult<V, ApiResultCode> done, D body) {
        if (done.isFailure()) {
            return ApiResult.ofResult(done);
        }
        return ApiResult.success(body);
    }

    public static <V, D> ApiResult<D> mapOnSuccess(DoneResult<V, ApiResultCode> done, Function<V, D> mapper) {
        if (done.isFailure()) {
            return ApiResult.ofResult(done);
        }
        return ApiResult.success(mapper.apply(done.get()));
    }

    public static <V, D> ApiResult<D> mapOnFailure(DoneResult<V, ApiResultCode> done, D body) {
        if (done.isFailure()) {
            return ApiResult.map(done, body);
        }
        return ApiResult.success();
    }

    public static <V, D> ApiResult<D> mapOnFailure(DoneResult<V, ApiResultCode> done, Function<V, D> mapper) {
        if (done.isFailure()) {
            return ApiResult.map(done, mapper.apply(done.get()));
        }
        return ApiResult.success();
    }

    public static <O> ApiResult<O> of(ApiResult<?> source) {
        return new ApiResult<>(source.getCode(), source.getMessage(), source.getMessage(), null);
    }

    public static <O> ApiResult<O> map(ApiResult<?> source, O body) {
        return new ApiResult<>(source.getCode(), source.getMessage(), source.getMessage(), body);
    }

    public static <V, D> ApiResult<D> map(ApiResult<?> done, Function<ApiResult<?>, D> mapper) {
        return ApiResult.map(done, mapper.apply(done));
    }

    public static <O> ApiResult<O> map(DoneResult<O, ApiResultCode> done) {
        return new ApiResult<>(done.getCode(), done.getMessage(), done.get());
    }

    public static <O> ApiResult<O> map(DoneResult<?, ApiResultCode> done, O body) {
        return new ApiResult<>(done.getCode(), done.getMessage(), body);
    }

    public static <V, D> ApiResult<D> map(DoneResult<V, ApiResultCode> done, Function<DoneResult<V, ApiResultCode>, D> mapper) {
        return ApiResult.map(done, mapper.apply(done));
    }

    public static <O> ApiResult<O> success(O body) {
        return new ApiResult<>(CommonApiResultCode.SUCCESS, "", body);
    }

    public static <O> ApiResult<O> success() {
        return success(null);
    }

    public ApiResult() {
    }

    private ApiResult(int code, String message, String description, O body) {
        this.code = code;
        this.message = message;
        this.description = description;
        this.body = body;
    }

    private ApiResult(ResultCode code, String description, O body) {
        this(code.getCode(), code.getMessage(), description, body);
    }

    public int getCode() {
        return this.code;
    }

    public O getBody() {
        return as(this.body);
    }

    public O orElseBody(O other) {
        O object = getBody();
        return object != null ? object : other;
    }

    public O orElseGetBody(Supplier<? extends O> other) {
        O object = getBody();
        return object != null ? object : other.get();
    }

    public void ifPresent(Consumer<? super O> consumer) {
        O object = getBody();
        if (object != null) {
            consumer.accept(object);
        }
    }

    public Optional<O> optional() {
        return Optional.ofNullable(this.body);
    }

    public void ifSuccess(Consumer<? super O> consumer) {
        if (this.isSuccess()) {
            consumer.accept(this.body);
        }
    }

    public void ifFailure(Consumer<? super O> consumer) {
        if (this.isFailure()) {
            consumer.accept(this.body);
        }
    }

    public String getMessage() {
        return this.message;
    }

    public String getDescription() {
        return description;
    }

    public boolean isSuccess() {
        return ResultCode.isSuccessCode(this.code);
    }

    public boolean isFailure() {
        return !this.isSuccess();
    }

    //    public ResultCode resultCode() {
    //        return ResultCodes.of(this.code);
    //    }

    //    public DoneResult<O, ApiResultCode> toDone() {
    //        return DoneResults.done(resultCode(), this.body, this.getDescription());
    //    }
    //
    //    public <T> DoneResult<T> toDoneWithoutBody() {
    //        return DoneResults.done(resultCode(), null, this.getDescription());
    //    }

    //    @Override
    //    public String toString() {
    //        return "WebResult [code=" + code + ", message=" + message + ", body=" + body + "]";
    //    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("code", code)
                .append("message", message)
                .append("description", description)
                .append("body", body)
                .toString();
    }
}
