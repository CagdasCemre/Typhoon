package com.typhoon.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

public class Contact implements ContactListener {

	public int onGround=0;
	World world;
	InputHandle in;
	Array<Body> enemyRemove=new Array<Body>();
	public Contact (World world,Body body) {
		this.world=world;
		in=new InputHandle(body, this);
		Gdx.input.setInputProcessor(in);
	}
	
	@Override
	public void beginContact(com.badlogic.gdx.physics.box2d.Contact contact) {
		Fixture	fa = contact.getFixtureA();
		Fixture fb = contact.getFixtureB();

		if (fa.getUserData() != null && fa.getUserData().equals("foot")) {
			onGround++;
			
		}
		if (fb.getUserData() != null && fb.getUserData().equals("foot")) {
			onGround++;
		
		}if ((fb.getUserData() != null && fa.getUserData()!=null)&&(fb.getUserData().equals("sensorEn")&&fa.getUserData().equals("sword"))) {
			enemyRemove.add(fb.getBody());
			System.out.println(fb+" "+fa);
		}	
		if ((fa.getUserData() != null && fb.getUserData()!=null)&&(fa.getUserData().equals("sensorEn")&&fb.getUserData().equals("sword"))) {
			enemyRemove.add(fa.getBody());
			
			
		}	

	}

	@Override
	public void endContact(com.badlogic.gdx.physics.box2d.Contact contact) {
		Fixture	fa = contact.getFixtureA();
		Fixture fb = contact.getFixtureB();
		if (fa.getUserData() != null && fa.getUserData().equals("foot")) {
			onGround--;
		}
		if (fb.getUserData() != null && fb.getUserData().equals("foot")) {
			onGround--;
		}

	}

	@Override
	public void preSolve(com.badlogic.gdx.physics.box2d.Contact contact, Manifold oldManifold) {
	}
	@Override
	public void postSolve(com.badlogic.gdx.physics.box2d.Contact contact, ContactImpulse impulse) {
	}

	public int isPlayerOnGround() {
	return onGround;
	}

	
	

}
