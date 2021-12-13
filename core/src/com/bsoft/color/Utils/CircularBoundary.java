package com.bsoft.color.Utils;

public class CircularBoundary extends Boundary{
    float radius;

    public CircularBoundary(float radius, float x, float y){
        super(x, y);
        this.radius = radius;
    }

    @Override
    public boolean isInSide(float x, float y) {
        return (x >= this.x + radius && x <= this.x + radius) && (y >= this.y + radius && y <= this.y + radius);
    }

    public float getRadius() { return radius; }
    public void setRadius(float radius) { this.radius = radius; }
}
