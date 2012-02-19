package com.catchme;

import android.app.Activity;
import android.os.Bundle;

public class CatchmeActivity extends Activity implements WelcomePresenter.View {

  WelcomePresenter welcomePresenter = new WelcomePresenter(this);

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    welcomePresenter.go();
  }

  public void setWelcomePresenter(WelcomePresenter welcomePresenter) {
    this.welcomePresenter = welcomePresenter;
  }

}
