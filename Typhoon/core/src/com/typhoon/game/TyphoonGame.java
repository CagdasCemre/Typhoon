package com.typhoon.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

public class TyphoonGame extends Game {
	World world;
	Box2DDebugRenderer dbug;
	OrthographicCamera cam;
	
	Player hero;
	Enemy bad;
	
	MapEd map;
	
	Contact c;
	@Override
	public void create () {
	world=new World(new Vector2(0,-9.81f), true);
	dbug=new Box2DDebugRenderer();
	
	cam=new OrthographicCamera();
	cam.setToOrtho(false, Gdx.graphics.getWidth()/TyphoonVars.PPM, Gdx.graphics.getHeight()/TyphoonVars.PPM );

	map=new MapEd(world);
	hero=new Player(world, 100, 100, "hero");
	bad=new Enemy(world, 100, 100, "enemy");
	
	c=new Contact(world,hero.pBody);
	world.setContactListener(c);
	

	}
	public void update() {
		if(c.in.a) {
		for(Body a:c.enemyRemove) {
		world.destroyBody(a);	
		}
		c.enemyRemove.clear();
		}
	}

	@Override
	public void render () {
		Gdx.gl20.glClearColor(0, 0, 0, 1);
		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
		world.step(1/60f, 6, 2);
		
		
		
		cam.update();
		cam.position.set(hero.pBody.getPosition(),0f);
		
		
		dbug.render(world, cam.combined);
		
		map.tilerend.setView(cam);
		map.tilerend.render();
		
		update();
	}
	
	@Override
	public void dispose () {
		
	}
}
