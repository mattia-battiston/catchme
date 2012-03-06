package com.catchme.steps.map.type;

import android.content.Context;
import android.widget.Button;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

public interface MapStepView {
  MapView getMap();

  MapController getMapController();

  void setTitle(String titleName);

  void setTarget(GeoPoint geoPoint, String titleName, String textName);

  Button getContinueButton();

  Context getContext();
}
