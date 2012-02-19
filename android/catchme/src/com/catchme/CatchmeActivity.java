package com.catchme;

import android.app.Activity;
import android.os.Bundle;

public class CatchmeActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // start the first step; eventually this will read the step the user has
    // arrived to from the db
    WelcomePresenter.getInstance().go(this);
  }

  @Override
  protected void onResume() {
    super.onResume();

    // start the first step; eventually this will read the step the user has
    // arrived to from the db
    WelcomePresenter.getInstance().go(this);
  }

}
