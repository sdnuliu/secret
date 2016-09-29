package com.sdnuliu.secret.framework.utils;

/**
 * Created by liuteng on 16/9/29.
 */

public class DataCheckUtil {
    public static <T> T checkNotNull(T reference) {
        if (reference == null) {
            throw new NullPointerException();
        } else {
            return reference;
        }
    }
}
