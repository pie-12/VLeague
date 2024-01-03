package GUI;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class LoginGUI extends JFrame {

	public LoginGUI(){
		
		JPanel panel = new JPanel();
		panel.setBounds(233, 128, 109, 176);
		getContentPane().add(panel);
		
		JLabel Background = new JLabel("");
		Background.setIcon(new ImageIcon(PlayerGUI.class.getResource("/IMG/login.png")));
		Background.setBounds(0, 0, 550, 550);
		getContentPane().add(Background);
		
		this.setSize(550,550);
		getContentPane().setLayout(null);
		this.setVisible(true);
		this.setResizable(false); //khoá thu phóng
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);	
	} 
	
	public static void main(String[] args) {
		new LoginGUI();
	}
}
