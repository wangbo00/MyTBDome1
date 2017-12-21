package wangbo.bawei.com.mytbdome.mine.login.view;

import wangbo.bawei.com.mytbdome.mine.login.bean.LoginBean;

/**
 * author:Created by YanZhiXiong on 2017/12/12.
 */

public interface LoginView {
    void getData(LoginBean loginBean);
    void onfuail(String msf);
}
