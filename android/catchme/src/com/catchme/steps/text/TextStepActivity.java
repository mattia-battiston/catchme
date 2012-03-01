package com.catchme.steps.text;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;

import com.catchme.R;
import com.catchme.flow.presenter.Presenter;
import com.catchme.steps.text.WelcomePresenter.PresenterView;

public class TextStepActivity extends Activity implements PresenterView {

  private Presenter<PresenterView> presenter = WelcomePresenter.getInstance();

  private Button continueButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.welcome);

    continueButton = (Button) findViewById(R.id.welcome_continue);

    presenter.bind(this);
  }

  @Override
  public void onBackPressed() {
    presenter.back(this);
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
    this.presenter = presenter;
  }

}
