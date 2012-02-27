package com.catchme.steps.text;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.catchme.android.IntentFactory;
import com.catchme.flow.presenter.Presenter;
import com.catchme.flow.step.BaseStep;

public class WelcomePresenter extends BaseStep implements Presenter {

  private static WelcomePresenter instance = new WelcomePresenter();

  public static WelcomePresenter getInstance() {
    return instance;
  }

  public interface PresenterView {
    Button getContinueButton();

    Context getContext();
  }

  private IntentFactory intentFactory = new IntentFactory();

  private WelcomePresenter() {
  }

  @Override
  public void go(Context currentContext) {
    Intent goToWelcome = intentFactory.createIntent(currentContext,
        WelcomeActivity.class);
    currentContext.startActivity(goToWelcome);
  }

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
