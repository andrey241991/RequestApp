package com.example.home_pc.requestapp.login.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.home_pc.requestapp.R;
import com.example.home_pc.requestapp.login.presenter.LoginPresenter;
import com.example.home_pc.requestapp.router.Router;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

public class LoginActivity extends MvpAppCompatActivity implements LoginView {

    public static final String TOKEN_KEY = "TOKEN_KEY";
    private CallbackManager callbackManager;
    private String token;

    @InjectPresenter
    LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        boolean isLoggedIn = accessToken != null && !accessToken.isExpired();
        if(isLoggedIn){
            token = accessToken.getToken();
            presenter.startMainScreen();
        }

        callbackManager = CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        token = loginResult.getAccessToken().getToken();
                        presenter.startMainScreen();
                    }

                    @Override
                    public void onCancel() {
                        Toast.makeText(LoginActivity.this, "ON CANCEL", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        Toast.makeText(LoginActivity.this, "FacebookException = " + exception.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void startMainActivity() {
        Router.startMainActivity(this, token);
    }
}



