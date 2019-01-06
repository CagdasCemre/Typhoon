package com.typhoon.game;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;

public class Animations {
	Body body;
	Texture image;
	TextureRegion [] animationFrames;
	String imgpath;
	Animation<TextureRegion> animation;
	SpriteBatch batch;
	public Animations(Body b,String imgpath,float posx,float posy) {
		body=b;
		this.imgpath=imgpath;
		animationFrames=new TextureRegion[3];
		batch=new SpriteBatch();
		image=new Texture(imgpath);
		this.animate(posx, posy);
	}
	
	public void splitImage(Texture iMg){
		
		TextureRegion[][] tmpAnim=TextureRegion.split(iMg, 32, 32);
		int	index=0;
		
		for(int i=0;i<3;i++) {
			animationFrames[index++]=tmpAnim[0][i];
		}
		
		
		
	}
	
	public void animate(float x,float y) {
		splitImage(image);
		animation=new Animation<TextureRegion>(1f/3f,animationFrames);
		//System.out.println(animation.getKeyFrameIndex(TyphoonVars.dt));
		batch.begin();
		batch.draw(animation.getKeyFrame(TyphoonVars.dt,true),(x*TyphoonVars.PPM), (y*TyphoonVars.PPM),100f,100f);
		batch.end();
	}
	
	
	
	
}
