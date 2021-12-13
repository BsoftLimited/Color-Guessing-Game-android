package com.bsoft.color.Levels;

import com.bsoft.color.ColorGame;
import com.bsoft.color.GameObjects.LiveObject;
import com.bsoft.color.Utils.Util;

public class LevelOne extends BaseLevel{
    public LevelOne(ColorGame game) {
        super(game);
        String[] init = Util.generateColorCode(2, 2);
        for(int i = 0; i < init.length; i++){
            
        }
    }

    @Override
    public void onClick(LiveObject object) {

    }

    @Override
    public void onHover(LiveObject object) {

    }

    @Override
    public void show() {

    }

    @Override
    public void resize(int width, int height) {

    }
}
