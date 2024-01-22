package LOG;

import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.border.LineBorder;

import DBS.DBController;
import managerGUI.MainGUI;

import javax.swing.JButton;

public class RegisterGUI extends JFrame {
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_2;
	private JPasswordField passwordField_2;
	private JPasswordField passwordField_1;
	
	public Icon getIcon(int width, int height, String link) {
		Image image = new ImageIcon(getClass().getResource("/IMG/" + link + ".png")).getImage();
		Icon icon = new ImageIcon(image.getScaledInstance(width, height, image.SCALE_SMOOTH));
		return icon;
	}
	public RegisterGUI(){;
		
		JLabel line_2 = new JLabel("");
		line_2.setFont(new Font("Courier New", Font.PLAIN, 20));
		line_2.setBounds(0, 0, 500, 300);
		//loginPanel.add(line_2);
		line_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		getContentPane().setLayout(null);
		
		JPanel loginPanel = new JPanel();
		loginPanel.setLayout(null);
		loginPanel.setBorder(new LineBorder(new Color(0, 0, 0), 6));
		loginPanel.setBackground(new Color(255, 255, 255, 200));
		loginPanel.setBounds(50, 110, 500, 315);
		getContentPane().add(loginPanel);
		
		
		JLabel register_label = new JLabel("REGISTER");
		register_label.setHorizontalAlignment(SwingConstants.CENTER);
		register_label.setForeground(Color.BLACK);
		register_label.setFont(new Font("Courier New", Font.BOLD, 35));
		register_label.setBounds(0, 0, 500, 100);
		loginPanel.add(register_label);
		
		JLabel username_label = new JLabel("Username:");
		username_label.setForeground(Color.BLACK);
		username_label.setFont(new Font("Courier New", Font.BOLD, 18));
		username_label.setBounds(34, 110, 203, 50);
		loginPanel.add(username_label);
		
		JLabel password_label = new JLabel("Password:");
		password_label.setForeground(Color.BLACK);
		password_label.setFont(new Font("Courier New", Font.BOLD, 18));
		password_label.setBounds(34, 150, 203, 50);
		loginPanel.add(password_label);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Consolas", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textField_2.setBounds(229, 123, 246, 25);
		loginPanel.add(textField_2);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setFont(new Font("Consolas", Font.PLAIN, 15));
		passwordField_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		passwordField_2.setBounds(229, 161, 246, 25);
		loginPanel.add(passwordField_2);
		
		JLabel line_1 = new JLabel("");
		line_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		line_1.setBounds(0, 0, 500, 85);
		loginPanel.add(line_1);
		
		JLabel logo_1 = new JLabel("");
		logo_1.setBounds(10, 5, 80, 80);
		loginPanel.add(logo_1);
		
		JLabel logo_2 = new JLabel("");
		logo_2.setBounds(410, 5, 80, 80);
		loginPanel.add(logo_2);
		
		JLabel pw_img = new JLabel("");
		pw_img.setBounds(18, 176, 30, 30);
		loginPanel.add(pw_img);
		
		JLabel view_n_hide_pw_label = new JLabel("");
		view_n_hide_pw_label.setBounds(430, 182, 25, 25);
		loginPanel.add(view_n_hide_pw_label);
				
		JLabel register_ques = new JLabel("                   Already have an account? Log in here:");
		register_ques.setHorizontalAlignment(SwingConstants.LEFT);
		register_ques.setFont(new Font("Courier New", Font.ITALIC, 12));
		register_ques.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		register_ques.setBounds(0, 285, 500, 25);
		loginPanel.add(register_ques);
		
		JLabel password_label_1 = new JLabel("Confirm Password:");
		password_label_1.setForeground(Color.BLACK);
		password_label_1.setFont(new Font("Courier New", Font.BOLD, 18));
		password_label_1.setBounds(34, 188, 205, 50);
		loginPanel.add(password_label_1);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Consolas", Font.PLAIN, 15));
		passwordField_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		passwordField_1.setBounds(229, 199, 246, 25);
		loginPanel.add(passwordField_1);
		
		//------------------------Button------------------------//
		JButton log_in_button = new JButton("Log in");
		log_in_button.setFont(new Font("Courier New", Font.BOLD, 11));
		log_in_button.setFocusable(false);
		log_in_button.setFocusPainted(false);
		log_in_button.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		log_in_button.setBackground(Color.WHITE);
		log_in_button.setBounds(410, 285, 85, 25);
		loginPanel.add(log_in_button);
		
		log_in_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoginGUI();
				setVisible(false);
			}
		});
		
		JButton register_button = new JButton("Register");
		register_button.setFont(new Font("Courier New", Font.BOLD, 15));
		register_button.setFocusable(false);
		register_button.setFocusPainted(false);
		register_button.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		register_button.setBackground(Color.WHITE);
		register_button.setBounds(207, 242, 85, 25);
		loginPanel.add(register_button);
		
		register_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textField_2.getText();
				String password = passwordField_2.getText();
				String confirm_password = passwordField_1.getText();
				if (username.equals("") || password.equals("") || confirm_password.equals("")) {
					JOptionPane.showMessageDialog(null, "Please fill in all fields.");
				} else if (!password.equals(confirm_password)) {
					JOptionPane.showMessageDialog(null, "Password and confirm password are not the same!");
				} else {
					try {
						Connection con = new DBController().getConnection();
						PreparedStatement ps = con.prepareStatement("insert into guess_acc values(?,?)");
						ps.setString(1, username);
						ps.setString(2, password);
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null, "Register successfully.");
						new LoginGUI();
						setVisible(false);
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Username already exists.");
					}
				}
			}
		});
		
		//-------------------Background-------------------//
		JLabel Background = new JLabel("");
		Background.setBounds(0, 0, 600, 600);
		Background.setIcon(getIcon(600, 600, "register_bg"));
		getContentPane().add(Background);
		ImageIcon logo = new ImageIcon(getClass().getResource("/IMG/football.png"));
		this.setIconImage(logo.getImage());
		this.setTitle("Register");
		this.setSize(600, 600);
		this.setVisible(true);
		this.setResizable(false); //khoá thu phóng
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);	
	} 
	
	public static void main(String[] args) {
		new RegisterGUI();
	}
}
