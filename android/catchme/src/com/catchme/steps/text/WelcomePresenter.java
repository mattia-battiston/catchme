package com.catchme.steps.text;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.catchme.android.IntentFactory;
import com.catchme.flow.presenter.BasePresenter;

public class WelcomePresenter extends BasePresenter<TextStepView> {

  private static WelcomePresenter instance = new WelcomePresenter();

  public static WelcomePresenter getInstance() {
    return instance;
  }

  private WelcomePresenter() {
  }

  @Override
  public void go(Context currentContext) {
    Intent goToWelcome = intentFactory.createIntent(currentContext,
        TextStepActivity.class);
    currentContext.startActivity(goToWelcome);
  }

  @Override
  public void bind(final TextStepView view) {
    view.getContinueButton().setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        next(view.getContext());
      }
    });
  }

  @Override
  public String getName() {
    return "welcome";
  }

  public void setIntentFactory(IntentFactory intentFactory) {
    this.intentFactory = intentFactory;
  }

}
