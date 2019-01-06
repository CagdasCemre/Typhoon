package com.typhoon.game;




import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class MapEd {

public static TiledMap tmap;
OrthogonalTiledMapRenderer tilerend;


public MapEd(World world) {
	this.mapLoad();
	this.mapObLoad(world);
	
}

public void mapLoad() {
tmap=new TmxMapLoader().load("C:\\Users\\Lenovo\\Desktop\\Typhoon\\core\\assets\\Test Map\\Test.tmx");

tilerend=new OrthogonalTiledMapRenderer(tmap);

}

public void mapObLoad(World world) {
	Body body;
	BodyDef bdef=new BodyDef();
	FixtureDef fdef= new FixtureDef();
	PolygonShape shape= new PolygonShape();

	for(MapObject a:tmap.getLayers().get("Ground").getObjects()) {
		Rectangle rec=((RectangleMapObject) a).getRectangle();
		
		bdef.type=BodyType.StaticBody;
		bdef.position.set(new Vector2((rec.getX()+rec.getWidth()/2)/TyphoonVars.PPM,(rec.getY()+rec.getHeight()/2)/TyphoonVars.PPM));
	
		
		body=world.createBody(bdef);
		
		shape.setAsBox((float)rec.getWidth()/2/TyphoonVars.PPM,(float)rec.getHeight()/2/TyphoonVars.PPM);
		
		fdef.shape=shape;
		
		body.createFixture(fdef).setUserData("ground");
		
		
		Switch.create(world);
	}
}

public OrthogonalTiledMapRenderer getTilerend() {
	return tilerend;
}

	


}
