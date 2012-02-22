package com.catchme.steps.map.point;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.catchme.R;
import com.catchme.steps.map.BaloonLayout;
import com.catchme.steps.map.CatchmeMapPresenter;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapView;

public class MapPointFactory {

  private final Activity activity;
  private final CatchmeMapPresenter presenter;

  public MapPointFactory(Activity activity, CatchmeMapPresenter mapPresenter) {
    this.activity = activity;
    this.presenter = mapPresenter;
  }

  // TODO some of this code should be in the MapPointOverlay, the baloon is
  // part of the point for us
  public MapPointOverlay createMapPoint(GeoPoint point) {
    MapPointOverlay pin = new MapPointOverlay(activity);
    pin.setPoint(point);

    BaloonLayout noteBaloon = getBaloonLayout();

    MapView map = presenter.getView().getMap();
    noteBaloon.setVisibility(View.VISIBLE);
    ((TextView) noteBaloon.findViewById(R.id.note_text))
        .setText("Example text for baloon");
    map.addView(noteBaloon, new MapView.LayoutParams(200, 200, point,
        MapView.LayoutParams.BOTTOM_CENTER));
    map.setEnabled(false);// TODO is this needed?

    return pin;
  }

  // TODO initialize this starting the application and make it available
  private BaloonLayout getBaloonLayout() {
    LayoutInflater layoutInflater = (LayoutInflater) activity
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    BaloonLayout noteBaloon = (BaloonLayout) layoutInflater.inflate(
        R.layout.baloon, null);
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
        200, 100);
    layoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
    layoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
    noteBaloon.setLayoutParams(layoutParams);
    return noteBaloon;
  }

}
