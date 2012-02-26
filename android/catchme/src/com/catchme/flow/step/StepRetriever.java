package com.catchme.flow.step;

import java.util.ArrayList;
import java.util.List;

import com.catchme.flow.presenter.PresenterRetriever;
import com.catchme.steps.exit.ExitStep;
import com.catchme.steps.map.CatchmeMapPresenter;
import com.catchme.steps.text.WelcomePresenter;

public class StepRetriever {

  // TODO test
  // TODO store status in a database, to know where we are in the flow

  // TODO next should calculate the next step to go to
  // TODO back should calculate the next step to go to

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
    return new ExitStep();
  }

  public List<Step> getSteps() {
    return steps;
  }

  public static void setSteps(List<Step> steps) {
    StepRetriever.steps = steps;
  }
}
