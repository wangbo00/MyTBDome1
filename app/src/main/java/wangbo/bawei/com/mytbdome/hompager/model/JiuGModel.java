package wangbo.bawei.com.mytbdome.hompager.model;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import wangbo.bawei.com.mytbdome.hompager.bean.JgBean;
import wangbo.bawei.com.mytbdome.utils.GsonObjectCallback;
import wangbo.bawei.com.mytbdome.utils.OkHttp3Utils;

/**
 * author:Created by Wangbo on 2017/12/15.
 */

public class JiuGModel implements JGModel {
    JgBean jgBean=new JgBean();

    private  OnBanFinish onBanFinish;

    public  interface OnBanFinish{
        void  success(JgBean jgBean);
        void  failed(String msg);
    }

    public  void setOnBanFinish(OnBanFinish onBanFinish) {
        this.onBanFinish = onBanFinish;
    }

    @Override
    public void getUrl(String url, Map<String, String> map) {
        OkHttp3Utils.doPost(url, map, new GsonObjectCallback<JgBean>() {
            @Override
            public void onUi(JgBean jgBean) {
                String code = jgBean.getCode();
                String msg = jgBean.getMsg();
                if (code.equals("0")){
                    onBanFinish.success(jgBean);
                }else {
                    onBanFinish.failed(msg);
                }
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });
    }
}
