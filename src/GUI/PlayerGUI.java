package GUI;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
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
	private JTextField ID_TextField;
	private JTextField PlayerName_TextField;
	private JTextField ShirtNumber_TextField;
	private JTextField Age_TextField;
	private JTextField Weight_TextField;
	private JTextField Nationality_TextField;
	private JTextField Height_TextField;
	private JTable table;
	private static JComboBox clubCombobox;
	private Vector vector_Row, vector_Column;
	
	public Icon getIcon(String link) {
		int width = 150, height = 150;
		Image image = new ImageIcon(getClass().getResource("/IMG/" + link + ".png")).getImage();
		Icon icon = new ImageIcon(image.getScaledInstance(width, height, image.SCALE_SMOOTH));
		return icon;
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
		} catch (Exception e) {
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
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return vD;
	}
	
	public PlayerGUI(){
		//---------------Khai báo các component---------------//			
		JPanel panel = new JPanel();
		panel.setBounds(194, 450, 772, 37);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 118, 0));
		this.add(panel);
		panel.setOpaque(false);
		
		JButton Back_Button = new JButton("Back");
		Back_Button.setFont(new Font("Tahoma", Font.BOLD, 10));
		Back_Button.setBounds(0, 0, 65, 21);
		this.add(Back_Button);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(18, 48, 120, 322);
		this.add(panel_1);
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
		this.add(panel_2);
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
		this.add(Position_comboBox);
		Position_comboBox.setModel(new DefaultComboBoxModel(new String[] {"Forward",  "Midfielder" , "Defender", "Goalkeeper"}));
		Position_comboBox.setSelectedIndex(-1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(134, 236, 168, 134);
		this.add(panel_3);
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
		this.add(scrollPane);
		
		clubCombobox = new JComboBox();
		clubCombobox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Vector vector_Row = new Vector();
				vector_Row = getvRow();
				table.setModel(new DefaultTableModel(vector_Row, vector_Column));
				scrollPane.setViewportView(table);					
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
                        Icon icon = getIcon(selectedItem);                        
                        club_Label.setIcon(icon);
                    }
                } catch (Exception ex) {                   
                    ex.printStackTrace();
                }
            }
        });
		this.add(club_Label);	
		
		JLabel ClubName_Label = new JLabel("Club Name:");
		ClubName_Label.setForeground(Color.WHITE);
		ClubName_Label.setFont(new Font("Tahoma", Font.BOLD, 14));
		ClubName_Label.setBounds(342, 31, 100, 16);
		this.add(ClubName_Label);
		
		clubCombobox.setModel(new DefaultComboBoxModel(new String[] {"Free Agents" , "Becamex Bình Dương" , "Công An Hà Nội" , "Đông Á Thanh Hóa" , "Hà Nội FC" , "Hải Phòng" , "LPBank Hoàng Anh Gia Lai" , "Hồng Lĩnh Hà Tĩnh" , "Khánh Hòa" , "Quảng Nam" , "MerryLand Quy Nhơn Bình Định" , "Sông Lam Nghệ An" , "Thép Xanh Nam Định" , "TP Hồ Chí Minh" , "Thể Công – Viettel" }));
		clubCombobox.setBounds(440, 30, 222, 21);
		this.add(clubCombobox);			
		
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
			}
		});			
		
		vector_Row = getvRow();
		table.setModel(new DefaultTableModel(vector_Row, vector_Column));
		scrollPane.setViewportView(table);

		//------------Cài đặt chức năng cho các nút------------//
		JButton Insert_Button = new JButton("Insert");
		Insert_Button.setBounds(342, 400, 85, 21);
		panel.add(Insert_Button);
		
		Insert_Button.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conn = new DBController().getConnection();
					Vector vD = new Vector();
					String sql = "INSERT INTO vleague.footballplayer VALUES (?,?,?,?,?,?,?,?,?)";
					PreparedStatement statement = conn.prepareStatement(sql);
					
					statement.setString(1, ID_TextField.getText());
					statement.setString(2, PlayerName_TextField.getText());
					statement.setInt(3, Integer.parseInt(ShirtNumber_TextField.getText()));
					statement.setString(4, Position_comboBox.getSelectedItem().toString());
					statement.setInt(5, Integer.parseInt(Weight_TextField.getText()));
					statement.setInt(6, Integer.parseInt(Height_TextField.getText()));
					statement.setInt(7, Integer.parseInt(Age_TextField.getText()));
					statement.setString(8, Nationality_TextField.getText());
					String idClub = (String)get_idClub();
					statement.setString(9, idClub);
					statement.execute();
					
					JOptionPane.showMessageDialog(null, "Inserted successfully!");
					Vector vector_Row = new Vector();
					vector_Row = getvRow();
					table.setModel(new DefaultTableModel(vector_Row, vector_Column));
					scrollPane.setViewportView(table);				
					
				}
				catch (java.lang.NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Please enter complete information.");
				}
				catch (java.sql.SQLIntegrityConstraintViolationException e2) {
					JOptionPane.showMessageDialog(null, "ID already taken, try another ID.");
				}
				catch (Exception e3) {
				    e3.printStackTrace();
				    JOptionPane.showMessageDialog(null, "Insert failed.");
				}				
			}
		});		
		
		JButton Update_Button = new JButton("Update");
		Update_Button.setBounds(463, 400, 85, 21);
		panel.add(Update_Button);		
		
		Update_Button.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conn = new DBController().getConnection();
					DefaultTableModel model = (DefaultTableModel)table.getModel();
					int index_row = table.getSelectedRow();
					String ID_value = (String)model.getValueAt(index_row, 0);
					String sql = "UPDATE footballplayer SET ID = ?, Name = ?, ShirtNumber = ?, Position = ?, Weight = ?, Height = ?, Age = ?, Nationality = ? WHERE ID = ?";
					PreparedStatement statement = conn.prepareStatement(sql);
					
					statement.setString(1, ID_TextField.getText());
					statement.setString(2, PlayerName_TextField.getText());
					statement.setInt(3, Integer.parseInt(ShirtNumber_TextField.getText()));
					statement.setString(4, Position_comboBox.getSelectedItem().toString());
					statement.setInt(5, Integer.parseInt(Weight_TextField.getText()));
					statement.setInt(6, Integer.parseInt(Height_TextField.getText()));
					statement.setInt(7, Integer.parseInt(Age_TextField.getText()));
					statement.setString(8, Nationality_TextField.getText());
					statement.setString(9, ID_value);
					statement.execute();
		            
					JOptionPane.showMessageDialog(null, "Updated successfully!");
					Vector vector_Row = new Vector();
					vector_Row = getvRow();
					table.setModel(new DefaultTableModel(vector_Row, vector_Column));
					scrollPane.setViewportView(table);				
				}

				catch (java.lang.ArrayIndexOutOfBoundsException e1) {
					JOptionPane.showMessageDialog(null, "No row selected.");
				}
				catch (SQLIntegrityConstraintViolationException e2) {
					JOptionPane.showMessageDialog(null, "ID already taken, try another ID.");
				}
				catch (Exception e3) {
				    e3.printStackTrace();
				    JOptionPane.showMessageDialog(null, "Update failed.");
				}				
			}
		});
		
		JButton Delete_Button = new JButton("Delete");
		Delete_Button.setBounds(577, 400, 85, 21);
		panel.add(Delete_Button);
		
		Delete_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vector vtemp;
				vtemp = getvRow();
				int index_row = table.getSelectedRow();
				int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this player?" , "Delete Confirm" , JOptionPane.YES_NO_CANCEL_OPTION);
				if(confirm == 0) {
					try {
						Connection conn = new DBController().getConnection();
						String idFootballplayer = ((Vector)vtemp.get(index_row)).get(0) + "";
						String sql = "DELETE FROM footballplayer WHERE ID = ?";
						PreparedStatement statement = conn.prepareStatement(sql);
						statement.setString(1, idFootballplayer);
						statement.execute();
						
						JOptionPane.showMessageDialog(null, "Deleted successfully.");
						Vector vector_Row = new Vector();
						vector_Row = getvRow();
						table.setModel(new DefaultTableModel(vector_Row, vector_Column));
						scrollPane.setViewportView(table);
					}
					catch (java.lang.ArrayIndexOutOfBoundsException e1) {
						JOptionPane.showMessageDialog(null, "No row selected.");
					}
					catch (SQLException e2) {
						e2.printStackTrace();
						JOptionPane.showMessageDialog(null, "Delete failed.");
					}
				}
			}
		});		
		
		JButton Clear_Button = new JButton("Clear");
		Clear_Button.setBounds(694, 400, 85, 21);
		panel.add(Clear_Button);
		
		Clear_Button.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ID_TextField.setText("");
					PlayerName_TextField.setText("");
					ShirtNumber_TextField.setText("");
					Position_comboBox.setSelectedIndex(-1);
					Weight_TextField.setText("");
					Height_TextField.setText("");
					Age_TextField.setText("");
					Nationality_TextField.setText("");						
					
					Vector vector_Row = new Vector();
					vector_Row = getvRow();
					table.setModel(new DefaultTableModel(vector_Row, vector_Column));
					scrollPane.setViewportView(table);				
					
				} catch (Exception e2) {
				    e2.printStackTrace();
				    JOptionPane.showMessageDialog(null, "Clear failed.");
				}				
			} 
		});		
		
		//------------------Background và cài đặt Frame---------------------//
		JLabel Background = new JLabel("");
		Background.setIcon(new ImageIcon(PlayerGUI.class.getResource("/IMG/gg.png")));
		Background.setBounds(0, 0, 1000, 505);
		this.add(Background);
		
		this.setSize(1014,542);
		this.setLayout(null);
		this.setVisible(true);
		this.setResizable(false); //khoá thu phóng
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);		
	}
	public static void main(String[] args) {
		new PlayerGUI();
	}
}

