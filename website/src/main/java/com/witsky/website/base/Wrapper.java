package com.witsky.website.base;

/**
 * @author YSJ
 * @date 2022/07/20 15:53
 */
public class Wrapper {
    public static Class<?> getPrimitive(Class<?> wrapperClass) {
        return doPrimitive(wrapperClass);
    }

    public static Class<?> getWrapper(Class<?> primitiveClass) {
        return doWrapper(primitiveClass);
    }

    public static boolean isWrapper(Class<?> toClass) {
        return checkWrapper(toClass);
    }

    private static Class<?> doPrimitive(Class<?> wrapperClass) {
        if (wrapperClass.equals(Integer.class)) {
            return Integer.TYPE;
        }
        if (wrapperClass.equals(Short.class)) {
            return Short.TYPE;
        }
        if (wrapperClass.equals(Long.class)) {
            return Long.TYPE;
        }
        if (wrapperClass.equals(Float.class)) {
            return Float.TYPE;
        }
        if (wrapperClass.equals(Double.class)) {
            return Double.TYPE;
        }
        if (wrapperClass.equals(Byte.class)) {
            return Byte.TYPE;
        }
        if (wrapperClass.equals(Character.class)) {
            return Character.TYPE;
        }
        if (wrapperClass.equals(Boolean.class)) {
            return Boolean.TYPE;
        }
        if (wrapperClass.equals(Void.class)) {
            return Void.TYPE;
        }
        return wrapperClass;
    }

    private static Class<?> doWrapper(Class<?> toClass) {
        if (toClass.equals(Integer.TYPE)) {
            return Integer.class;
        }
        if (toClass.equals(Short.TYPE)) {
            return Short.class;
        }
        if (toClass.equals(Long.TYPE)) {
            return Long.class;
        }
        if (toClass.equals(Float.TYPE)) {
            return Float.class;
        }
        if (toClass.equals(Double.TYPE)) {
            return Double.class;
        }
        if (toClass.equals(Byte.TYPE)) {
            return Byte.class;
        }
        if (toClass.equals(Character.TYPE)) {
            return Character.class;
        }
        if (toClass.equals(Boolean.TYPE)) {
            return Boolean.class;
        }
        if (toClass.equals(Void.TYPE)) {
            return Void.class;
        }
        return toClass;
    }

    private static boolean checkWrapper(Class<?> toClass) {
        if (toClass.equals(Integer.class)) {
            return true;
        }
        if (toClass.equals(Short.class)) {
            return true;
        }
        if (toClass.equals(Long.class)) {
            return true;
        }
        if (toClass.equals(Float.class)) {
            return true;
        }
        if (toClass.equals(Double.class)) {
            return true;
        }
        if (toClass.equals(Byte.class)) {
            return true;
        }
        if (toClass.equals(Character.class)) {
            return true;
        }
        if (toClass.equals(Boolean.class)) {
            return true;
        }
        if (toClass.equals(Void.class)) {
            return true;
        }
        return false;
    }

}

