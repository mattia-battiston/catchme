package com.catchme.trials;

import android.app.Activity;
import android.os.Bundle;

@Deprecated
public class HelloWorldActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    // setContentView(R.layout.helloworld);

    // Button helloButton = (Button) findViewById(R.id.helloButton);
    // helloButton.setOnClickListener(new View.OnClickListener() {
    // @Override
    // public void onClick(View v) {
    // new AppController(HelloWorldActivity.this).goToMap();
    // }
    // });
  }

}
