import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Jmainframe {
	
	public static JFrame Jmainframe;
	
	public static JPanel Pl1;
	public static JPanel Pl2;
	public static JPanel Pl3;
	
	public static JPanel P1;
	public static JPanel P2;
	public static JPanel P3;
	
	
	
	public Jmainframe(){
		frame();
	}
	public static void frame(){
		
		Jmainframe = new JFrame("Reflexz v" + Main.ver);
		Jmainframe.setSize(400,600);
		Jmainframe.setLocationRelativeTo(null);
		
		Jmainframe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		Jmainframe.addWindowListener(new WindowAdapter() {
			 public void windowClosing(WindowEvent event) {
		            exit();
		        }
		});
		
		Pl1 = new JPanel();
		Pl2 = new JPanel();
		Pl3 = new JPanel();
		P1 = new JPanel();
		P2 = new JPanel();
		P3 = new JPanel();
		
		JButton B1 = new JButton("BANG");
		JButton B2 = new JButton("BANG");
		JButton B3 = new JButton("BANG");
		B1.setFont(new Font("Serif", Font.PLAIN, 24));
		B1.setPreferredSize(new Dimension(200, 300));
		B2.setFont(new Font("Serif", Font.PLAIN, 24));
		B2.setPreferredSize(new Dimension(200, 300));
		B3.setFont(new Font("Serif", Font.PLAIN, 24));
		B3.setPreferredSize(new Dimension(200, 300));
		
		
		
		P1.add(B1);
		P2.add(B2);
		P3.add(B3);
		
		Pl1.setBackground(Color.RED);
		Pl2.setBackground(Color.YELLOW);
		Pl3.setBackground(Color.GREEN);
		
		
		Jmainframe.add(Pl1);
		Jmainframe.add(Pl2);
		Jmainframe.add(Pl3);
		Jmainframe.add(P1);
		Jmainframe.add(P2);
		Jmainframe.add(P3);
		
		
		
		
		Jmainframe.setLayout ( new GridLayout(2,3));
		Jmainframe.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		
		new Jmainframe();
		
		

	}
	public static void exit(){
		System.exit(1);
	}
}
