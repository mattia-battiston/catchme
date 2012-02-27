package com.catchme.steps.exit;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.catchme.android.IntentFactory;
import com.catchme.flow.AppController;
import com.catchme.flow.step.BaseStep;

public class ExitStep extends BaseStep {

  private IntentFactory intentFactory = new IntentFactory();

  public void go(Context context) {
    Activity activity = (Activity) context;

    Intent i = intentFactory.createIntent(Intent.ACTION_MAIN,
        Intent.CATEGORY_HOME);
    activity.startActivity(i);
    activity.finish();
  }

  @Override
  public void setAppController(AppController appController) {
  }

  @Override
  public String getName() {
    return "exit";
  }

  public void setIntentFactory(IntentFactory intentFactory) {
    this.intentFactory = intentFactory;
  }

}
