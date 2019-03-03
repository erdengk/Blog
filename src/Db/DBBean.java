package Db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DBBean
{ 	
	private String driverStr = "com.mysql.jdbc.Driver";
	private String connStr = "jdbc:mysql://localhost:3306/bbs?useUnicode=true&characterEncoding=utf-8&useSSL=false"; 
	private String dbusername = "root"; 
	private String dbpassword = "root";
	private Connection conn = null; 
	private static Statement stmt = null;
	public DBBean() 
	{ 
		try { 
			Class.forName(driverStr); 
			conn = DriverManager.getConnection(connStr, dbusername, dbpassword); 
			stmt = conn.createStatement(); 
			} 
		catch (Exception ex)
			{ 
			System.out.println(ex.getMessage());
			System.out.println("数据连接失败！"); 
			} 
	} 
	public static Connection getConnection(){
		String driver ="com.mysql.jdbc.Driver";
		String url ="jdbc:mysql://localhost:3306/bbs?useUnicode=true&characterEncoding=utf-8&useSSL=false";
		String user ="root";
		String password ="root";
		Connection connection =null;
		try {
			Class.forName(driver);
			connection =DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	public int executeUpdate(String s) 
	{ 
		int result = 0; 
		System.out.println("--更新语句:"+s+"\n");
		try { 
			result = stmt.executeUpdate(s); 
			} 
		catch (Exception ex) 
		{ 
			System.out.println("执行更新错误！"); 
		} 
		return result; 
	} 
	public static ResultSet executeQuery(String s) 
	{ 
		ResultSet rs = null; 
		System.out.print("--查询语句:"+s+"\n");
		try {
			rs = stmt.executeQuery(s);
			} 
		catch (Exception ex) 
		{ 
			System.out.println("执行查询错误！");
		} 
		return rs; 
	} 
	public void execQuery(String s)
	{ 
		try { stmt.executeUpdate(s); } 
		catch (SQLException e) { 
			System.out.println("执行插入错误！"); 
			} 
	} 
	public void close() {
		try { stmt.close(); conn.close(); } 
		catch (Exception e) { } 
		} 
    public static void closeConnection(Connection conn){
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("关闭资源失败");
                e.printStackTrace();
            }
        }
    }

}