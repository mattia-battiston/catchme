package com.catchme.flow;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.catchme.flow.step.Step;
import com.catchme.flow.step.StepRetriever;

public class AppController {

  private StepRetriever stepRetriever = new StepRetriever();

  private Step step;

  // TODO test
  // TODO store status in a database, to know where we are in the flow
  // TODO next should calculate the next step to go to
  // TODO back should calculate the next step to go to

  public void start(Context context) {
    this.step = stepRetriever.getFirstStep();
    goToStep(context);
  }

  public void next(Context context) {
    this.step = stepRetriever.getStepAfter(step);
    goToStep(context);
  }

  public void back(Activity activity) {
    Intent i = new Intent();
    i.setAction(Intent.ACTION_MAIN);
    i.addCategory(Intent.CATEGORY_HOME);
    activity.startActivity(i);
    activity.finish();
  }

  private void goToStep(Context context) {
    step.setAppController(this);
    step.go(context);
  }

  public void setStepRetriever(StepRetriever stepRetriever) {
    this.stepRetriever = stepRetriever;
  }

}
