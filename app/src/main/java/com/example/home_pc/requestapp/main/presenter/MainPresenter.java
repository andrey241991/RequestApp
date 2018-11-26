package com.example.home_pc.requestapp.main.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.home_pc.requestapp.api.Api;
import com.example.home_pc.requestapp.main.view.MainView;
import com.example.home_pc.requestapp.rx.AppRxSchedulers;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    private AppRxSchedulers rxSchedulers;
    private Api api;

    public MainPresenter(AppRxSchedulers rxSchedulers, Api api) {
        this.rxSchedulers = rxSchedulers;
        this.api = api;
    }

    public void btnGetUsersClick(String token) {
        api.getAllUsers(token)
                .compose(rxSchedulers.ioToMain())
                .subscribe(
                        result -> {
                            if (result != null) {
                                String msg = result.meta.getMessage();
                                getViewState().showMessage(msg);
                            } else {
                                showError("showNetworkRequestError");
                            }
                        },
                        throwable -> showError(throwable.getMessage()));
    }

    public void btnGetUserByIdClick(String userId, String token) {
        api.getUserById(token, userId)
                .compose(rxSchedulers.ioToMain())
                .subscribe(
                        result -> {
                            if (result != null) {
                                String msg = result.meta.getMessage();
                                getViewState().showMessage(msg);
                            } else {
                                showError("showNetworkRequestError");
                            }
                        },
                        throwable -> showError(throwable.getMessage()));
    }

    public void btnDeleteUserByIdClick(String userId, String token) {
        api.deleteUser(token, userId)
                .compose(rxSchedulers.ioToMain())
                .subscribe(
                        result -> {
                            if (result != null) {
                                String msg = result.meta.getMessage();
                                getViewState().showMessage(msg);
                            } else {
                                showError("showNetworkRequestError");
                            }
                        },
                        throwable -> showError(throwable.getMessage()));
    }

    public void btnCreateNewUserClick(String firstName, String lastName, String email, String gender, String token) {
        api.createUser(token, firstName, lastName, email, gender)
                .compose(rxSchedulers.ioToMain())
                .subscribe(
                        result -> {
                            if (result != null) {
                                String msg = result.meta.getMessage();
                                getViewState().showMessage(msg);
                            } else {
                                showError("showNetworkRequestError");
                            }
                        },
                        throwable -> showError(throwable.getMessage()));
    }

    public void btnUpdateUserByIdClick(String userId, String firstName, String lastName, String token) {
        api.updateUser(token, firstName, lastName, userId)
                .compose(rxSchedulers.ioToMain())
                .subscribe(
                        result -> {
                            if (result != null) {
                                String msg = result.meta.getMessage();
                                getViewState().showMessage(msg);
                            } else {
                                showError("showNetworkRequestError");
                            }
                        },
                        throwable -> showError(throwable.getMessage()));
    }

    private void showError(String errorMsg) {
        String errorMessage = "error message: ";
        if (errorMsg.contains("404")) {
            getViewState().showMessage(errorMessage + "The requested resource does not exist");
        }
        if (errorMsg.contains("400")) {
            getViewState().showMessage(errorMessage + "Bad request. This could be caused by various actions by the user," +
                    " such as providing invalid JSON data in the request body, providing invalid action parameters, etc.");
        }
        if (errorMsg.contains("401")) {
            getViewState().showMessage(errorMessage + "Authentication failed");
        }

    }

}

