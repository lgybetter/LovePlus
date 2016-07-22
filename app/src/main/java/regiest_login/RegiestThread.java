package regiest_login;

import android.content.Context;
import android.os.Handler;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import beanclass.UserBeanClass;

/**
 * Created by Administrator on 2016/7/21.
 */
public class RegiestThread extends Thread {
    private String url;
    private UserBeanClass user;
    private Context context;
    private Handler handler = null;
    public RegiestThread(String url,UserBeanClass user, Context context, Handler handler) {
        url = this.url;
        user = this.user;
        context = this.context;
        handler = this.handler;
    }

    @Override
    public void run() {
        try {
            URL httpUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) httpUrl.openConnection();
            connection.setRequestMethod("POST");
            connection.setReadTimeout(5000);
            OutputStream out = connection.getOutputStream();
            String content = "phone" + user.getPhone() + "&username" + user.getUsernanme() + "&password" + user.getPassword();
            out.write(content.getBytes());
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer stringBuffer = new StringBuffer();
            String str;
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
