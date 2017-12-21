package wangbo.bawei.com.mytbdome.hompager.view;

import wangbo.bawei.com.mytbdome.hompager.bean.JZBean;
/**
 * author:Created by Wangbo on 2017/12/16.
 */

public interface LoadView {

    void jzsuccess(JZBean jzBean);
    void jzfalied(String msf);
}
