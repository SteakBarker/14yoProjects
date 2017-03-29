import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class Ball {
	
	int x=200, y=0;
	int rad=30;
	int dx=1, dy=3;
	public int setdy;
	
	
	
	
	public void update(Main m){
		
		
		
		x += dx;
		y += dy;
	}
	
	public void paint(Graphics g){
		g.setColor(Color.BLUE);
		g.fillOval(x-rad, y-rad, rad*2, rad*2);
	}
	public int getRad(){
		return rad;
		
	}
	public int getX(){
		return x;
	}

	public int getY() {
		return y;
	}
	public int getdy(){
		return(dy);
	}

	public void setdy(int sdy) {
		dy = sdy;
	}
}
