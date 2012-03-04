package com.catchme.steps.map.type;

import android.content.Context;
import android.widget.Button;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

public interface MapStepView {
  MapView getMap();

  MapController getMapController();

  void setTarget(GeoPoint geoPoint, String text);

  Button getContinueButton();

  Context getContext();
}
