package com.catchme;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.catchme.WelcomePresenter.PresenterView;

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
    Intent i = new Intent();
    i.setAction(Intent.ACTION_MAIN);
    i.addCategory(Intent.CATEGORY_HOME);
    startActivity(i);
    finish();
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
