package com.kit.weather.animation.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Desc：描述模块内容
 * User: ZhouJing
 * Date: 2016/11/3 10:52
 */
public abstract class Actor {

    protected Context context;

    /**
     * 定义一个矩阵对象
     */
    protected Matrix matrix = new Matrix();

    /**
     * 获取屏幕宽度
     */
    protected float screenWidth;

    /**
     * 获取屏幕高度
     */
    protected float screenHeiht;

    protected Actor(Context context) {
        this.context = context;
    }

    /**
     * 获取屏幕的分辨率
     *
     * @param context
     */
    @SuppressWarnings("unused")
    protected void getViewSize(Context context) {
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(metrics);
        this.screenHeiht = metrics.heightPixels;
        this.screenWidth = metrics.widthPixels;
    }

    public abstract void draw(Canvas canvas, int width, int height);
}
