import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;





public class MainQuick {
	static double ver = 0.01;
	static JFrame Jframe = new JFrame();
	
	static int score = 0;
	static int life = 3;
	static Color Color;
	static int timeDiff = 5;
	static int answer;
	static int Aoni = 2;
	
	
	
	static Thread ColorTimer = new Thread();
	//jFrame vars
	
	
	
	static JPanel jP1;
	static JPanel jP2;
	static JPanel jP3;
	
	
	
	
	static JLabel jScore;
	static JLabel jLife;
	static JButton jCheck;
	static JLabel jQuestion;
	static JTextField jInput;
	
	
	
	public MainQuick(){
		System.out.println("MainQuick ran");
		frame();
	}
	public static void frame(){
		
		
		
		Jframe = new JFrame("Matts QuickGuess v" + ver);
		Jframe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		Jframe.setSize(600,200);
		Jframe.setResizable(false);
		Jframe.addWindowListener(new WindowAdapter() {
			 public void windowClosing(WindowEvent event) {
					System.exit(1);
		        }
		});
		jP1 = new JPanel();
		jP2 = new JPanel();
		jP3 = new JPanel();
		
		
		jInput = new JTextField(30);
		
		jScore = new JLabel();
		jLife = new JLabel();
		jCheck = new JButton("Check");
		jQuestion = new JLabel();
		jQuestion.setFont(new Font("Bold", Font.PLAIN, 30));
		
		
		
		//jFinal
		
		//Panel
		jP1.add(jQuestion);
		jP2.add(jInput);
		jP2.add(jCheck);
		jP3.add(jScore);
		jP3.add(jLife);
		
		
		
		//Frame
		Jframe.add(jP1);
		Jframe.add(jP2);
		Jframe.add(jP3);
		
		
		
		Jframe.setLayout ( new GridLayout(3,1));
		Jframe.setResizable(false);
		Jframe.setLocationRelativeTo(null);
		Jframe.setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainQuick();
		gen(Aoni);
		
		
		Thread colorFPS = new Thread(){
			public void run(){
				while(true){
					jP1.setBackground(Color);
					jP2.setBackground(Color);
					jP3.setBackground(Color);
					
					try {
						Thread.sleep(80);
					} catch (InterruptedException e) {;
					}
					
				}
			}
		};
		colorFPS.start();
		
		
		ColorTimer = new Thread(){
			public void run(){
				System.out.println("StartingColorTimer");
				double wait = timeDiff * 1000 / 250 /2;
				int red = 0;
				int Green = 255;
				int changeRed = red;
				int changeGreen = Green;
				
				
				
				while(true){
				
						try {
							Thread.sleep((long) wait);
						} catch (InterruptedException e) {
						}
						
						if (changeGreen <= 0 ){
							if (changeRed >= 255){
							toSlow();
							ColorTimer.stop();
							} else{
						changeRed += 1;
							}
						} else{
							changeGreen -= 1;
						}
						
						System.out.println("Changing color");
						Color = new Color(changeRed, changeGreen, 0, 0x80);
						
						
					}
					
			}
		};
		ColorTimer.start();
		
		Thread FPS = new Thread(){
			public void run(){
				while(true){
				jScore.setText("   Score: " + score);
				jLife.setText("   Life: " + life);
				
				jP3.repaint();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
				
				}
			}
		};
		FPS.start();
		
	}
	
	public static void gen(int Aon){
		Random ran = new Random();
		int numbers [] = new int[Aon];
		 for (int i = 0; i < Aon; i++) {
			numbers[i] = ran.nextInt(100);
			System.out.println("Number " + i + " = " + numbers[i]);
			answer += numbers[i];
		}
		System.out.println("Answer: " + answer);
		jQuestion.setText(numbers[0] + " + " + numbers[1] + " = ?" );
		
		ColorTimer.start();
		Jframe.repaint();
	}
	public static void check(int input){
		
		if (input == answer){
			
			
			
			
		}else{
			
		}
		
		
		
	}
	public static void wrong(int input){
		
		
		
	}
	public static void toSlow(){
		JOptionPane.showMessageDialog(null, "TO SLOW! The answer was " + answer);
		gen(Aoni);
		ColorTimer.stop();
	}
}
