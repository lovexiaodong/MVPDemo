package com.ums.newpos.mvpdemo.mvp.presenter;

import android.os.Handler;

import com.ums.newpos.mvpdemo.mvp.been.User;
import com.ums.newpos.mvpdemo.mvp.biz.IUserBiz;
import com.ums.newpos.mvpdemo.mvp.biz.OnLoginListener;
import com.ums.newpos.mvpdemo.mvp.biz.UserBiz;
import com.ums.newpos.mvpdemo.mvp.view.IUserLoginView;

/**
 * Created by 张玉栋 on 2017/12/13.
 */

public class UserLoginPresenter {
    private IUserBiz userBiz;
    private IUserLoginView userLoginView;
    private Handler mHandler = new Handler();

    public UserLoginPresenter(IUserLoginView userLoginView)
    {
        this.userLoginView = userLoginView;
        this.userBiz = new UserBiz();
    }

    public void login() {
        userLoginView.showLoading();
        userBiz.login(userLoginView.getUserName(), userLoginView.getPassword(), new OnLoginListener() {
            @Override
            public void loginSuccess(final User user) {
                //需要在UI线程执行
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.toMainActivity(user);
                        userLoginView.hideLoading();
                    }
                });

            }

            @Override
            public void loginFailed() {
                //需要在UI线程执行
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.showFailedError();
                        userLoginView.hideLoading();
                    }
                });

            }
        });

    }
    public void clear()
    {
        userLoginView.clearUserName();
        userLoginView.clearPassword();
    }
}
