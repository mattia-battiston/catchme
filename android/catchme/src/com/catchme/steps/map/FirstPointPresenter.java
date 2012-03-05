package com.catchme.steps.map;

import com.catchme.steps.map.type.BaseMapStepPresenter;
import com.google.android.maps.GeoPoint;

public class FirstPointPresenter extends BaseMapStepPresenter {

  @Override
  public String getName() {
    return "firstPoint";
  }

  @Override
  protected String getTextName() {
    return "map_firstPoint";
  }

  @Override
  protected GeoPoint getTarget() {
    return createPoint();
  }

  protected GeoPoint createPoint() {
    return new GeoPoint(19240000, -99120000);
  }

}
