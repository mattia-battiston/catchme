package com.catchme.flow.presenter;

import android.content.Context;

import com.catchme.android.IntentFactory;
import com.catchme.flow.AppController;

public abstract class BasePresenter<T> implements Presenter<T> {

  protected AppController appController;

  protected IntentFactory intentFactory = new IntentFactory();

  @Override
  public void next(Context context) {
    appController.next(context);
  }

  @Override
  public void back(Context context) {
    appController.back(context);
  }

  @Override
  public void setAppController(AppController appController) {
    this.appController = appController;
  }

}
