package com.typhoon.game;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

public class Switch {

	
	public static void create(World world) {
		Body body;
		BodyDef bdef=new BodyDef();
		FixtureDef fdef= new FixtureDef();
		PolygonShape shape= new PolygonShape();

		for(MapObject a:MapEd.tmap.getLayers().get("Switch").getObjects()) {
			Rectangle rec=((RectangleMapObject) a).getRectangle();
			
			bdef.type=BodyType.StaticBody;
			bdef.position.set(new Vector2((rec.getX()+rec.getWidth()/2)/TyphoonVars.PPM,(rec.getY()+rec.getHeight()/2)/TyphoonVars.PPM));
		
			
			body=world.createBody(bdef);
			
			shape.setAsBox((float)rec.getWidth()/2/TyphoonVars.PPM,(float)rec.getHeight()/2/TyphoonVars.PPM);
			
			fdef.shape=shape;
			
			body.createFixture(fdef);
			
			//foot
			shape.setAsBox(10/TyphoonVars.PPM  , 2/TyphoonVars.PPM  , new Vector2(0/TyphoonVars.PPM, 15/TyphoonVars.PPM ), 0);
			fdef.shape = shape;
			fdef.isSensor = true;
		body.createFixture(fdef).setUserData("switch");;
	//
			

		}

	}
}
