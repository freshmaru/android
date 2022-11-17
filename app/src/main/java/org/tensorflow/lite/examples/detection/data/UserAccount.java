package org.tensorflow.lite.examples.detection.data;

/*
사용자 계정 정보 모델 클라스스 */

public class UserAccount {
    private String emailId;     //  id
    private String password;    //  비밀번호

    private String userName;    //  이름
    private String age;         //  나이
    private String idToken;     //  Firebase uid (고유 토큰정보)


    public UserAccount() {  }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    public String getIdToken() {
        return idToken;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public String getAge() {
        return age;
    }
}

