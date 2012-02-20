package com.catchme.steps.text;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.catchme.flow.AppController;

public class WelcomePresenter {

  private static WelcomePresenter instance = new WelcomePresenter();
  private AppController appController;

  public interface PresenterView {
    Button getContinueButton();

    Context getContext();
  }

  private WelcomePresenter() {
  }

  public void go(Context currentContext) {
    Intent goToWelcome = new Intent(currentContext, WelcomeActivity.class);
    currentContext.startActivity(goToWelcome);
  }

  public void bind(final PresenterView view) {
    view.getContinueButton().setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        System.out.println("Go to next");
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

  public void setAppController(AppController appController) {
    this.appController = appController;
  }

}
