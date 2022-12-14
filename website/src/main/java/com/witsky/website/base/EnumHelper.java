package com.witsky.website.base;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author YSJ
 * @date 2022/07/20 15:50
 */
public class EnumHelper {

    private static final Map<Class<?>, Map<String, Object>> enumMap = new ConcurrentHashMap<>();

    public static <I, E extends IdEnum<I>> E of(Class<E> enumClass, I id) {
        return ThrowHelper.checkNotNull(uncheckOf(enumClass, id),
                "ID 为 {} 的 {} 枚举实例不存在", id, enumClass);
    }

    public static <E> E ofName(Class<E> enumClass, String name) {
        return ThrowHelper.checkNotNull(uncheckOfName(enumClass, name),
                "ID 为 {} 的 {} 枚举实例不存在", name, enumClass);
    }

    public static <E extends Enum<E>, S> E of(Class<E> enumClass, Function<E, S> getter, S value) {
        return ThrowHelper.checkNotNull(uncheckOf(enumClass, getter, value),
                "{} 为 {} 的 {} 枚举实例不存在", getter, value, enumClass);
    }

    public static <E, S> Set<E> find(Class<E> enumClass, Function<E, S> getter, Collection<? extends S> value) {
        Set<E> enums = new HashSet<>();
        for (E e : enumClass.getEnumConstants()) {
            if (value.contains(getter.apply(e))) {
                enums.add(e);
            }
        }
        return enums;
    }

    public static <E, S> E uncheckOf(Class<E> enumClass, Function<E, S> getter, S value) {
        for (E e : enumClass.getEnumConstants()) {
            if (Objects.equals(getter.apply(e), value)) {
                return e;
            }
        }
        return null;
    }

    public static <I, E extends IdEnum<I>> E uncheckOf(Class<E> enumClass, I id) {
        for (E e : enumClass.getEnumConstants()) {
            if (e.getId().equals(id)) {
                return e;
            }
        }
        return null;
    }

    public static <E> E uncheckOfName(Class<E> enumClass, String enumName) {
        if (Enum.class.isAssignableFrom(enumClass)) {
            return ObjectHelper.as(enumMap.computeIfAbsent(enumClass, c -> {
                try {
                    Method method = c.getMethod("values");
                    Object[] inter = (Object[])method.invoke(null);
                    Map<String, Object> builder = new HashMap<>();
                    for (Object e : inter) {
                        builder.put(e.toString(), e);
                    }
                    return Collections.unmodifiableMap(builder);
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            }).get(enumName));
        }
        return null;
    }

    @SafeVarargs
    public static <E extends Enum<E>> boolean isIn(E value, E... elements) {
        return Stream.of(elements).anyMatch(v -> v == value);
    }

    @SafeVarargs
    public static <E extends Enum<E>> boolean isOut(E value, E... elements) {
        return Stream.of(elements).noneMatch(v -> v == value);
    }

}

