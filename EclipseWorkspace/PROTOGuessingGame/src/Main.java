import javax.swing.*;

import java.awt.*;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main {
	
	int life = 6;
	int diff = 100;
	Random ran = new Random();
	int rannum = ran.nextInt(diff);
	String lastguess = "Make a guess between 0 / 100";
	
	private Color randomColor;
	private JFrame frame;
	private JTextField text;
	private JPanel p1;
	private JButton b1;
	private JLabel Jlastguess;
	private JLabel Jlives;
	private JPanel p2;
	private JPanel p3;
	private JPanel p4;
	private JButton Jcredits;
	
	
	public Main() {
		gui();	
	}
	
	public void gui() {
		
		
		
		frame = new JFrame("Matts Guess v0.02");
		frame.setSize(500,150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		frame.setLayout ( new FlowLayout());
		
		b1 = new JButton("Check");
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String input = text.getText();
				int guess = Integer.parseInt(input);
				
				if (guess > rannum) {
					life = life -1;
					lastguess = "high!";
					JOptionPane.showMessageDialog(null, "Your guess of " + guess + " was to high!");
				} else if ( guess < rannum ) {
					life = life -1;
					lastguess = "low!";
					JOptionPane.showMessageDialog(null, "Your guess was of " + guess + " was to low!");
				} else if ( guess == rannum) {
					JOptionPane.showMessageDialog(null, "YOU WIN!  The number was " + rannum + " And you won with " + life + " lives left!");
					System.exit(1);
				}
					
					
				if (life <= 0 ){
					JOptionPane.showMessageDialog(null, "Your lives has hit 0, You loss! The number was " + rannum);
					System.exit(1);
				}
				int R = (int) (Math.random( )*256);
				int G = (int)(Math.random( )*256);
				int B= (int)(Math.random( )*256);
				Color randomColor = new Color(R, G, B, 0x65);

						p1.setBackground(randomColor);
						p2.setBackground(randomColor);
						p3.setBackground(randomColor);
						p4.setBackground(randomColor);
						frame.setBackground(randomColor);
						frame.repaint();
				text.setText("");
				Jlives.setText("Lives: " + life);
				Jlastguess.setText("Your last guess of " + guess + " was to " + lastguess);
			}});
		
		text = new JTextField(30);
		Jlives = new JLabel("Lives: " + life);
		Jlastguess = new JLabel (lastguess);
		Jcredits = new JButton("Credits");
		Jcredits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Made by:  Matthew Shewmaker, Thanks for play v0.02");
			}
		});
		p1 = new JPanel();
		p1.setBackground(Color.gray);
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		p2.add(Jlives);
		p1.add(text);
		p1.add(b1);
		p3.add(Jlastguess);
		p4.add(Jcredits);

		
		
		int R = (int) (Math.random( )*256);
		int G = (int)(Math.random( )*256);
		int B= (int)(Math.random( )*256);
		Color randomColor = new Color(R, G, B, 0x65);
		
		p1.setBackground(randomColor);
		p2.setBackground(randomColor);
		p3.setBackground(randomColor);
		p4.setBackground(randomColor);
		frame.setBackground(randomColor);
		
		frame.add(p3);
		frame.add(p1);
		frame.add(p2);
		frame.add(p4);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		
		
	}
	
	
	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "Your job today is the guess the number between 0/100! Good luck!");
		new Main();
		
		
		
		
	
	
	}
}
	


