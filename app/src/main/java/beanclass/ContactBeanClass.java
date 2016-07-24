package beanclass;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/7/23.
 */
public class ContactBeanClass implements Serializable{
    private String userName;
    private String phone;
    private Boolean isFamily;
    private String  alias;
    private String description;
    public ContactBeanClass(String userName,String phone,String alias,String description,Boolean isFamly) {
        this.alias = alias;
        this.description = description;
        this.phone = phone;
        this.isFamily = isFamly;
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getFamly() {
        return isFamily;
    }

    public void setFamly(Boolean famly) {
        isFamily = famly;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
