package com.catchme.steps.map.point;

import java.util.ArrayList;

import android.content.Context;

import com.catchme.R;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapView;
import com.google.android.maps.OverlayItem;

public class MapPointOverlay extends ItemizedOverlay<OverlayItem> {

  private ArrayList<OverlayItem> overlayItems = new ArrayList<OverlayItem>();

  private OverlayItem target;

  public MapPointOverlay(Context context) {
    super(boundCenterBottom(context.getResources().getDrawable(
        R.drawable.map_pin)));
  }

  public void setPoint(GeoPoint point) {
    this.target = new OverlayItem(point, "", "");
    overlayItems.add(target);
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

  @Override
  public boolean onTap(GeoPoint p, MapView mapView) {
    System.out.println("tap sul punto " + p);
    return super.onTap(p, mapView);
  }

  @Override
  protected boolean onTap(int index) {
    System.out.println("tap sull'oggetto " + index);
    return super.onTap(index);
  }

}
