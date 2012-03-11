package com.catchme.steps.map;

import com.catchme.steps.map.type.BaseMapStepPresenter;
import com.google.android.maps.GeoPoint;

public class FirstPointPresenter extends BaseMapStepPresenter {

  @Override
  public String getStepName() {
    return "firstPoint";
  }

  @Override
  protected String getTitleName() {
    return "map_firstPoint_title";
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
    return new GeoPoint(45449805, 11023514);
  }

}
