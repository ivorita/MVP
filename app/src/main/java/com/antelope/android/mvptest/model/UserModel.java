package com.antelope.android.mvptest.model;

public class UserModel implements IUser {

    String name;
    String pwd;

    public UserModel(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPwd() {
        return pwd;
    }

    @Override
    public int checkValidity(String name, String pwd) {
        if (name == null || pwd == null || !name.equals(getName()) || !pwd.equals(getPwd())){
            return -1;
        }
        return 0;
    }


}
