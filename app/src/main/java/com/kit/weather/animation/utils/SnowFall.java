package com.kit.weather.animation.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.kit.weather.animation.base.ActorInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Desc：描述模块内容
 * User: ZhouJing
 * Date: 2016/11/3 10:53
 */
public class SnowFall extends Actor {

    private List<XMLActorData> listXMLData = null;
    Paint paint = new Paint();
    private Bitmap bitmap_snows[] = null;
    private static Random random = new Random();
    //随机位置的雪花对象
    private static final int NUM_SNOWFLAKES = 55;

    private ArrayList<ActorInfo> snowflake = new ArrayList<ActorInfo>();

    private ArrayList<ActorInfo> snowflake_xl = new ArrayList<ActorInfo>();
    private ArrayList<ActorInfo> snowflake_m = new ArrayList<ActorInfo>();
    private ArrayList<ActorInfo> snowflake_s = new ArrayList<ActorInfo>();
    private ArrayList<ActorInfo> snowflake_l = new ArrayList<ActorInfo>();

    @SuppressWarnings("static-access")
    protected SnowFall(Context context) {
        super(context);
        // 设置是否使用抗锯齿功能，会消耗较大资源，绘制图形速度会变慢
        paint.setAntiAlias(false);
        // 如果该项设置为true，则图像在动画进行中会滤掉对Bitmap图像的优化操作，加快显示速度，本设置项依赖于dither和xfermode的设置
        paint.setFilterBitmap(true);
        // 设定是否使用图像抖动处理，会使绘制出来的图片颜色更加平滑和饱满，图像更加清晰
        paint.setDither(true);
        try {
            listXMLData = SaxService.getInstance().readXML(context, "weather_scene_slight_snow_day.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
        getViewSize(context);
        loadRainImage(context);
        addRandomRain();
    }

    @Override
    public void draw(Canvas canvas, int width, int height) {
        try {
            if (canvas != null) {
                drawRain(canvas);
                ActorInfo rain = null;
                for (int k = 0; k < NUM_SNOWFLAKES; k++) {
                    rain = snowflake_xl.get(k);
                    snowDown(rain);
                    rain = snowflake_m.get(k);
                    snowDown(rain);
                    rain = snowflake_s.get(k);
                    snowDown(rain);
                    rain = snowflake_l.get(k);
                    snowDown(rain);
                }
            }
            Thread.sleep(25);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @SuppressLint("NewApi")
    public void drawRain(Canvas canvas) {
        ActorInfo rain = null;
        for (int k = 0; k < NUM_SNOWFLAKES; k++) {
            rain = snowflake_xl.get(k);
            canvas.drawBitmap(rain.getBitmap(), rain.getX(), rain.getY(), paint);
            rain = snowflake_m.get(k);
            canvas.drawBitmap(rain.getBitmap(), rain.getX(), rain.getY(), paint);
            rain = snowflake_s.get(k);
            canvas.drawBitmap(rain.getBitmap(), rain.getX(), rain.getY(), paint);
            rain = snowflake_l.get(k);
            canvas.drawBitmap(rain.getBitmap(), rain.getX(), rain.getY(), paint);
        }
    }

    /**
     * 把图片加载到内存汇中
     *
     * @param context
     */
    private void loadRainImage(Context context) {
        if (listXMLData != null && listXMLData.size() > 0) {
            bitmap_snows = new Bitmap[listXMLData.size()];
        }
        for (int i = 0; i < listXMLData.size(); i++) {
            bitmap_snows[i] = BitmapFactory.decodeResource(context.getResources(), getResId(listXMLData.get(i).getActorName()));
        }
    }

    public void addRandomRain() {

        for (int k = 0; k < NUM_SNOWFLAKES; k++) {
            snowflake_xl.add(new ActorInfo(bitmap_snows[3], random.nextFloat()
                    * screenWidth, random.nextFloat() * screenHeiht,
                    listXMLData.get(3).getSpeed() / 100,
                    1 - random.nextFloat() * 2));
            snowflake_m.add(new ActorInfo(bitmap_snows[2], random.nextFloat()
                    * screenWidth, random.nextFloat() * screenHeiht,
                    listXMLData.get(2).getSpeed() / 100,
                    1 - random.nextFloat() * 2));
            snowflake_s.add(new ActorInfo(bitmap_snows[1], random.nextFloat()
                    * screenWidth, random.nextFloat() * screenHeiht,
                    listXMLData.get(1).getSpeed() / 100,
                    1 - random.nextFloat() * 2));
            snowflake_l.add(new ActorInfo(bitmap_snows[0], random.nextFloat()
                    * screenWidth, random.nextFloat() * screenHeiht,
                    listXMLData.get(0).getSpeed() / 100,
                    1 - random.nextFloat() * 2));
        }
    }

    /**
     * 雨下落
     *
     * @param snow
     */
    private void snowDown(ActorInfo snow) {
        // 雨的落出屏幕后又让它从顶上下落
        if (snow.getX() > screenWidth || snow.getY() > screenHeiht) {
            snow.setY(0);
            snow.setX(random.nextFloat() * screenWidth);
        }
        snow.setX(snow.getX() + snow.getOffset());// 下落飘的偏移量
        snow.setY(snow.getY() + snow.getSpeed());// 下落的速度
    }

    private int getResId(String resName) {
        int drawable = 0;
        Resources resources = context.getResources();
        int indentify = resources.getIdentifier(context.getPackageName()
                + ":drawable/" + resName, null, null);
        /*if (indentify > 0) {
			drawable = resources.getDrawable(indentify);
		}*/
        return indentify;
    }
}
