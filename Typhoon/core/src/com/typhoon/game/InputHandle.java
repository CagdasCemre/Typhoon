package com.typhoon.game;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;


public class InputHandle extends InputAdapter {
	Body body;
	Contact c;
	World w;
	 public InputHandle(Body b,Contact con,World world) {
	body=b;
	c=con;
	w=world;
	}
	
	
	@Override
	public boolean keyDown (int keycode) {
		if(keycode==Keys.D)
			body.applyForceToCenter(new Vector2(100f,0f), true);
			
		if(keycode==Keys.A)
			body.applyForceToCenter(new Vector2(-100f,0f), true);
		if(keycode==Keys.W&&c.isPlayerOnGround()>0) {
			body.applyForceToCenter(new Vector2(0f,200f), true);
			
		}if(keycode==Keys.K &&c.a) { 
			w.destroyBody(c.fbod);
		}
			
		return false;
	}
	@Override
	public boolean keyUp (int keycode) {
		if(keycode==Keys.D||keycode==Keys.A)
			body.setLinearVelocity(0f,0f);
			
		
		return false;
	}


}
