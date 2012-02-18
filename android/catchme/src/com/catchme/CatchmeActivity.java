package com.catchme;

import android.os.Bundle;

import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

public class CatchmeActivity extends MapActivity implements CatchmeView {

  private CatchmePresenter catchmePresenter = new CatchmePresenter();

  private MapController mapController;

  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    MapView mapView = (MapView) findViewById(R.id.mapview);
    mapView.setBuiltInZoomControls(true);

    mapController = mapView.getController();
    mapController.setZoom(10);
    // mapController.setCenter(new GeoPoint(latitudeE6, longitudeE6))
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