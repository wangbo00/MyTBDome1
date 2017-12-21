package wangbo.bawei.com.mytbdome.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.jwenfeng.library.pulltorefresh.BaseRefreshListener;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;
import com.youth.banner.Banner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import wangbo.bawei.com.mytbdome.R;
import wangbo.bawei.com.mytbdome.hompager.Seek;
import wangbo.bawei.com.mytbdome.hompager.adapter.JZAdapter;
import wangbo.bawei.com.mytbdome.hompager.adapter.JgAdapter;
import wangbo.bawei.com.mytbdome.hompager.bean.BannerBean;
import wangbo.bawei.com.mytbdome.hompager.bean.JZBean;
import wangbo.bawei.com.mytbdome.hompager.bean.JgBean;
import wangbo.bawei.com.mytbdome.hompager.lbglideApp.GlideApp;
import wangbo.bawei.com.mytbdome.hompager.presenter.JGPresenter;
import wangbo.bawei.com.mytbdome.hompager.presenter.LoadPresenter;
import wangbo.bawei.com.mytbdome.hompager.view.JGView;
import wangbo.bawei.com.mytbdome.hompager.view.LoadView;
import wangbo.bawei.com.mytbdome.utils.API;

/**
 * author:Created by Wangbo on 2017/12/15.
 */

public class HomePager extends Fragment implements JGView,LoadView{
    //二维码
    int REQUEST_CODE = 1;

    private View view;
    //搜索框
    private EditText et_seek;

    //轮播图
    private List<BannerBean.NewslistBean> list;
    //九宫格
    private RecyclerView jiu_rlv;
    private JgBean jg_data;
    private List<JgBean.DataBean> jiu_data;
    private JgAdapter jgadapter;
    //加载更多
    private JZBean load_data;
    private List<JZBean.DataBean> jz_data;

    private RecyclerView jz_rly;
    private PullToRefreshLayout ptr;
    private JZAdapter jzadapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.honmepage_main, null);

        ptr = view.findViewById(R.id.pullToRefresh);

        //九宫格
        JGData();
        //加载更多
        LoadData();
        initRefresh();

        //头部二维码扫描
        ImageView img_zXing = view.findViewById(R.id.img_zxing);
        ZXingLibrary.initDisplayOpinion(getActivity());
        //跳转
        img_zXing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CaptureActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
        //点击收缩商品框跳转到搜索页面
        et_seek = view.findViewById(R.id.et_seek);
        et_seek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Seek.class);
                startActivity(intent);
            }
        });

        //轮播图
        final Banner banner = view.findViewById(R.id.mybanner);
        OkHttpClient client=new OkHttpClient();
        Request quest=new Request.Builder()
                .url("http://api.tianapi.com/meinv/?key=2a0024d1f7f558e09936f697580f1643&num=10")
                .build();

        Call call=client.newCall(quest);
        call.enqueue(new Callback() {

            private ArrayList<String> bannerurl;

            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String s = response.body().string();
                Gson gson=new Gson();
                BannerBean bannerBean = gson.fromJson(s, BannerBean.class);
                HomePager.this.list = bannerBean.getNewslist();
                bannerurl = new ArrayList<>();
                for (int i = 0; i < HomePager.this.list.size() ; i++) {
                    bannerurl.add(HomePager.this.list.get(i).getPicUrl());
                }
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        banner.setImageLoader(new GlideApp()).setImages(bannerurl).start();
                    }
                });
            }
        });

        return view;
    }


    private void initRefresh() {
        ptr.setRefreshListener(new BaseRefreshListener() {
            @Override
            public void refresh() {
                if (jz_data!=null){
                    LoadData();
                }
                ptr.finishRefresh();
            }

            @Override
            public void loadMore() {
                if (jz_data!=null){
                    jz_data.addAll(jz_data.size(),jz_data);
                    jzadapter.notifyDataSetChanged();
                }
                ptr.finishLoadMore();

            }
        });
    }

    //加载更多数据
    private void LoadData() {
        jz_rly= view.findViewById(R.id.jz_recyclerview);
        LoadPresenter loadpresenter = new LoadPresenter(this);
        StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        jz_rly.setLayoutManager(staggeredGridLayoutManager);
        Map<String,String> map = new HashMap<>();
        loadpresenter.getUrl(API.NIKE,map);

    }


    //九宫格
    private void JGData() {
        jiu_rlv = view.findViewById(R.id.jg_recyclerview);
        JGPresenter jgPresenter = new JGPresenter(this);
        StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL);
        jiu_rlv.setLayoutManager(staggeredGridLayoutManager);
        Map<String,String> map=new HashMap<>();
        jgPresenter.getUrl(API.jiug,map);
    }


    //二维码扫描 重写onActivityResult判断结果
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            //处理扫描结果（在界面上显示）
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    Toast.makeText(getActivity(), "解析结果:" + result, Toast.LENGTH_LONG).show();
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(getActivity(), "解析二维码失败", Toast.LENGTH_LONG).show();
                }
            }
        }
    }


    //九宫格的成功失败的方法
    @Override
    public void jiusuccess(JgBean jgBean) {
        jiu_data = jgBean.getData();
        JgAdapter jiuAdapter=new JgAdapter(getActivity(), jiu_data);
        jiu_rlv.setAdapter(jiuAdapter);
        JGPresenter jiuPresenter=new JGPresenter(this);
    }

    @Override
    public void jiuonfalied(String msg) {

    }


    //加载更多成功失败的方法
    @Override
    public void jzsuccess(JZBean jzBean) {
        jz_data = jzBean.getData();
        jzadapter = new JZAdapter(getActivity(),jz_data);
        jz_rly.setAdapter(jzadapter);
        LoadPresenter loadpresenter = new LoadPresenter(this);

    }

    @Override
    public void jzfalied(String msf) {

    }
}
