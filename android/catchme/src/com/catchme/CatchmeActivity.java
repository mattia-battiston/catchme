package com.catchme;

import android.app.Activity;
import android.os.Bundle;

public class CatchmeActivity extends Activity implements WelcomePresenter.View {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    new WelcomePresenter(this).go();
  }
}
