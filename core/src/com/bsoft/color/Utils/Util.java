package com.bsoft.color.Utils;

import com.badlogic.gdx.graphics.Color;

import java.util.Random;

public class Util {
    public static String[] generateColorCode(int count, int difficulty){
        String[] init = new String[count];
        Random random = new Random();
        int red = random.nextInt(255);
        int green = random.nextInt(255);
        int blue = random.nextInt(255);

        init[0] = Integer.toHexString( Color.toIntBits(red, green, blue, 255));
        for(int i = 1; i < count; i++){
            int initRed = clamp (0, 255, red + (127 - random.nextInt( ((12 - difficulty) / 10) * 255)));
            int initGreen = clamp (0, 255, green + (127 - random.nextInt( ((12 - difficulty) / 10) * 255)));
            int initBlue = clamp (0, 255, blue + (127 - random.nextInt( ((12 - difficulty) / 10) * 255)));
            init[i] = Integer.toHexString( Color.toIntBits(initRed, initGreen, initBlue, 255));
        }
        return init;
    }

    public static int clamp(int lowest, int highest, int value){
        if(value <= lowest) return  lowest;
        if(value >= highest ) return highest;
        return value;
    }
}
