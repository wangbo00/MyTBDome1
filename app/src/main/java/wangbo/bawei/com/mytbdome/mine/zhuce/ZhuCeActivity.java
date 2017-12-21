package wangbo.bawei.com.mytbdome.mine.zhuce;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import wangbo.bawei.com.mytbdome.R;
import wangbo.bawei.com.mytbdome.mine.login.LogInActivity;
import wangbo.bawei.com.mytbdome.mine.zhuce.bean.ZhuCeBean;
import wangbo.bawei.com.mytbdome.mine.zhuce.presenter.ZhucePresenter;
import wangbo.bawei.com.mytbdome.mine.zhuce.view.ZhuceView;
import wangbo.bawei.com.mytbdome.utils.API;


/**
 * author:Created by Wangbo on 2017/12/11.
 */

public class ZhuCeActivity extends AppCompatActivity implements View.OnClickListener,ZhuceView{

    private EditText zc_phone;
    private EditText zc_psw;
    private Button zc_zhuce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuce);
        zc_phone = (EditText) findViewById(R.id.zc_phone);
        zc_psw = (EditText) findViewById(R.id.zc_psw);
        zc_zhuce = (Button) findViewById(R.id.zc_zhuce);
        zc_zhuce.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.zc_zhuce:
                String name = zc_phone.getText().toString();
                String pwd = zc_psw.getText().toString();
                ZhuCe(name, pwd);
                break;

        }

    }

    private void ZhuCe(String name, String pwd) {
        ZhucePresenter zhucePresenter= new ZhucePresenter(this);
        Map<String,String> map= new HashMap<>();
        map.put("mobile",name);
        map.put("password",pwd);
        zhucePresenter.getUrl(API.Zhuce,map);
    }

    @Override
    public void getData(ZhuCeBean zhuCeBean) {
        String msg = zhuCeBean.getMsg();
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, LogInActivity.class);
        startActivity(intent);
        
    }

    @Override
    public void onfuail(String msf) {
        Toast.makeText(this,msf,Toast.LENGTH_SHORT).show();

    }
}


