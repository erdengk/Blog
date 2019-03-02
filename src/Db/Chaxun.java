package Db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import User.User;
public class Chaxun 
{
	public static Connection getConnection(){
		String driver ="com.mysql.jdbc.Driver";//数据库驱动
		String url ="jdbc:mysql://localhost:3306/login";
		String user ="root";
		String password ="root";
		Connection connection =null;
		Statement stmt = null; 
		try {
			Class.forName(driver);//加载数据库驱动
			connection =DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;//返回连接
	}
	public String FindUser(String username){
		String passd = null;
		String sql = "select * from  where username=?";
		Connection con =getConnection();//获取连接
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement(sql);//预处理
			pstmt.setString(1, username);//给？赋值
			rs = pstmt.executeQuery();//执行SQL语句
			if(rs.next()){
				//遍历查找到与username匹配的password
				passd=rs.getString("password");//将查询到的password赋值给passd
			}else{
				passd=null;//未查询到为空
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			} catch (SQLException e) {		
				e.printStackTrace();
			}
		}
		return passd;//返回passd
	}
	//查

	
}

