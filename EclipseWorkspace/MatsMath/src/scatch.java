import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class scatch {
	public static boolean Svisable = false;
	
	private static JFrame Jmainframe;
	private static JTextArea Jtext;
	public static String save = "";
	
	
	public scatch(){
		gui();
	}
	public static void gui(){
		
		Jmainframe = new JFrame("Scratch paper");
		Jmainframe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		Jmainframe.setSize(400,300);
		Jmainframe.setResizable(false);
		Jmainframe.addWindowListener(new WindowAdapter() {
			 public void windowClosing(WindowEvent event) {
				open();
		        }
		});
		
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JButton Jclear = new JButton("clear");
		JButton Jsave = new JButton("save");
		JButton Jload = new JButton("load");
		
		Jtext = new JTextArea(10,35);
		
		
		
		p1.add(Jtext);
		p2.add(Jclear);
		p2.add(Jsave);
		p2.add(Jload);
		
		
		
		Jmainframe.add(p1);
		Jmainframe.add(p2);
		
		Jmainframe.setLayout ( new GridLayout(2,1));
		Jmainframe.setLocationRelativeTo(null);
		Svisable = true;
		Jmainframe.setVisible(true);
		
		Jclear.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Jtext.setText("");
				
			}
		});
		
		Jsave.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				save = Jtext.getText();
			}
		});
		Jload.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Jtext.setText(save);
			}
		});
		
		
		
		
	}
	
	public static void main(String[] args) {
		
		new scatch();
		
	}
	public static void open(){
		
		if ( Svisable == true ) {
			Jmainframe.setVisible(false);
			Svisable = false;
		} else if ( Svisable == false ) {
			Jmainframe.setVisible(true);
			Svisable = true;
		}
		
		
	}
}
