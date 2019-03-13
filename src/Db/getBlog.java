package Db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.config.ServerAuthContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jboss.weld.context.SessionContext;

import User.UserBlog;

import User.UserBlog;
public class getBlog {
		public static UserBlog getUserBlog(String inputname,int inputnum)
		{
			Connection con = null;
	        // 通过Statement 的改为prepareStatement
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	        String sql = null;
	        UserBlog blog = new UserBlog();
	        try {
	            sql = "select * from blog where name = '"+inputname+"'  and number = '"+inputnum+"'";
	            con = DBBean.getConnection();
	            // 对于JDBC而言,SQL注入攻击只对Statement有效,对PreparedStatement是无效的,这是因为PreparedStatement不允许在插入时改变查询的逻辑结构。
	            System.out.println(sql);
	            stmt = con.prepareStatement(sql);
	            rs = stmt.executeQuery(sql);
				while(rs.next()){
					blog.setUsername(rs.getString("name"));
					blog.setTitle(rs.getString("title"));
					blog.setTxt(rs.getString("txt"));
			}
				return blog;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
		List<UserBlog> list = new ArrayList<UserBlog>();
		public List<UserBlog> getBlog()
		{
			Connection con = null;
	        // 通过Statement 的改为prepareStatement
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	        String sql = null;
	        try {
	            sql = "select * from blog " ;
	            con = DBBean.getConnection();
	            // 对于JDBC而言,SQL注入攻击只对Statement有效,对PreparedStatement是无效的,这是因为PreparedStatement不允许在插入时改变查询的逻辑结构。
	            stmt = con.prepareStatement(sql);
	            rs = stmt.executeQuery(sql);
				while(rs.next()){
					UserBlog blog = new UserBlog();
					blog.setUsername(rs.getString("name"));
					blog.setTitle(rs.getString("title"));
					blog.setTxt(rs.getString("txt"));
					list.add(blog);
			}
				return list;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}




}
