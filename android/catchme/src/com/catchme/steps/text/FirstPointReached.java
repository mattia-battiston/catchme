package com.catchme.steps.text;

import com.catchme.steps.text.type.BaseTextStepPresenter;

public class FirstPointReached extends BaseTextStepPresenter {

  @Override
  public String getStepName() {
    return "First Point Reached";
  }

  @Override
  public String getTextName() {
    return "text_firstPointReached";
  }

  @Override
  protected String getTitleName() {
    return "text_firstPointReached_title";
  }

}
