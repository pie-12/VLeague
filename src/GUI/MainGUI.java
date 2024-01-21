package GUI;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class MainGUI extends JFrame {
	public Icon getIcon(String link) {
		int width = 1000, height = 600;
		Image image = new ImageIcon(getClass().getResource("/IMG/" + link + ".png")).getImage();
		Icon icon = new ImageIcon(image.getScaledInstance(width, height, image.SCALE_SMOOTH));
		return icon;
	}
	public MainGUI(){
		Icon icon = getIcon("mainGUI");		
		this.setSize(1000,600);
		getContentPane().setLayout(null);
		
		JPanel title_panel = new JPanel();
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0, 0, 1000, 120);
		title_panel.setBackground(new Color(69, 159, 226));		
		
		JLabel title = new JLabel("V-LEAGUE MANAGEMENT SYSTEM");
		title.setFont(new Font("Tahoma", Font.BOLD, 35));
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setForeground(Color.WHITE);
		title.setBounds(0, 0, 1000, 150);
		title_panel.add(title);
		getContentPane().add(title_panel);
		
		JPanel menu_panel = new JPanel();
		menu_panel.setBounds(0, 120, 1000, 450);
		menu_panel.setOpaque(false);
		//getContentPane().add(menu_panel);
		menu_panel.setLayout(new BoxLayout(menu_panel, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		panel.setBounds(85, 229, 144, 120);
		getContentPane().add(panel);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 144, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 120, Short.MAX_VALUE)
		);
		panel.setLayout(gl_panel);
		
		JLabel Background = new JLabel("");
		Background.setIcon(icon);
		Background.setBounds(0, 0, 1000, 600);
		getContentPane().add(Background);
		this.setVisible(true);
		this.setResizable(false); //khoá thu phóng
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);	
	} 
	
	public static void main(String[] args) {
		new MainGUI();
	}
}
