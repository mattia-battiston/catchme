package com.catchme.steps.map.point.baloon;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class BaloonLayout extends LinearLayout {

  public BaloonLayout(Context context) {
    super(context);
  }

  public BaloonLayout(Context context, AttributeSet attributeSet) {
    super(context, attributeSet);
  }

  @Override
  protected void dispatchDraw(Canvas canvas) {
    Paint wholeBalloonArea = new Paint();
    wholeBalloonArea.setARGB(0, 0, 0, 0);

    int baloonWidth = getMeasuredWidth();
    int baloonHeight = getMeasuredHeight();

    // top balloon with the text
    // RectF panelRect = new RectF();
    // panelRect.set(0, 0, baloonWidth, baloonHeight / 2);
    // canvas.drawRoundRect(panelRect, 5, 5, wholeBalloonArea);
    RectF balloonRect = new RectF();
    balloonRect.set(0, 0, baloonWidth, 2 * (baloonHeight / 3));
    wholeBalloonArea.setARGB(230, 255, 255, 255);
    canvas.drawRoundRect(balloonRect, 10, 10, wholeBalloonArea);

    // here it's drawing the leg of the baloon
    Path balloonTip = new Path();
    balloonTip.moveTo(5 * (baloonWidth / 8), 2 * (baloonHeight / 3));
    balloonTip.lineTo(baloonWidth / 2, baloonHeight);
    balloonTip.lineTo(3 * (baloonWidth / 4), 2 * (baloonHeight / 3));

    canvas.drawPath(balloonTip, wholeBalloonArea);

    super.dispatchDraw(canvas);
  }

}