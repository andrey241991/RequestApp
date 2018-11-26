package com.example.home_pc.requestapp.router;

import android.content.Context;
import android.content.Intent;

import com.example.home_pc.requestapp.main.view.MainActivity;

import static com.example.home_pc.requestapp.login.view.LoginActivity.TOKEN_KEY;

public class Router {

    public static void startMainActivity(Context context, String token){
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(TOKEN_KEY, token);
        context.startActivity(intent);
    }

}
