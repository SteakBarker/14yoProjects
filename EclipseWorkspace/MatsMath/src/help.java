import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class help {
	
	private static JFrame JHframe;
	
	
	public help(){
		Hgui();
	}
	public void Hgui(){
		
		JHframe = new JFrame("Help");
		JHframe.setSize(400,200);
		JHframe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		JHframe.setSize(500,250);
		JHframe.setResizable(false);
		JHframe.addWindowListener(new WindowAdapter() {
			 public void windowClosing(WindowEvent event) {
				 JHframe.dispose();
		        }
		});
		
		JPanel p1 = new JPanel();
		JTextArea Jhelp = new JTextArea(15,45);
		Jhelp.setEditable(false);
		Jhelp.setText("Welcome to Mats math v" + main.ver + " In my game you will be asked random questions. Get it right or lose a life! You can pick between with type of math you want to be asked! Each is worth diffrent ponts thouhg! Add: 1, When you get at a high enough level, You will be faced with easier numbers But 3 digets! And you can get 2 points!, Subtract: 1, Multiply: 2 When you get at a high enough level in mulication, You will get a score of 3 per each!, Devive: 1 Make sure you round to the lowest number!. THe more you answer the harder it will get! If you anser enough questions right you will get a bonus round, Its worth 3 score and is a large number you must add, You dont lose a life if you fail, and you get one try! You also have a skip, You will loss a score if you do this, But not if its during the bonus! You also have a calator, You may use it 3 times! You also have scratch paper, It costs 10 score, But you can use it  for free after the one time fee!  \n \n Made by Matthew Shewmaker! You also have a timer! If it reachers zero, You lose, also, it gets smaller every round!");
		Jhelp.setLineWrap(true);
		Jhelp.setWrapStyleWord(true);
		
		
		p1.add(Jhelp);
		
		JHframe.add(p1);
		
		JHframe.setLayout ( new GridLayout(1,1));
		JHframe.setLocationRelativeTo(null);
		JHframe.setAlwaysOnTop(true);
		JHframe.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new help();
		

	}

}
