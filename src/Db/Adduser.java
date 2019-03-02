package Db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Adduser {
	public static int add(String username,String password,String email) {
		int b=0;
		Connection con = DBBean.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			if(username==null  || email==null)
			{
				return 0;
			}else{
				
				String sql=	 "insert into user (username,password,email) values (?,?,?)";
				preparedStatement = con.prepareStatement(sql);
				preparedStatement.setString(1, username);
				preparedStatement.setString(2, password);
				preparedStatement.setString(3,email);
				preparedStatement.executeUpdate();
				b=1;
				return b;
			}
		} catch (Exception e) {
			String msg=e.toString();
			System.out.println(msg+"注册失败");
			b=0;
			return b;
		}
		finally {
            // 最后关闭一下资源
            if (con != null) {
                DBBean.closeConnection(con);
            }
        }  
		
	}
}
