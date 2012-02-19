package com.catchme;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class WelcomePresenter {

  private final PresenterView view;

  public interface PresenterView {
    Context getCurrentContext();

    void setContentView(int contentView);

    Button getContinueButton();
  }

  public WelcomePresenter(PresenterView view) {
    this.view = view;
  }

  public void go() {
    view.getContinueButton().setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        next();
      }
    });
  }

  public void next() {
    Context currentView = view.getCurrentContext();
    Intent goToMap = new Intent(currentView, CatchmeMapActivity.class);
    currentView.startActivity(goToMap);
  }

}
