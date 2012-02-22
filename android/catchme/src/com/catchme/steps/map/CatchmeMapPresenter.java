package com.catchme.steps.map;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.catchme.R;
import com.catchme.steps.map.point.MapPointOverlay;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

public class CatchmeMapPresenter {

  private static CatchmeMapPresenter instance = new CatchmeMapPresenter();
  private PresenterView view;

  public interface PresenterView {
    MapView getMap();

    MapController getMapController();

    void setTarget(GeoPoint geoPoint);

    Button getContinueButton();
  }

  private CatchmeMapPresenter() {
  }

  public static CatchmeMapPresenter getInstance() {
    return instance;
  }

  public void go(Context context) {
    Intent goToMap = new Intent(context, CatchmeMapActivity.class);
    context.startActivity(goToMap);
  }

  public void bind(final PresenterView view) {
    this.view = view;
    view.getMap().setBuiltInZoomControls(true);
    view.getMapController().setZoom(15);

    view.setTarget(new GeoPoint(19240000, -99120000));
  }

  public void onTargetClicked(MapPointOverlay target) {
    MapView map = view.getMap();
    MapController mapController = view.getMapController();
    GeoPoint point = target.getPoint();

    View noteBaloon = target.getNoteBaloon();
    map.removeView(noteBaloon);
    noteBaloon.setVisibility(View.VISIBLE);
    ((TextView) noteBaloon.findViewById(R.id.note_text))
        .setText("Example text for baloon");
    map.addView(noteBaloon, new MapView.LayoutParams(200, 200, point,
        MapView.LayoutParams.BOTTOM_CENTER));
    map.setEnabled(false);

    mapController.animateTo(point);

    Button closeButton = view.getContinueButton();
    closeButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        System.out.println("Button clicked");
      }
    });

  }
}
