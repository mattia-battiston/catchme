package com.catchme.steps.text;

import com.catchme.steps.text.type.BaseTextStepPresenter;

public class FirstPointReached extends BaseTextStepPresenter {

  private static FirstPointReached instance = new FirstPointReached();

  private FirstPointReached() {
  }

  public static FirstPointReached getInstance() {
    return instance;
  }

  @Override
  public String getName() {
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
