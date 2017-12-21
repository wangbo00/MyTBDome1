package wangbo.bawei.com.mytbdome.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import wangbo.bawei.com.mytbdome.R;
import wangbo.bawei.com.mytbdome.shoping.model.bean.CartBean;
import wangbo.bawei.com.mytbdome.shoping.model.bean.CountPriceBean;
import wangbo.bawei.com.mytbdome.shoping.presenter.CartPresenter;
import wangbo.bawei.com.mytbdome.shoping.view.IView.IMainActivity;
import wangbo.bawei.com.mytbdome.shoping.view.adapter.MyAdapter;
import wangbo.bawei.com.mytbdome.shoping.view.custom.CartExpanableListview;

/**
 * author:Created by Wangbo on 2017/12/15.
 */
/**
 *1.点击全选:选中/未选中...调用适配器中的方法...myAdapter.setIsCheckAll(true);来设置所有的一级和二级是否选中,计算
 *
 * 2.一级列表的点击事件:
 *      2.1改变当前一级选中的状态...dataBean.setChoosed(! dataBean.isChoosed());
 *      2.2根据当前一级的状态,改变该组里面二级列表的状态....changeChilState(groupPosition,dataBean.isChoosed());
 *      2.3通过判断所有的一级组是否选中,来决定是否全选选中:...changeAllState(isAllGroupChecked());
 *      2.4发送价格个数量:...sendPriceAndCount();
 *      2.5刷新适配器
 * 3.二级列表点击事件:
 *      3.1点击改变当前子条目状态:...listBean.setChildChoosed(! listBean.isChildChoosed());//相反
 *      3.2发送价钱和数量给界面显示....sendPriceAndCount();
 *      3.3如果当前子条目是选中状态
 *          3.3.1选中
 *              判断一下当前组中所有的子条目是否全部选中:...isAllChildSelected(groupPosition)
 *              如果全部选中改变一下当前组的状态:...changGroupState(groupPosition,true);...确定是否改变全选changeAllState(isAllGroupChecked());
 *          3.3.2未选中
 *              changGroupState(groupPosition,false);改变当前组false...是否全选changeAllState(isAllGroupChecked());
 */



public class ShopPing extends Fragment implements IMainActivity, View.OnClickListener{
    private View view;
    private CartExpanableListview expanableListview;
    private String cartUrl = "https://www.zhaoapi.cn/product/getCarts?uid=3004";
    private CartPresenter cartPresenter;
    private Gson gson;
    private MyAdapter myAdapter;
    private CheckBox check_all;
    private TextView text_total;
    private TextView text_buy;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0){
                CountPriceBean countPriceBean = (CountPriceBean) msg.obj;

                //设置
                text_total.setText("合计:¥"+countPriceBean.getPrice());
                text_buy.setText("去结算("+countPriceBean.getCount()+")");
            }else  if (msg.what == 1){//改变全选
                boolean flag = (boolean) msg.obj;

                check_all.setChecked(flag);
            }
        }
    };
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.shoping_main,null);
        check_all = view.findViewById(R.id.check_all);
        text_total = view.findViewById(R.id.text_total);
        text_buy = view.findViewById(R.id.text_buy);
        expanableListview = view.findViewById(R.id.expanable_listview);
        //去掉默认的指示器
        expanableListview.setGroupIndicator(null);

        cartPresenter = new CartPresenter(this);
        gson = new Gson();

        //全选:...点击事件
        check_all.setOnClickListener(this);


        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        //请求数据
        cartPresenter.getCartData(cartUrl);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.check_all:
                myAdapter.setIfCheckAll(check_all.isChecked());

                break;
        }
    }



    @Override
    public void getSuccessCartData(String json) {
        //解析数据
        CartBean cartBean = gson.fromJson(json, CartBean.class);

        //一个是一级标题的数据
        List<CartBean.DataBean> listGroup = cartBean.getData();

        //所有子条目的数据
        List<List<CartBean.DataBean.ListBean>> listChilds = new ArrayList<>();
        for (int i=0;i<listGroup.size();i++){
            listChilds.add(listGroup.get(i).getList());
        }

        //设置适配器
        myAdapter = new MyAdapter(getActivity(), listGroup, listChilds,handler);
        expanableListview.setAdapter(myAdapter);

        //展开所有
        for (int i=0;i<listGroup.size();i++){
            expanableListview.expandGroup(i);
        }

    }
}
