package com.catchme.steps.text;

import com.catchme.steps.text.type.BaseTextStepPresenter;

public class WelcomePresenter extends BaseTextStepPresenter {

  private static WelcomePresenter instance = new WelcomePresenter();

  public static WelcomePresenter getInstance() {
    return instance;
  }

  private WelcomePresenter() {
  }

  @Override
  public String getName() {
    return "welcome";
  }

  @Override
  public String getTextName() {
    return "text_welcome";
  }

}
