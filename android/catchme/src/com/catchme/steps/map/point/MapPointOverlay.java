package com.catchme.steps.map.point;

import java.util.ArrayList;

import android.content.Context;

import com.catchme.R;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;

public class MapPointOverlay extends ItemizedOverlay<OverlayItem> {

  private ArrayList<OverlayItem> overlayItems = new ArrayList<OverlayItem>();

  public MapPointOverlay(Context context) {
    super(boundCenterBottom(context.getResources().getDrawable(
        R.drawable.map_pin)));
  }

  public void setPoint(GeoPoint point) {
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

}
