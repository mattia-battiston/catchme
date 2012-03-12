package com.catchme.flow.step;

import java.util.ArrayList;
import java.util.List;

import com.catchme.flow.presenter.Presenter;
import com.catchme.steps.exit.ExitStep;
import com.catchme.steps.map.SimplePointPresenter;
import com.catchme.steps.text.FirstPointReached;
import com.catchme.steps.text.WelcomePresenter;

public class StepRetriever {

  // TODO store status in a database, to know where we are in the flow

  private static List<Presenter<?>> steps = new ArrayList<Presenter<?>>();

  private static Presenter<?> exitStep = new ExitStep();

  static {
    steps.add(new WelcomePresenter());
    steps.add(new SimplePointPresenter("sacher", 45449805, 11023514));
    steps.add(new FirstPointReached());
    steps.add(new SimplePointPresenter("pizzeria70", 45449060, 11020489));
  }

  public Presenter<?> getFirstStep() {
    return steps.get(0);
  }

  public Presenter<?> getStepAfter(Presenter<?> step) {
    for (int i = 0; i < steps.size() - 1; i++) {
      Presenter<?> candidate = steps.get(i);
      if (candidate.getStepName().equals(step.getStepName()))
        return steps.get(i + 1);
    }
    throw new RuntimeException("No more steps");
  }

  public Presenter<?> getStepBefore(Presenter<?> step) {
    for (int i = 1; i < steps.size(); i++) {
      Presenter<?> candidate = steps.get(i);
      if (candidate.getStepName().equals(step.getStepName()))
        return steps.get(i - 1);
    }
    return exitStep;
  }

  public List<Presenter<?>> getSteps() {
    return steps;
  }

  public static void setSteps(List<Presenter<?>> steps) {
    StepRetriever.steps = steps;
  }
}
