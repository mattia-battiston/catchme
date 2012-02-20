package com.catchme.steps.map;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;

import com.catchme.R;
import com.catchme.R.id;
import com.catchme.R.layout;
import com.catchme.steps.map.WelcomePresenter.PresenterView;

public class WelcomeActivity extends Activity implements PresenterView {

  private WelcomePresenter welcomePresenter = WelcomePresenter.getInstance();

  private Button continueButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.welcome);

    continueButton = (Button) findViewById(R.id.welcome_continue);

    welcomePresenter.bind(this);
  }

  @Override
  public void onBackPressed() {
    welcomePresenter.back(this);
  }

  @Override
  public Button getContinueButton() {
    return continueButton;
  }

  @Override
  public Context getContext() {
    return this;
  }

}
