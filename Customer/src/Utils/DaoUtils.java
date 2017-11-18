package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import Exception.SQLException;
//实现一个工具类用于获取数据库连接和关闭数据库的连接
public class DaoUtils {
	private static String className;
	private static String url;
	private static String user;
	private static String password;
	
	//读取数据库配置文件
	static{
		ResourceBundle rb = ResourceBundle.getBundle("my");
		className = rb.getString("className");
		url = rb.getString("url");
		user = rb.getString("user");
		password = rb.getString("password");
	}
	
	//获取数据库连接
	public static Connection getConnextion(){
		Connection conn = null;
		try {
			Class.forName(className);
			 conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//关闭与数据库的所有连接
	public static void closeAll(ResultSet rs,Statement st,Connection conn){
		
		if(rs!=null){
			try {
				rs.close();
			} catch (java.sql.SQLException e) {
				e.printStackTrace();
			}
		}
		rs = null;
		
		if(st!=null){
			try {
				st.close();
			} catch (java.sql.SQLException e){
				e.printStackTrace();
			}
		}
		st=null;
		
		if(conn!=null){
			try {
				conn.close();
			} catch (java.sql.SQLException e) {
				e.printStackTrace();
			}
		}
		conn = null;
	}
	
	
}
