package com.catchme;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class WelcomePresenter {

  private static WelcomePresenter instance = new WelcomePresenter();

  public interface PresenterView {
    Button getContinueButton();
  }

  private WelcomePresenter() {
  }

  public void go(Context currentContext) {
    Intent goToWelcome = new Intent(currentContext, WelcomeActivity.class);
    currentContext.startActivity(goToWelcome);
  }

  public void bind(PresenterView view) {
    view.getContinueButton().setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        System.out.println("Go to next");
      }
    });
  }

  // public void next() {
  // Context currentView = view.getCurrentContext();
  // Intent goToMap = new Intent(currentView, CatchmeMapActivity.class);
  // currentView.startActivity(goToMap);
  // }

  public static WelcomePresenter getInstance() {
    return instance;
  }

}
