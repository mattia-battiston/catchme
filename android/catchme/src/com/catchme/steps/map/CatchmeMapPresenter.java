package com.catchme.steps.map;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.catchme.flow.AppController;
import com.catchme.flow.presenter.Presenter;
import com.catchme.flow.step.Step;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

public class CatchmeMapPresenter implements Step, Presenter {

  // TODO implement back, refactor, test

  private static CatchmeMapPresenter instance = new CatchmeMapPresenter();
  private PresenterView view;
  private AppController appController;

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
    Intent goToMap = new Intent(context, CatchmeMapActivity.class);
    context.startActivity(goToMap);
  }

  public void bind(final PresenterView view) {
    this.view = view;
    MapView map = view.getMap();
    MapController mapController = view.getMapController();
    map.setBuiltInZoomControls(true);

    GeoPoint target = new GeoPoint(19240000, -99120000);
    view.setTarget(target);
    mapController.animateTo(target);
    mapController.setZoom(15);

    view.getContinueButton().setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        System.out.println("Button clicked");
        appController.next(view.getContext());
      }
    });
  }

  public void setAppController(AppController appController) {
    this.appController = appController;
  }

  public PresenterView getView() {
    return view;
  }
}
