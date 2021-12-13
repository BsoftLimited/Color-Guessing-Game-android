package com.bsoft.color;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class ColorGame extends Game {
	public static enum Orientation{ Vertical, Horizontal }
	public static interface OrientationChangeListener{ void onOrientationChange(Orientation orientation); }
	private ShapeRenderer renderer;
	private StretchViewport viewport;
	public Orientation orientation;
	private OrientationChangeListener orientationChangeListener;

	public ColorGame(Orientation orientation){
		this.orientation = orientation;
		this.viewport = new StretchViewport(this.getGameWidth(), this.getGameHeight());
	}

	public ColorGame(){ this(Orientation.Horizontal); }

	public ShapeRenderer getRenderer() { return renderer; }
	public Orientation getOrientation() { return orientation; }

	public void flip(){
		this.orientation = orientation == Orientation.Horizontal ? Orientation.Vertical : Orientation.Horizontal;
		if(orientationChangeListener != null){ orientationChangeListener.onOrientationChange(orientation); }
	}

	public void setOrientationChangeListener(OrientationChangeListener orientationChangeListener) {
		this.orientationChangeListener = orientationChangeListener;
	}

	public int getGameWidth(){ return orientation == Orientation.Horizontal ? 800 : 480; }
	public int getGameHeight(){ return orientation == Orientation.Horizontal ? 480 : 800; }

	@Override
	public void create () {
		renderer = new ShapeRenderer();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		viewport.update(width, height);
		renderer.setProjectionMatrix(viewport.getCamera().combined);
	}
	
	@Override
	public void dispose () {
		renderer.dispose();
	}
}
