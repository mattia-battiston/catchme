package com.catchme.flow;

import android.content.Context;

import com.catchme.flow.presenter.Presenter;
import com.catchme.flow.step.StepRetriever;

public class AppController {

  private StepRetriever stepRetriever = new StepRetriever();

  private Presenter<?> step;

  public void start(Context context) {
    this.step = stepRetriever.getFirstStep();
    goToStep(context);
  }

  public void next(Context context) {
    this.step = stepRetriever.getStepAfter(step);
    goToStep(context);
  }

  public void back(Context context) {
    this.step = stepRetriever.getStepBefore(step);
    goToStep(context);
  }

  private void goToStep(Context context) {
    step.setAppController(this);
    step.go(context);
  }

  public void setStepRetriever(StepRetriever stepRetriever) {
    this.stepRetriever = stepRetriever;
  }

  public void setStep(Presenter<?> step) {
    this.step = step;
  }

}
