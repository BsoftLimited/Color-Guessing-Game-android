package com.bsoft.color.Utils;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Disposable;
import com.bsoft.color.ColorGame;
import com.bsoft.color.GameObjects.GameObject;
import com.bsoft.color.GameObjects.LiveObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectManager implements Disposable {
    private ColorGame colorGame;
    private List<GameObject> gameObjects;

    public ObjectManager(ColorGame colorGame){
        this.colorGame = colorGame;
        gameObjects = new ArrayList<>();
    }

    public void remove(GameObject... gameObjects){
        this.gameObjects.removeAll(Arrays.asList(gameObjects));
    }

    public void add(GameObject... gameObjects){
        this.gameObjects.addAll(Arrays.asList(gameObjects));
    }

    public void render(){
        for(GameObject gameObject : gameObjects){
            gameObject.render(this);
        }
    }

    public void update(){
        for(GameObject gameObject : gameObjects){
            if(gameObject instanceof LiveObject){
                ((LiveObject)gameObject).update();
            }
        }
    }

    public ShapeRenderer getRenderer() {
        return colorGame.getRenderer();
    }

    @Override
    public void dispose() {
        for(GameObject gameObject : gameObjects){
            gameObject.dispose();
        }
    }
}
