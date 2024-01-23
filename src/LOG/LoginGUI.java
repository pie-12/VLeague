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

public class LoginGUI extends JFrame {
	private JTextField user_tf;
	private JPasswordField password_Field;
	private JTextField textField;
	private JPasswordField passwordField;
	
	public Icon getIcon(int width, int height, String link) {
		Image image = new ImageIcon(getClass().getResource("/IMG/" + link + ".png")).getImage();
		Icon icon = new ImageIcon(image.getScaledInstance(width, height, image.SCALE_SMOOTH));
		return icon;
	}
	public LoginGUI(){
		JPanel loginPanel = new JPanel();
		loginPanel.setBounds(300, 120, 500, 350);
		loginPanel.setBackground(new Color(255, 255, 255, 200));
		
		loginPanel.setBorder(new LineBorder(new Color(0, 0, 0), 6));
		loginPanel.setLayout(null);
		
		JPanel pncard = new JPanel();
		pncard.setBounds(300, 120, 500, 350);
		pncard.setLayout(new CardLayout(0,0));;
		pncard.setOpaque(false);
		
		JLabel line_2 = new JLabel("");
		line_2.setFont(new Font("Courier New", Font.PLAIN, 20));
		line_2.setBounds(0, 0, 500, 300);
		//loginPanel.add(line_2);
		line_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		JLabel login_label = new JLabel("GUESS LOGIN");
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
		getContentPane().setLayout(null);
		
		login_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Connection conn = new DBController().getConnection();
				String sql = "SELECT * FROM guess_acc WHERE username_guess = ? AND password= ?";
				String username = user_tf.getText();
				String password = String.valueOf(password_Field.getPassword());
				
				if (username.equals("") || password.equals("")) {
					JOptionPane.showMessageDialog(null, "Please fill in all fields!");
					return;
				}				
				try {
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, username);
					ps.setString(2, password);
					java.sql.ResultSet rs = ps.executeQuery();
					if (rs.next()) {
						new guessGUI.MainGUI();
						setVisible(false);
					} else {
						JOptionPane.showMessageDialog(null, "Wrong username or password!");
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}				
			}
		});
		
		JButton guess_button1 = new JButton("Guess");
		guess_button1.setBounds(5, 85, 245, 25);
		guess_button1.setFont(new Font("Courier New", Font.BOLD, 18));
		guess_button1.setBackground(Color.lightGray);
		guess_button1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		guess_button1.setFocusPainted(false);
		guess_button1.setFocusable(false);
		
		
		guess_button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CardLayout c1 = (CardLayout)(pncard.getLayout());
				c1.show(pncard, "t1");
				
			}
		});
		
		JButton guess_button2 = new JButton("Guess");
		guess_button2.setBounds(5, 85, 245, 25);
		guess_button2.setFont(new Font("Courier New", Font.BOLD, 18));
		guess_button2.setBackground(Color.lightGray);
		guess_button2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		guess_button2.setFocusPainted(false);
		guess_button2.setFocusable(false);
		
		
		guess_button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CardLayout c1 = (CardLayout)(pncard.getLayout());
				c1.show(pncard, "t1");
				
			}
		});
		
		
		
		JButton manager_button1 = new JButton("Manager");
		manager_button1.setBounds(250, 85, 245, 25);
		manager_button1.setFont(new Font("Courier New", Font.BOLD, 18));
		manager_button1.setFocusable(false);
		manager_button1.setFocusPainted(false);
		manager_button1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		manager_button1.setBackground(Color.LIGHT_GRAY);
		
		
		manager_button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CardLayout c1 = (CardLayout)(pncard.getLayout());
				c1.show(pncard, "t2");
				
			}
		});
		
		JButton manager_button2 = new JButton("Manager");
		manager_button2.setBounds(250, 85, 245, 25);
		manager_button2.setFont(new Font("Courier New", Font.BOLD, 18));
		manager_button2.setFocusable(false);
		manager_button2.setFocusPainted(false);
		manager_button2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		manager_button2.setBackground(Color.LIGHT_GRAY);
		
		
		manager_button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CardLayout c1 = (CardLayout)(pncard.getLayout());
				c1.show(pncard, "t2");
				
			}
		});
		
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
		Background.setIcon(getIcon(1100, 600, "loginbg"));
		
		JPanel loginPanel_1 = new JPanel();
		loginPanel_1.setLayout(null);
		loginPanel_1.setBorder(new LineBorder(new Color(0, 0, 0), 6));
		loginPanel_1.setBackground(new Color(255, 255, 255, 200));
		loginPanel_1.setBounds(0, 0, 500, 350);
		
		JLabel view_n_hide_pw_label_1 = new JLabel("");
		view_n_hide_pw_label_1.setBounds(430, 182, 25, 25);
		loginPanel_1.add(view_n_hide_pw_label_1);
		view_n_hide_pw_label_1.setIcon(getIcon(23, 23, "view"));
		
		
		JLabel login_label_1 = new JLabel("MANAGER LOGIN");
		login_label_1.setHorizontalAlignment(SwingConstants.CENTER);
		login_label_1.setForeground(Color.BLACK);
		login_label_1.setFont(new Font("Courier New", Font.BOLD, 35));
		login_label_1.setBounds(0, 0, 500, 100);
		loginPanel_1.add(login_label_1);
		
		JLabel username_label_1 = new JLabel("Username:");
		username_label_1.setForeground(Color.BLACK);
		username_label_1.setFont(new Font("Courier New", Font.BOLD, 18));
		username_label_1.setBounds(52, 131, 154, 50);
		loginPanel_1.add(username_label_1);
		
		
		JLabel password_label_1 = new JLabel("Password:");
		password_label_1.setForeground(Color.BLACK);
		password_label_1.setFont(new Font("Courier New", Font.BOLD, 18));
		password_label_1.setBounds(52, 171, 154, 50);
		loginPanel_1.add(password_label_1);
		
		JTextField textField_1 = new JTextField();
		textField_1.setFont(new Font("Consolas", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textField_1.setBounds(172, 144, 250, 25);
		loginPanel_1.add(textField_1);
		
		JPasswordField passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Consolas", Font.PLAIN, 15));
		passwordField_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		passwordField_1.setBounds(172, 182, 250, 25);
		loginPanel_1.add(passwordField_1);
		
		JLabel line_1_1 = new JLabel("");
		line_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		line_1_1.setBounds(0, 0, 500, 85);
		loginPanel_1.add(line_1_1);
		
		JLabel username_img_1 = new JLabel("");
		username_img_1.setBounds(18, 137, 30, 30);
		loginPanel_1.add(username_img_1);
		username_img_1.setIcon(getIcon(25, 25, "userlogin"));
		
		JLabel logo_1_1 = new JLabel("");
		logo_1_1.setBounds(10, 5, 80, 80);
		loginPanel_1.add(logo_1_1);
		logo_1_1.setIcon(getIcon(80, 80, "fb_login_logo"));

		
		JLabel logo_2_1 = new JLabel("");
		logo_2_1.setBounds(410, 5, 80, 80);
		loginPanel_1.add(logo_2_1);
		logo_2_1.setIcon(getIcon(80, 80, "fb_login_logo"));

		
		JLabel pw_img_1 = new JLabel("");
		pw_img_1.setBounds(18, 176, 30, 30);
		loginPanel_1.add(pw_img_1);
		pw_img_1.setIcon(getIcon(25, 25, "padlock"));
		
		view_n_hide_pw_label_1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				passwordField_1.setEchoChar((char) 0);
			}

			public void mouseReleased(java.awt.event.MouseEvent evt) {
				passwordField_1.setEchoChar('•');
			}
		});

		
		
		JButton login_button_1 = new JButton("Login");
		login_button_1.setFont(new Font("Courier New", Font.BOLD, 15));
		login_button_1.setFocusable(false);
		login_button_1.setFocusPainted(false);
		login_button_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		login_button_1.setBackground(Color.WHITE);
		login_button_1.setBounds(172, 221, 85, 25);
		loginPanel_1.add(login_button_1);
		
		login_button_1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Connection conn = new DBController().getConnection();
                String sql = "SELECT * FROM manager_acc WHERE username_manager = ? AND password= ?";
                String username = textField_1.getText();
                String password = String.valueOf(passwordField_1.getPassword());
                
                if (username.equals("") || password.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill in all fields!");
                    return;
                }				
                try {
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.setString(1, username);
                    ps.setString(2, password);
                    java.sql.ResultSet rs = ps.executeQuery();
                    if (rs.next()) {
                        new managerGUI.MainGUI();
                        setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Wrong username or password!");
                    }
                } catch (Exception e2) {}
            }
		});
		
		loginPanel.add(guess_button1);
		loginPanel.add(manager_button1);
		
		
		loginPanel_1.add(guess_button2);
		loginPanel_1.add(manager_button2);
		
		
		pncard.add(loginPanel, "t1");
		
		//-----register button-----//
		
		JLabel register_ques = new JLabel("                   Don't have an account? Register here:");
		register_ques.setFont(new Font("Courier New", Font.ITALIC, 12));
		register_ques.setHorizontalAlignment(SwingConstants.LEFT);
		register_ques.setBounds(0, 320, 500, 25);	
		register_ques.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		loginPanel.add(register_ques);
		
		JButton register = new JButton("Register");
		register.setFont(new Font("Courier New", Font.BOLD, 11));
		register.setBounds(410, 320, 85, 25);
		register.setFocusable(false);
		register.setFocusPainted(false);
		register.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		register.setBackground(Color.WHITE);
		loginPanel.add(register);
		pncard.add(loginPanel_1, "t2");
		
		register.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new RegisterGUI();
				setVisible(false);
			}
		});
		
		//------------background----------------//
		getContentPane().add(pncard);
		getContentPane().add(Background);
		ImageIcon logo = new ImageIcon(getClass().getResource("/IMG/football.png"));
		this.setIconImage(logo.getImage());
		this.setTitle("Login");
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
