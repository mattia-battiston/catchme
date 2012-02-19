package com.catchme;

import android.os.Bundle;

import com.google.android.maps.MapActivity;

public class CatchmeMapActivity extends MapActivity {

  // TODO convert to use a presenter

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
