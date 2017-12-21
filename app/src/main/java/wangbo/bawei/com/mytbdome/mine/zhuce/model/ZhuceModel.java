package wangbo.bawei.com.mytbdome.mine.zhuce.model;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import wangbo.bawei.com.mytbdome.mine.zhuce.bean.ZhuCeBean;
import wangbo.bawei.com.mytbdome.utils.GsonObjectCallback;
import wangbo.bawei.com.mytbdome.utils.OkHttp3Utils;

/**
 * author:Created by Wangbo on 2017/12/15.
 */

public class ZhuceModel {
    ZhuCeBean zhuCeBean = new ZhuCeBean();
    private ZhuceFinish zhuceFinish;

    public interface ZhuceFinish{
        void onZhuceFinishLisenter(ZhuCeBean zhuCeBean);
        void onfuail(String msg);
    }
    public void setZhuceFinish(ZhuceFinish zhuceFinish){
        this.zhuceFinish=zhuceFinish;
    }
    public void getUrl(String url, Map<String,String> map){
        OkHttp3Utils.doPost(url, map, new GsonObjectCallback<ZhuCeBean>() {
            @Override
            public void onUi(ZhuCeBean zhuCeBean) {
                String code = zhuCeBean.getCode();
                String msg = zhuCeBean.getMsg();
                if (code.equals("0")){
                    zhuceFinish.onZhuceFinishLisenter(zhuCeBean);
                }else {
                    zhuceFinish.onfuail(msg);
                }
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });
    }

}
