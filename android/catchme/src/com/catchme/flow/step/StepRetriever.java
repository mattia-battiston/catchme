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

  private static List<Step> steps = new ArrayList<Step>();

  private static Step exitStep = new ExitStep();

  static {
    steps.add(presenterRetriever.getPresenter(WelcomePresenter.class));
    steps.add(presenterRetriever.getPresenter(CatchmeMapPresenter.class));
  }

  public Step getFirstStep() {
    return steps.get(0);
  }

  public Step getStepAfter(Step step) {
    for (int i = 0; i < steps.size() - 1; i++) {
      Step candidate = steps.get(i);
      if (candidate.getName().equals(step.getName()))
        return steps.get(i + 1);
    }
    throw new RuntimeException("No more steps");
  }

  public Step getStepBefore(Step step) {
    for (int i = 1; i < steps.size(); i++) {
      Step candidate = steps.get(i);
      if (candidate.getName().equals(step.getName()))
        return steps.get(i - 1);
    }
    return exitStep;
  }

  public List<Step> getSteps() {
    return steps;
  }

  public static void setSteps(List<Step> steps) {
    StepRetriever.steps = steps;
  }
}
