package com.catchme;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;

public class CatchmeActivity extends Activity implements
    WelcomePresenter.PresenterView {

  private WelcomePresenter welcomePresenter = new WelcomePresenter(this);

  private Button continueButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.welcome);

    continueButton = (Button) findViewById(R.id.welcome_continue);

    welcomePresenter.go();
  }

  @Override
  public Context getCurrentContext() {
    return this;
  }

  @Override
  public Button getContinueButton() {
    return continueButton;
  }

  public void setWelcomePresenter(WelcomePresenter welcomePresenter) {
    this.welcomePresenter = welcomePresenter;
  }

}
