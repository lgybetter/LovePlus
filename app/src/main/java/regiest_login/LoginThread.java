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
import java.net.URLEncoder;

/**
 * Created by Administrator on 2016/7/21.
 */
public class LoginThread extends Thread {
    private String url;
    private UserBeanClass user;
    private Handler handler = null;
    private Context context;
    public LoginThread(String url,UserBeanClass user, Context context, Handler handler) {
        url = this.url;
        user = this.user;
        context = this.context;
        handler = this.handler;
    }

    @Override
    public void run() {
        url = url + "?phone=" + user.getPhone() + "&password=" + user.getPassword();
        try {
            URL httpUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) httpUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.setReadTimeout(5000);
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
