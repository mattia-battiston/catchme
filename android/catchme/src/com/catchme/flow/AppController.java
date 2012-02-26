package com.catchme.flow;

import android.app.Activity;
import android.content.Context;

import com.catchme.flow.step.Step;
import com.catchme.flow.step.StepRetriever;

public class AppController {

  private StepRetriever stepRetriever = new StepRetriever();

  private Step step;

  public void start(Context context) {
    this.step = stepRetriever.getFirstStep();
    goToStep(context);
  }

  public void next(Context context) {
    this.step = stepRetriever.getStepAfter(step);
    goToStep(context);
  }

  public void back(Activity activity) {
    this.step = stepRetriever.getStepBefore(step);
    goToStep(activity);
  }

  private void goToStep(Context context) {
    step.setAppController(this);
    step.go(context);
  }

  public void setStepRetriever(StepRetriever stepRetriever) {
    this.stepRetriever = stepRetriever;
  }

  public void setStep(Step step) {
    this.step = step;
  }

}
