package com.typhoon.game;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;

public class Contact implements ContactListener {

	public int onGround = 0;
	World world;
	InputHandle in;
	Body fbod;
	boolean a = false;

	@Override
	public void beginContact(com.badlogic.gdx.physics.box2d.Contact contact) {
		Fixture fa = contact.getFixtureA();
		Fixture fb = contact.getFixtureB();

		if (fa.getUserData() != null && fa.getUserData().equals("foot")) {
			onGround++;

		}
		if (fb.getUserData() != null && fb.getUserData().equals("foot")) {
			onGround++;

		}
		if ((fb.getUserData() != null && fa.getUserData() != null)
				&& (fb.getUserData().equals("sensorEn") && fa.getUserData().equals("sword"))) {
			a = true;
			fbod = fb.getBody();
		}
		if ((fa.getUserData() != null && fb.getUserData() != null)
				&& (fa.getUserData().equals("sensorEn") && fb.getUserData().equals("sword"))) {
			fbod = fa.getBody();
			a = true;
		}
		if ((fb.getUserData() != null && fa.getUserData() != null)
				&& (fb.getUserData().equals("foot") && fa.getUserData().equals("switch"))) {
			if(fa.getBody()!=null&&fb.getBody()!=null)
			world.destroyBody(fb.getBody()); ;
		}
		if ((fa.getUserData() != null && fa.getBody()!=null&&fb.getBody()!=null)
				&& (fa.getUserData().equals("foot") && fb.getUserData().equals("switch"))) {
			if(fb.getUserData() != null&&fa.getUserData() != null)
			world.destroyBody(fa.getBody()); ;
		
		}

	}

	@Override
	public void endContact(com.badlogic.gdx.physics.box2d.Contact contact) {
		Fixture fa = contact.getFixtureA();
		Fixture fb = contact.getFixtureB();
		if (fa.getUserData() != null && fa.getUserData().equals("foot")) {
			onGround--;
		}
		if (fb.getUserData() != null && fb.getUserData().equals("foot")) {
			onGround--;
		}
		if ((fb.getUserData() != null && fa.getUserData() != null)
				&& (fb.getUserData().equals("sensorEn") && fa.getUserData().equals("sword"))) {
			a = false;

		}
		if ((fa.getUserData() != null && fb.getUserData() != null)
				&& (fa.getUserData().equals("sensorEn") && fb.getUserData().equals("sword"))) {
			a = false;

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
