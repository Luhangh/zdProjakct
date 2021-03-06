package com.ludvk.utils;

import android.util.Log;


/**
 * Creator lh on 2017/2/24 9:55.
 * Email:3021634343@qq.com
 * Description: Log统一管理类
 */

public class L {

    private L() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static boolean isDebug = true;// 是否需要打印bug，可以在application的onCreate函数里面初始化
    private static final String TAG = "qb++mops2";

    // 下面四个是默认tag的函数
    public static void i(String msg) {
        if (isDebug) {
            Log.i(TAG, StringUtils.object2String(msg));
        }
    }

    public static void d(String msg) {
        if (isDebug) {
            Log.d(TAG, StringUtils.object2String(msg));
        }
    }

    public static void e(String msg) {
        if (isDebug) {
            Log.e(TAG, StringUtils.object2String(msg));
        }
    }

    public static void v(String msg) {
        if (isDebug) {
            Log.v(TAG, StringUtils.object2String(msg));
        }
    }

    public static void w(String msg) {
        if (isDebug) {
            Log.w(TAG, StringUtils.object2String(msg));
        }
    }

    public static void w(String msg, Throwable tr) {
        if (isDebug) {
            Log.w(TAG, StringUtils.object2String(msg), tr);
        }
    }

    // 下面是传入自定义tag的函数
    public static void i(String tag, String msg) {
        if (isDebug) {
            Log.i(tag, StringUtils.object2String(msg));
        }
    }

    public static void d(String tag, String msg) {
        if (isDebug) {
            Log.i(tag, StringUtils.object2String(msg));
        }
    }

    public static void e(String tag, String msg) {
        if (isDebug) {
            Log.i(tag, StringUtils.object2String(msg));
        }
    }

    public static void v(String tag, String msg) {
        if (isDebug) {
            Log.i(tag, StringUtils.object2String(msg));
        }
    }

    public static void w(String tag, String msg) {
        if (isDebug) {
            Log.w(tag, StringUtils.object2String(msg));
        }
    }

    public static void w(String tag, String msg, Throwable tr) {
        if (isDebug) {
            Log.w(tag, StringUtils.object2String(msg), tr);
        }
    }

    public static void print(String msg) {
        if (isDebug) {
            System.out.print(StringUtils.object2String(msg));
        }
    }

    public static void print(Boolean msg) {
        if (isDebug) {
            System.out.print(StringUtils.object2String(msg));
        }
    }

    public static void print(int msg) {
        if (isDebug) {
            System.out.print(StringUtils.object2String(msg));
        }
    }
}