package regiest_login;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.administrator.loveplus.R;

import beanclass.UserBeanClass;

/**
 * Created by Administrator on 2016/7/21.
 */
public class RegiestActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText userPhone,userName,userPassword;
    private Button regiestClick;
    private UserBeanClass user = null;
    private Handler handler;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regiest_layout);
        initView();
        regiestClick.setOnClickListener(this);
    }

    private void initView() {
        userName = (EditText) findViewById(R.id.et_user_nickname);
        userPhone = (EditText) findViewById(R.id.et_user_phone);
        userPassword = (EditText) findViewById(R.id.et_password);
        regiestClick = (Button) findViewById(R.id.bn_click_regiest);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            /**
             * 点击注册按钮，向服务器进行数据请求
             */
            case R.id.bn_click_regiest:
                String url = "http://kilerd-loveplus.daoapp.io/user";
                String phone = userPhone.getText().toString();
                String password = userPassword.getText().toString();
                String name = userName.getText().toString();
                if(phone.length() != 0 && name.length() != 0 && password.length() != 0) {
                    user = new UserBeanClass(phone,name,password);
                    /**
                     * 开启服务器请求线程
                     */
                    new RegiestThread(url,user,this,handler).start();

                } else {
                    Snackbar snackbar = Snackbar.make(view,"请输入正确信息！",Snackbar.LENGTH_SHORT).setAction("Action", null);
                    snackbar.show();
                }
                break;
            default:

                break;

        }
    }
}
