package com.catchme.steps.map;

import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;

import com.catchme.R;
import com.catchme.steps.map.point.MapPointFactory;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;

public class CatchmeMapActivity extends MapActivity implements
    CatchmeMapPresenter.PresenterView {

  private CatchmeMapPresenter mapPresenter = CatchmeMapPresenter.getInstance();

  private MapPointFactory mapPointFactory = new MapPointFactory(this,
      mapPresenter);

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
  public void setTarget(GeoPoint point) {
    List<Overlay> overlays = mapView.getOverlays();
    overlays.add(mapPointFactory.createMapPoint(point));

    mapController.animateTo(point);
  }

  @Override
  public Button getContinueButton() {
    return (Button) findViewById(R.id.mapBaloon_close);
  }

  @Override
  public Context getContext() {
    return this;
  }
}
