package com.witsky.website.base;

import java.lang.reflect.*;

/**
 * @author YSJ
 * @date 2022/07/20 15:49
 */
public class ReferenceType <T> {

    private final Type type;

    protected ReferenceType() {
        Class<?> parameterizedTypeReferenceSubclass = findReferenceTypeSubclass(getClass());
        Type type = parameterizedTypeReferenceSubclass.getGenericSuperclass();
        ThrowHelper.checkArgument(type instanceof ParameterizedType, "Type must be a parameterized type");
        ParameterizedType parameterizedType = (ParameterizedType)type;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        ThrowHelper.checkArgument(actualTypeArguments.length == 1, "Number of type arguments must be 1");
        this.type = actualTypeArguments[0];
    }

    private ReferenceType(Type type) {
        this.type = type;
    }

    public Type getType() {
        return this.type;
    }

    @Override
    public boolean equals(Object other) {
        return (this == other || (other instanceof ReferenceType &&
                this.type.equals(((ReferenceType<?>)other).type)));
    }

    @Override
    public int hashCode() {
        return this.type.hashCode();
    }

    @Override
    public String toString() {
        return "ReferenceType<" + this.type + ">";
    }

    /**
     * Build a {@code ReferenceType} wrapping the given type.
     *
     * @param type a generic type (possibly obtained via reflection,
     *             e.g. from {@link java.lang.reflect.Method#getGenericReturnType()})
     * @return a corresponding reference which may be passed into
     * {@code ReferenceType}-accepting methods
     * @since 4.3.12
     */
    public static <T> ReferenceType<T> forType(Type type) {
        return new ReferenceType<T>(type) {
        };
    }

    private static Class<?> findReferenceTypeSubclass(Class<?> child) {
        Class<?> parent = child.getSuperclass();
        if (Object.class == parent) {
            throw new IllegalStateException("Expected ReferenceType superclass");
        } else if (ReferenceType.class == parent) {
            return child;
        } else {
            return findReferenceTypeSubclass(parent);
        }
    }

}