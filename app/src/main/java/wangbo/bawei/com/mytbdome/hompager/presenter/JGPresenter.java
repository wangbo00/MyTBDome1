package wangbo.bawei.com.mytbdome.hompager.presenter;

import java.util.Map;

import wangbo.bawei.com.mytbdome.hompager.bean.JgBean;
import wangbo.bawei.com.mytbdome.hompager.model.JiuGModel;
import wangbo.bawei.com.mytbdome.hompager.view.JGView;

/**
 * author:Created by Wangbo on 2017/12/15.
 */

public class JGPresenter implements JiuGModel.OnBanFinish{
    JGView jgview;
    JiuGModel jiuGModel;

    public JGPresenter(JGView jgview) {
        this.jgview = jgview;
        this.jiuGModel=new JiuGModel();
        jiuGModel.setOnBanFinish(this);
    }

    public  void  getUrl(String url, Map<String,String> map){
        jiuGModel.getUrl(url,map);
    }

    @Override
    public void success(JgBean jgBean) {
        jgview.jiusuccess(jgBean);
    }

    @Override
    public void failed(String msg) {
        jgview.jiuonfalied(msg);
    }
}
