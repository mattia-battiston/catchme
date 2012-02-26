package com.catchme;

import android.app.Activity;
import android.os.Bundle;

import com.catchme.flow.AppController;

public class CatchmeActivity extends Activity {

  private AppController appController = new AppController();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  protected void onResume() {
    super.onResume();

    appController.start(this);
  }

  public void setAppController(AppController appController) {
    this.appController = appController;
  }

}
