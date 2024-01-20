package GUI;



import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import DBS.DBController;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class scheduleee extends JFrame {
	Vector vT, vD;
	
	public 	static Vector getvD() {
		Connection con = new DBController().getConnection();
		Vector vD = new Vector();
		String sql = "SELECT * FROM vleague.schedule";
		PreparedStatement stm;
		try {
			stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				Vector vtemp = new Vector();
				vtemp.add(rs.getString(1));
				vtemp.add(rs.getString(2));
				vtemp.add(rs.getString(3));
				vtemp.add(rs.getString(4));
				vtemp.add(rs.getString(5));
				vtemp.add(rs.getString(6));
				vD.add(vtemp);
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return vD;
	}
	
	public static Vector getMDB() {
		Vector v = new Vector();
		
		Connection conn = new DBController().getConnection();
		Vector vD = new Vector();
		String sql = "SELECT * FROM vleague.footballteam";
		PreparedStatement stm;
		try {
			stm = conn.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				v.add(rs.getString(1));
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return v;
	}
	
	public static Vector getSVD() {
		Vector v = new Vector();
		
		Connection con = new DBController().getConnection();
		String sql = "SELECT * FROM vleague.stadium";
		PreparedStatement stm;
		try {
			stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				v.add(rs.getString(1));
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return v;
	}
	
	public Icon getIcon(String d) {
		int width = 200, height = 230;
		Image image = new ImageIcon(getClass().getResource("/icon/" + d + ".png")).getImage();
		Icon icon = new ImageIcon(image.getScaledInstance(width, height, image.SCALE_SMOOTH));
		return icon;
	}
	
	public scheduleee() {
		Container con = getContentPane();
		JPanel pnmain = new JPanel();
		pnmain.setLayout(new BorderLayout());
		
		JPanel pneast = new JPanel();
		
		JPanel pncenter = new JPanel();
		pncenter.setLayout(new BorderLayout());
		
		JPanel pncenter_center = new JPanel();
		GridLayout gl_pncenter_center = new GridLayout(8,2);
		gl_pncenter_center.setVgap(10);
		gl_pncenter_center.setHgap(-400);
		pncenter_center.setLayout(gl_pncenter_center);
		
		JPanel pncenter_south = new JPanel();
		
		JLabel lbid = new JLabel("Mã trận đấu");
		lbid.setForeground(Color.RED);
		lbid.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lbteam1 = new JLabel("Đội 1");
		lbteam1.setForeground(new Color(0, 128, 0));
		lbteam1.setFont(new Font("Tahoma", Font.BOLD, 13));
		JLabel lbteam2 = new JLabel("Đội 2");
		lbteam2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbteam2.setForeground(new Color(30, 144, 255));
		JLabel lbngay = new JLabel("Ngày diễn ra");
		lbngay.setForeground(new Color(233, 150, 122));
		lbngay.setFont(new Font("Tahoma", Font.BOLD, 13));
		JLabel lbgio = new JLabel("Giờ diễn ra");
		lbgio.setForeground(new Color(219, 112, 147));
		lbgio.setFont(new Font("Tahoma", Font.BOLD, 13));
		JLabel lbsvd = new JLabel("Nơi diễn ra");
		lbsvd.setForeground(new Color(205, 92, 92));
		lbsvd.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		final JTextField tfid = new JTextField();
		final JComboBox jcbteam1 = new JComboBox(getMDB());
		jcbteam1.setSelectedItem(null);
		final JComboBox jcbteam2 = new JComboBox(getMDB());
		jcbteam2.setSelectedItem(null);
		final JTextField tfngay = new JTextField();
		final JTextField tfgio = new JTextField();
		final JComboBox jcbsvd = new JComboBox(getSVD());
		jcbsvd.setSelectedItem(null);
		
		
		JButton jbadd = new JButton("Thêm");
		JButton jbupdate = new JButton("Sửa");
		JButton jbdelete = new JButton("Xóa");
		JButton jbclear = new JButton("Xóa các field");
		JButton jbback = new JButton("Trở lại");
		
		JPanel jpbutton = new JPanel();
		jpbutton.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 8));
		
		JLabel emty = new JLabel();
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		Dimension preferredSize = new Dimension(600,750);
        scrollPane.setPreferredSize(preferredSize);
		
		
		
		vT = new Vector();
		vT.add("Mã trận đấu");
		vT.add("Đội 1");
		vT.add("Đội 2");
		vT.add("Ngày thi đấu");
		vT.add("Giờ thi đấu");
		vT.add("Nơi diễn ra"); 
		
		vD = getvD();
		
		Border bd = BorderFactory.createLineBorder(Color.ORANGE);
		TitledBorder ttlBorder = BorderFactory.createTitledBorder(bd, "Lịch thi đấu");
		pneast.setBorder(ttlBorder);
		
		final JTable tb = new JTable();
		tb.setModel(new DefaultTableModel(vD, vT));
		scrollPane.setViewportView(tb);
		
		
		final JButton jbteam1 = new JButton();
        jbteam1.setPreferredSize(new Dimension(270, 250));
        
        jbteam1.setOpaque(false);
        jbteam1.setBackground(new Color(0, 0, 0, 100));
        
		
		final JButton jbteam2 = new JButton();
		
		jbteam2.setOpaque(false);
        jbteam2.setBackground(new Color(0, 0, 0, 100));
		
		JLabel lbvs = new JLabel("VS");
		lbvs.setFont(new Font("Arial", Font.BOLD, 15));
		lbvs.setHorizontalAlignment(SwingConstants.CENTER);
		
		// Tạo một TableCellRenderer để căn giữa dữ liệu trong cột
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        
        // Đặt renderer cho mỗi cột trong JTable
        for (int i = 0; i < tb.getColumnCount(); i++) {
            tb.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
		
		jcbteam1.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                try {
                    // Xử lý sự kiện khi giá trị thay đổi
                    String selectedItem = (String) jcbteam1.getSelectedItem();
                    if (selectedItem != null) {
                        Icon icon = getIcon(selectedItem);
                        
                        jbteam1.setIcon(icon);
                    }
                } catch (Exception ex) {
                   
                    ex.printStackTrace();
                }
            }
        });
		jcbteam2.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                try {
                    // Xử lý sự kiện khi giá trị thay đổi
                    String selectedItem = (String) jcbteam2.getSelectedItem();
                    if (selectedItem != null) {
                        Icon icon = getIcon(selectedItem);
                        
                        jbteam2.setIcon(icon);
                    }
                } catch (Exception ex) {
                    
                    ex.printStackTrace();
                }
            }
        });
		
		tb.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = tb.getSelectedRow();
				int column = tb.getSelectedColumn();
				tfid.setText((String)tb.getValueAt(row, 0));
				jcbteam1.setSelectedItem((String)tb.getValueAt(row, 1));
				jcbteam2.setSelectedItem((String)tb.getValueAt(row, 2));
				tfngay.setText((String)tb.getValueAt(row, 3));
				tfgio.setText((String)tb.getValueAt(row, 4));
				jcbsvd.setSelectedItem((String)tb.getValueAt(row, 5));
				
			}
		});
		
		jbadd.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Connection con = new DBController().getConnection();
				String sql = "INSERT INTO vleague.schedule VALUES (?, ?, ?, ?, ?, ?)";
				try {
					PreparedStatement stm = con.prepareStatement(sql);
					stm.setString(1, tfid.getText());
					stm.setString(2, (String) jcbteam1.getSelectedItem());
					stm.setString(3, (String) jcbteam2.getSelectedItem());
					stm.setString(4, tfngay.getText());
					stm.setString(5, tfgio.getText());
					stm.setString(6, jcbsvd.getSelectedItem() + "");
					stm.execute();
					JOptionPane.showMessageDialog(null, "Thêm lịch thi đấu thành công");
				
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Thêm lịch thi đấu không thành công");
					e1.printStackTrace();
				}
				vD = getvD();
				tb.setModel(new DefaultTableModel(vD, vT));
			}
		});
		
		jbupdate.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Connection con = new DBController().getConnection();
				String sql = "UPDATE vleague.schedule SET ID = ?, Team1 = ?, Team2 = ?, Day = ?, Time = ?, Stadium = ? WHERE ID = ?";
				try {
					PreparedStatement stm = con.prepareStatement(sql);
					stm.setString(1, tfid.getText());
					stm.setString(2, (String) jcbteam1.getSelectedItem());
					stm.setString(3, (String) jcbteam2.getSelectedItem());
					stm.setString(4, tfngay.getText());
					stm.setString(5, tfgio.getText());
					stm.setString(6, jcbsvd.getSelectedItem() + "");
					stm.setString(7, tfid.getText());
					stm.execute();
					JOptionPane.showMessageDialog(null, "Cập nhập thành công");
					
					vD = getvD();
					tb.setModel(new DefaultTableModel(vD, vT));
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Cập nhập không thành công");
					e2.printStackTrace();
				}
			}
		});
		jbdelete.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Connection con = new DBController().getConnection();
				String sql = "DELETE FROM vleague.schedule WHERE ID = ?";
				try {
					PreparedStatement stm = con.prepareStatement(sql);
					stm.setString(1, tfid.getText());
					
					int choose = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa lịch thi đấu này không?");
					if (choose == 0) {
						stm.execute();
						JOptionPane.showMessageDialog(null, "Xóa thành công");
						
						vD = getvD();
						tb.setModel(new DefaultTableModel(vD, vT));
					}
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Xóa không thành công");
				}
				}
		});;
		
		jbclear.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tfid.setText("");
		        jcbteam1.setSelectedItem(null);
		        jcbteam2.setSelectedItem(null);
		        tfngay.setText("");
		        tfgio.setText("");
		        jcbsvd.setSelectedItem(null);
		        jbteam1.setIcon(null);
		        jbteam2.setIcon(null);
			}
		});
		
		jbback.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new MainGUI();
				setVisible(false);
			}
		});
		//ADD thanh phan
		
		
		jpbutton.add(jbadd);
		jpbutton.add(jbupdate);
		jpbutton.add(jbdelete);
		jpbutton.add(jbclear);
		jpbutton.add(jbback);
		
		pncenter_center.add(lbid);
		pncenter_center.add(tfid);
		pncenter_center.add(lbteam1);
		pncenter_center.add(jcbteam1);
		pncenter_center.add(lbteam2);
		pncenter_center.add(jcbteam2);
		pncenter_center.add(lbngay);
		pncenter_center.add(tfngay);
		pncenter_center.add(lbgio);
		pncenter_center.add(tfgio);
		pncenter_center.add(lbsvd);
		pncenter_center.add(jcbsvd);
		pncenter_center.add(emty);
		pncenter_center.add(jpbutton);
		
		pncenter_south.setLayout(new GridLayout(1, 3, 0, 0));
		
		pncenter_south.add(jbteam1);
		pncenter_south.add(lbvs);
		pncenter_south.add(jbteam2);
		
		pneast.add(scrollPane);
		
		pncenter.add(pncenter_center, BorderLayout.CENTER);
		pncenter.add(pncenter_south, BorderLayout.SOUTH);
		pnmain.add(pncenter, BorderLayout.CENTER);
		pnmain.add(pneast, BorderLayout.EAST);
		pneast.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 5));
		pneast.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		con.add(pnmain, BorderLayout.CENTER);	
		
		setSize(1280,750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		
	}
	public static void main(String[] args) {
		new scheduleee();
	}
}

