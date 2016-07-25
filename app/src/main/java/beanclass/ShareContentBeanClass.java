package beanclass;

/**
 * Created by Administrator on 2016/7/25.
 */
public class ShareContentBeanClass {
    private String fromPerson;
    private String messageText;
    //此处应该定义一个视频的文件
    public ShareContentBeanClass(String fromPerson,String messageText) {
        this.fromPerson = fromPerson;
        this.messageText = messageText;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getFromPerson() {
        return fromPerson;
    }

    public void setFromPerson(String fromPerson) {
        this.fromPerson = fromPerson;
    }
}
