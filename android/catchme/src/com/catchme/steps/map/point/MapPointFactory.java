package com.catchme.steps.map.point;

import android.app.Activity;

import com.google.android.maps.GeoPoint;

public class MapPointFactory {

  private final Activity activity;

  public MapPointFactory(Activity activity) {
    this.activity = activity;
  }

  public MapPointOverlay createMapPoint(GeoPoint point) {
    MapPointOverlay pin = new MapPointOverlay(activity);
    pin.setPoint(point);
    return pin;
  }

}
