package com.catchme.steps.exit;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.catchme.flow.AppController;
import com.catchme.flow.step.Step;

public class ExitStep implements Step {

  public void go(Context context) {
    Activity activity = (Activity) context;

    Intent i = new Intent();
    i.setAction(Intent.ACTION_MAIN);
    i.addCategory(Intent.CATEGORY_HOME);
    activity.startActivity(i);
    activity.finish();
  }

  @Override
  public void setAppController(AppController appController) {
  }

}
