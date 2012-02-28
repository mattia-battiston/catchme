package com.catchme.steps.text;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;

import com.catchme.R;
import com.catchme.steps.text.WelcomePresenter.PresenterView;

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

  public void setPresenter(WelcomePresenter presenter) {
    this.welcomePresenter = presenter;
  }

}
