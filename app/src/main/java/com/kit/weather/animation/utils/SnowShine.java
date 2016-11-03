package com.kit.weather.animation.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.Log;

import com.kit.weather.animation.R;

/**
 * Desc：描述模块内容
 * User: ZhouJing
 * Date: 2016/11/3 11:10
 */
public class SnowShine extends Actor {

    float initPositionX;
    float initPositionY;
    boolean isInit;
    Bitmap frame;
    RectF box;
    RectF targetBox;
    Paint paint = new Paint();
    int alpha;
    boolean alphaUp = true;

    protected SnowShine(Context context) {
        super(context);
        box = new RectF();
        targetBox = new RectF();
        paint.setAntiAlias(true);
    }

    @Override
    public void draw(Canvas canvas, int width, int height) {
        //逻辑处理
        //初始化
        if (!isInit) {
            Log.d("weather", "cloud init");
            initPositionX = width * 0.34F;
            initPositionY = height * 0.22F;
            frame = BitmapFactory.decodeResource(context.getResources(), R.drawable.snow_light);
            matrix.reset();
            matrix.setScale(1.3f, 1.3f);
            matrix.mapRect(targetBox, box);
            matrix.postTranslate(targetBox.width(), 0);
            isInit = true;
            return;
        }
        //移动
//        matrix.postTranslate(0.5F, 0);
        //边界处理
        matrix.mapRect(targetBox, box);
        if (targetBox.left > width) {
            matrix.postTranslate(-targetBox.right, 0);
        }
        //绘制
        canvas.drawBitmap(frame, matrix, paint);
    }
}
