package com.catchme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CatchmeActivity extends Activity implements WelcomePresenter.View {

  WelcomePresenter welcomePresenter = new WelcomePresenter(this);

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    welcomePresenter.go();

    Button continueButton = (Button) findViewById(R.id.welcome_continue);
    continueButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent goToMap = new Intent(CatchmeActivity.this,
            CatchmeMapActivity.class);
        startActivity(goToMap);
      }
    });
  }

  public void setWelcomePresenter(WelcomePresenter welcomePresenter) {
    this.welcomePresenter = welcomePresenter;
  }

}
