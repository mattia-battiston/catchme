package com.catchme.steps.map;

import java.util.ArrayList;

import android.content.Context;

import com.catchme.R;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;

public class MapPointOverlay extends ItemizedOverlay<OverlayItem> {

  private ArrayList<OverlayItem> overlayItems = new ArrayList<OverlayItem>();

  // TODO clean up this constructor, probably use a factory
  public MapPointOverlay(Context context, GeoPoint point) {
    super(boundCenterBottom(context.getResources().getDrawable(
        R.drawable.map_pin)));
    OverlayItem overlayitem = new OverlayItem(point, "", "");
    addOverlay(overlayitem);
  }

  public void addOverlay(OverlayItem overlay) {
    overlayItems.add(overlay);
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
