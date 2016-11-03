package com.kit.weather.animation.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.kit.weather.animation.utils.RenderThread;

/**
 * Desc：描述模块内容
 * User: ZhouJing
 * Date: 2016/11/3 11:13
 */
public class SceneSurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    private RenderThread renderThread;
    private SurfaceHolder surfaceHolder;

    public SceneSurfaceView(Context context) {
        super(context);
    }

    public SceneSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);

        setFocusable(true);
        setFocusableInTouchMode(true);
        this.setKeepScreenOn(true);
    }

    public SceneSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);

        setFocusable(true);
        setFocusableInTouchMode(true);
        this.setKeepScreenOn(true);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Log.d("weather", "surfaceCreated");
        if (renderThread == null) {
            renderThread = new RenderThread(surfaceHolder, getContext());
            renderThread.start();
        }
    }

    int width;
    int height;

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        width = getMeasuredWidth();
        height = getMeasuredHeight();
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.d("weather", "onMeasure width=" + width + ",height=" + height);
        if (renderThread != null) {
            renderThread.setWidth(width);
            renderThread.setHeight(height);
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        Log.d("weather", "surfaceChanged");
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        Log.d("weather", "surfaceDestroyed");
        renderThread.getRenderHandler().sendEmptyMessage(1);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        Log.d("weather", "onFinishInflate");
    }
}

