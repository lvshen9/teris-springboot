package com.lvshen.teris.util;

/**
 * Description:
 *
 * @author Lvshen
 * @version 1.0
 * @date: 2021/3/30 21:32
 * @since JDK 1.8
 */
public class CommonUtils {
    private static final String ROOT_PATH = "src/main/resources/";

    public static String getFullPath(String path) {
        return ROOT_PATH.concat(path);
    }
}
