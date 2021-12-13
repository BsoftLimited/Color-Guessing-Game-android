package com.bsoft.color.Utils;

public abstract class Boundary {
    protected float x, y;

    protected Boundary(float x, float y){
        this.x = x;
        this.y = y;
    }

    public float getX() { return x; }
    public float getY() { return y; }

    public void setX(float x) { this.x = x; }
    public void setY(float y) { this.y = y; }
    public void setPosition(float x, float y){
        this.x = x;
        this.y = y;
    }

    public abstract boolean isInSide(float x, float y);
}
