import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class main {
	private static JFrame Jmainframe;
	private static JPanel p1;
	private static JLabel Label1;
	
	public main(){
		gui();
	}
	public static void gui(){
	    Jmainframe = new JFrame("Image test");
		Jmainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Jmainframe.setSize(500,200);
		p1 = new JPanel();
		ImageIcon image = new ImageIcon("test.jpg");
		Label1 = new JLabel(image);
		Label1 = new JLabel();
		
		p1.add(Label1);
		Jmainframe.add(p1);
		Jmainframe.setVisible(true);;
	}
	
	public static void main(String[] args) {
		
		new main();
		
		
	}

}
