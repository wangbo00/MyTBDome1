package wangbo.bawei.com.mytbdome;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hjm.bottomtabbar.BottomTabBar;

import wangbo.bawei.com.mytbdome.fragment.Classify;
import wangbo.bawei.com.mytbdome.fragment.HomePager;
import wangbo.bawei.com.mytbdome.fragment.MiNe;
import wangbo.bawei.com.mytbdome.fragment.ShopPing;

public class MainActivity extends AppCompatActivity {

    private BottomTabBar bottomTabBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化控件
        bottomTabBar = (BottomTabBar) findViewById(R.id.bottom_tab_bar);

        //底部导航
        bottomTabBar.init(getSupportFragmentManager())
                .setChangeColor(Color.RED,Color.DKGRAY)//点击切换颜色
                .addTabItem("首页",R.drawable.ic_nav_home, HomePager.class)
                .addTabItem("分类",R.drawable.ic_nav_class, Classify.class)
                .addTabItem("购物车",R.drawable.ic_nav_cart,ShopPing.class)
                .addTabItem("我的",R.drawable.ic_nav_user,MiNe.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {

                    @Override
                    public void onTabChange(int position, String name) {

                    }
                });

    }

}
