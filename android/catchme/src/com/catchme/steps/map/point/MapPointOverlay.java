package com.catchme.steps.map.point;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;

import com.catchme.R;
import com.catchme.steps.map.BaloonLayout;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;

public class MapPointOverlay extends ItemizedOverlay<OverlayItem> {

  private ArrayList<OverlayItem> overlayItems = new ArrayList<OverlayItem>();

  private BaloonLayout noteBaloon;

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

  public View getNoteBaloon() {
    return noteBaloon;
  }

}
