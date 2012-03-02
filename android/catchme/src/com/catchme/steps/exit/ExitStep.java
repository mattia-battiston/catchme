package com.catchme.steps.exit;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.catchme.android.IntentFactory;
import com.catchme.flow.presenter.BasePresenter;

public class ExitStep extends BasePresenter<ExitStepView> {

  private IntentFactory intentFactory = new IntentFactory();

  public void go(Context context) {
    Activity activity = (Activity) context;

    Intent i = intentFactory.createIntent(Intent.ACTION_MAIN,
        Intent.CATEGORY_HOME);
    activity.startActivity(i);
    activity.finish();
  }

  public void setIntentFactory(IntentFactory intentFactory) {
    this.intentFactory = intentFactory;
  }

  @Override
  public void bind(ExitStepView view) {
  }

  @Override
  public String getName() {
    return "exit";
  }

}
