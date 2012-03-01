package com.catchme.steps.text;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.catchme.android.IntentFactory;
import com.catchme.flow.presenter.BasePresenter;

public class WelcomePresenter extends
    BasePresenter<WelcomePresenter.PresenterView> {

  private static WelcomePresenter instance = new WelcomePresenter();

  public static WelcomePresenter getInstance() {
    return instance;
  }

  public interface PresenterView {
    Button getContinueButton();

    Context getContext();
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
  public void bind(final PresenterView view) {
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
