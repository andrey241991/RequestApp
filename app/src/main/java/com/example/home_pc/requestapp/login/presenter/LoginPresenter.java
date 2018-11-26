package com.example.home_pc.requestapp.login.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.home_pc.requestapp.login.view.LoginView;

@InjectViewState
public class LoginPresenter extends MvpPresenter<LoginView> {

    public void startMainScreen() {
        getViewState().startMainActivity();
    }

}
