package com.antelope.android.mvptest.View;

public interface ILoginView {
    void onClearText();
    void onLoginResult(Boolean result,int code);
    void onSetProgressBarVisibility(int visibility);
}
