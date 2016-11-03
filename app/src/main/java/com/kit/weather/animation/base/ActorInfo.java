package com.kit.weather.animation.base;

import android.graphics.Bitmap;
import android.graphics.Paint;

/**
 * Desc：描述模块内容
 * User: ZhouJing
 * Date: 2016/11/3 10:56
 */
public class ActorInfo {

    //图片
    Bitmap bitmap;
    //定义一个画笔
    Paint paint;
    //开始飘落的横坐标
    float x;
    //开始飘落的纵坐标
    float y;
    //下落的速度
    float speed;
    //下落时偏移的值
    float offset;

    public ActorInfo(Bitmap bitmap, float x, float y, float speed, float offset) {
        this.bitmap = bitmap;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.offset = offset;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getOffset() {
        return offset;
    }

    public void setOffset(float offset) {
        this.offset = offset;
    }
}
