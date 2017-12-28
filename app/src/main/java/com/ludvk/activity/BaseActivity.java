package com.ludvk.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.view.View;
import android.widget.LinearLayout;

import com.ludvk.utils.AppManager;

/**
 * Creator lh on 2017/5/11 10:12.
 * Email:3021634343@qq.com
 * Description: 基类Activity
 */

public abstract class BaseActivity extends Activity implements View.OnClickListener {


    private LinearLayout returnOut;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(attachLayoutRes());
        AppManager.getAppManager().addActivity(this);
        initView();
        initData();
    }

    /**
     * 绑定布局文件
     *
     * @return 布局文件ID
     */
    @LayoutRes
    protected abstract int attachLayoutRes();

    /**
     * 初始化视图控件
     */
    protected abstract void initView();

    /**
     * 初始化数据
     */
    protected abstract void initData();





}