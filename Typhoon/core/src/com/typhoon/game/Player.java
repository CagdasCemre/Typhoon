package com.typhoon.game;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;


public class Player extends Entities {
	Vector2 pPos;
	Body pBody;
	Animations heroAnim;
	public Player(World world,int h, int dmg, String type) {
		super(world,h, dmg, type);
		this.create();
	}

	@Override
	public void create() {
		boDef=new BodyDef();
		fdef=new FixtureDef();
		pPos=new Vector2(30f/TyphoonVars.PPM, 115.0f/TyphoonVars.PPM);
		boDef.type=BodyType.DynamicBody;
		boDef.position.set(pPos);
		pBody=world.createBody(boDef);
	
	PolygonShape shape = new PolygonShape();
	shape.setAsBox(10/TyphoonVars.PPM, 20/TyphoonVars.PPM );
	
	fdef.shape = shape;
	fdef.friction = 0f;
pBody.createFixture(fdef).setUserData(type);
	
			//foot
			shape.setAsBox(10/TyphoonVars.PPM  , 2/TyphoonVars.PPM  , new Vector2(0/TyphoonVars.PPM, -20/TyphoonVars.PPM ), 0);
			fdef.shape = shape;
			fdef.isSensor = true;
pBody.createFixture(fdef).setUserData("foot");;
	//
		//Sword
		shape.setAsBox(10/TyphoonVars.PPM  , 2/TyphoonVars.PPM  , new Vector2(pBody.getPosition().x/TyphoonVars.PPM+15/TyphoonVars.PPM, pBody.getPosition().x/TyphoonVars.PPM ), 0);
		fdef.shape=shape;
		fdef.isSensor=true;
Fixture sword= pBody.createFixture(fdef);
		sword.setUserData("sword");
		//
		
	
	}
	public void animCrt_RUN() {
		heroAnim=new Animations(pBody,"C:\\Users\\Lenovo\\Desktop\\Typhoon\\core\\assets\\Hero Sprite.png",pBody.getPosition().x,pBody.getPosition().y);
		//System.out.println(pBody.getPosition().x+" y:"+ pBody.getPosition().y);
	}
	
	
	
	
	

}
