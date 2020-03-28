package com.krzem.hilbert_curver;



import java.awt.Graphics2D;
import java.lang.Math;



public class HilbertCurve{
	private int d;
	private int i;



	public HilbertCurve(int d,int i){
		this.d=d;
		this.i=i;
	}



	public int len(){
		return (int)Math.pow(2,this.d*this.i);
	}



	public int max_pos(){
		return (int)Math.pow(2,this.i);
	}



	public int[][] data(){
		int[][] dt=new int[this.len()][this.d];
		for (int i=0;i<this.len();i++){
			dt[i]=this.point(i);
		}
		return dt;
	}



	public int[] point(int h){
		String bs=Integer.toBinaryString(h);
		while (bs.length()<this.d*this.i){
			bs="0"+bs;
		}
		int[] x=new int[this.d];
		for (int i=0;i<this.d;i++){
			String bl="";
			for (int j=i+0;j<bs.length();j+=this.d){
				bl+=String.valueOf(bs.charAt(j));
			}
			x[i]=Integer.parseInt(bl,2);
		}
		int t=x[this.d-1]>>1;
		for (int i=this.d-1;i>0;i--){
			x[i]^=x[i-1];
		}
		x[0]^=t;
		int q=2;
		int z=2<<(this.i-1);
		while (q!=z){
			int p=q-1;
			for (int i=this.d-1;i>=0;i--){
				if ((x[i]&q)>=1){
					x[0]^=p;
				}
				else{
					t=(x[0]^x[i])&p;
					x[0]^=t;
					x[i]^=t;
				}
			}
			q<<=1;
		}
		return x;
	}



	public void draw(Graphics2D g,int w,int h){
		int[][] dt=this.data();
		int mx=this.max_pos()-1;
		for (int i=0;i<dt.length-1;i++){
			g.drawLine((int)this._map(dt[i][0],0,mx,0,w),(int)this._map(dt[i][1],0,mx,0,h),(int)this._map(dt[i+1][0],0,mx,0,w),(int)this._map(dt[i+1][1],0,mx,0,h));
		}
	}



	private double _map(double v,double aa,double ab,double ba,double bb){
		return (v-aa)/(ab-aa)*(bb-ba)+ba;
	}
}