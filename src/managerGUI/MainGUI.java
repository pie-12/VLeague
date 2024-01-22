package managerGUI;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JMenu;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import LOG.LoginGUI;

public class MainGUI extends JFrame {
	public Icon getIcon(int width, int height, String link) {
		Image image = new ImageIcon(getClass().getResource("/IMG/" + link + ".png")).getImage();
		Icon icon = new ImageIcon(image.getScaledInstance(width, height, image.SCALE_SMOOTH));
		return icon;
	}
	public MainGUI(){
		Icon icon = getIcon(1000, 600, "mainGUI");		
		this.setSize(1000,600);
		getContentPane().setLayout(null);
		
		JPanel title_panel = new JPanel();
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0, 0, 1000, 120);
		title_panel.setBackground(new Color(69, 159, 226));
		getContentPane().add(title_panel);
		
		JLabel lblNewLabel = new JLabel("V-LEAGUE MANAGEMENT SYSTEM");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setVerticalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 1000, 120);
		title_panel.add(lblNewLabel);
		
		JPanel menu_panel = new JPanel();
		menu_panel.setBounds(0, 120, 1000, 440);
		getContentPane().add(menu_panel);
		menu_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 30));
		menu_panel.setOpaque(false);
		
		JPanel player_menu = new JPanel();
		player_menu.setBackground(new Color(255, 255, 255));
		player_menu.setPreferredSize(new Dimension(170, 170));
		menu_panel.add(player_menu);
		player_menu.setLayout(null);
		player_menu.setBorder(new LineBorder(new Color(69,159,226), 3));
		
		JLabel player_icon = new JLabel("");
		player_icon.setHorizontalAlignment(SwingConstants.CENTER);
		player_icon.setBounds(10, 10, 150, 115);
		player_icon.setIcon(getIcon(100,100,"soccer-player"));
		player_menu.add(player_icon);
		
		JLabel player_label = new JLabel("Player");
		player_label.setHorizontalAlignment(SwingConstants.CENTER);
		player_label.setBounds(10, 135, 150, 25);
		player_label.setFont(new Font("Consolas", Font.BOLD, 20));
		player_label.setForeground(new Color(69, 159, 226));
		player_menu.add(player_label);
		
		player_menu.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				new managerGUI.PlayerGUI();
				setVisible(false);
			}
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				player_menu.setBackground(Color.lightGray);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				player_menu.setBackground(Color.white);
			}
		});
		
		JPanel schedule_menu = new JPanel();
		schedule_menu.setBackground(new Color(255, 255, 255));
		schedule_menu.setPreferredSize(new Dimension(170, 170));
		menu_panel.add(schedule_menu);
		schedule_menu.setLayout(null);
		schedule_menu.setBorder(new LineBorder(new Color(69,159,226), 3));
		
		JLabel schedule_icon = new JLabel("");
		schedule_icon.setHorizontalAlignment(SwingConstants.CENTER);
		schedule_icon.setBounds(10, 10, 150, 115);
		schedule_icon.setIcon(getIcon(100,100,"calendar"));
		schedule_menu.add(schedule_icon);
		
		JLabel schedule_label = new JLabel("Schedule");
		schedule_label.setHorizontalAlignment(SwingConstants.CENTER);
		schedule_label.setForeground(new Color(69, 159, 226));
		schedule_label.setFont(new Font("Consolas", Font.BOLD, 20));
		schedule_label.setBounds(10, 135, 150, 25);
		schedule_menu.add(schedule_label);
		
		schedule_menu.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				new ScheduleGUI();
				setVisible(false);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				schedule_menu.setBackground(Color.lightGray);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				schedule_menu.setBackground(Color.white);
			}
		});
		
		JPanel result_menu = new JPanel();
		result_menu.setBackground(new Color(255, 255, 255));
		result_menu.setPreferredSize(new Dimension(170, 170));
		menu_panel.add(result_menu);
		result_menu.setLayout(null);
		result_menu.setBorder(new LineBorder(new Color(69,159,226), 3));
		
		JLabel result_label = new JLabel("Result");
		result_label.setHorizontalAlignment(SwingConstants.CENTER);
		result_label.setForeground(new Color(69, 159, 226));
		result_label.setFont(new Font("Consolas", Font.BOLD, 20));
		result_label.setBounds(10, 135, 150, 25);
		result_menu.add(result_label);
		
		JLabel result_icon = new JLabel("");
		result_icon.setHorizontalAlignment(SwingConstants.CENTER);
		result_icon.setBounds(10, 10, 150, 115);
		result_icon.setIcon(getIcon(100,100,"score"));
		result_menu.add(result_icon);
		
		result_menu.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				new managerGUI.ResultGUI();
				setVisible(false);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				result_menu.setBackground(Color.lightGray);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				result_menu.setBackground(Color.white);
			}
		});
		
		JPanel ranking_menu = new JPanel();
		ranking_menu.setBackground(new Color(255, 255, 255));
		ranking_menu.setPreferredSize(new Dimension(170, 170));
		menu_panel.add(ranking_menu);
		ranking_menu.setLayout(null);
		ranking_menu.setBorder(new LineBorder(new Color(69,159,226), 3));
		
		JLabel rank_label = new JLabel("Rank");
		rank_label.setHorizontalAlignment(SwingConstants.CENTER);
		rank_label.setForeground(new Color(69, 159, 226));
		rank_label.setFont(new Font("Consolas", Font.BOLD, 20));
		rank_label.setBounds(10, 135, 150, 25);
		ranking_menu.add(rank_label);
		
		JLabel rank_icon = new JLabel("");
		rank_icon.setHorizontalAlignment(SwingConstants.CENTER);
		rank_icon.setBounds(10, 10, 150, 115);
		rank_icon.setIcon(getIcon(100,100,"league"));
		ranking_menu.add(rank_icon);
		
		ranking_menu.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				new managerGUI.RankGUI();
				setVisible(false);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				ranking_menu.setBackground(Color.lightGray);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				ranking_menu.setBackground(Color.white);
			}
		});
		
		JPanel logout_menu = new JPanel();
		logout_menu.setBackground(new Color(255, 255, 255));
		logout_menu.setPreferredSize(new Dimension(170, 170));
		menu_panel.add(logout_menu);
		logout_menu.setLayout(null);
		logout_menu.setBorder(new LineBorder(new Color(69,159,226), 3));
		
		JLabel logout_label = new JLabel("Log Out");
		logout_label.setHorizontalAlignment(SwingConstants.CENTER);
		logout_label.setForeground(new Color(69, 159, 226));
		logout_label.setFont(new Font("Consolas", Font.BOLD, 20));
		logout_label.setBounds(10, 135, 150, 25);
		logout_menu.add(logout_label);
		
		JLabel logout_icon = new JLabel("");
		logout_icon.setHorizontalAlignment(SwingConstants.CENTER);
		logout_icon.setBounds(10, 10, 150, 115);
		logout_icon.setIcon(getIcon(70,70,"logout"));
		logout_menu.add(logout_icon);
		
		logout_menu.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				new LoginGUI();
				setVisible(false);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				logout_menu.setBackground(Color.lightGray);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				logout_menu.setBackground(Color.white);
			}
		});
		
		//-----------------Background-----------------
		JLabel Background = new JLabel("");
		Background.setIcon(icon);
		Background.setBounds(0, 0, 1000, 600);
		getContentPane().add(Background);
		ImageIcon logo = new ImageIcon(getClass().getResource("/IMG/football.png"));
		this.setIconImage(logo.getImage());
		this.setTitle("V-League Management System");		
		this.setVisible(true);
		this.setResizable(false); //khoá thu phóng
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);	
	} 
	
	public static void main(String[] args) {
		new MainGUI();
	}
}
