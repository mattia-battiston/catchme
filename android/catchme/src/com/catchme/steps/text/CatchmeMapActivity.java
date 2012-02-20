package com.catchme.steps.text;

import android.os.Bundle;

import com.catchme.R;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

public class CatchmeMapActivity extends MapActivity implements
    CatchmeMapPresenter.PresenterView {

  private CatchmeMapPresenter mapPresenter = CatchmeMapPresenter.getInstance();

  private MapController mapController;
  private MapView mapView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.catchme_map);

    mapView = (MapView) findViewById(R.id.mapview);
    mapController = mapView.getController();

    mapPresenter.bind(this);

    // LayoutInflater layoutInflater = (LayoutInflater) this
    // .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    // BaloonLayout noteBaloon = (BaloonLayout) layoutInflater.inflate(
    // R.layout.baloon, null);
    // RelativeLayout.LayoutParams layoutParams = new
    // RelativeLayout.LayoutParams(
    // 200, 100);
    // layoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
    // layoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
    // noteBaloon.setLayoutParams(layoutParams);
    //
    // mapView.removeView(noteBaloon);
    // noteBaloon.setVisibility(View.VISIBLE);
    // ((TextView) noteBaloon.findViewById(R.id.note_text))
    // .setText("Example text for baloon");
    // GeoPoint point = new GeoPoint(19240000, -99120000);
    // mapController.animateTo(point);
    // mapView.addView(noteBaloon, new MapView.LayoutParams(200, 200, point,
    // MapView.LayoutParams.BOTTOM_CENTER));
    // mapView.setEnabled(false);
    //
    // Button closeButton = (Button) findViewById(R.id.mapBaloon_close);
    // closeButton.setOnClickListener(new View.OnClickListener() {
    // @Override
    // public void onClick(View v) {
    // System.out.println("Button clicked");
    // }
    // });

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

}
