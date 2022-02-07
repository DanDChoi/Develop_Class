package join.mvc.model;

import static login.mvc.model.LoginSQL.SELECT;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import mvc.domain.Member;

public class JoinDAO {
	private DataSource ds;
	JoinDAO(){
		try{
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/myoracle");
		}catch(NamingException ne){}
	}
	Member getMember(String email) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int seq = rs.getInt(1);
				String name = rs.getString(2);
				//String email = rs.getString(3);
				String pwd = rs.getString(4);
				String phone = rs.getString(5);
				Date rdate = rs.getDate(6);
				Date udate = rs.getDate(7);
				
				return new Member(seq, name, email, pwd, phone, rdate, udate);
			}else {
				return null;
			}
		}catch(SQLException se) {
			return null;
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {
				
			}
		}
	}
}