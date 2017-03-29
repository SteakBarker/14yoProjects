import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class cal {
	
	private static JFrame Jmainframe;
	private static JComboBox Jop;
	private static JLabel Janswer;
	private static JTextField input1;
	private static JTextField input2;
	private static int answer;
	private static JPanel p1;
	
	
	public cal(){
		gui();
	}
	public static void gui(){
		
		Jmainframe = new JFrame("Calclater");
		Jmainframe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		Jmainframe.setSize(450,100);
		Jmainframe.setResizable(false);
		Jmainframe.addWindowListener(new WindowAdapter() {
			 public void windowClosing(WindowEvent event) {
		            exit();
		        }
		});
		
		//JPanel
		p1 = new JPanel();
		
		
		// TextFeilds
		input1 = new JTextField(10);
		input2 = new JTextField(10);
		
		// ComoBoBox
		String ops [] = {"+", "-", "*", "/"};
		Jop = new JComboBox(ops);
		
		//JButton
		JButton Jequal = new JButton("=");
		
		//JLabel
		Janswer = new JLabel("");
		
		//AnctionLisener
		Jequal.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				math();
			}
		});
		
		
		
		
		
		
		Janswer.setFont(new Font("Serif", Font.PLAIN, 30));
		
		p1.add(input1);
		p1.add(Jop);
		p1.add(input2);
		p1.add(Jequal);
		p1.add(Janswer);
		
		
		int R = (int) (Math.random( )*256);
		int G = (int)(Math.random( )*256);
		int B= (int)(Math.random( )*256);
		Color randomColor = new Color(R, G, B, 0x30);
		p1.setBackground(randomColor);
		
		Jmainframe.add(p1);
		
		Jmainframe.setLocationRelativeTo(null);
		Jmainframe.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		
		
		new cal();
	}
	public static void exit(){
		JOptionPane.showMessageDialog(null, "Bye! Hope you did math!");
		System.exit(1);
	}
	public static void math(){
		try{
			String tempinput1 = input1.getText();
			int number1 = Integer.parseInt(tempinput1);
			String tempinput2 = input2.getText();
			int number2 = Integer.parseInt(tempinput2);
			
			
			String op = (String) Jop.getSelectedItem();
			
			if (op == "+"){
				answer = number1 + number2;
				
			} else if (op == "-"){
				answer = number1 - number2;
				
			} else if (op == "*"){
				answer = number1 * number2;
				
			} else if (op == "/"){
				answer = number1 / number2;
				
			}
			
			
			
		}catch(Exception e1){
			JOptionPane.showMessageDialog(null, "No input, Or wrong type of input! Use only numbers!");
			input1.setText("");
			input2.setText("");
		}
		String tempanswer = answer + "";
		Janswer.setText(tempanswer);
		
		int R = (int) (Math.random( )*256);
		int G = (int)(Math.random( )*256);
		int B= (int)(Math.random( )*256);
		Color randomColor = new Color(R, G, B, 0x30);
		p1.setBackground(randomColor);
		
		
		input1.setText("");
		input2.setText("");
		
		Jmainframe.repaint();
		
		
	}
}
