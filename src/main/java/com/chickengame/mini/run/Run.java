package com.chickengame.mini.run;

import com.chickengame.mini.controller.ConnectAndClose;
import com.chickengame.mini.view.LoginMenu;

public class Run {
    public static void main(String[] args) {
        LoginMenu lm = new LoginMenu(); // 로그인메뉴 객체생성
        lm.run(); // 로그인메뉴 시작
        if (ConnectAndClose.getInstance().getConnection() != null) {
            ConnectAndClose.getInstance().close(ConnectAndClose.getInstance().getConnection());
        }
    }
}
