import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class main {
	static double ver = 0.9;
	
	
	
	static int guess;
	
	//RandomVars
	static Random rand = new Random();
	static int diff = 10;
	static int hdiff = 5;
	static int q1;
	static int q2;
	static int answer;
	static int life = 5;
	static int correct = 0;
	static int skipped = 0;
	static String op;
	static String op1;
	static String question;
	static int score = 0;
	static int posscore = 1;
	static int bonus=0;
	static boolean afterbonus = false;
	static boolean musicplay = true;
	static int caltimes = 3;
	static int timetobonus=5;
	static boolean paperhint = false;
	static boolean help1 = true;
	static int q3;
	static int time = 300;
	static int savetime = time;
	
	
	
	//JFrameVars
	private static JFrame Jmainframe;
	
	//JTextField
	static private JTextField Janswerbox;
	
	
	//JLabel
	private JLabel Jcorrect;
	private JLabel Jlife;
	private static JLabel Jposscore;
	private JLabel Jtime;
	protected String[] args;
	private static JLabel Jquestion;
	private static JLabel Jskipped;
	private static JLabel Jscore;
	//JComboBOx
	private static JComboBox Jop;
	
	//Panel
	private static JPanel p1;
	private static JPanel p2;
	private static JPanel p3;
	private static JPanel p4;
	
	
	
	public main(){
		
		gui();
	}
	public void gui(){
		
		Thread painter = new Thread(){
			public void run(){
				while(true){
					Jtime.setText(" " +time);
					Jscore.setText("Score: " +score);
					Jlife.setText("Life: " + life);
					Jposscore.setText("  PossableScore: " + posscore);
					Jcorrect.setText(correct + " Answers correct");
					Jskipped.setText(skipped + " Questions skipped");
				Jmainframe.repaint();
				try {
					Thread.sleep(17);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				}
			}
		};
		
	    //JFrame
	    Jmainframe = new JFrame("Mats Math  v" +ver);
		Jmainframe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		Jmainframe.setSize(500,200);
		Jmainframe.setResizable(false);
		Jmainframe.addWindowListener(new WindowAdapter() {
			 public void windowClosing(WindowEvent event) {
		            exit();
		        }
		});
		
		
		//JPanle
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
	    p4 = new JPanel();
		
		//JLabel
		Jquestion = new JLabel(question);
		Jlife = new JLabel();
		Jcorrect = new JLabel();
		Jskipped = new JLabel();
		Jscore = new JLabel();
		JLabel Jblank = new JLabel("     ");
		JLabel Jblank1 = new JLabel("     ");
		Jposscore = new JLabel();
		Jtime = new JLabel();
		
		
		//JButton
		JButton Jcheck = new JButton("check");
		JButton Jskip = new JButton("Skip");
		JButton Jcredits = new JButton("Help");
		JButton Jpaper = new JButton("paper");
		JButton Jcal = new JButton("cal");
		JButton Jhighscore = new JButton("score");
		
		//JTextField
		Janswerbox = new JTextField(20);
		
		//JComboBox
		String ops [] = {"Add", "Subtract", "Multply", "devide"};
		Jop = new JComboBox(ops);
		
		//ActionListener
		Jcheck.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
				String input = Janswerbox.getText();
				int guess = Integer.parseInt(input);
				if (guess == answer ){
					JOptionPane.showMessageDialog(null, "Correct!! The answer was " + answer);
					
					correct = correct + 1;
					if ( savetime <= 20){
						
					} else if ( savetime <= 40 ){
						savetime-= 1;
					}else {
						savetime-=5;
					}
					
					
					if (afterbonus == true) {
						life = life +1;
						afterbonus = false;
						savetime+= 20;
						Jlife.setText("Life: " + life);
					}
					diff = diff +3;
					hdiff = hdiff +1;
					score = score + posscore;
					bonus = bonus +1;
					gen();
				} else {
					if ( afterbonus == true ){
						JOptionPane.showMessageDialog(null, "WRONG! You failed the bonus! it was " + answer + " You said " + guess);
						gen();
						return;
					}
					JOptionPane.showMessageDialog(null, "Wrong! " + guess + " Is wrong, Try again!");
					life = life - 1;
				}
				
				if (life <= 0) {
					JOptionPane.showMessageDialog(null, "YOU LOSS! Thw answer you are looking for is " + answer + " You got " + score + " score thouhg!");
					System.exit(1);
				}
				
				Janswerbox.setText("");
				int R = (int) (Math.random( )*256);
				int G = (int)(Math.random( )*256);
				int B= (int)(Math.random( )*256);
				Color randomColor = new Color(R, G, B, 0x65);

						p1.setBackground(randomColor);
						p2.setBackground(randomColor);
						p3.setBackground(randomColor);
						p4.setBackground(randomColor);
				
				} catch(Exception e1){
					JOptionPane.showMessageDialog(null, "No input, Or wrong type of input! Use only number!");
					Janswerbox.setText("");
				}
			}
		});
		
		Jskip.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (afterbonus == true ){
					JOptionPane.showMessageDialog(null, "You skipped the bonus? But why!? It was " + answer);
					afterbonus = false;
					gen();
					return;
				}
				JOptionPane.showMessageDialog(null, "SKIPPED! The answer was " +answer+ " You loss one score!");
				skipped = skipped + 1;
				score = score - 1;
				gen();
			}
		});
		
		Jcredits.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				help.main(args);
			}
			
		});
		
		Jpaper.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if ( afterbonus == true){
					JOptionPane.showMessageDialog(null, "Sorry! No Paper during the bonus!");
					return;
				}
				if (paperhint == false ){
				JOptionPane.showMessageDialog(null, "You now can use scratch paper, But this costs you 10 score!");
				score = score - 10;
				paperhint = true;
				}
				scatch.main(args);
			}	
		});
		Jcal.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (caltimes == 0){
					JOptionPane.showMessageDialog(null, "You cant do that anymore!");
					return;
				} else if ( afterbonus == true ) {
					JOptionPane.showMessageDialog(null, "You cant do that during the bonus!");
					return;
				}
				JOptionPane.showMessageDialog(null, "You may only use this " + caltimes + " times!");
				cal.main(args);;
			}
		});
		Jhighscore.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				highscore.main(args);;
			}
		});
		
		
		
		
		
		
		
		
		
		
		//JFinal
		
		
		Jquestion.setFont(new Font("Serif", Font.PLAIN, 24));
		p1.add(Jquestion, BorderLayout.SOUTH);
		Jtime.setFont(new Font("Serif", Font.PLAIN, 15));
		p1.add(Jtime);
		p2.add(Jop);
		p2.add(Janswerbox);
		p2.add(Jcheck);
		p2.add(Jskip);
		Jlife.setFont(new Font("Serif", Font.PLAIN, 22));
		p3.add(Jlife);
		p3.add(Jblank);
		p3.add(Jcorrect);
		p3.add(Jblank1);
		p3.add(Jskipped);
		Jscore.setFont(new Font("Serif", Font.PLAIN, 30));
		p4.add(Jhighscore);
		p4.add(Jcal);
		p4.add(Jpaper);
		p4.add(Jcredits);
		p4.add(Jscore);
		Jposscore.setFont(new Font("Serif", Font.PLAIN, 13));
		p4.add(Jposscore);
		
		Jmainframe.add(p1);
		Jmainframe.add(p2);
		Jmainframe.add(p3);
		Jmainframe.add(p4);
		
		painter.start();
		
		
int R = (int) (Math.random( )*256);
int G = (int)(Math.random( )*256);
int B= (int)(Math.random( )*256);
Color randomColor = new Color(R, G, B, 0x65);

		p1.setBackground(randomColor);
		p2.setBackground(randomColor);
		p3.setBackground(randomColor);
		p4.setBackground(randomColor);
		
		Jmainframe.setLayout ( new GridLayout(4,1));
		Jmainframe.setLocationRelativeTo(null);
		Jmainframe.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		Thread timer = new Thread(){
			public void run(){
				while(true){
					if ( time == 0){
						timeout();
					}
				time-= 1;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				}
				
				
			}
		};
		
		
		q1 = rand.nextInt(diff);
		q2 = rand.nextInt(diff);
		answer = q1 + q2;
		question = q1 + " + " + q2;
		timer.start();
		new main();
		
		
		
		
		
		
		
	}
	public static void gen(){
		
		time = savetime;
		
		if (bonus >= timetobonus){
			time = 60;
			if ( scatch.Svisable == true){
				JOptionPane.showMessageDialog(null, "Sorry! No Scratch paper during the bonus round! You can reopen it after the bonus!");
				scatch.open();
			} if ( cal.calvis == true){
				JOptionPane.showMessageDialog(null, "Sorry! You cant have that open during the bonus round!");
				cal.exit();
			}
			q1 = rand.nextInt(1000);
			q2 = rand.nextInt(1000);
			q3 = rand.nextInt(1000);
			answer = q1 + q2 + q3;
			question = q1 + " + " + q2 + " + " + q3;
			posscore = 4;
			bonus = 0;
			JOptionPane.showMessageDialog(null, "BONUS ROUND! Make it count! Its worth 4 score! and gain a life!");
			Jquestion.setText(question);
			Janswerbox.setText("");
			afterbonus = true;
			timetobonus = timetobonus +1;	
		if (q1 == 0 ){
			gen();
		} else if ( q2 == 0 ){
			gen();
		}
		return;
	}
		op = (String) Jop.getSelectedItem();
		q1 = rand.nextInt(diff);
		q2 = rand.nextInt(diff);
		q3 = rand.nextInt(diff);
		if (op == "Add"){
			answer = q1 + q2;
			question = q1 + " + " + q2;
			posscore = 1;
			if ( diff >= 100 ){
				q1 = rand.nextInt(diff-50);
				q2 = rand.nextInt(diff-50);
				q3 = rand.nextInt(diff-50);
				answer = q1 + q2 + q3;
			    question = q1 + " + " + q2 + " + " + q3;
			    posscore = 2;
			}
		} else if ( op == "Subtract") {
			answer = q1 - q2;
			question = q1 + " - " + q2;
			posscore = 1;
			if (q1 <= q2 ){
				answer = q2 - q1;
				question = q2 + " - " + q1;
				posscore = 1;
			}
		} else if ( op == "Multply"){
			q1 = rand.nextInt(hdiff);
			q2 = rand.nextInt(hdiff);
			answer = q1 * q2;
			question = q1 + " * " + q2;
			posscore = 2;
			if (hdiff >= 25){
				posscore = 3;
			}
		} else if ( op == "devide"){
			q1 = rand.nextInt(hdiff);
			q2 = rand.nextInt(hdiff);
			try{
			if ( help1 == true ) {
				JOptionPane.showMessageDialog(null, "Make sure when devideing, Round to the LOWEST number! LOWEST!");
				help1 = false;
			}
			
			answer = q1 / q2;
			question = q1 + " / " + q2;
			try{
			Math.round(answer);
			} catch(Exception e){
				
			}
			if ( answer == 0) {
				gen();
			}
			
			}
			catch(Exception e){
				gen();
			}
			posscore = 1;
			if (q1 <= q2 ){
				answer = q2 / q1;
				question = q2 + " / " + q1;
			}
		} else {
			JOptionPane.showMessageDialog(null, "An error happed when trying to find the op");
		}
		Jquestion.setText(question);
		Janswerbox.setText("");
		Jposscore.setText("PossableScore: " +posscore);
		
		
		int R = (int) (Math.random( )*256);
		int G = (int)(Math.random( )*256);
		int B= (int)(Math.random( )*256);
		Color randomColor = new Color(R, G, B, 0x65);

				p1.setBackground(randomColor);
				p2.setBackground(randomColor);
				p3.setBackground(randomColor);
				p4.setBackground(randomColor);
				
				
	}
	public static void exit(){
		JOptionPane.showMessageDialog(null, "Bye! Hope you had fun! You got a score of " + score);
		System.exit(1);
	}
	public static void timeout(){
		JOptionPane.showMessageDialog(null, "OUT OF TIME! " + answer + " was the answer!");
		life--;
		gen();
	}
}
