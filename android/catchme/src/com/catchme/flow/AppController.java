package com.catchme.flow;

import java.util.Stack;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.catchme.CatchmeMapPresenter;
import com.catchme.WelcomePresenter;

public class AppController {

  private Stack<Context> activities = new Stack<Context>();

  public void start(Context context) {
    // start the first step; eventually this will read the step the user has
    // arrived to from the db
    WelcomePresenter welcomePresenter = WelcomePresenter.getInstance();
    welcomePresenter.setAppController(this);

    welcomePresenter.go(context);
  }

  public void next(Context context) {
    activities.push(context);

    CatchmeMapPresenter.getInstance().go(context);
  }

  public void back(Activity activity) {
    Intent i = new Intent();
    i.setAction(Intent.ACTION_MAIN);
    i.addCategory(Intent.CATEGORY_HOME);
    activity.startActivity(i);
    activity.finish();
  }

}
