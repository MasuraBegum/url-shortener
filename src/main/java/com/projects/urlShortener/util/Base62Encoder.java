package com.projects.urlShortener.util;

public class Base62Encoder {
    private static final String BASE62 =
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String encode(long value) {
        StringBuilder sb = new StringBuilder();
        while(value > 0) {
            int rem = (int) value % 62;
            sb.append(BASE62.charAt(rem));
            value /= 62;
        }

        return sb.reverse().toString();
    }
}
