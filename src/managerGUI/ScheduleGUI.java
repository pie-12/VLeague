package managerGUI;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import java.awt.Scrollbar;
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
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

import com.toedter.calendar.JDateChooser;
import com.toedter.components.JSpinField;

import DBS.DBController;

import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants;


public class ScheduleGUI extends JFrame{
	private JTextField matchID_textField;
	private static JComboBox team1_comboBox;
	private static JComboBox team2_comboBox;
	private JDateChooser dateChooser;
	private JSpinner spinner;
	private JComboBox stadium_comboBox;
	private JTable table;
	private Vector vector_Row, vector_Column;	
	private Boolean use_duplicate_check = true; //true = insert/update, false = choose row
	
	public Icon getIcon(int width, int height, String link) {
		Image image = new ImageIcon(getClass().getResource("/IMG/" + link + ".png")).getImage();
		Icon icon = new ImageIcon(image.getScaledInstance(width, height, image.SCALE_SMOOTH));
		return icon;
	}

	public static String get_idClub_from_team1_comboBox() {
		String res = null;
		Connection conn = new DBController().getConnection();
		String sql = "SELECT * FROM footballclub WHERE club_Name = ?";
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, team1_comboBox.getSelectedItem().toString());
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
	
	public static String get_idClub_from_team2_comboBox() {
		String res = null;
		Connection conn = new DBController().getConnection();
		String sql = "SELECT * FROM footballclub WHERE club_Name = ?";
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, team2_comboBox.getSelectedItem().toString());
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
		String sql = "SELECT * FROM vleague.schedule ORDER BY match_date ASC, match_time ASC";
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Vector vtemp = new Vector();
				vtemp.add(resultSet.getString("match_id"));
				vtemp.add(resultSet.getString("team1_name"));
				vtemp.add(resultSet.getString("team2_name"));
				vtemp.add(resultSet.getDate("match_date"));
				vtemp.add(resultSet.getTime("match_time"));
				vtemp.add(resultSet.getString("stadium_name"));
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
	
	public ScheduleGUI() {		
		this.setSize(1014, 542);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(312, 76, 633, 364);
		getContentPane().add(scrollPane);
		
		//------------Hiển thị bảng------------//
		vector_Column = new Vector();                                                                            
		vector_Column.add("Match ID");
		vector_Column.add("Team 1");
		vector_Column.add("Team 2");
		vector_Column.add("Match Date");
		vector_Column.add("Match Time");
		vector_Column.add("Stadium");	
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
					use_duplicate_check = false;
	                int row = table.getSelectedRow();
	                matchID_textField.setText(table.getValueAt(row, 0).toString());
	                team1_comboBox.setSelectedItem(table.getValueAt(row, 1).toString());
	                team2_comboBox.setSelectedItem(table.getValueAt(row, 2).toString());
	                dateChooser.setDate((Date)table.getValueAt(row, 3));
	                spinner.setValue(table.getValueAt(row, 4));
	                stadium_comboBox.setSelectedItem(table.getValueAt(row, 5).toString()); 
	                use_duplicate_check = true;
				} catch (java.lang.ClassCastException e) {
					// do nothing
				}				
              }						
		});	
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setBounds(18, 48, 120, 322);
		getContentPane().add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.RIGHT, 7, 30));
		
		JLabel matchID_Label = new JLabel("Match ID:");
		matchID_Label.setForeground(Color.WHITE);
		matchID_Label.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_1.add(matchID_Label);
		
		JLabel team1_Label = new JLabel("Team 1:");
		team1_Label.setForeground(Color.WHITE);
		team1_Label.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_1.add(team1_Label);
		
		JLabel team2_Label = new JLabel("Team 2:");
		team2_Label.setForeground(Color.WHITE);
		team2_Label.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_1.add(team2_Label);
		
		JLabel matchDate_Label = new JLabel("Match Date:");
		matchDate_Label.setForeground(Color.WHITE);
		matchDate_Label.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_1.add(matchDate_Label);
		
		JLabel matchTime_Label = new JLabel("Match Time:");
		matchTime_Label.setForeground(Color.WHITE);
		matchTime_Label.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_1.add(matchTime_Label);
		
		JLabel Stadium_Label = new JLabel("Stadium:");
		Stadium_Label.setForeground(Color.WHITE);
		Stadium_Label.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_1.add(Stadium_Label);
		
		matchID_textField = new JTextField();
		matchID_textField.setBounds(148, 76, 144, 19);
		getContentPane().add(matchID_textField);
		
		team1_comboBox = new JComboBox();
		team1_comboBox.setBounds(148, 123, 144, 21);
		team1_comboBox.setModel(new DefaultComboBoxModel(new String[] {"Becamex Bình Dương" , "Công An Hà Nội" , "Đông Á Thanh Hóa" , "Hà Nội FC" , "Hải Phòng" , "LPBank Hoàng Anh Gia Lai" , "Hồng Lĩnh Hà Tĩnh" , "Khánh Hòa" , "Quảng Nam" , "MerryLand Quy Nhơn Bình Định" , "Sông Lam Nghệ An" , "Thép Xanh Nam Định" , "TP Hồ Chí Minh" , "Thể Công – Viettel" }));
		team1_comboBox.setSelectedIndex(-1);
		getContentPane().add(team1_comboBox);
		
		
		team2_comboBox = new JComboBox();
		team2_comboBox.setBounds(148, 169, 144, 21);
		team2_comboBox.setModel(new DefaultComboBoxModel(new String[] {"Becamex Bình Dương" , "Công An Hà Nội" , "Đông Á Thanh Hóa" , "Hà Nội FC" , "Hải Phòng" , "LPBank Hoàng Anh Gia Lai" , "Hồng Lĩnh Hà Tĩnh" , "Khánh Hòa" , "Quảng Nam" , "MerryLand Quy Nhơn Bình Định" , "Sông Lam Nghệ An" , "Thép Xanh Nam Định" , "TP Hồ Chí Minh" , "Thể Công – Viettel" }));
		team2_comboBox.setSelectedIndex(-1);
		getContentPane().add(team2_comboBox);	
		
		//------------Kiểm tra trùng lặp------------//
		team1_comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (team1_comboBox.getSelectedItem() == team2_comboBox.getSelectedItem() && team1_comboBox.getSelectedIndex() != -1 && team2_comboBox.getSelectedIndex() != -1 && use_duplicate_check == true) {
					JOptionPane.showMessageDialog(null, "Team 1 and Team 2 must be different!");
					team1_comboBox.setSelectedIndex(-1);
				}
			}
		});
		team2_comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (team2_comboBox.getSelectedItem() == team1_comboBox.getSelectedItem() && team1_comboBox.getSelectedIndex() != -1 && team2_comboBox.getSelectedIndex() != -1 && use_duplicate_check == true) {
					JOptionPane.showMessageDialog(null, "Team 1 and Team 2 must be different!");
					team2_comboBox.setSelectedIndex(-1);
				}
			}
		});
		//---------------------------------------//
		
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy/MM/dd");
		dateChooser.setBounds(148, 216, 144, 19);
		dateChooser.setDate(new Date());
		getContentPane().add(dateChooser);
		
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerDateModel());
		JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(spinner, "HH:mm:ss");
		spinner.setEditor(timeEditor);
		spinner.setBounds(148, 261, 144, 19);
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");			
			Date twelveOClock = sdf.parse("12:00:00");
			spinner.setValue(twelveOClock);
		} catch (Exception e) {
			// TODO: handle exception
		}	
		getContentPane().add(spinner);
		
		stadium_comboBox = new JComboBox();
		stadium_comboBox.setBounds(148, 308, 144, 21);
		stadium_comboBox.setModel(new DefaultComboBoxModel(new String[] {"Bà Rịa", "Bến Tre", "Bình Phước", "Buôn Ma Thuột", "Cà Mau", "Cẩm Phả", "Cần Thơ", "Cao Lãnh", "Chi Lăng", "Gò Đậu", "Hà Nam", "Hà Tĩnh", "Hàng Đẫy", "Hoà Xuân", "Kon Tum", "Lạch Tray", "Lâm Viên", "Long An", "Mỹ Đình", "Ninh Bình", "Phan Thiết", "Phú Yên", "Pleiku", "Quân khu 7", "Quy Nhơn", "Rạch Giá", "Tam Kỳ", "Tây Ninh", "Thanh Hóa", "Thiên Trường", "Thống Nhất", "Tự Do", "Việt Trì", "Vinh", "Vĩnh Long", "Đồng Nai"}));
		stadium_comboBox.setSelectedIndex(-1);
		getContentPane().add(stadium_comboBox);

		JLabel team1_img_Label = new JLabel("");
		team1_img_Label.setBounds(10, 350, 125, 125);
		team1_img_Label.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		team1_img_Label.setHorizontalAlignment(JLabel.CENTER);
		team1_img_Label.setVerticalAlignment(JLabel.CENTER);
		team1_comboBox.addActionListener(new ActionListener() {            
            public void actionPerformed(ActionEvent e) {
                try {
                    // Xử lý sự kiện khi giá trị thay đổi
                    String selectedItem = (String)get_idClub_from_team1_comboBox();
                    if (selectedItem != null) {
                        Icon icon = getIcon(115, 115, selectedItem);                        
                        team1_img_Label.setIcon(icon);
                    }
                } catch (Exception ex) {                   
                    ex.printStackTrace();
                }
            }
        });
		getContentPane().add(team1_img_Label);
		JPanel panel_team1 = new JPanel();
		panel_team1.setBackground(new Color(255, 255, 255, 100));
		panel_team1.setBounds(10, 350, 125, 125);
		getContentPane().add(panel_team1);
		
		JLabel team2_img_Label = new JLabel("");
		team2_img_Label.setBounds(172, 350, 125, 125);
		team2_img_Label.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		team2_img_Label.setHorizontalAlignment(JLabel.CENTER);
		team2_img_Label.setVerticalAlignment(JLabel.CENTER);
		team2_comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Xử lý sự kiện khi giá trị thay đổi
					String selectedItem = (String) get_idClub_from_team2_comboBox();
					if (selectedItem != null) {
                        Icon icon = getIcon(115, 115, selectedItem);                        
						team2_img_Label.setIcon(icon);
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		getContentPane().add(team2_img_Label);
		JPanel panel_team2 = new JPanel();
		panel_team2.setBackground(new Color(255, 255, 255, 100));
		panel_team2.setBounds(172, 350, 125, 125);
		getContentPane().add(panel_team2);
		
		JLabel versus_Label = new JLabel("");
		versus_Label.setFont(new Font("Tahoma", Font.BOLD, 16));
		versus_Label.setForeground(new Color(255, 255, 255));
		versus_Label.setVerticalAlignment(SwingConstants.CENTER);
		versus_Label.setHorizontalAlignment(SwingConstants.CENTER);
		versus_Label.setText("VS");
		versus_Label.setBounds(91, 350, 125, 125);
		getContentPane().add(versus_Label);
		
		JLabel schedule_label = new JLabel("SCHEDULE");
		schedule_label.setFont(new Font("Tahoma", Font.BOLD, 30));
		schedule_label.setForeground(new Color(255, 255, 255));
		schedule_label.setHorizontalAlignment(SwingConstants.CENTER);
		schedule_label.setBounds(312, 10, 623, 44);
		getContentPane().add(schedule_label);
		
		//-----------------Button-----------------//
		JPanel button_panel = new JPanel();
		button_panel.setOpaque(false);
		button_panel.setBounds(194, 450, 772, 37);
		getContentPane().add(button_panel);
		button_panel.setLayout(new FlowLayout(FlowLayout.LEFT, 118, 0));
		
		JButton Insert_Button = new JButton("Insert");
		Insert_Button.setFocusable(false);
		Insert_Button.setBackground(Color.WHITE);
		button_panel.add(Insert_Button);
		
		
		Insert_Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (matchID_textField.getText().equals("") || team1_comboBox.getSelectedIndex() == -1 || team2_comboBox.getSelectedIndex() == -1 || stadium_comboBox.getSelectedIndex() == -1) {
                    JOptionPane.showMessageDialog(null, "Please fill in all fields!");
                }
                else {
                    Connection conn = new DBController().getConnection();
                    String sql = "INSERT INTO schedule (match_id, match_date, match_time, team1_name, team2_name, stadium_name) VALUES (?, ?, ?, ?, ?, ?)";
                    try {
                        PreparedStatement statement = conn.prepareStatement(sql);
                        statement.setString(1, matchID_textField.getText());
                        statement.setDate(2, new java.sql.Date(dateChooser.getDate().getTime()));
                        statement.setTime(3, new java.sql.Time(((Date)spinner.getValue()).getTime()));
                        statement.setString(4, team1_comboBox.getSelectedItem().toString());
                        statement.setString(5, team2_comboBox.getSelectedItem().toString());
                        statement.setString(6, stadium_comboBox.getSelectedItem().toString());
                        statement.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Insert successfully!");
                        vector_Row = getvRow();
                        table.setModel(new DefaultTableModel(vector_Row, vector_Column));
                    }
                    catch (java.sql.SQLIntegrityConstraintViolationException e2) {
						// TODO: handle exception
                    JOptionPane.showMessageDialog(null, "ID already taken, try another ID.");
					}
                    catch (SQLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }

                    matchID_textField.setText("");
                    team1_comboBox.setSelectedIndex(-1);
                    team2_comboBox.setSelectedIndex(-1);
                    stadium_comboBox.setSelectedIndex(-1);
                    dateChooser.setDate(new Date());
                    try {
                        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");			
                        Date twelveOClock = sdf.parse("12:00:00");
                        spinner.setValue(twelveOClock);
                    } catch (Exception e2) {
                    	e2.printStackTrace();
                    	}
                    }
            }
		});
		
		JButton Update_Button = new JButton("Update");
		Update_Button.setFocusable(false);
		Update_Button.setBackground(Color.WHITE);
		button_panel.add(Update_Button);
		
		Update_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
						Connection conn = new DBController().getConnection();
						DefaultTableModel model = (DefaultTableModel)table.getModel();
						int index_row = table.getSelectedRow();
						String ID_value = model.getValueAt(index_row, 0).toString();
						String sql = "UPDATE schedule SET match_id = ?, match_date = ?, match_time = ?, team1_name = ?, team2_name = ?, stadium_name = ? WHERE match_id = ?";
						PreparedStatement statement = conn.prepareStatement(sql);
						
						statement.setString(1, matchID_textField.getText());
						statement.setDate(2, new java.sql.Date(dateChooser.getDate().getTime()));
						statement.setTime(3, new java.sql.Time(((Date)spinner.getValue()).getTime()));
						statement.setString(4, team1_comboBox.getSelectedItem().toString());
						statement.setString(5, team2_comboBox.getSelectedItem().toString());
						statement.setString(6, stadium_comboBox.getSelectedItem().toString());
						statement.setString(7, ID_value);
						statement.execute();
						
						JOptionPane.showMessageDialog(null, "Update successfully!");
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
		Delete_Button.setFocusable(false);
		Delete_Button.setBackground(Color.WHITE);
		button_panel.add(Delete_Button);
		
		Delete_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vector vtemp;
				vtemp = getvRow();
				int index_row = table.getSelectedRow();
				int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this match?" , "Delete Confirm" , JOptionPane.YES_NO_CANCEL_OPTION);
				if(confirm == 0) {
					try {
						Connection conn = new DBController().getConnection();
						String match_id = ((Vector)vtemp.get(index_row)).get(0) + "";
						String sql = "DELETE FROM schedule WHERE match_id = ?";
						PreparedStatement statement = conn.prepareStatement(sql);
						statement.setString(1, match_id);
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
		Clear_Button.setFocusable(false);
		Clear_Button.setBackground(Color.WHITE);
		button_panel.add(Clear_Button);
		
		Clear_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				matchID_textField.setText("");
				team1_comboBox.setSelectedIndex(-1);
				team2_comboBox.setSelectedIndex(-1);
				stadium_comboBox.setSelectedIndex(-1);
				dateChooser.setDate(new Date());
				team1_img_Label.setIcon(null);
				team2_img_Label.setIcon(null);
				try {
					SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
					Date twelveOClock = sdf.parse("12:00:00");
					spinner.setValue(twelveOClock);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		
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
				new MainGUI();
				setVisible(false);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				back_panel.setBackground(Color.lightGray);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				back_panel.setBackground(Color.black);
			}
		});
		
		//-------------------Set Background-------------------//
		
		JLabel Background = new JLabel("");
		Background.setIcon(new ImageIcon(PlayerGUI.class.getResource("/IMG/gg.png")));
		Background.setBounds(0, 0, 1000, 505);
		getContentPane().add(Background);
		ImageIcon logo = new ImageIcon(getClass().getResource("/IMG/football.png"));
		this.setIconImage(logo.getImage());
		this.setTitle("Schedule Management");
		this.setVisible(true);
		this.setResizable(false); // khoá thu phóng
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new ScheduleGUI();
	}
}
