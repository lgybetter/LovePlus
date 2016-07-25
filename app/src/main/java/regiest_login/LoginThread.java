package regiest_login;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import beanclass.UserBeanClass;

/**
 * 登陆请求服务器线程
 * Created by Administrator on 2016/7/21.
 */
public class LoginThread extends Thread {
    private String url;
    private UserBeanClass user;
    private Handler handler = null;
    private Context context;
    public LoginThread(String url,UserBeanClass user, Context context, Handler handler) {
        this.url = url;
        this.user = user;
        this.context = context;
        this.handler = handler;
    }

    @Override
    public void run() {
        url = url + "?phone=" + user.getPhone() + "&password=" + user.getPassword();
        try {
            URL httpUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) httpUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.setReadTimeout(5000);
            int code = connection.getResponseCode();
            Log.d("info", String.valueOf(code));
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String str;
            StringBuffer stringBuffer = new StringBuffer();
            while((str = reader.readLine()) != null) {
                stringBuffer.append(str);
            }
            Log.d("info",stringBuffer.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
