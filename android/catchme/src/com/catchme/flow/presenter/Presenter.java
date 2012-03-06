package com.catchme.flow.presenter;

import android.content.Context;

import com.catchme.flow.AppController;

public interface Presenter<T> {

  void go(Context context);

  void bind(T view);

  void next(Context context);

  void back(Context context);

  public abstract String getStepName();

  void setAppController(AppController appController);

}
