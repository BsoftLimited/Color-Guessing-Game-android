package com.bsoft.color.Utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.bsoft.color.ColorGame;
import com.bsoft.color.GameObjects.GameObject;
import com.bsoft.color.GameObjects.LiveObject;

public class TouchHandler implements InputProcessor {
    public static interface OnTouchListener{
        void onClick(LiveObject object);
        void onHover(LiveObject object);
    }

    private static InputMultiplexer inputHandler;
    private ColorGame game;
    private float xScale, yScale, initscreenX, initScreenY;
    OnTouchListener listener;
    LiveObject object;

    public TouchHandler(ColorGame game, OnTouchListener listener, LiveObject object){
        this.listener = listener;
        this.object = object;
        this.game = game;
        xScale = ((float) Gdx.graphics.getWidth())/game.getGameWidth();
        yScale = ((float)Gdx.graphics.getHeight())/game.getGameHeight();
        initScreenY = 0; initscreenX = 0;
        if(inputHandler == null){
            inputHandler = new InputMultiplexer();
            Gdx.input.setInputProcessor(inputHandler);
        }
        inputHandler.addProcessor(this);
    }

    public void destroy(){
        if(inputHandler != null){ inputHandler.removeProcessor(this);}
    }
    public static void dispose(){ inputHandler = null; }

    @Override
    public boolean touchDown(int screenX, int screenY, int p3, int p4){
        if(object.getBoundary().isInSide(screenX / xScale, game.getGameHeight() - (screenY / yScale))){
            listener.onClick(object);
            return true;
        }
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer){
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pionter, int button){
        return false;
    }

    @Override
    public boolean keyTyped(char p1){
        return false;
    }

    @Override
    public boolean keyUp(int p1){ return false; }

    @Override
    public boolean keyDown(int key) {
        if(Input.Buttons.LEFT == key){
            if(object.getBoundary().isInSide(initscreenX / xScale, game.getGameHeight() - (initScreenY / yScale))){
                listener.onClick(object);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        if(object.getBoundary().isInSide(screenX / xScale, game.getGameHeight() - (screenY / yScale))){
            listener.onHover(object);
            initscreenX = screenX;
            initScreenY = screenY;
            return true;
        }
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) { return false; }
}
