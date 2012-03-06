package com.catchme.steps.text;

import com.catchme.steps.text.type.BaseTextStepPresenter;

public class WelcomePresenter extends BaseTextStepPresenter {

  public WelcomePresenter() {
    System.out.println("creating WelcomePresenter");
  }

  @Override
  public String getStepName() {
    return "welcome";
  }

  @Override
  protected String getTextName() {
    return "text_welcome";
  }

  @Override
  protected String getTitleName() {
    return "text_welcome_title";
  }

}
