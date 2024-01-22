package managerGUI;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import java.awt.Scrollbar;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.awt.ScrollPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.ImageView;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

import com.toedter.calendar.JDateChooser;
import com.toedter.components.JSpinField;

import DBS.DBController;

import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants;


public class RankGUI extends JFrame{
	private JTable table;
	private Vector vector_Row, vector_Column;	
	private Boolean use_duplicate_check = true; //true = insert/update, false = choose row
	private JLabel team1_img_Label;
    private JLabel team2_img_Label;
	
	public Icon getIcon(int width, int height, String link) {
		Image image = new ImageIcon(getClass().getResource("/IMG/" + link + ".png")).getImage();
		Icon icon = new ImageIcon(image.getScaledInstance(width, height, image.SCALE_SMOOTH));
		return icon;
	}
	
	public String get_idClub_from_nameclub(String nameclub) {
		Connection conn = new DBController().getConnection();
		String sql = "SELECT club_ID FROM vleague.footballclub WHERE club_Name = ?";
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, nameclub);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				return resultSet.getString("club_ID");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static Vector getvRow() {
		Connection conn = new DBController().getConnection();
		Vector vD = new Vector();
		String sql = "SELECT * FROM vleague.rank ORDER BY Points DESC";
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			int i = 0;
			while(resultSet.next()) {
				Vector vtemp = new Vector();
				vtemp.add(++i);
				vtemp.add(resultSet.getString("club_name"));
				vtemp.add(resultSet.getInt("Matches_played"));
				vtemp.add(resultSet.getInt("Win"));
				vtemp.add(resultSet.getInt("Draw"));
				vtemp.add(resultSet.getInt("Lose"));
				vtemp.add(resultSet.getInt("Points"));				
				vD.add(vtemp);				
			}
			}
		catch (java.lang.NullPointerException e1) {
			//feature
		}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return vD;
	}
	
	public RankGUI() {		
		this.setSize(1014, 542);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(218, 76, 727, 364);
		getContentPane().add(scrollPane);
		
		JLabel club_Label = new JLabel("");
		club_Label.setBounds(20, 76, 170, 170);
		club_Label.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		club_Label.setHorizontalAlignment(JLabel.CENTER);
		club_Label.setVerticalAlignment(JLabel.CENTER);

		getContentPane().add(club_Label);
		JPanel club_panel = new JPanel();
		club_panel.setBackground(new Color(255, 255, 255, 100));
		club_panel.setBounds(20, 76, 170, 170);
		getContentPane().add(club_panel);
		
		//------------Hiển thị bảng------------//
		vector_Column = new Vector();     
		vector_Column.add("Rank");
		vector_Column.add("Club name");
		vector_Column.add("Matches played");
		vector_Column.add("Won matches");
		vector_Column.add("Draw matches");
		vector_Column.add("Lost matches");
		vector_Column.add("Points");	
		table = new JTable();
		vector_Row = getvRow();
		table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));	
		//table.getTableHeader().setResizingAllowed(false);
		table.getTableHeader().setReorderingAllowed(false);
		table.setModel(new DefaultTableModel(vector_Row, vector_Column));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				try {
	                int row = table.getSelectedRow();
	                String nameclub = table.getValueAt(row, 1).toString();
	                String selectedItem = get_idClub_from_nameclub(nameclub);
	                if (selectedItem != null) {
	                    Icon icon = getIcon(155, 155, selectedItem);                        
	                    club_Label.setIcon(icon);
	                } 
	                
				} catch (java.lang.ClassCastException e) {
					// do nothing
				}				
              }				
		});	
		
		scrollPane.setViewportView(table);
		
		JLabel ranking_label = new JLabel("RANKING");
		ranking_label.setFont(new Font("Tahoma", Font.BOLD, 30));
		ranking_label.setForeground(new Color(255, 255, 255));
		ranking_label.setHorizontalAlignment(SwingConstants.CENTER);
		ranking_label.setBounds(218, 10, 727, 44);
		getContentPane().add(ranking_label);
		
		//------------------------Button------------------------//
		JPanel back_panel = new JPanel();
		back_panel.setBounds(0, 0, 40, 40);
		getContentPane().add(back_panel);
		back_panel.setBackground(Color.black);
		back_panel.setLayout(null);
		JLabel back_icon = new JLabel("");
		back_icon.setHorizontalAlignment(SwingConstants.CENTER);
		back_icon.setVerticalAlignment(SwingConstants.CENTER);
		back_icon.setBounds(0, 0, 38, 38);
		back_icon.setIcon(getIcon(38,38,"left-arrow"));
		back_panel.add(back_icon);
		
		back_panel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				new managerGUI.MainGUI();
				setVisible(false);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				back_panel.setBackground(Color.lightGray);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				back_panel.setBackground(Color.black);
			}
		});
		
		JButton chart_button = new JButton("Show Chart");
		chart_button.setBounds(20, 419, 170, 21);
		getContentPane().add(chart_button);
		chart_button.setBackground(Color.WHITE);
		chart_button.setFont(new Font("Tahoma", Font.BOLD, 12));
		chart_button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		chart_button.setFocusPainted(false);
		
		chart_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new managerGUI.ChartGUI();
				setVisible(false);
			}
		});
		//-------------------Set Background-------------------//
		
		JLabel Background = new JLabel("");
		Background.setIcon(new ImageIcon(PlayerGUI.class.getResource("/IMG/gg.png")));
		Background.setBounds(0, 0, 1000, 505);
		getContentPane().add(Background);
		ImageIcon logo = new ImageIcon(getClass().getResource("/IMG/football.png"));
		this.setIconImage(logo.getImage());
		this.setTitle("V-League Ranking");	
		this.setVisible(true);
		this.setResizable(false); // khoá thu phóng
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new RankGUI();
	}
}
