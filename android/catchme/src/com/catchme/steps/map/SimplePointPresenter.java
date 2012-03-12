package com.catchme.steps.map;

import com.catchme.steps.map.type.BaseMapStepPresenter;
import com.google.android.maps.GeoPoint;

public class SimplePointPresenter extends BaseMapStepPresenter {

  private final String stepName;
  private final int latitude;
  private final int longitude;

  public SimplePointPresenter(String stepName, int latitude, int longitude) {
    this.stepName = stepName;
    this.latitude = latitude;
    this.longitude = longitude;
  }

  @Override
  public String getStepName() {
    return stepName;
  }

  @Override
  protected String getTitleName() {
    return "map_" + stepName + "_title";
  }

  @Override
  protected String getTextName() {
    return "map_" + stepName;
  }

  @Override
  protected GeoPoint getTarget() {
    return createPoint();
  }

  protected GeoPoint createPoint() {
    return new GeoPoint(latitude, longitude);
  }

}
