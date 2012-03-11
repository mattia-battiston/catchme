package com.catchme.steps.map.point;

import java.util.ArrayList;

import android.content.Context;

import com.catchme.R;
import com.catchme.steps.map.point.baloon.BaloonLayout;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapView;
import com.google.android.maps.MapView.LayoutParams;
import com.google.android.maps.OverlayItem;

public class MapPointOverlay extends ItemizedOverlay<OverlayItem> {

  private ArrayList<OverlayItem> overlayItems = new ArrayList<OverlayItem>();

  private BaloonLayout layout;

  private GeoPoint point;

  private MapView mapView;

  public MapPointOverlay(Context context) {
    super(boundCenterBottom(context.getResources().getDrawable(
        R.drawable.map_pin)));
  }

  public void setPosition(GeoPoint point) {
    this.point = point;
    overlayItems.add(new OverlayItem(point, "", ""));
    populate();
  }

  @Override
  protected OverlayItem createItem(int i) {
    return overlayItems.get(i);
  }

  @Override
  public int size() {
    return overlayItems.size();
  }

  public void setLayout(BaloonLayout layout) {
    this.layout = layout;
  }

  public BaloonLayout getView() {
    return layout;
  }

  public LayoutParams getViewParams() {
    return new MapView.LayoutParams(200, 100, point,
        MapView.LayoutParams.BOTTOM_CENTER);
  }

  @Override
  public boolean onTap(GeoPoint p, MapView mapView) {
    this.mapView = mapView;
    mapView.removeView(layout);
    return super.onTap(p, mapView);
  }

  @Override
  protected boolean onTap(int index) {
    mapView.addView(getView(), getViewParams());
    return super.onTap(index);
  }

}
