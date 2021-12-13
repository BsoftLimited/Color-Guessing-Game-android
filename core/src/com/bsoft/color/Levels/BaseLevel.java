package com.bsoft.color.Levels;

import com.badlogic.gdx.Screen;
import com.bsoft.color.ColorGame;
import com.bsoft.color.GameObjects.ColorObject;
import com.bsoft.color.Utils.ObjectManager;
import com.bsoft.color.Utils.TouchHandler;

public abstract class BaseLevel implements Screen, TouchHandler.OnTouchListener {
    private ColorGame game;
    private ObjectManager objectManager;

    public BaseLevel(ColorGame game){
        this.game = game;
        this.objectManager = new ObjectManager(game);
    }

    public ColorGame getGame() {
        return game;
    }

    public ObjectManager getObjectManager() {
        return objectManager;
    }

    @Override
    public void render(float delta) {
        objectManager.render();
        objectManager.update();
    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        objectManager.dispose();
    }
}
