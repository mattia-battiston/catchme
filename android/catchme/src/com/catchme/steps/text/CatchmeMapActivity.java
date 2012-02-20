package com.catchme.steps.text;

import android.os.Bundle;

import com.catchme.R;
import com.google.android.maps.MapActivity;

public class CatchmeMapActivity extends MapActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.catchme_map);
  }

  @Override
  protected boolean isRouteDisplayed() {
    return false;
  }

}
