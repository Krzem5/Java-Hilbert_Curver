package com.krzem.hilbert_curver;



import java.awt.Graphics2D;



public class Engine extends Constants{
	public Main cls;
	public HilbertCurve hc;



	public Engine(Main cls){
		this.cls=cls;
		this.hc=new HilbertCurve(2,6);
	}



	public void update(){

	}



	public void draw(Graphics2D g){
		g.translate((Math.min(WINDOW_SIZE.width,WINDOW_SIZE.height)==WINDOW_SIZE.height?WINDOW_SIZE.width/2-WINDOW_SIZE.height/2:0),(Math.min(WINDOW_SIZE.width,WINDOW_SIZE.height)==WINDOW_SIZE.width?WINDOW_SIZE.height/2-WINDOW_SIZE.width/2:0));
		this.hc.draw(g,Math.min(WINDOW_SIZE.width,WINDOW_SIZE.height),Math.min(WINDOW_SIZE.width,WINDOW_SIZE.height));
	}
}