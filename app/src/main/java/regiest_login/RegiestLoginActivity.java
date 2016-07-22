package regiest_login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.administrator.loveplus.R;

import beanclass.UserBeanClass;

/**
 * Created by Administrator on 2016/7/20.
 */
public class RegiestLoginActivity extends Activity implements View.OnClickListener{
    private EditText userPhone,userPassword;
    private Button regiest,login;
    private String url = " ";
    private UserBeanClass user = null;
    private Handler handler = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regiest_login_layout);
        initView();
        login.setOnClickListener(this);
        regiest.setOnClickListener(this);
    }

    private void initView() {
        userPhone = (EditText) findViewById(R.id.et_user_phone);
        userPassword = (EditText) findViewById(R.id.et_password);
        regiest = (Button) findViewById(R.id.bn_regiest);
        login = (Button) findViewById(R.id.bn_login);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            /**
             * 点击登录按钮，向服务器进行数据提交，根据服务器返回的数据进行判断
             * **/
            case R.id.bn_login:
                String phone = userPhone.getText().toString();
                String password = userPassword.getText().toString();
                if(phone.length() != 0 && password.length() != 0) {
                    user = new UserBeanClass(phone,null,password);
                    //开启向服务器请求数据的线程
                    //new LoginThread(url,user,this,handler).start();
                    /**
                     * 显示服务器返回的状态并通知UI线程更新
                     * **/
                    Log.d("info","Login success! " + user.getPhone() + " " + user.getPassword());
                } else {
                    Snackbar snackbar = Snackbar.make(view,"请输入正确信息！",Snackbar.LENGTH_SHORT)
                            .setAction("Action", null);
                    snackbar.show();
                    Log.d("info","Login error");
                }
                break;
            /**
             *点击注册按钮，跳转到注册界面
             */
            case R.id.bn_regiest:
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(),RegiestActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
