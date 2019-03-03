package Db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import User.User;

public class getUser {
	List<User> list = new ArrayList<User>();
	public List<User> getUser()
	{
		Connection con = null;
        // 通过Statement 的改为prepareStatement
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = null;
        try {
             sql = "select * from user " ;
            con = DBBean.getConnection();
            // 对于JDBC而言,SQL注入攻击只对Statement有效,对PreparedStatement是无效的,这是因为PreparedStatement不允许在插入时改变查询的逻辑结构。
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery(sql);
			while(rs.next()){
				User user = new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				list.add(user);
		}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}

