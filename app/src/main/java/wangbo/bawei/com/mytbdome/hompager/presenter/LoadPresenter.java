package wangbo.bawei.com.mytbdome.hompager.presenter;


import java.util.Map;

import wangbo.bawei.com.mytbdome.hompager.bean.JZBean;
import wangbo.bawei.com.mytbdome.hompager.model.LoadModel;
import wangbo.bawei.com.mytbdome.hompager.view.LoadView;

/**
 * author:Created by Wangbo on 2017/12/16.
 */

public class LoadPresenter implements LoadModel.JzOnBanFinish{

    LoadView loadView;
    LoadModel loadModel;

    public LoadPresenter(LoadView loadView){
        this.loadView=loadView;
        this.loadModel= new LoadModel();
        loadModel.setJzOnBanFinish(this);
    }

    public void getUrl(String url, Map<String,String> map){
        loadModel.getUrl(url,map);
    }
    @Override
    public void jzsucess(JZBean jzBean) {
        loadView.jzsuccess(jzBean);

    }

    @Override
    public void jzfailed(String msg) {
        loadView.jzfalied(msg);

    }
}

