package com.ums.newpos.mvpdemo.mvp.biz;

import com.ums.newpos.mvpdemo.mvp.been.User;

/**
 * Created by 张玉栋 on 2017/12/13.
 */

public interface OnLoginListener {

    void loginSuccess(User user);

    void loginFailed();
}
