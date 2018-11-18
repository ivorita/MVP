package com.antelope.android.mvptest.presenter;

public interface ILoginPresenter {

    void clear();
    void doLogin(String name, String pwd);
    void setProgressBarVisibility(int visibility);
}
