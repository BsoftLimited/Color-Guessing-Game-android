package com.bsoft.color.GameObjects;

import com.badlogic.gdx.utils.Disposable;
import com.bsoft.color.Utils.ObjectManager;

public interface GameObject extends Disposable {
    void render(ObjectManager objectManager);
}
