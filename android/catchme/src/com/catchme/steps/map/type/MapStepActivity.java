package com.catchme.steps.map.type;

import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.catchme.R;
import com.catchme.flow.presenter.Presenter;
import com.catchme.steps.map.point.MapPointFactory;
import com.catchme.steps.map.point.MapPointOverlay;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;

public class MapStepActivity extends MapActivity implements MapStepView {

  private static Presenter<MapStepView> mapPresenter;

  private MapPointFactory mapPointFactory = new MapPointFactory(this);

  private MapController mapController;
  private MapView mapView;

  private TextView textTitle;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.map);

    mapView = (MapView) findViewById(R.id.mapview);
    mapController = mapView.getController();
    textTitle = (TextView) findViewById(R.id.map_title);

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

  @Override
  public void setTitle(String titleName) {
    int textResourceId = getResources().getIdentifier(titleName, "string",
        getPackageName());
    textTitle.setText(textResourceId);
  }

  public void setMapPointFactory(MapPointFactory mapPointFactory) {
    this.mapPointFactory = mapPointFactory;
  }

  public void setMapView(MapView mapView) {
    this.mapView = mapView;
  }

  public static void setMapPresenter(Presenter<MapStepView> presenter) {
    mapPresenter = presenter;
  }

  public void setMapController(MapController mapController) {
    this.mapController = mapController;
  }

  public void setTextTitle(TextView textTitle) {
    this.textTitle = textTitle;
  }

}
