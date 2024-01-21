package GUI;

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
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

import com.toedter.calendar.JDateChooser;
import com.toedter.components.JSpinField;

import DBS.DBController;

import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants;


public class ResultGUI extends JFrame{
	private JTextField matchID_textField;
	private static TextField team1_textField;
    private static TextField team2_textField;
	private JTable table;
	private Vector vector_Row, vector_Column;	
	private Boolean use_duplicate_check = true; //true = insert/update, false = choose row
	private JTextField score_1_textField;
	private JTextField score_2_textField;
	
	public Icon getIcon(String link) {
		int width = 115, height = 115;
		Image image = new ImageIcon(getClass().getResource("/IMG/" + link + ".png")).getImage();
		Icon icon = new ImageIcon(image.getScaledInstance(width, height, image.SCALE_SMOOTH));
		return icon;
	}

	public static String get_idClub_from_team1_textField() {
		String res = null;
		Connection conn = new DBController().getConnection();
		String sql = "SELECT * FROM footballclub WHERE club_Name = ?";
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, team1_textField.getText());
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
	
	public static String get_idClub_from_team2_textField() {
		String res = null;
		Connection conn = new DBController().getConnection();
		String sql = "SELECT * FROM footballclub WHERE club_Name = ?";
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, team2_textField.getText());
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
		String sql = "SELECT * FROM vleague.schedule";
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Vector vtemp = new Vector();
				vtemp.add(resultSet.getString("match_id"));
				vtemp.add(resultSet.getString("team1_name"));
				if(resultSet.getString("score_1") == null || resultSet.getString("score_2") == null)
					vtemp.add("? - ?");
				else
					vtemp.add(resultSet.getString("score_1") + " - " + resultSet.getString("score_2"));
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
	
	public ResultGUI() {		
		this.setSize(1014, 542);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(312, 76, 633, 364);
		getContentPane().add(scrollPane);
		
		//------------Hiển thị bảng------------//
		vector_Column = new Vector();                                                                            
		vector_Column.add("Match ID");
		vector_Column.add("Team 1");
		vector_Column.add("Result");
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
	                team1_textField.setText(table.getValueAt(row, 1).toString());
	                team2_textField.setText(table.getValueAt(row, 3).toString());
				} catch (java.lang.ClassCastException e) {
					// do nothing
				}				
              }						
		});	
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setBounds(18, 48, 120, 171);
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
		
		matchID_textField = new JTextField();
		matchID_textField.setBounds(148, 76, 144, 19);
		matchID_textField.setEditable(false);
		getContentPane().add(matchID_textField);
		
		team1_textField = new TextField();
		team1_textField.setBounds(148, 123, 144, 21);
		team1_textField.setEditable(false);
		getContentPane().add(team1_textField);
		
		
		team2_textField = new TextField();
		team2_textField.setBounds(148, 169, 144, 21);
		team2_textField.setEditable(false);
		getContentPane().add(team2_textField);
		
		
		

		JLabel team1_img_Label = new JLabel("");
		team1_img_Label.setBounds(10, 350, 125, 125);
		team1_img_Label.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		team1_img_Label.setHorizontalAlignment(JLabel.CENTER);
		team1_img_Label.setVerticalAlignment(JLabel.CENTER);
		team1_textField.addActionListener(new ActionListener() {            
            public void actionPerformed(ActionEvent e) {
                try {
                    // Xử lý sự kiện khi giá trị thay đổi
                    String selectedItem = (String)get_idClub_from_team1_textField();
                    if (selectedItem != null) {
                        Icon icon = getIcon(selectedItem);                        
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
		team2_textField.addActionListener(new ActionListener() {            
            public void actionPerformed(ActionEvent e) {
                try {
                    // Xử lý sự kiện khi giá trị thay đổi
                    String selectedItem = (String)get_idClub_from_team2_textField();
                    if (selectedItem != null) {
                        Icon icon = getIcon(selectedItem);                        
                        team1_img_Label.setIcon(icon);
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
		
		//-----------------Button-----------------//
		JPanel button_panel = new JPanel();
		button_panel.setOpaque(false);
		button_panel.setBounds(10, 312, 292, 37);
		getContentPane().add(button_panel);
		button_panel.setLayout(new FlowLayout(FlowLayout.LEFT, 118, 0));
		
		JButton Update_Button = new JButton("Update");
		Update_Button.setFocusable(false);
		Update_Button.setBackground(Color.WHITE);
		button_panel.add(Update_Button);
		
		Update_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
						Connection conn = new DBController().getConnection();
						DefaultTableModel model = (DefaultTableModel)table.getModel();
						String sql = "UPDATE schedule SET score_1 = ?, score_2 = ? WHERE match_id = ?";
						PreparedStatement statement = conn.prepareStatement(sql);
						
						statement.setString(1, score_1_textField.getText());
						statement.setString(2, score_2_textField.getText());
						statement.setString(3, matchID_textField.getText());
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
					catch (Exception e3) {
					    e3.printStackTrace();
					    JOptionPane.showMessageDialog(null, "Update failed.");
				}
			}
		});
		
		score_1_textField = new JTextField();
		score_1_textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		score_1_textField.setBounds(53, 300, 40, 40);
		getContentPane().add(score_1_textField);
		score_1_textField.setColumns(10);
		
		score_2_textField = new JTextField();
		score_2_textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		score_2_textField.setColumns(10);
		score_2_textField.setBounds(216, 300, 40, 40);
		getContentPane().add(score_2_textField);
		
		
		//-------------------Set Background-------------------//
		
		JLabel Background = new JLabel("");
		Background.setIcon(new ImageIcon(PlayerGUI.class.getResource("/IMG/gg.png")));
		Background.setBounds(0, 0, 1000, 505);
		getContentPane().add(Background);
		this.setVisible(true);
		this.setResizable(false); // khoá thu phóng
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new ResultGUI();
	}
}
