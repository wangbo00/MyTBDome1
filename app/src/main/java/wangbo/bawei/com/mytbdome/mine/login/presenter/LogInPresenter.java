package wangbo.bawei.com.mytbdome.mine.login.presenter;

import java.util.Map;

import wangbo.bawei.com.mytbdome.mine.login.bean.LoginBean;
import wangbo.bawei.com.mytbdome.mine.login.model.LogIn;
import wangbo.bawei.com.mytbdome.mine.login.view.LoginView;

/**
 * author:Created by Wangbo on 2017/12/15.
 */

public class LogInPresenter implements LogIn.LoginFinish{
    LoginView iView;
    LogIn logIn;

    public LogInPresenter(LoginView iView) {
        this.iView = iView;
        this.logIn=new LogIn();
        logIn.setLoginFinish(this);
    }
    public  void  getUrl(String url, Map<String,String> map){
        logIn.getUrl(url,map);
    }

    @Override
    public void onLoginFinishLisenter(LoginBean loginBean) {
        iView.getData(loginBean);

    }

    @Override
    public void onfuail(String msg) {
        iView.onfuail(msg);

    }
}
