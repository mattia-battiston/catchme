package com.catchme.flow.step;

import com.catchme.flow.presenter.PresenterRetriever;
import com.catchme.steps.exit.ExitStep;
import com.catchme.steps.map.CatchmeMapPresenter;
import com.catchme.steps.text.WelcomePresenter;

public class StepRetriever {

  // TODO test
  // TODO store status in a database, to know where we are in the flow

  // TODO next should calculate the next step to go to
  // TODO back should calculate the next step to go to

  private PresenterRetriever presenterRetriever = new PresenterRetriever();

  public Step getFirstStep() {
    return presenterRetriever.getPresenter(WelcomePresenter.class);
  }

  public Step getStepAfter(Step step) {
    return presenterRetriever.getPresenter(CatchmeMapPresenter.class);
  }

  public Step getStepBefore(Step step) {
    return new ExitStep();
  }
}
