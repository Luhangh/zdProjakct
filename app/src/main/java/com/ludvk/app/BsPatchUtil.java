package com.ludvk.app;

/**
 * Creator lh on 2017/9/12 11:40.
 * Email:luchefg@gmail.com
 * Description:
 */

public class BsPatchUtil {

    static {
        System.loadLibrary("libbsdiff.so");
    }

    public static native int patch(String oldApkpath,String newApkpath,String patchPath);
}
