package wangbo.bawei.com.mytbdome.mine.login.model;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import wangbo.bawei.com.mytbdome.mine.login.bean.LoginBean;
import wangbo.bawei.com.mytbdome.utils.GsonObjectCallback;
import wangbo.bawei.com.mytbdome.utils.OkHttp3Utils;

/**
 * author:Created by Wangbo on 2017/12/15.
 */

public class LogIn implements LoginModel{

    LoginBean loginBean = new LoginBean();

    private  LoginFinish loginFinish;



    public  interface LoginFinish{
        void  onLoginFinishLisenter(LoginBean loginBean);
        void onfuail(String msg);
    }

    public void setLoginFinish(LoginFinish loginFinish) {
        this.loginFinish = loginFinish;
    }

    @Override
    public void getUrl(String url, Map<String, String> map) {
        OkHttp3Utils.doPost(url, map, new GsonObjectCallback<LoginBean>() {

            @Override
            public void onUi(LoginBean loginBean) {
                String code = loginBean.getCode();
                String msg = loginBean.getMsg();
                if (code.equals("0")){
                    loginFinish.onLoginFinishLisenter(loginBean);

                }else {
                    loginFinish.onfuail(msg);
                }

            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });

    }


}
