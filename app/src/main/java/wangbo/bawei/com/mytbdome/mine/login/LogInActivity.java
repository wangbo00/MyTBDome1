package wangbo.bawei.com.mytbdome.mine.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import wangbo.bawei.com.mytbdome.MainActivity;
import wangbo.bawei.com.mytbdome.R;
import wangbo.bawei.com.mytbdome.mine.zhuce.ZhuCeActivity;
import wangbo.bawei.com.mytbdome.mine.login.bean.LoginBean;
import wangbo.bawei.com.mytbdome.mine.login.presenter.LogInPresenter;
import wangbo.bawei.com.mytbdome.mine.login.view.LoginView;
import wangbo.bawei.com.mytbdome.utils.API;


/**
 * author:Created by Wangbo on 2017/12/12.
 */

public class LogInActivity extends AppCompatActivity implements View.OnClickListener,LoginView{
    private EditText phone;
    private EditText psw;
    private Button login;
    private Button zhuce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        phone = (EditText) findViewById(R.id.phone);
        psw = (EditText) findViewById(R.id.psw);
        login = (Button) findViewById(R.id.login);
        zhuce = (Button) findViewById(R.id.zhuce);

        login.setOnClickListener(this);
        zhuce.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login:
                String name = phone.getText().toString();
                String pwd = psw.getText().toString();
                DengLu(name,pwd);
                break;
            case R.id.zhuce:
                Intent intent = new Intent(LogInActivity.this,ZhuCeActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }

    private void DengLu(String name, String pwd) {
        LogInPresenter loginPresenter=new LogInPresenter(this);
        Map<String,String> map=new HashMap<>();
        map.put("mobile",name);
        map.put("password",pwd);
        loginPresenter.getUrl(API.login,map);

    }

    @Override
    public void getData(LoginBean loginBean) {
        String msg = login.toString();
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    @Override
    public void onfuail(String msf) {
        Toast.makeText(this,msf,Toast.LENGTH_SHORT).show();

    }
}
