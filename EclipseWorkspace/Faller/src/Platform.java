import java.awt.Color;
import java.awt.Graphics;


public class Platform {
	
	private int maxSpeed = 20;
	
	private int x= 600, y=900;
	private int width=150, height=10;
	private int dx, dy;
	
	
	public void update(Main m, Ball b){
		
		int mWidth = m.getWidth();
		if ( x > m.getWidth() + 20){
			x = -290;
		}
		if ( x < -290 ){
			x = mWidth + 20;
		}
		x += dx;
	}
	public void paint(Graphics g){
		g.setColor(Color.RED);
		g.fillRect(x-height, y-width, width*2, height*2);
		
	}
	
	
	public void moveRight(){
		if ( dx <= maxSpeed){
			dx+= 2;
		}
	}
	public void moveLeft(){
		if ( dx >= -maxSpeed){
			dx+= -2;
		}
	}
	public void slow(){
		
		Thread slow = new Thread(){
			public void run(){
		boolean loop = true;
		while(loop){
			if (dx == 0){
				loop = false;
				break;
			}
			if ( dx > 0){
				dx--;
			}
			if ( dx < 0){
				dx++;
			}
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		}
		};
		slow.start();
		
	}
}