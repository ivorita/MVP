package com.antelope.android.mvptest.presenter;

import android.os.Handler;
import android.os.Looper;

import com.antelope.android.mvptest.View.ILoginView;
import com.antelope.android.mvptest.model.IUser;
import com.antelope.android.mvptest.model.UserModel;


public class LoginPresenterCompl implements ILoginPresenter {

    private ILoginView mILoginView;
    private IUser mIUser;
    private Handler mHandler;

    public LoginPresenterCompl(ILoginView ILoginView) {
        mILoginView = ILoginView;
        initUser();
        mHandler = new Handler(Looper.getMainLooper());

    }

    private void initUser() {
        mIUser = new UserModel("mvp","mvp");
    }

    @Override
    public void clear() {
        mILoginView.onClearText();
    }

    @Override
    public void doLogin(String name, String pwd) {
        Boolean isLoginSuccess = true;
        final int code = mIUser.checkValidity(name,pwd);
        if (code != 0){
            isLoginSuccess = false;
        }
        final Boolean result = isLoginSuccess;
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mILoginView.onLoginResult(result,code);
            }
        },5000);
    }

    @Override
    public void setProgressBarVisibility(int visibility) {
        mILoginView.onSetProgressBarVisibility(visibility);
    }

}
