package com.bsoft.color.GameObjects;

import com.bsoft.color.Utils.Boundary;

public interface LiveObject extends GameObject{
    void update();
    Boundary getBoundary();
}
