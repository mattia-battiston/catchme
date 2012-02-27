package com.catchme.steps.text;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.catchme.flow.AppController;
import com.catchme.flow.presenter.Presenter;
import com.catchme.flow.step.Step;

public class WelcomePresenter implements Step, Presenter {

  // TODO extract common parts for presenters

  private static WelcomePresenter instance = new WelcomePresenter();
  private AppController appController;

  public interface PresenterView {
    Button getContinueButton();

    Context getContext();
  }

  private WelcomePresenter() {
  }

  @Override
  public void go(Context currentContext) {
    Intent goToWelcome = new Intent(currentContext, WelcomeActivity.class);
    currentContext.startActivity(goToWelcome);
  }

  public void bind(final PresenterView view) {
    view.getContinueButton().setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        appController.next(view.getContext());
      }
    });
  }

  public void back(Activity activity) {
    appController.back(activity);
  }

  public static WelcomePresenter getInstance() {
    return instance;
  }

  @Override
  public void setAppController(AppController appController) {
    this.appController = appController;
  }

  @Override
  public String getName() {
    return "welcome";
  }

}
