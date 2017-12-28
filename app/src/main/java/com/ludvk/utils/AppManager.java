package com.ludvk.utils;


import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;


import java.util.Stack;

/**
 * 应用程序Activity管理类：用于Activity管理和应用程序退出
 *
 */
public class AppManager {

    private static Stack<Activity> activityStack;
    private static AppManager instance;

    private AppManager(){}
    /**
     * 单一实例
     */
    public static AppManager getAppManager(){
        if(instance==null){
            instance=new AppManager();
        }
        return instance;
    }
    /**
     * 添加Activity到堆栈
     */
    public void addActivity(Activity activity){
        if(activityStack==null){
            activityStack=new Stack<Activity>();
        }
        activityStack.add(activity);
        Object[] obj = activityStack.toArray();
        for(int i = 0;i<obj.length;i++){
            Activity acti = (Activity) obj[i];
        }
    }


    /**
     * 获取当前Activity（堆栈中最后一个压入的）
     */
    public Activity currentActivity(){
        Activity activity=activityStack.lastElement();
        return activity;
    }
    /**
     * 结束当前Activity（堆栈中最后一个压入的）
     */
    public void finishActivity(){
        Activity activity=activityStack.lastElement();
        finishActivity(activity);
    }
    /**
     * 结束指定的Activity
     */
    public void finishActivity(Activity activity){
        if(activity!=null){
            activityStack.remove(activity);
            activity.finish();
            activity=null;
        }
    }
    /**
     * 结束指定类名的Activity
     */
    public void finishActivityclass(Class<?> cls) {
        if (activityStack != null) {
            for (Activity activity : activityStack) {
                if (activity.getClass().equals(cls)) {
                    this.activityStack.remove(activity);
                    finishActivity(activity);
                    break;
                }
            }
        }
    }

    /**
     * 除最顶层activity，结束所有顶层以下activity
     */
    public void finishActivityExceptLast(){

    }

    /**
     * 除第一个Activity页面外，结束所有activity
     * 修改了删除顺序
     */
    public void finishActivityExceptFirst(){
        for(int i = 0 ;i<activityStack.size();i++){
            L.print("....."+activityStack.get(i).toString());
        }
        for(int i = activityStack.size() ; i >1;i--){
            if( null != activityStack.get(i-1)){
                activityStack.get(i-1).finish();
            }
        }
    }

    /**
     * 关闭除了指定activity以外的全部activity 如果cls不存在于栈中，则栈全部清空
     *
     * @param cls
     */
    public void finishOthersActivity(Class<?> cls) {
        for (Activity activity : activityStack) {
            if (!(activity.getClass().equals(cls))) {
                finishActivity(activity);
            }
        }
    }
    /**
     * 结束所有Activity
     */
    public void finishAllActivity(){
        for(int i = activityStack.size();i>0;i--){
        }
        for (int i = activityStack.size(); i > 0; i--){

            if (null != activityStack.get(i-1)){
                activityStack.get(i-1).finish();
            }
        }
        activityStack.clear();
        if(!activityStack.empty()){
            for(int i = 0;i<activityStack.size();i++){
                L.print(activityStack.get(i).toString());
            }
        }
    }
    /**
     * 退出应用程序
     */
    public void AppExit(Context context) {
        try {
            finishAllActivity();
            ActivityManager activityMgr= (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            activityMgr.restartPackage(context.getPackageName());
            System.exit(0);
        } catch (Exception e) {	}
    }
}