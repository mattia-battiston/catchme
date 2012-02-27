package com.catchme.flow.step;

import java.util.ArrayList;
import java.util.List;

import com.catchme.flow.presenter.PresenterRetriever;
import com.catchme.steps.exit.ExitStep;
import com.catchme.steps.map.CatchmeMapPresenter;
import com.catchme.steps.text.WelcomePresenter;

public class StepRetriever {

  // TODO store status in a database, to know where we are in the flow

  private static PresenterRetriever presenterRetriever = new PresenterRetriever();

  private static List<BaseStep> steps = new ArrayList<BaseStep>();

  private static BaseStep exitStep = new ExitStep();

  static {
    steps.add(presenterRetriever.getPresenter(WelcomePresenter.class));
    steps.add(presenterRetriever.getPresenter(CatchmeMapPresenter.class));
  }

  public BaseStep getFirstStep() {
    return steps.get(0);
  }

  public BaseStep getStepAfter(BaseStep step) {
    for (int i = 0; i < steps.size() - 1; i++) {
      BaseStep candidate = steps.get(i);
      if (candidate.getName().equals(step.getName()))
        return steps.get(i + 1);
    }
    throw new RuntimeException("No more steps");
  }

  public BaseStep getStepBefore(BaseStep step) {
    for (int i = 1; i < steps.size(); i++) {
      BaseStep candidate = steps.get(i);
      if (candidate.getName().equals(step.getName()))
        return steps.get(i - 1);
    }
    return exitStep;
  }

  public List<BaseStep> getSteps() {
    return steps;
  }

  public static void setSteps(List<BaseStep> steps) {
    StepRetriever.steps = steps;
  }
}
