package com.catchme;

import android.app.Activity;
import android.os.Bundle;

public class HelloWorldActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.helloworld);
  }

}
