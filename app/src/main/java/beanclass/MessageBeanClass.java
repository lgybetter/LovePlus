package beanclass;

import android.graphics.Bitmap;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/7/22.
 */
public class MessageBeanClass implements Serializable{
    private String name;
    private int type;
    private String time;
    private String messageText;
    public MessageBeanClass(String name ,String messageText,String time,int type) {
        this.name = name;
        this.messageText = messageText;
        this.time = time;
        this.type = type;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
