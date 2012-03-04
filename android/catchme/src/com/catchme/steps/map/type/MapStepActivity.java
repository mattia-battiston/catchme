package com.catchme.steps.map.type;

import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;

import com.catchme.R;
import com.catchme.steps.map.FirstPointPresenter;
import com.catchme.steps.map.point.MapPointFactory;
import com.catchme.steps.map.point.MapPointOverlay;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;

public class MapStepActivity extends MapActivity implements MapStepView {

  private FirstPointPresenter mapPresenter = FirstPointPresenter.getInstance();

  private MapPointFactory mapPointFactory = new MapPointFactory(this);

  private MapController mapController;
  private MapView mapView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.catchme_map);

    mapView = (MapView) findViewById(R.id.mapview);
    mapController = mapView.getController();

    mapPresenter.bind(this);
  }

  @Override
  protected boolean isRouteDisplayed() {
    return false;
  }

  @Override
  public MapView getMap() {
    return mapView;
  }

  @Override
  public MapController getMapController() {
    return mapController;
  }

  @Override
  public void setTarget(GeoPoint point, String text) {
    MapPointOverlay mapPoint = mapPointFactory.createMapPoint(point, text);
    addPointOnMap(mapPoint);
    mapController.animateTo(point);
  }

  private void addPointOnMap(MapPointOverlay mapPoint) {
    mapView.addView(mapPoint.getView(), mapPoint.getViewParams());

    List<Overlay> overlays = mapView.getOverlays();
    overlays.add(mapPoint);
  }

  @Override
  public Button getContinueButton() {
    return (Button) findViewById(R.id.mapBaloon_close);
  }

  @Override
  public Context getContext() {
    return this;
  }

  @Override
  public void onBackPressed() {
    mapPresenter.back(this);
  }

  public void setMapPointFactory(MapPointFactory mapPointFactory) {
    this.mapPointFactory = mapPointFactory;
  }

  public void setMapView(MapView mapView) {
    this.mapView = mapView;
  }

  public void setMapPresenter(FirstPointPresenter presenter) {
    this.mapPresenter = presenter;
  }

  public void setMapController(MapController mapController) {
    this.mapController = mapController;
  }

}
