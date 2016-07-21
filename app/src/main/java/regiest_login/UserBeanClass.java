package regiest_login;

/**
 * Created by Administrator on 2016/7/21.
 */
public class UserBeanClass {
    private String phone;
    private String username;
    private String password;
    public UserBeanClass(String phone, String usernanme, String password) {
        this.phone = phone;
        this.username = usernanme;
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsernanme() {
        return username;
    }

    public void setUsernanme(String usernanme) {
        this.username = usernanme;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
