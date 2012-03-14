package com.catchme.steps.text;

import com.catchme.steps.text.type.BaseTextStepPresenter;

public class SimpleTextPresenter extends BaseTextStepPresenter {

  private final String stepName;

  public SimpleTextPresenter(String stepName) {
    this.stepName = stepName;
  }

  @Override
  public String getStepName() {
    return stepName;
  }

  @Override
  protected String getTextName() {
    return "text_" + stepName;
  }

  @Override
  protected String getTitleName() {
    return "text_" + stepName + "_title";
  }

}
