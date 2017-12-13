package com.ums.newpos.mvpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ums.newpos.mvpdemo.mvp.been.User;
import com.ums.newpos.mvpdemo.mvp.presenter.UserLoginPresenter;
import com.ums.newpos.mvpdemo.mvp.view.IUserLoginView;

public class MainActivity extends AppCompatActivity implements IUserLoginView {

    private UserLoginPresenter mUserLoginPresenter = new UserLoginPresenter(this);

    private EditText mUserName, mPassword;
    private Button mLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUserName = findViewById(R.id.user_name);
        mPassword = findViewById(R.id.password);
        mLogin = findViewById(R.id.login);
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserLoginPresenter.login();
            }
        });
    }

    @Override
    public String getUserName() {
        return mUserName.getText().toString();
    }

    @Override
    public String getPassword() {
        return mPassword.getText().toString();
    }

    @Override
    public void clearUserName() {

        mUserName.setText("");

    }

    @Override
    public void clearPassword() {
        mUserName.setText("");
    }

    @Override
    public void showLoading() {

        Toast.makeText(MainActivity.this, "LogIn", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void toMainActivity(User user) {

        mUserName.setText(user.getUserName());
        mPassword.setText(user.getPassword());
    }

    @Override
    public void showFailedError() {
        Toast.makeText(MainActivity.this, "failed", Toast.LENGTH_SHORT).show();
    }
}
