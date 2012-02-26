package com.catchme.flow.step;

import android.content.Context;

import com.catchme.flow.AppController;

public interface Step {

  void setAppController(AppController appController);

  void go(Context context);

}
