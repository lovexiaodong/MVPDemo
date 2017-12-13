package com.ums.newpos.mvpdemo.mvp.biz;

/**
 * Created by 张玉栋 on 2017/12/13.
 */

public interface IUserBiz {

    public void login(String username, String password, OnLoginListener loginListener);
}
