package beanclass;

import android.graphics.Bitmap;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/7/22.
 */
public class MessageBeanClass implements Serializable{
    private String name;
    private String time;
    private String messageText;
    public MessageBeanClass(String name ,String messageText,String time) {
        this.name = name;
        this.messageText = messageText;
        this.time = time;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
