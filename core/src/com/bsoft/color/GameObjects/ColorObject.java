package com.bsoft.color.GameObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.bsoft.color.Utils.Boundary;
import com.bsoft.color.Utils.CircularBoundary;
import com.bsoft.color.Utils.ObjectManager;

public class ColorObject implements LiveObject{
    private Color color;
    private CircularBoundary boumdary;
    private float newRadius;

    public ColorObject(String hexCode, float radius){
        this.color = Color.valueOf(hexCode);
        this.boumdary = new CircularBoundary(radius, 0, 0);
        this.newRadius = radius;
    }

    public void setPosition(float x, float y){
        this.boumdary.setPosition(x, y);
    }

    @Override
    public Boundary getBoundary() { return boumdary; }

    public void setPositionX(float positionX) { this.boumdary.setX(positionX); }
    public void setPositionY(float positionY) { this.boumdary.setY(positionY); }
    public void setColor(Color color) { this.color = color; }
    public void setRadius(float radius) { this.boumdary.setRadius(radius); }
    public Color getColor() { return color; }
    public String getColorCode(){ return color.toString(); }

    @Override
    public void render(ObjectManager objectManager) {
        objectManager.getRenderer().begin(ShapeRenderer.ShapeType.Filled);
        objectManager.getRenderer().setColor(color);
        objectManager.getRenderer().circle(boumdary.getX(), boumdary.getY(), this.boumdary.getRadius());
        objectManager.getRenderer().end();
    }

    public void resize(float newRadius){
        this.newRadius = newRadius;
    }

    @Override
    public void update() {
        if(newRadius != boumdary.getRadius()){
            boumdary.setRadius(boumdary.getRadius() + (newRadius - boumdary.getRadius()) * Gdx.graphics.getDeltaTime());
        }
    }

    @Override
    public void dispose() {

    }
}
