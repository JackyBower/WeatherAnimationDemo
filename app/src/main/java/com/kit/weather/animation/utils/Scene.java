package com.kit.weather.animation.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc：描述模块内容
 * User: ZhouJing
 * Date: 2016/11/3 11:09
 */
public class Scene {

    private Context context;
    private int width;
    private int height;

    private Bitmap bg;
    private List<Actor> actors = new ArrayList<Actor>();
    private Paint paint;

    public Scene(Context context) {
        this.context = context;
        paint = new Paint();
        paint.setAntiAlias(true);
    }

    public void setBg(Bitmap bg) {
        this.bg = bg;
    }

    public void add(Actor actor) {
        actors.add(actor);
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(bg, new Rect(0, 0, bg.getWidth(), bg.getHeight()), new Rect(0, 0, width, height), paint);
        for (Actor actor : actors) {
            actor.draw(canvas, width, height);
        }
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
