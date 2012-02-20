package com.catchme.steps.map;

import java.util.ArrayList;

import android.graphics.drawable.Drawable;

import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;

public class HelloItemizedOverlay extends ItemizedOverlay<OverlayItem> {

  private ArrayList<OverlayItem> overlayItems = new ArrayList<OverlayItem>();

  public HelloItemizedOverlay(Drawable defaultMarker) {
    super(boundCenterBottom(defaultMarker));
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
