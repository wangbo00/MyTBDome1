package wangbo.bawei.com.mytbdome.app;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Process;

/**
 * Created by fan on 2017/12/7.
 */

public class MyAPP extends Application{
    public static MyAPP mInstance;


    private static Context context;
    private static Handler handler;
    private static int mainId;
    public static boolean isLoginSuccess;//是否已经登录的状态

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        //关于context----http://blog.csdn.net/lmj623565791/article/details/40481055
        context = getApplicationContext();
        //初始化handler
        handler = new Handler();
        //主线程的id
        mainId = Process.myTid();
    }
    public static MyAPP getInstance() {
        return mInstance;
    }

    /**
     * 对外提供了context
     * @return
     */
    public static Context getAppContext() {
        return context;
    }

    /**
     * 得到全局的handler
     * @return
     */
    public static Handler getAppHanler() {
        return handler;
    }

    /**
     * 获取主线程id
     * @return
     */
    public static int getMainThreadId() {
        return mainId;
    }
}
