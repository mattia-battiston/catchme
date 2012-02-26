package com.catchme.flow.step;

import com.catchme.flow.presenter.PresenterRetriever;
import com.catchme.steps.map.CatchmeMapPresenter;
import com.catchme.steps.text.WelcomePresenter;

public class StepRetriever {

  private PresenterRetriever presenterRetriever = new PresenterRetriever();

  public Step getFirstStep() {
    return presenterRetriever.getPresenter(WelcomePresenter.class);
  }

  public Step getStepAfter(Step step) {
    return presenterRetriever.getPresenter(CatchmeMapPresenter.class);
  }

}
