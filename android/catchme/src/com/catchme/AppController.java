package com.catchme;

import android.app.Activity;
import android.content.Intent;

public class AppController {

  private final Activity currentActivity;

  public AppController(Activity context) {
    this.currentActivity = context;
  }

  public void goToHelloWorld() {
    Intent goToHelloWorld = new Intent(currentActivity,
        HelloWorldActivity.class);
    currentActivity.startActivity(goToHelloWorld);
  }

}
