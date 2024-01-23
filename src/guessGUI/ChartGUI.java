package guessGUI;

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
import java.awt.Panel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.ImageView;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.editor.DefaultChartEditorFactory;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

import com.toedter.calendar.JDateChooser;
import com.toedter.components.JSpinField;

import DBS.DBController;

import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants;




public class ChartGUI extends JFrame{
	private Vector vector_Row, vector_Column;	
	
	public Icon getIcon(int width, int height, String link) {
		Image image = new ImageIcon(getClass().getResource("/IMG/" + link + ".png")).getImage();
		Icon icon = new ImageIcon(image.getScaledInstance(width, height, image.SCALE_SMOOTH));
		return icon;
	}
	public static String get_id(String club_name) {
        Connection conn = new DBController().getConnection();
        String sql = "SELECT club_id FROM vleague.footballclub WHERE club_name = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, club_name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("club_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
	
	public static Vector getPoints() {
		Connection conn = new DBController().getConnection();
		Vector vD = new Vector();
		String sql = "SELECT * FROM vleague.rank ORDER BY Points DESC";
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			int i = 0;
			while(resultSet.next()) {
				Vector vtemp = new Vector();
				vtemp.add(resultSet.getString("club_name"));
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
	
	public ChartGUI() {		
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
				new guessGUI.RankGUI();
				setVisible(false);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				back_panel.setBackground(Color.lightGray);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				back_panel.setBackground(Color.black);
			}
		});
		//------------------------Chart------------------------//
		JLabel chart_label = new JLabel("CHART");
		chart_label.setFont(new Font("Tahoma", Font.BOLD, 30));
		chart_label.setForeground(new Color(255, 255, 255));
		chart_label.setHorizontalAlignment(SwingConstants.CENTER);
		chart_label.setBounds(50, 10, 940, 44);
		getContentPane().add(chart_label);
		
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        vector_Row = getPoints();        
		for (int i = 0; i < vector_Row.size(); i++) {
			Vector vtemp = (Vector) vector_Row.get(i);
			String idclub = get_id((String) vtemp.get(0));
			dataset.addValue((int) vtemp.get(1), "" , idclub);
		}
        JFreeChart chart = ChartFactory.createBarChart(
                "", // Tiêu đề biểu đồ
                "Team IDs", // Label trục x
                "Points", // Label trục y
                dataset // Dữ liệu
        );

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBounds(0, 0, 900, 400);


        Panel panel = new Panel();
        panel.setBounds(50, 65, 900, 400);
        panel.setLayout(null);
        panel.add(chartPanel);
        getContentPane().add(panel);
		//-------------------Set Background-------------------//
		this.setSize(1014, 542);
		getContentPane().setLayout(null);
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
		new ChartGUI();
	}
}
