package guessGUI;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import DBS.DBController;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;


public class PlayerGUI extends JFrame{
	private static JTextField ID_TextField;
	private JTextField PlayerName_TextField;
	private JTextField ShirtNumber_TextField;
	private JTextField Age_TextField;
	private JTextField Weight_TextField;
	private JTextField Nationality_TextField;
	private JTextField Height_TextField;
	private JTable table;
	private static JComboBox clubCombobox;
	private static JComboBox searchby_comBox;
	private Vector vector_Row, vector_Column;
	private static JTextField Search_textField;
	
	public Icon getIcon(int width, int height, String link) {
		Image image = new ImageIcon(getClass().getResource("/IMG/" + link + ".png")).getImage();
		Icon icon = new ImageIcon(image.getScaledInstance(width, height, image.SCALE_SMOOTH));
		return icon;
	}
	
	public static String get_nameClub() {
		String res = null;
		Connection conn = new DBController().getConnection();
		String sql = "SELECT club_Name FROM footballclub WHERE club_ID = ?";
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, get_idClub_fromtextfield());
			ResultSet resultSet = statement.executeQuery();	
			if(resultSet.next()) res = resultSet.getString("club_Name");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;				
	}
		
	public static String get_idClub_fromtextfield() {
		String res = null;
		Connection conn = new DBController().getConnection();
		String sql = "SELECT club_ID FROM footballplayer WHERE ID = ?";
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, ID_TextField.getText());
			ResultSet resultSet = statement.executeQuery();	
			if(resultSet.next()) res = resultSet.getString("club_ID");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;				
	}
	
	public static String get_idClub() {
		String res = null;
		Connection conn = new DBController().getConnection();
		String sql = "SELECT * FROM footballclub WHERE club_Name = ?";
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, clubCombobox.getSelectedItem().toString());
			ResultSet resultSet = statement.executeQuery();	
			if(resultSet.next()) res = resultSet.getString("club_ID");
		}
		catch (java.lang.NullPointerException e1) {
			//feature
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return res;				
	}
	
	public static Vector getvRow() {
		Connection conn = new DBController().getConnection();
		Vector vD = new Vector();
		String id_Club = get_idClub();
		String sql = "SELECT * FROM vleague.footballplayer WHERE footballplayer.club_ID = ?";
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, id_Club);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Vector vtemp = new Vector();
				vtemp.add(resultSet.getString("ID"));
				vtemp.add(resultSet.getString("Name"));
				vtemp.add(resultSet.getInt("ShirtNumber"));
				vtemp.add(resultSet.getString("Position"));
				vtemp.add(resultSet.getInt("Weight"));
				vtemp.add(resultSet.getInt("Height"));
				vtemp.add(resultSet.getInt("Age"));
				vtemp.add(resultSet.getString("Nationality"));
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
	public static Vector getvRow_search() {
		Connection conn = new DBController().getConnection();
		Vector vD = new Vector();
		String id_Club = get_idClub();
		String type_combox = (String)(searchby_comBox.getSelectedItem().toString());
		String sql = "SELECT * FROM vleague.footballplayer WHERE " + type_combox + " LIKE '%" + (String)(Search_textField.getText()) + "%'";
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Vector vtemp = new Vector();
				vtemp.add(resultSet.getString("ID"));
				vtemp.add(resultSet.getString("Name"));
				vtemp.add(resultSet.getInt("ShirtNumber"));
				vtemp.add(resultSet.getString("Position"));
				vtemp.add(resultSet.getInt("Weight"));
				vtemp.add(resultSet.getInt("Height"));
				vtemp.add(resultSet.getInt("Age"));
				vtemp.add(resultSet.getString("Nationality"));
				vD.add(vtemp);				
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return vD;
	}
	public PlayerGUI(){
				
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 51, 120, 322);
		getContentPane().add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.RIGHT, 7, 30));
		panel_1.setOpaque(false); //trong suốt
		
		JLabel ID_Label = new JLabel("ID:");
		ID_Label.setForeground(Color.WHITE);
		ID_Label.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_1.add(ID_Label);
		
		JLabel PlayerName_Label = new JLabel("Player Name:");
		PlayerName_Label.setForeground(Color.WHITE);
		PlayerName_Label.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_1.add(PlayerName_Label);
		
		JLabel ShirtNumber_Label = new JLabel("Shirt Number:");
		ShirtNumber_Label.setForeground(Color.WHITE);
		ShirtNumber_Label.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_1.add(ShirtNumber_Label); 
		
		JLabel Position_Label = new JLabel("Position:");
		Position_Label.setForeground(Color.WHITE);
		Position_Label.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_1.add(Position_Label);
		
		JLabel Weight_Label = new JLabel("Weight:");
		Weight_Label.setForeground(Color.WHITE);
		Weight_Label.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_1.add(Weight_Label);
		
		JLabel Nationality_Label = new JLabel("Nationality:");
		Nationality_Label.setForeground(Color.WHITE);
		Nationality_Label.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_1.add(Nationality_Label);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(134, 51, 168, 140);
		getContentPane().add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.LEFT, 8, 26));
		panel_2.setOpaque(false);
		
		ID_TextField = new JTextField();
		panel_2.add(ID_TextField);
		ID_TextField.setColumns(15);
		
		PlayerName_TextField = new JTextField();
		panel_2.add(PlayerName_TextField);
		PlayerName_TextField.setColumns(15);
		
		ShirtNumber_TextField = new JTextField();
		panel_2.add(ShirtNumber_TextField);
		ShirtNumber_TextField.setColumns(4);
		
		JLabel Age_Label = new JLabel("     Age:");
		Age_Label.setForeground(Color.WHITE);
		panel_2.add(Age_Label);
		Age_Label.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		Age_TextField = new JTextField();
		panel_2.add(Age_TextField);
		Age_TextField.setColumns(4);
		
		JComboBox Position_comboBox = new JComboBox();
		Position_comboBox.setBounds(141, 216, 100, 21);
		getContentPane().add(Position_comboBox);
		Position_comboBox.setModel(new DefaultComboBoxModel(new String[] {"Forward",  "Midfielder" , "Defender", "Goalkeeper"}));
		Position_comboBox.setSelectedIndex(-1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(134, 236, 168, 134);
		getContentPane().add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.LEFT, 8, 26));
		panel_3.setOpaque(false);
		
		Weight_TextField = new JTextField();
		Weight_TextField.setColumns(4);
		panel_3.add(Weight_TextField);
		
		JLabel Height_Label = new JLabel("Height:");
		Height_Label.setForeground(Color.WHITE);
		Height_Label.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_3.add(Height_Label);
		
		Height_TextField = new JTextField();
		Height_TextField.setColumns(4);
		panel_3.add(Height_TextField);
		
		Nationality_TextField = new JTextField();
		panel_3.add(Nationality_TextField);
		Nationality_TextField.setColumns(15);
			
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(312, 76, 633, 364);
		getContentPane().add(scrollPane);
		
		clubCombobox = new JComboBox();
		clubCombobox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(clubCombobox.getSelectedIndex() != -1) {
					Vector vector_Row = new Vector();
					vector_Row = getvRow();
					table.setModel(new DefaultTableModel(vector_Row, vector_Column));
					scrollPane.setViewportView(table);	
				}
				else scrollPane.setViewportView(table);	
			}
		});
		
		JLabel club_Label = new JLabel("");
		club_Label.setBounds(136, 335, 160, 160);
		club_Label.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		club_Label.setHorizontalAlignment(JLabel.CENTER);
		club_Label.setVerticalAlignment(JLabel.CENTER);
		clubCombobox.addActionListener(new ActionListener() {            
            public void actionPerformed(ActionEvent e) {
                try {
                    // Xử lý sự kiện khi giá trị thay đổi
                    String selectedItem = (String) get_idClub();
                    if (selectedItem != null) {
                        Icon icon = getIcon(150, 150, selectedItem);                        
                        club_Label.setIcon(icon);
                    }
                } catch (Exception ex) {                   
                    ex.printStackTrace();
                }
            }
        });
       
		getContentPane().add(club_Label);	
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(136, 335, 160, 160);
		panel_4.setBackground(new Color(255, 255, 255, 100));
		getContentPane().add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(253, 10, 700, 50);
		getContentPane().add(panel_5);
		panel_5.setLayout(new FlowLayout(FlowLayout.LEFT, 9, 20));
		panel_5.setOpaque(false);
		
		
		JLabel ClubName_Label = new JLabel("Club Name:");
		ClubName_Label.setForeground(Color.WHITE);
		ClubName_Label.setFont(new Font("Tahoma", Font.BOLD, 12));
		ClubName_Label.setBounds(312, 31, 100, 16);
		panel_5.add(ClubName_Label);
		
		clubCombobox.setModel(new DefaultComboBoxModel(new String[] {"Free Agents" , "Becamex Bình Dương" , "Công An Hà Nội" , "Đông Á Thanh Hóa" , "Hà Nội FC" , "Hải Phòng" , "LPBank Hoàng Anh Gia Lai" , "Hồng Lĩnh Hà Tĩnh" , "Khánh Hòa" , "Quảng Nam" , "MerryLand Quy Nhơn Bình Định" , "Sông Lam Nghệ An" , "Thép Xanh Nam Định" , "TP Hồ Chí Minh" , "Thể Công – Viettel" }));
		clubCombobox.setBounds(388, 30, 222, 21);
		panel_5.add(clubCombobox);		
		
		JLabel Search_Label = new JLabel("     Search:");
		Search_Label.setForeground(Color.WHITE);
		Search_Label.setFont(new Font("Tahoma", Font.BOLD, 12));
		Search_Label.setBounds(627, 30, 100, 16);
		panel_5.add(Search_Label);
		
		Search_textField = new JTextField();
		Search_textField.setColumns(15);
		Search_textField.setBounds(685, 30, 100, 19);
		panel_5.add(Search_textField);
		
		JLabel By_Label = new JLabel("By:");
		By_Label.setForeground(Color.WHITE);
		By_Label.setFont(new Font("Tahoma", Font.BOLD, 12));
		By_Label.setBounds(795, 30, 34, 16);
		panel_5.add(By_Label);
		
		searchby_comBox = new JComboBox();
		searchby_comBox.setModel(new DefaultComboBoxModel(new String[] {"ID",  "Name" , "Position", "Age", "Nationality"}));
		searchby_comBox.setBounds(825, 30, 89, 21);
		searchby_comBox.setSelectedIndex(-1);
		panel_5.add(searchby_comBox);	
		
		
		
		
		//------------Hiển thị bảng------------//
		vector_Column = new Vector();                                                                            
		vector_Column.add("Player ID");
		vector_Column.add("Player Name");
		vector_Column.add("Shirt Number");
		vector_Column.add("Position");
		vector_Column.add("Weight");
		vector_Column.add("Height");
		vector_Column.add("Age");
		vector_Column.add("Nationality");		
		
		table = new JTable();
		table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 11));	
		//table.getTableHeader().setResizingAllowed(false);
		table.getTableHeader().setReorderingAllowed(false);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	
				int index = table.getSelectedRow();
				ID_TextField.setText(table.getValueAt(index, 0).toString());
				PlayerName_TextField.setText(table.getValueAt(index, 1).toString());
				ShirtNumber_TextField.setText(table.getValueAt(index, 2).toString());
				Position_comboBox.setSelectedItem(table.getValueAt(index, 3).toString());
				Weight_TextField.setText(table.getValueAt(index, 4).toString());
				Height_TextField.setText(table.getValueAt(index, 5).toString());
				Age_TextField.setText(table.getValueAt(index, 6).toString());
				Nationality_TextField.setText(table.getValueAt(index, 7).toString());
				
				String selectedItem = get_idClub_fromtextfield();
                if (selectedItem != null) {
                    Icon icon = getIcon(150, 150, selectedItem);                        
                    club_Label.setIcon(icon);
                } 
			}
		});			
		
		vector_Row = getvRow();
		table.setModel(new DefaultTableModel(vector_Row, vector_Column));
		scrollPane.setViewportView(table);

		//------------Cài đặt chức năng cho các nút------------//
		JButton Search_Button = new JButton();
		//Search_Button.setBackground(new Color(255, 255, 255));
		ImageIcon Icon = new ImageIcon("src/IMG/search.png");
		Search_Button.setIcon(Icon);
		Search_Button.setLocation(0,0);
		Search_Button.setFocusable(false);
		Search_Button.setPreferredSize(new Dimension(30, 25));
		Search_Button.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Vector vD = new Vector();							
					Vector vector_Row = new Vector();
					vector_Row = getvRow_search();
					
					club_Label.setIcon(null);
					
					table.setModel(new DefaultTableModel(vector_Row, vector_Column));
					scrollPane.setViewportView(table);							
				}
				catch (java.lang.NullPointerException e1) {
					JOptionPane.showMessageDialog(null, "Please select type of information you want to search.");
				}
				catch (Exception e3) {
				    e3.printStackTrace();
				    JOptionPane.showMessageDialog(null, "Search failed.");
				}				
			}
		});
		panel_5.add(Search_Button);
		
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
				new guessGUI.MainGUI();
				setVisible(false);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				back_panel.setBackground(Color.lightGray);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				back_panel.setBackground(Color.black);
			}
		});
		
		//------------------Background và cài đặt Frame---------------------//
		JLabel Background = new JLabel("");
		Background.setIcon(new ImageIcon(PlayerGUI.class.getResource("/IMG/gg.png")));
		Background.setBounds(0, 0, 1000, 505);
		getContentPane().add(Background);
		
		this.setSize(1014,542);
		getContentPane().setLayout(null);
		ImageIcon logo = new ImageIcon(getClass().getResource("/IMG/football.png"));
		this.setIconImage(logo.getImage());
		this.setTitle("Player Management");	
		this.setVisible(true);
		this.setResizable(false); //khoá thu phóng
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);		
	}
	public static void main(String[] args) {
		new PlayerGUI();
	}
}

