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
    steps.add(new SimpleTextPresenter("firstMessage"));

    steps.add(new SimplePointPresenter("sacher", 45449805, 11023514));
    steps.add(new SimpleTextPresenter("sacherReached"));
    steps.add(new SimpleTextPresenter("sacherReachedText"));
    steps.add(new SimpleTextPresenter("sacherMessage"));

    steps.add(new SimplePointPresenter("pizzeria70", 45449060, 11020489));
    steps.add(new SimpleTextPresenter("pizzeria70Reached"));
    steps.add(new SimpleTextPresenter("pizzeria70ReachedText"));
    steps.add(new SimpleTextPresenter("pizzeria70Message"));

    steps.add(new SimplePointPresenter("viaBadile", 45441427, 11022977));
    steps.add(new SimpleTextPresenter("viaBadileReached"));
    steps.add(new SimpleTextPresenter("viaBadileReachedText"));
    steps.add(new SimpleTextPresenter("viaBadileMessage"));

    steps.add(new SimplePointPresenter("ferraris", 45433293, 10996181));
    steps.add(new SimpleTextPresenter("ferrarisReached"));
    steps.add(new SimpleTextPresenter("ferrarisReachedText"));
    steps.add(new SimpleTextPresenter("ferrarisMessage"));

    steps.add(new SimplePointPresenter("firstPizza", 45439135, 10992768));
    steps.add(new SimpleTextPresenter("firstPizzaReached"));
    steps.add(new SimpleTextPresenter("firstPizzaReachedText"));
    steps.add(new SimpleTextPresenter("firstPizzaMessage"));

    steps.add(new SimplePointPresenter("oldHouse", 45439290, 10985363));
    steps.add(new SimpleTextPresenter("oldHouseReached"));
    steps.add(new SimpleTextPresenter("oldHouseReachedText"));
    steps.add(new SimpleTextPresenter("oldHouseMessage"));

    steps.add(new SimplePointPresenter("cinemaFiume", 45442627, 10976893));
    steps.add(new SimpleTextPresenter("cinemaFiumeReached"));
    steps.add(new SimpleTextPresenter("cinemaFiumeReachedText"));
    steps.add(new SimpleTextPresenter("cinemaFiumeMessage"));

    steps.add(new SimplePointPresenter("castelvecchio", 45439575, 10988398));
    steps.add(new SimpleTextPresenter("castelvecchioReached"));
    steps.add(new SimpleTextPresenter("castelvecchioReachedText"));
    steps.add(new SimpleTextPresenter("castelvecchioMessage"));

    steps.add(new SimplePointPresenter("pozzoAmore", 45442993, 10996096));
    steps.add(new SimpleTextPresenter("pozzoAmoreReached"));
    steps.add(new SimpleTextPresenter("pozzoAmoreReachedText"));
    steps.add(new SimpleTextPresenter("pozzoAmoreMessage"));

    steps.add(new SimplePointPresenter("viaStella", 45441716, 10998894));
    steps.add(new SimpleTextPresenter("viaStellaReached"));
    steps.add(new SimpleTextPresenter("viaStellaReachedText"));
    steps.add(new SimpleTextPresenter("viaStellaMessage"));

    steps.add(new SimplePointPresenter("pontePietra", 45447705, 10999932));
    steps.add(new SimpleTextPresenter("pontePietraReached"));
    steps.add(new SimpleTextPresenter("pontePietraReachedText"));
    steps.add(new SimpleTextPresenter("pontePietraMessage"));

    steps.add(new SimplePointPresenter("torreLamberti", 45443128, 10997693));
    steps.add(new SimpleTextPresenter("torreLambertiReached"));
    steps.add(new SimpleTextPresenter("torreLambertiReachedText"));
    steps.add(new SimpleTextPresenter("torreLambertiMessage"));

    steps.add(new SimpleTextPresenter("timeToGoHome"));
    steps.add(new SimplePointPresenter("home", 45444727, 11021433));
    steps.add(new SimpleTextPresenter("homeReached"));

    steps.add(new SimpleTextPresenter("ensureYoureHome"));
    steps.add(new SimpleTextPresenter("handOverYourPhone"));
    steps.add(new SimpleTextPresenter("fullMessage"));

    steps.add(new SimpleTextPresenter("thankYou"));
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
    return exitStep;
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
