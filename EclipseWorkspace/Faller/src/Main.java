import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Main extends Applet implements Runnable, KeyListener {
	Platform p;
	Ball b;
	
	
	
	
	@Override
	public void init() {
		p = new Platform();
		b = new Ball();
		this.setFocusable(true);
		this.setSize(1500,800);
		addKeyListener(this);
	}
	@Override
	public void start() {
		Thread tMain = new Thread(this);
		tMain.start();
	}
	@Override
	public void run() {
		while (true){
			p.update(this, b);
			b.update(this);
			repaint();
			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public void paint(Graphics g) {
		p.paint(g);
		b.paint(g);
		
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
		case KeyEvent.VK_A:
			p.moveLeft();
			break;
		case KeyEvent.VK_D: 
			p.moveRight(); 
			break;
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		p.slow();
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}
	
	
}
