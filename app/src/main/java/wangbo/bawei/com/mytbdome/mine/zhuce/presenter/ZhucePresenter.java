package wangbo.bawei.com.mytbdome.mine.zhuce.presenter;

import java.util.Map;

import wangbo.bawei.com.mytbdome.mine.zhuce.bean.ZhuCeBean;
import wangbo.bawei.com.mytbdome.mine.zhuce.model.ZhuceModel;
import wangbo.bawei.com.mytbdome.mine.zhuce.view.ZhuceView;

/**
 * author:Created by Wangbo on 2017/12/15.
 */

public class ZhucePresenter implements ZhuceModel.ZhuceFinish {
    ZhuceView iView;
    ZhuceModel zhuceModel;

    public ZhucePresenter(ZhuceView iView){
        this.iView=iView;
        this.zhuceModel= new ZhuceModel();
        zhuceModel.setZhuceFinish(this);
    }
    public void getUrl(String url, Map<String,String> map){
        zhuceModel.getUrl(url,map);
    }





    @Override
    public void onZhuceFinishLisenter(ZhuCeBean zhuCeBean) {
        iView.getData(zhuCeBean);

    }

    @Override
    public void onfuail(String msg) {
        iView.onfuail(msg);

    }
}
