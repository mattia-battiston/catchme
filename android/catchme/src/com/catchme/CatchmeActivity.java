package com.catchme;

import android.os.Bundle;

import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

public class CatchmeActivity extends MapActivity implements CatchmeView {

  private MapController mapController;

  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    MapView mapView = (MapView) findViewById(R.id.mapview);
    mapView.setBuiltInZoomControls(true);

    this.mapController = mapView.getController();

    CatchmePresenter catchmePresenter = new CatchmePresenter(this);
    catchmePresenter.bind();
  }

  @Override
  protected boolean isRouteDisplayed() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public MapController getMapController() {
    return mapController;
  }
}