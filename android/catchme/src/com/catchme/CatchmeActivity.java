package com.catchme;

import android.app.Activity;
import android.os.Bundle;

public class CatchmeActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.welcome);

    // TextView content = (TextView) findViewById(R.id.welcome_content);
    // content.setText(R.string.veryLongText);
    // content.setMovementMethod(new ScrollingMovementMethod());
  }
}
