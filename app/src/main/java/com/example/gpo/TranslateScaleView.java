package com.example.gpo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DrawFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.util.logging.Logger;

public class TranslateScaleView extends ViewGroup {
    float dx;
    float dy;
    float scaleFac;

    Region r;
    private Path mPath;
    private Paint mPaint;
    private Path mTransformedPath;
    private Paint cColor;
    boolean scaling;
    Canvas canvas;
    private VectorDrawable vectorDrawable;
    private Drawable drawable;
    private Context context;
    int viewWidth;
    int viewHeight;
    float svgWidth;
    float svgHeight;

    private static final byte NONE = 0;
    private static final byte DRAG = 1;
    private static final byte ZOOM = 2;

    private byte mode = NONE;

    private Matrix matrix = new Matrix();
    private Matrix matrixInverse = new Matrix();
    private Matrix savedMatrix = new Matrix();


    // Parameters for zooming.
    private PointF start = new PointF();
    private PointF mid = new PointF();
    private float oldDist = 1f;
    private float[] lastEvent = null;
    private long lastDownTime = 0l;

    private float[] mDispatchTouchEventWorkingArray = new float[2];
    private float[] mOnTouchEventWorkingArray = new float[2];

    private VectorDrawable mapMarker;

    private Integer x;
    private Integer y;

    private static final int MARKER_SIZE = 30;
    private static final int MAP_SIZE = 720;
    private static final int SHIFT = 80;

    private static final DrawFilter filter = new PaintFlagsDrawFilter(Paint.ANTI_ALIAS_FLAG, 0);


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        mDispatchTouchEventWorkingArray[0] = ev.getX();
        mDispatchTouchEventWorkingArray[1] = ev.getY();
        mDispatchTouchEventWorkingArray = screenPointsToScaledPoints(mDispatchTouchEventWorkingArray);
        ev.setLocation(mDispatchTouchEventWorkingArray[0], mDispatchTouchEventWorkingArray[1]);
        return super.dispatchTouchEvent(ev);
    }

    public TranslateScaleView(Context context) {
        super(context);
        init(context);
        this.context = context;
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    public TranslateScaleView(Context context, Drawable drawable) {
        super(context);
        init(context);
        this.drawable = drawable;
        this.context = context;
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    public TranslateScaleView(Context context, VectorDrawable vectorDrawable) {
        super(context);
        init(context);
        this.vectorDrawable = vectorDrawable;
        this.context = context;
        mapMarker = (VectorDrawable) this.context.getDrawable(R.drawable.ic_marker);
        setPoint(0, 102);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    public TranslateScaleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TranslateScaleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }


    private void init(Context context) {

    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
        invalidate();
    }

    public void setVectorDrawable(VectorDrawable vectorDrawable) {
        this.vectorDrawable = vectorDrawable;
        invalidate();
    }

    public void setPoint(int x, int y) {
        /**
         * left, top - начальные координаты
         * right, bottom - конечные
         * ширина картинки = right - left
         * высота = bottom - top
         * MAP_SIZE - y : поправка на то, что у тебя точка (0, 0) в левом нижнем углу, а не в левом верхнем.
         * y - MARKER_SIZE : поправка на то, что маркер рисуется относительно левого верхнего угла => указывает маркер ниже точки, от которой рисуется.
         */
        mapMarker.setBounds(x - (MARKER_SIZE / 2), (MAP_SIZE - y) - MARKER_SIZE, x + (MARKER_SIZE / 2), MAP_SIZE - y);
        this.x = x;
        this.y = y;
        invalidate();
    }


    private float spacing(MotionEvent event) {
        float x = event.getX(0) - event.getX(1);
        float y = event.getY(0) - event.getY(1);
        return (float) Math.sqrt(x * x + y * y);
    }

    private void midPoint(PointF point, MotionEvent event) {
        float x = event.getX(0) + event.getX(1);
        float y = event.getY(0) + event.getY(1);
        point.set(x / 2, y / 2);
    }

    private float[] scaledPointsToScreenPoints(float[] a) {
        matrix.mapPoints(a);
        return a;
    }

    private float[] screenPointsToScaledPoints(float[] a) {
        matrixInverse.mapPoints(a);
        return a;
    }


    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() != GONE) {
                child.layout(left, top, left + child.getMeasuredWidth(), top + child.getMeasuredHeight());
            }
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() != GONE) {
                measureChild(child, widthMeasureSpec, heightMeasureSpec);
            }
        }
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        float[] values = new float[9];
        matrix.getValues(values);
        canvas.save();
        canvas.translate(values[Matrix.MTRANS_X], values[Matrix.MTRANS_Y]);
        canvas.scale(values[Matrix.MSCALE_X], values[Matrix.MSCALE_Y]);
        Log.e("", "x = " + values[Matrix.MTRANS_X] + "\n" + "y = " + values[Matrix.MTRANS_Y]);
        this.canvas = canvas;
        //svg.renderToCanvas(canvas);
        //drawable.draw(canvas);
        vectorDrawable.draw(canvas);
        if (x != null && y != null) {
            mapMarker.draw(canvas);
        }
        canvas.restore();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        mOnTouchEventWorkingArray[0] = event.getX();
        mOnTouchEventWorkingArray[1] = event.getY();

        mOnTouchEventWorkingArray = scaledPointsToScreenPoints(mOnTouchEventWorkingArray);

        event.setLocation(mOnTouchEventWorkingArray[0], mOnTouchEventWorkingArray[1]);

        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                savedMatrix.set(matrix);
                mode = DRAG;
                lastEvent = null;
                long downTime = event.getDownTime();
                if (downTime - lastDownTime < 300l) {
                    float density = getResources().getDisplayMetrics().density;
                    if (Math.max(Math.abs(start.x - event.getX()), Math.abs(start.y - event.getY())) < 40.f * density) {
                        savedMatrix.set(matrix);
                        mid.set(event.getX(), event.getY());
                        mode = ZOOM;
                        lastEvent = new float[4];
                        lastEvent[0] = lastEvent[1] = event.getX();
                        lastEvent[2] = lastEvent[3] = event.getY();
                    }
                    lastDownTime = 0l;
                } else {
                    lastDownTime = downTime;
                }
                start.set(event.getX(), event.getY());
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                oldDist = spacing(event);
                if (oldDist > 10f) {
                    savedMatrix.set(matrix);
                    midPoint(mid, event);
                    mode = ZOOM;
                }
                lastEvent = new float[4];
                lastEvent[0] = event.getX(0);
                lastEvent[1] = event.getX(1);
                lastEvent[2] = event.getY(0);
                lastEvent[3] = event.getY(1);
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
                mode = NONE;
                lastEvent = null;
                break;
            case MotionEvent.ACTION_MOVE:
                final float density = getResources().getDisplayMetrics().density;
                if (mode == DRAG) {
                    matrix.set(savedMatrix);
                    dx = event.getX() - start.x;
                    dy = event.getY() - start.y;
                    matrix.postTranslate(dx, dy);
                    matrix.invert(matrixInverse);
                    if (Math.max(Math.abs(start.x - event.getX()), Math.abs(start.y - event.getY())) > 20.f * density) {
                        lastDownTime = 0l;
                    }
                } else if (mode == ZOOM) {
                    if (event.getPointerCount() > 1) {
                        float newDist = spacing(event);
                        if (newDist > 10f * density) {
                            matrix.set(savedMatrix);
                            float scale = (newDist / oldDist);
                            scaleFac = newDist;
                            matrix.postScale(scale, scale, mid.x, mid.y);
                            matrix.invert(matrixInverse);
                        }
                    } else {
                        matrix.set(savedMatrix);
                        float scale = event.getY() / start.y;
                        scaleFac = scale;
                        matrix.postScale(scale, scale, mid.x, mid.y);
                        matrix.invert(matrixInverse);
                    }
                }

                break;
        }


        float[] values = new float[9];
        matrix.getValues(values);


        //int x = ((int)(event.getX() - values[2]*values[Matrix.MSCALE_X]))/(int)values[0];
        //int y = ((int)(event.getY() - values[5]*values[Matrix.MSCALE_Y]))/(int)values[4];

        int x = ((int)(event.getX() / values[Matrix.MSCALE_X] - (values[Matrix.MTRANS_X]/values[Matrix.MSCALE_X])));
        int y = ((int)(event.getY() / values[Matrix.MSCALE_Y] - (values[Matrix.MTRANS_Y]/values[Matrix.MSCALE_Y])));


        invalidate();
        return true;
    }


}