package com.catchme.steps.map;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.catchme.flow.presenter.Presenter;
import com.catchme.flow.step.BaseStep;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

public class CatchmeMapPresenter extends BaseStep implements Presenter {

  // TODO implement back, refactor, test

  private static CatchmeMapPresenter instance = new CatchmeMapPresenter();

  private PresenterView view;

  private MapView map;

  private MapController mapController;

  public interface PresenterView {
    MapView getMap();

    MapController getMapController();

    void setTarget(GeoPoint geoPoint);

    Button getContinueButton();

    Context getContext();
  }

  private CatchmeMapPresenter() {
  }

  public static CatchmeMapPresenter getInstance() {
    return instance;
  }

  public void go(Context context) {
    Intent goToMap = intentFactory.createIntent(context,
        CatchmeMapActivity.class);
    context.startActivity(goToMap);
  }

  public void bind(final PresenterView view) {
    this.view = view;
    this.map = view.getMap();
    this.mapController = view.getMapController();

    map.setBuiltInZoomControls(true);
    mapController.setZoom(15);

    GeoPoint target = new GeoPoint(19240000, -99120000);
    view.setTarget(target);
    mapController.animateTo(target);

    view.getContinueButton().setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        next(view.getContext());
      }
    });
  }

  public PresenterView getView() {
    return view;
  }

  @Override
  public String getName() {
    return "firstPoint";
  }
}
