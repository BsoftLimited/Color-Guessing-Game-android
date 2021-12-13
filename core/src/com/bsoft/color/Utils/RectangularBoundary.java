package com.bsoft.color.Utils;

public class RectangularBoundary extends Boundary{
    float with, height;

    public RectangularBoundary(float x, float y, float width, float height){
        super(x, y);
        this.with = width;
        this.height = height;
    }

    public float getWith() { return with; }
    public float getHeight() { return height; }

    public void setWith(float with) { this.with = with; }
    public void setHeight(float height) { this.height = height; }

    @Override
    public boolean isInSide(float x, float y) {
        return (x >= this.x && x <= this.with) && (y >= this.y && y <= this.height);
    }
}
