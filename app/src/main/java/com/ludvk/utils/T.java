package com.ludvk.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Creator lh on 2017/2/24 9:55.
 * Email:3021634343@qq.com
 * Description: Toast统一管理类
 */
public class T {

    private T() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    private static final boolean isShow = true;
    private static final boolean isShowLOG = true;

    /**
     * 短时间显示Toast日志
     */
    public static void showShortLog(Context context, CharSequence message) {
        if (isShowLOG && null != context) {
            Toast.makeText(context, "LOG==" + StringUtils.object2String(message),
                    Toast.LENGTH_LONG).show();
        }
    }

    /**
     * 短时间显示Toast
     */
    public static void showShort(Context context, CharSequence message) {
        if (isShow && null != context) {
            Toast.makeText(context, StringUtils.object2String(message), Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 短时间显示Toast
     */
    public static void showShort(Context context, int message) {
        if (isShow && null != context) {
            Toast.makeText(context, StringUtils.object2String(message + ""),
                    Toast.LENGTH_LONG).show();
        }
    }

    /**
     * 长时间显示Toast
     */
    public static void showLong(Context context, CharSequence message) {
        if (isShow && null != context) {
            Toast.makeText(context, StringUtils.object2String(message), Toast.LENGTH_LONG).show();
        }
    }

    /**
     * 长时间显示Toast
     */
    public static void showLong(Context context, int message) {
        if (isShow && null != context) {
            Toast.makeText(context, StringUtils.object2String(message + ""),
                    Toast.LENGTH_LONG).show();
        }
    }

    /**
     * 自定义显示Toast时间
     */
    public static void show(Context context, CharSequence message, int duration) {
        if (isShow && null != context) {
            Toast.makeText(context, StringUtils.object2String(message), duration).show();
        }
    }

    /**
     * 自定义显示Toast时间
     */
    public static void show(Context context, int message, int duration) {
        if (isShow && null != context) {
            Toast.makeText(context, StringUtils.object2String(message + ""), duration).show();
        }
    }


}