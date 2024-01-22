package GUI;

import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JButton;

public class LoginGUI extends JFrame {
	private JTextField user_tf;
	private JPasswordField password_Field;
	
	public Icon getIcon(int width, int height, String link) {
		Image image = new ImageIcon(getClass().getResource("/IMG/" + link + ".png")).getImage();
		Icon icon = new ImageIcon(image.getScaledInstance(width, height, image.SCALE_SMOOTH));
		return icon;
	}
	public LoginGUI(){
		getContentPane().setLayout(null);
		JPanel loginPanel = new JPanel();
		loginPanel.setBounds(300, 120, 500, 350);
		loginPanel.setBackground(new Color(255, 255, 255, 200));
		getContentPane().add(loginPanel);
		loginPanel.setBorder(new LineBorder(new Color(0, 0, 0), 6));
		loginPanel.setLayout(null);
		
		JLabel line_2 = new JLabel("");
		line_2.setFont(new Font("Courier New", Font.PLAIN, 20));
		line_2.setBounds(0, 0, 500, 300);
		//loginPanel.add(line_2);
		line_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		JLabel fix_vnhpl = new JLabel("");
		fix_vnhpl.setBounds(368, 179, 25, 25);
		loginPanel.add(fix_vnhpl);
		fix_vnhpl.setBackground(Color.WHITE);
		
		JLabel login_label = new JLabel("LOGIN");
		login_label.setBounds(0, 0, 500, 100);
		login_label.setForeground(new Color(0, 0, 0));
		login_label.setFont(new Font("Courier New", Font.BOLD, 35));
		login_label.setHorizontalAlignment(SwingConstants.CENTER);
		
		loginPanel.add(login_label);
		
		JLabel username_label = new JLabel("Username:");
		username_label.setBounds(52, 131, 154, 50);
		username_label.setForeground(new Color(0, 0, 0));
		username_label.setFont(new Font("Courier New", Font.BOLD, 18));
		loginPanel.add(username_label);
		
		JLabel password_label = new JLabel("Password:");
		password_label.setBounds(52, 171, 154, 50);
		password_label.setForeground(new Color(0, 0, 0));
		password_label.setFont(new Font("Courier New", Font.BOLD, 18));
		loginPanel.add(password_label);
		
		user_tf = new JTextField();
		user_tf.setBounds(172, 144, 250, 25);
		user_tf.setFont(new Font("Consolas", Font.PLAIN, 15));
		loginPanel.add(user_tf);
		user_tf.setColumns(10);
		user_tf.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		password_Field = new JPasswordField();
		password_Field.setBounds(172, 182, 250, 25);
		password_Field.setFont(new Font("Consolas", Font.PLAIN, 15));
		loginPanel.add(password_Field);
		password_Field.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		JLabel line_1 = new JLabel("");
		line_1.setBounds(0, 0, 500, 85);
		loginPanel.add(line_1);
		line_1.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		
		JLabel username_img = new JLabel("");
		username_img.setBounds(18, 137, 30, 30);
		loginPanel.add(username_img);
		username_img.setIcon(getIcon(25, 25, "userlogin"));
		
		JLabel logo_1 = new JLabel("");
		logo_1.setBounds(10, 5, 80, 80);
		loginPanel.add(logo_1);
		logo_1.setIcon(getIcon(80, 80, "fb_login_logo"));
		
		JLabel logo_2 = new JLabel("");
		logo_2.setBounds(410, 5, 80, 80);
		loginPanel.add(logo_2);
		logo_2.setIcon(getIcon(80, 80, "fb_login_logo"));
		
		JLabel pw_img = new JLabel("");
		pw_img.setBounds(18, 176, 30, 30);
		loginPanel.add(pw_img);
		pw_img.setIcon(getIcon(25, 25, "padlock"));
		
		
		JLabel view_n_hide_pw_label = new JLabel("");
		view_n_hide_pw_label.setBounds(430, 182, 25, 25);
		loginPanel.add(view_n_hide_pw_label);
		view_n_hide_pw_label.setIcon(getIcon(23, 23, "view"));
		
		JButton login_button = new JButton("Login");
		login_button.setBounds(172, 221, 85, 25);
		loginPanel.add(login_button);
		login_button.setFont(new Font("Courier New", Font.BOLD, 15));
		login_button.setBackground(Color.WHITE);
		login_button.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		login_button.setFocusPainted(false);
		login_button.setFocusable(false);
		
		JButton guess_button = new JButton("Guess");
		guess_button.setBounds(5, 84, 245, 25);
		guess_button.setFont(new Font("Courier New", Font.BOLD, 18));
		guess_button.setBackground(Color.lightGray);
		guess_button.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		guess_button.setFocusPainted(false);
		guess_button.setFocusable(false);
		loginPanel.add(guess_button);
		
		JButton manager_button = new JButton("Manager");
		manager_button.setFont(new Font("Courier New", Font.BOLD, 18));
		manager_button.setFocusable(false);
		manager_button.setFocusPainted(false);
		manager_button.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		manager_button.setBackground(Color.LIGHT_GRAY);
		manager_button.setBounds(250, 84, 245, 25);
		loginPanel.add(manager_button);
		
		view_n_hide_pw_label.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				password_Field.setEchoChar((char) 0);
			}

			public void mouseReleased(java.awt.event.MouseEvent evt) {
				password_Field.setEchoChar('•');
			}
		});
		
		
		JLabel Background = new JLabel("");
		Background.setBounds(0, 0, 1100, 600);
		Background.setIcon(getIcon(1100, 600, "login_bg"));
		getContentPane().add(Background);
		this.setSize(1100, 600);
		this.setVisible(true);
		this.setResizable(false); //khoá thu phóng
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);	
	} 
	
	public static void main(String[] args) {
		new LoginGUI();
	}
}
