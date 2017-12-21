package wangbo.bawei.com.mytbdome.hompager.model;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import wangbo.bawei.com.mytbdome.hompager.bean.JZBean;
import wangbo.bawei.com.mytbdome.utils.GsonObjectCallback;
import wangbo.bawei.com.mytbdome.utils.OkHttp3Utils;

/**
 * author:Created by Wangbo on 2017/12/16.
 */

public class LoadModel implements LoadMo{

    JZBean jzBean = new JZBean();

    private JzOnBanFinish jzOnBanFinish;

    public interface JzOnBanFinish{
        void jzsucess(JZBean jzBean);
        void jzfailed(String msg);
    }
    public void setJzOnBanFinish(JzOnBanFinish jzOnBanFinish){
        this.jzOnBanFinish=jzOnBanFinish;
    }


    @Override
    public void getUrl(String url, Map<String, String> map) {
        OkHttp3Utils.doPost(url, map, new GsonObjectCallback<JZBean>() {
            @Override
            public void onUi(JZBean jzBean) {
                String code = jzBean.getCode();
                String msg = jzBean.getMsg();
                if (code.equals("0")){
                    jzOnBanFinish.jzsucess(jzBean);
                }else{
                    jzOnBanFinish.jzfailed(msg);
                }

            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });

    }
}
