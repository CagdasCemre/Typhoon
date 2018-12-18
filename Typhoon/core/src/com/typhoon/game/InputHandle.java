package com.typhoon.game;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

public class InputHandle extends InputAdapter  {
	Body body;
	Contact c;
	public  boolean a=false;
	public InputHandle(Body body,Contact c) {
		this.body=body;
		this.c=c;
	}
	
	
	@Override
	public boolean keyDown (int keycode) {
		if(keycode==Keys.D)
			body.applyForceToCenter(new Vector2(100f,0f), true);
		if(keycode==Keys.A)
			body.applyForceToCenter(new Vector2(-100f,0f), true);
		if(keycode==Keys.W&&c.isPlayerOnGround()>0) {
			body.applyForceToCenter(new Vector2(0f,200f), true);
			
		}if(keycode==Keys.K)
			a=true;
			
		
		return false;
	}
	@Override
	public boolean keyUp (int keycode) {
		if(keycode==Keys.D||keycode==Keys.A)
			body.setLinearVelocity(0f,0f);
		if(keycode==Keys.K)
			a=false;
		
		return false;
	}


}
