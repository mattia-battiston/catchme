package com.catchme.flow.step;

import android.content.Context;

import com.catchme.android.IntentFactory;
import com.catchme.flow.AppController;

public abstract class BaseStep implements Step {

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

  public void setAppController(AppController appController) {
    this.appController = appController;
  }

}
