package com.catchme.flow.step;

import java.util.ArrayList;
import java.util.List;

import com.catchme.flow.presenter.Presenter;
import com.catchme.steps.exit.ExitStep;
import com.catchme.steps.map.SimplePointPresenter;
import com.catchme.steps.text.SimpleTextPresenter;

public class StepRetriever {

  // TODO store status in a database, to know where we are in the flow

  private static List<Presenter<?>> steps = new ArrayList<Presenter<?>>();

  private static Presenter<?> exitStep = new ExitStep();

  static {
    steps.add(new SimpleTextPresenter("welcome"));
    steps.add(new SimpleTextPresenter("instructions"));
    steps.add(new SimpleTextPresenter("getReady"));
    steps.add(new SimpleTextPresenter("firstText"));
    steps.add(new SimplePointPresenter("sacher", 45449805, 11023514));
    steps.add(new SimpleTextPresenter("firstPointReached"));
    steps.add(new SimplePointPresenter("pizzeria70", 45449060, 11020489));
    steps.add(new SimplePointPresenter("viaBadile", 45441427, 11022977));
    steps.add(new SimplePointPresenter("ferraris", 45433293, 10996181));
    steps.add(new SimplePointPresenter("firstPizza", 45439135, 10992768));
    steps.add(new SimplePointPresenter("oldHouse", 45439290, 10985363));
    steps.add(new SimplePointPresenter("pozzoAmore", 45442993, 10996096));
    steps.add(new SimplePointPresenter("viaStella", 45441716, 10998894));
    steps.add(new SimplePointPresenter("pontePietra", 45447705, 10999932));
    steps.add(new SimplePointPresenter("torreLamberti", 45443128, 10997693));
    steps.add(new SimplePointPresenter("home", 45444727, 11021433));
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
