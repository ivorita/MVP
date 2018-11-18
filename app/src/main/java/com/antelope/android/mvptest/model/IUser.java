package com.antelope.android.mvptest.model;

public interface IUser {

    String getName();
    String getPwd();

    int checkValidity(String name, String pwd);
}
