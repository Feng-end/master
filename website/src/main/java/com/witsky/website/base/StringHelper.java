package com.witsky.website.base;

import java.util.*;
import java.util.function.Supplier;

/**
 * @author YSJ
 * @date 2022/07/20 15:36
 */
public class StringHelper {
    private static final char DELIM_START = '{';
    private static final char ESCAPE_CHAR = '\\';
    private static final String DELIM_STR = "{}";

    public static boolean isEmpty(CharSequence cs) {
        return cs == null || cs.length() == 0;

    }

    public static boolean isNotEmpty(CharSequence cs) {
        return !isEmpty(cs);
    }

    private static boolean isEmpty(CharSequence... css) {
        return css == null || css.length <= 0;
    }

    public static boolean isAnyEmpty(CharSequence... css) {
        if (!isEmpty(css)) {
            for (CharSequence cs : css) {
                if (isEmpty(cs)) {
                    return true;
                }
            }

        }
        return false;
    }

    public static boolean isNoneEmpty(CharSequence... css) {
        return !isAnyEmpty(css);
    }

    public static boolean isAllEmpty(CharSequence... css) {
        if (!isEmpty(css)) {
            for (CharSequence cs : css) {
                if (isNotEmpty(cs)) {
                    return false;
                }
            }

        }
        return true;
    }

    public static boolean isBlank(CharSequence cs) {
        int strLen;
        if (cs != null && (strLen = cs.length()) != 0) {
            for (int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(cs.charAt(i))) {
                    return false;
                }
            }

        }
        return true;
    }

    public static boolean isNotBlank(CharSequence cs) {
        return !isBlank(cs);
    }

    public static boolean isAnyBlank(CharSequence... css) {
        if (!isEmpty(css)) {
            for (CharSequence cs : css) {
                if (isBlank(cs)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isNoneBlank(CharSequence... css) {
        return !isAnyBlank(css);
    }

    public static boolean isAllBlank(CharSequence... css) {
        if (!isEmpty(css)) {
            for (CharSequence cs : css) {
                if (isNotBlank(cs)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 如果 value is blank 返回 value, 否则返回elseValue
     *
     * @param value     值
     * @param elseValue 其他值
     * @return value is blank 返回 value, 否则返回elseValue
     */
    public static String ifBlankElse(String value, String elseValue) {
        if (isBlank(value)) {
            return value;
        }
        return elseValue;
    }

    /**
     * 如果 value is blank 返回 value, 否则返回elseValue.get()
     *
     * @param value     值
     * @param elseValue 其他值提供者
     * @return value is blank 返回 value, 否则返回elseValue.get()
     */
    public static String ifBlankElse(String value, Supplier<String> elseValue) {
        if (isBlank(value)) {
            return value;
        }
        return elseValue.get();
    }

    /**
     * 如果 value is not blank 返回 value, 否则返回elseValue
     *
     * @param value     值
     * @param elseValue 其他值
     * @return value is not blank 返回 value, 否则返回elseValue
     */
    public static String ifNotBlankElse(String value, String elseValue) {
        if (isNoneBlank(value)) {
            return value;
        }
        return elseValue;
    }

    /**
     * 如果 value is not blank 返回 value, 否则返回elseValue.get()
     *
     * @param value     值
     * @param elseValue 其他值提供者
     * @return value is not blank 返回 value, 否则返回elseValue.get()
     */
    public static String ifNotBlankElse(String value, Supplier<String> elseValue) {
        if (isNoneBlank(value)) {
            return value;
        }
        return elseValue.get();
    }

    public static String format(final String messagePattern, final Object... argArray) {
        if (messagePattern == null || argArray == null || argArray.length == 0) {
            return messagePattern;
        }

        int i = 0;
        int delimIndex;
        StringBuilder buffer = new StringBuilder(messagePattern.length() + 50);

        int index;
        for (index = 0; index < argArray.length; index++) {

            delimIndex = messagePattern.indexOf(DELIM_STR, i);

            if (delimIndex == -1) {
                // no more variables
                if (i == 0) { // this is a simple string
                    return messagePattern;
                } else {
                    // add the tail string which contains no variables and return
                    // the result.
                    buffer.append(messagePattern.substring(i, messagePattern.length()));
                    return buffer.toString();
                }
            } else {
                if (isEscapedDelimeter(messagePattern, delimIndex)) {
                    if (!isDoubleEscaped(messagePattern, delimIndex)) {
                        index--; // DELIM_START was escaped, thus should not be incremented
                        buffer.append(messagePattern.substring(i, delimIndex - 1));
                        buffer.append(DELIM_START);
                        i = delimIndex + 1;
                    } else {
                        // The escape character preceding the delimiter start is
                        // itself escaped: "abc x:\\{}"
                        // we have to consume one backward slash
                        buffer.append(messagePattern.substring(i, delimIndex - 1));
                        deeplyAppendParameter(buffer, argArray[index], new HashMap<>());
                        i = delimIndex + 2;
                    }
                } else {
                    // normal case
                    buffer.append(messagePattern.substring(i, delimIndex));
                    deeplyAppendParameter(buffer, argArray[index], new HashMap<>());
                    i = delimIndex + 2;
                }
            }
        }
        // append the characters following the last {} pair.
        buffer.append(messagePattern.substring(i, messagePattern.length()));
        return buffer.toString();
    }

    /**
     * Match a String against the given pattern, supporting the following simple
     * pattern styles: "xxx*", "*xxx", "*xxx*" and "xxx*yyy" matches (with an
     * arbitrary number of pattern parts), as well as direct equality.
     *
     * @param pattern the pattern to match against
     * @param str     the String to match
     * @return whether the String matches the given pattern
     */
    public static boolean isMatch(String pattern, String str) {
        if (pattern == null || str == null) {
            return false;
        }

        int firstIndex = pattern.indexOf('*');
        if (firstIndex == -1) {
            return pattern.equals(str);
        }

        if (firstIndex == 0) {
            if (pattern.length() == 1) {
                return true;
            }
            int nextIndex = pattern.indexOf('*', 1);
            if (nextIndex == -1) {
                return str.endsWith(pattern.substring(1));
            }
            String part = pattern.substring(1, nextIndex);
            if (part.isEmpty()) {
                return isMatch(pattern.substring(nextIndex), str);
            }
            int partIndex = str.indexOf(part);
            while (partIndex != -1) {
                if (isMatch(pattern.substring(nextIndex), str.substring(partIndex + part.length()))) {
                    return true;
                }
                partIndex = str.indexOf(part, partIndex + 1);
            }
            return false;
        }

        return (str.length() >= firstIndex &&
                pattern.substring(0, firstIndex).equals(str.substring(0, firstIndex)) &&
                isMatch(pattern.substring(firstIndex), str.substring(firstIndex)));
    }

    /**
     * Match a String against the given patterns, supporting the following simple
     * pattern styles: "xxx*", "*xxx", "*xxx*" and "xxx*yyy" matches (with an
     * arbitrary number of pattern parts), as well as direct equality.
     *
     * @param patterns the patterns to match against
     * @param str      the String to match
     * @return whether the String matches any of the given patterns
     */
    public static boolean isMatch(String[] patterns, String str) {
        if (patterns != null) {
            for (String pattern : patterns) {
                if (isMatch(pattern, str)) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean isEscapedDelimeter(String messagePattern, int delimeterStartIndex) {
        if (delimeterStartIndex == 0) {
            return false;
        }
        char potentialEscape = messagePattern.charAt(delimeterStartIndex - 1);
        return ESCAPE_CHAR == potentialEscape;
    }

    static boolean isDoubleEscaped(String messagePattern, int delimeterStartIndex) {
        return delimeterStartIndex >= 2 && messagePattern.charAt(delimeterStartIndex - 2) == ESCAPE_CHAR;
    }

    private static void deeplyAppendParameter(StringBuilder buff, Object o, Map<Object, Object> seenMap) {
        if (o == null) {
            buff.append("null");
            return;
        }
        if (!o.getClass().isArray()) {
            safeObjectAppend(buff, o);
        } else {
            // check for primitive array types because they
            // unfortunately cannot be cast to Object[]
            if (o instanceof boolean[]) {
                booleanArrayAppend(buff, (boolean[])o);
            } else if (o instanceof byte[]) {
                byteArrayAppend(buff, (byte[])o);
            } else if (o instanceof char[]) {
                charArrayAppend(buff, (char[])o);
            } else if (o instanceof short[]) {
                shortArrayAppend(buff, (short[])o);
            } else if (o instanceof int[]) {
                intArrayAppend(buff, (int[])o);
            } else if (o instanceof long[]) {
                longArrayAppend(buff, (long[])o);
            } else if (o instanceof float[]) {
                floatArrayAppend(buff, (float[])o);
            } else if (o instanceof double[]) {
                doubleArrayAppend(buff, (double[])o);
            } else {
                objectArrayAppend(buff, (Object[])o, seenMap);
            }
        }
    }

    private static void safeObjectAppend(StringBuilder sbuf, Object o) {
        try {
            String oAsString = o.toString();
            sbuf.append(oAsString);
        } catch (Throwable t) {
            System.err
                    .println("SLF4J: Failed toString() invocation on an object of type ["
                            + o.getClass().getName() + "]");
            t.printStackTrace();
            sbuf.append("[FAILED toString()]");
        }

    }

    private static void objectArrayAppend(StringBuilder sbuf, Object[] a, Map<Object, Object> seenMap) {
        sbuf.append('[');
        if (!seenMap.containsKey(a)) {
            seenMap.put(a, null);
            final int len = a.length;
            for (int i = 0; i < len; i++) {
                deeplyAppendParameter(sbuf, a[i], seenMap);
                if (i != len - 1) {
                    sbuf.append(", ");
                }
            }
            // allow repeats in siblings
            seenMap.remove(a);
        } else {
            sbuf.append("...");
        }
        sbuf.append(']');
    }

    private static void booleanArrayAppend(StringBuilder sbuf, boolean[] a) {
        sbuf.append('[');
        final int len = a.length;
        for (int i = 0; i < len; i++) {
            sbuf.append(a[i]);
            if (i != len - 1) {
                sbuf.append(", ");
            }
        }
        sbuf.append(']');
    }

    private static void byteArrayAppend(StringBuilder sbuf, byte[] a) {
        sbuf.append('[');
        final int len = a.length;
        for (int i = 0; i < len; i++) {
            sbuf.append(a[i]);
            if (i != len - 1) {
                sbuf.append(", ");
            }
        }
        sbuf.append(']');
    }

    private static void charArrayAppend(StringBuilder sbuf, char[] a) {
        sbuf.append('[');
        final int len = a.length;
        for (int i = 0; i < len; i++) {
            sbuf.append(a[i]);
            if (i != len - 1) {
                sbuf.append(", ");
            }
        }
        sbuf.append(']');
    }

    private static void shortArrayAppend(StringBuilder sbuf, short[] a) {
        sbuf.append('[');
        final int len = a.length;
        for (int i = 0; i < len; i++) {
            sbuf.append(a[i]);
            if (i != len - 1) {
                sbuf.append(", ");
            }
        }
        sbuf.append(']');
    }

    private static void intArrayAppend(StringBuilder sbuf, int[] a) {
        sbuf.append('[');
        final int len = a.length;
        for (int i = 0; i < len; i++) {
            sbuf.append(a[i]);
            if (i != len - 1) {
                sbuf.append(", ");
            }
        }
        sbuf.append(']');
    }

    private static void longArrayAppend(StringBuilder sbuf, long[] a) {
        sbuf.append('[');
        final int len = a.length;
        for (int i = 0; i < len; i++) {
            sbuf.append(a[i]);
            if (i != len - 1) {
                sbuf.append(", ");
            }
        }
        sbuf.append(']');
    }

    private static void floatArrayAppend(StringBuilder sbuf, float[] a) {
        sbuf.append('[');
        final int len = a.length;
        for (int i = 0; i < len; i++) {
            sbuf.append(a[i]);
            if (i != len - 1) {
                sbuf.append(", ");
            }
        }
        sbuf.append(']');
    }

    private static void doubleArrayAppend(StringBuilder sbuf, double[] a) {
        sbuf.append('[');
        final int len = a.length;
        for (int i = 0; i < len; i++) {
            sbuf.append(a[i]);
            if (i != len - 1) {
                sbuf.append(", ");
            }
        }
        sbuf.append(']');
    }

}
