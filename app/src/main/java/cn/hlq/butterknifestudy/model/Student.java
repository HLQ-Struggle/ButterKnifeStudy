package cn.hlq.butterknifestudy.model;

/**
 * Created by HLQ on 2017/4/11 0011.
 */

public class Student {

    private String userName;
    private String userPwd;

    public Student() {
    }

    public Student(String userName, String userPwd) {
        this.userName = userName;
        this.userPwd = userPwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }
}
