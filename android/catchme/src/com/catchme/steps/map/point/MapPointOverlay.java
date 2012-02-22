package com.catchme.steps.map.point;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;

import com.catchme.R;
import com.catchme.steps.map.BaloonLayout;
import com.catchme.steps.map.CatchmeMapPresenter;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;

public class MapPointOverlay extends ItemizedOverlay<OverlayItem> {

  private ArrayList<OverlayItem> overlayItems = new ArrayList<OverlayItem>();

  private OverlayItem target;

  private BaloonLayout noteBaloon;

  private CatchmeMapPresenter presenter;

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
  protected boolean onTap(int index) {
    System.out.println("tap sull'oggetto " + index);
    presenter.onTargetClicked(this);
    return true;
  }

  public void setBaloonLayout(BaloonLayout noteBaloon) {
    this.noteBaloon = noteBaloon;
  }

  public View getNoteBaloon() {
    return noteBaloon;
  }

  public void setPresenter(CatchmeMapPresenter presenter) {
    this.presenter = presenter;
  }

  public GeoPoint getPoint() {
    return target.getPoint();
  }

}
