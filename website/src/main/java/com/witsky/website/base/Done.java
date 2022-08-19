package com.witsky.website.base;

import java.util.Optional;
import java.util.function.*;

/**
 * @author YSJ
 * @date 2022/07/20 15:39
 */
public interface Done <TReturn>{
    /**
     * @return 是否成功
     */
    boolean isSuccess();

    /**
     * @return 是否有结果值呈现
     */
    default boolean isPresent() {
        return this.get() != null;
    }

    /**
     * @return 返回结果消息
     */
    String getMessage();

    /**
     * @return 获取返回结果
     */
    TReturn get();

    default Optional<TReturn> getOpt() {
        return Optional.ofNullable(this.get());
    }

    default TReturn orElse(TReturn other) {
        TReturn object = get();
        return object != null ? object : other;
    }

    default TReturn orElseGet(Supplier<? extends TReturn> other) {
        TReturn object = get();
        return object != null ? object : other.get();
    }

    default <X extends Throwable> TReturn orElseThrow(Supplier<? extends X> exceptionSupplier) throws X {
        TReturn object = get();
        if (object != null) {
            return object;
        } else {
            throw exceptionSupplier.get();
        }
    }

    default void ifPresent(Consumer<? super TReturn> consumer) {
        TReturn object = get();
        if (object != null) {
            consumer.accept(object);
        }
    }

    default void ifSuccess(Consumer<? super TReturn> consumer) {
        if (this.isSuccess()) {
            consumer.accept(get());
        }
    }

    default boolean isFailure() {
        return !this.isSuccess();
    }

    default void ifFailure(Consumer<? super TReturn> consumer) {
        if (!this.isSuccess()) {
            consumer.accept(get());
        }
    }

}
