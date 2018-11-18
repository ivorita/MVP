package com.antelope.android.mvptest.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.antelope.android.mvptest.R;
import com.antelope.android.mvptest.presenter.ILoginPresenter;
import com.antelope.android.mvptest.presenter.LoginPresenterCompl;

public class LoginActivity extends AppCompatActivity implements ILoginView,View.OnClickListener{

    private EditText et_user;
    private EditText et_pwd;
    private Button btn_login;
    private Button btn_clear;
    ILoginPresenter mILoginPresenter;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_user = findViewById(R.id.user_name);
        et_pwd = findViewById(R.id.password);
        btn_login = findViewById(R.id.login);
        btn_clear = findViewById(R.id.clear);
        mProgressBar = findViewById(R.id.progressBar);
        btn_clear.setOnClickListener(this);
        btn_login.setOnClickListener(this);

        mILoginPresenter = new LoginPresenterCompl(this);
        mILoginPresenter.setProgressBarVisibility(View.INVISIBLE);
    }

    @Override
    public void onClearText() {
        et_pwd.setText("");
        et_user.setText("");
    }

    @Override
    public void onLoginResult(Boolean result, int code) {
        mILoginPresenter.setProgressBarVisibility(View.VISIBLE);
        btn_login.setEnabled(true);
        btn_clear.setEnabled(true);
        if (result){
            Toast.makeText(this,"login success",Toast.LENGTH_SHORT).show();
            mILoginPresenter.setProgressBarVisibility(View.INVISIBLE);
        } else {
            Toast.makeText(this,"login fail",Toast.LENGTH_SHORT).show();
            mILoginPresenter.setProgressBarVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onSetProgressBarVisibility(int visibility) {
        mProgressBar.setVisibility(visibility);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login:
                mILoginPresenter.setProgressBarVisibility(View.VISIBLE);
                btn_login.setEnabled(false);
                btn_clear.setEnabled(false);
                mILoginPresenter.doLogin(et_user.getText().toString(),et_pwd.getText().toString());
                break;
            case R.id.clear:
                mILoginPresenter.clear();
                break;
        }
    }
}
