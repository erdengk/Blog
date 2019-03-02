package Db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import User.User;

public class Find {

	public static int Find(String inputusername, String inputpassword) 
	{
	   // String sql="select * from login where username="+"'"+inputusername+"'";//定义一个查询语句
	    Connection con = null;
        // 通过Statement 的改为prepareStatement
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int a=0;
        String sql = null;
        try {
             sql = "select * from user where username = '" + inputusername+
             "' and password= '" + inputpassword + "'";
            con = DBBean.getConnection();
            // 对于JDBC而言,SQL注入攻击只对Statement有效,对PreparedStatement是无效的,这是因为PreparedStatement不允许在插入时改变查询的逻辑结构。
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery(sql);
            // 进行结果的遍历，并给出相应的提示
            if (rs.next()) {
            	User user = new User();
            	user.setUsername(inputusername);
                System.out.println("登录成功！");
                a=1;
            } else {
                System.out.println("登录失败！");
                a=0;
            }	
            System.out.println("执行完毕！");
        } catch (SQLException e) {
            System.out.println("数据库访问异常!");
            throw new RuntimeException(e);
        } finally {
            // 最后关闭一下资源
            if (con != null) {
                DBBean.closeConnection(con);
            }
        }  
		return a ;	
	}
}