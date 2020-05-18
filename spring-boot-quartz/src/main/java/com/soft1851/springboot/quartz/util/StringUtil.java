package com.soft1851.springboot.quartz.util;

import java.util.List;

/**
 * @author Johnny
 * @Date: 2020/5/18 23:57
 * @Description:
 */
public enum StringUtil {
    ;
    /**
     * 获取List参数值
     * @param list
     * @return
     */
    public static String getListString(List<String> list) {
        StringBuilder result = new StringBuilder();
        for (String s : list) {
            result.append(s).append(" ");
        }
        return result.toString();
    }
}
