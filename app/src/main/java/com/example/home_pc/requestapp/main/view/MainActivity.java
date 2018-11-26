package com.example.home_pc.requestapp.main.view;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.home_pc.requestapp.R;
import com.example.home_pc.requestapp.api.Api;
import com.example.home_pc.requestapp.api.ApiClient;
import com.example.home_pc.requestapp.main.presenter.MainPresenter;
import com.example.home_pc.requestapp.rx.AppRxSchedulers;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.home_pc.requestapp.login.view.LoginActivity.TOKEN_KEY;

public class MainActivity extends MvpAppCompatActivity implements MainView {

    @BindView(R.id.btn_get_users) Button btnGetUsers;
    @BindView(R.id.btn_get_user_by_id) Button btnGetUserById;
    @BindView(R.id.btn_delete_user_by_id) Button btnDeleteUserById;
    @BindView(R.id.btn_create_new_user) Button btnCreateNewUser;
    @BindView(R.id.btn_update_user) Button btnUpdateUser;
    @BindView(R.id.ed_get_user_by_id) EditText edGetUserById;
    @BindView(R.id.ed_delete_user_by_id) EditText edDeleteUserById;
    @BindView(R.id.ed_first_name) EditText edFirstName;
    @BindView(R.id.ed_last_name) EditText edLastName;
    @BindView(R.id.ed_email) EditText edEmail;
    @BindView(R.id.ed_gender) EditText edGender;
    @BindView(R.id.ed_id_for_update) EditText edIdForUpdate;
    @BindView(R.id.ed_update_first_name) EditText edUpdateFirstName;
    @BindView(R.id.ed_update_last_name) EditText edUpdateLastName;

    private String token;

    @InjectPresenter
    MainPresenter presenter;

    @ProvidePresenter
    MainPresenter mainPresenter() {
        AppRxSchedulers rxSchedulers = new AppRxSchedulers();
        Api api = ApiClient.getClient();
        return new MainPresenter(rxSchedulers, api);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        token = getIntent().getStringExtra(TOKEN_KEY);

        btnGetUsers.setOnClickListener( v -> presenter.btnGetUsersClick(token));
        btnGetUserById.setOnClickListener( v -> presenter.btnGetUserByIdClick(edGetUserById.getText().toString(), token));
        btnDeleteUserById.setOnClickListener( v -> presenter.btnDeleteUserByIdClick(edDeleteUserById.getText().toString(), token));

        btnCreateNewUser.setOnClickListener(v -> {
            String firstName = edFirstName.getText().toString();
            String lastName = edLastName.getText().toString();
            String email = edEmail.getText().toString();
            String gender = edGender.getText().toString();
            presenter.btnCreateNewUserClick(firstName, lastName, email, gender, token);
        });

        btnUpdateUser.setOnClickListener(v -> {
            String id = edIdForUpdate.getText().toString();
            String firstName = edUpdateFirstName.getText().toString();
            String lastName = edUpdateLastName.getText().toString();
            presenter.btnUpdateUserByIdClick(id, firstName, lastName, token);
        });

    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
    }
}

