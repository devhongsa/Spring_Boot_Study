package com.example.hello.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostRequest {
    private String account;
    private String email;
    private String address;
    private String password;

    //phone_number와 같이 snake json 표기법이 아닌 phoneNumber, OTP 이런 표기법은 JsonProperty를 써줘야함.
    @JsonProperty("OTP")
    private String OTP;

    public String getOTP() {
        return OTP;
    }

    public void setOTP(String OTP) {
        this.OTP = OTP;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "PostRequest{" +
                "account='" + account + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                ", OTP='" + OTP + '\'' +
                '}';
    }
}
