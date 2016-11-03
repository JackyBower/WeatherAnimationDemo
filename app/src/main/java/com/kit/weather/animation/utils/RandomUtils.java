package com.kit.weather.animation.utils;

import java.util.Random;

/**
 * Desc：描述模块内容
 * User: ZhouJing
 * Date: 2016/11/3 10:35
 */
public class RandomUtils {

    private static final Random RANDOM = new Random();

    public float getRandom(float lower, float upper) {
        float min = Math.min(lower, upper);
        float max = Math.max(lower, upper);
        return getRandom(max - min) + min;
    }

    public float getRandom(float upper) {
        return RANDOM.nextFloat() * upper;
    }

    public int getRandom(int upper) {
        return RANDOM.nextInt(upper);
    }

}
