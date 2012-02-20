package com.catchme.flow;

import android.content.Context;

import com.catchme.CatchmeMapPresenter;
import com.catchme.WelcomePresenter;

public class AppController {

  public void start(Context context) {
    // start the first step; eventually this will read the step the user has
    // arrived to from the db
    WelcomePresenter welcomePresenter = WelcomePresenter.getInstance();
    welcomePresenter.setAppController(this);

    welcomePresenter.go(context);
  }

  public void next(Context context) {
    CatchmeMapPresenter.getInstance().go(context);
  }

}
