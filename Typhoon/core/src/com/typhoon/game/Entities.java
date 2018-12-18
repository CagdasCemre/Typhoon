package com.typhoon.game;


import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;


public abstract class Entities {
	int health,dmg_point;
	String type;
	
	BodyDef boDef;
	FixtureDef fdef;
	World world;
	public Entities(World world,int h,int dmg,String type) {
		health=h;
		dmg_point=dmg;
		this.type=type;
		
		
		boDef=new BodyDef();
		fdef=new FixtureDef();
		
		
		this.world=world;
	}
	
	
	
	public abstract void create();
	
	
	
	
	
	
	
	
	
	
	
	
}
