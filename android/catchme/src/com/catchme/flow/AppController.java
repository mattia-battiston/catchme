package com.catchme.flow;

import java.util.Stack;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.catchme.steps.map.CatchmeMapPresenter;
import com.catchme.steps.text.WelcomePresenter;

public class AppController {

  private Stack<Context> activities = new Stack<Context>();

  // TODO test
  // TODO store status in a database, to know where we are in the flow
  // TODO next should calculate the next step to go to
  // TODO back should calculate the next step to go to

  public void start(Context context) {
    // start the first step; eventually this will read the step the user has
    // arrived to from the db
    WelcomePresenter welcomePresenter = WelcomePresenter.getInstance();
    welcomePresenter.setAppController(this);

    welcomePresenter.go(context);
  }

  public void next(Context context) {
    activities.push(context);

    CatchmeMapPresenter catchmeMapPresenter = CatchmeMapPresenter.getInstance();
    catchmeMapPresenter.setAppController(this);
    catchmeMapPresenter.go(context);
  }

  public void back(Activity activity) {
    Intent i = new Intent();
    i.setAction(Intent.ACTION_MAIN);
    i.addCategory(Intent.CATEGORY_HOME);
    activity.startActivity(i);
    activity.finish();
  }

}
