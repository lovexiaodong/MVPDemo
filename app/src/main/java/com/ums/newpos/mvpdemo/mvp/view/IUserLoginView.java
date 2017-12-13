package com.ums.newpos.mvpdemo.mvp.view;

import com.ums.newpos.mvpdemo.mvp.been.User;

/**
 * Created by 张玉栋 on 2017/12/13.
 */

public interface IUserLoginView {

    String getUserName();

    String getPassword();

    void clearUserName();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void toMainActivity(User user);

    void showFailedError();
}
