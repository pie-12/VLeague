package DBS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.xdevapi.Statement;

public class DBController{
	
	public Connection getConnection() {
		Connection connect = null;
		try{
			   String userName = "root";
			   String password = "lamcanis412";
			   String url = "jdbc:mysql://localhost/vleague";
			   Class.forName ("com.mysql.cj.jdbc.Driver");
			   connect = DriverManager.getConnection(url, userName, password);
		} catch(Exception e){
			   System.out.println(e.getMessage());
		}
		return connect;
	}

	public static void main(String[] args) {
		Connection conn = null;
		try{
			   String userName = "root";
			   String password = "lamcanis412";
			   String url = "jdbc:mysql://localhost/vleague";
			   Class.forName ("com.mysql.cj.jdbc.Driver");
			   conn = DriverManager.getConnection(url, userName, password);
			   
		} catch(Exception e){

		}
	}
} //	có chỉnh
