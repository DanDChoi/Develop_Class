package team1.togather.model;

import static team1.togather.model.GroupTabSQL.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import team1.togather.domain.Gathering;
import team1.togather.domain.GroupTab;

class GroupTabDAO {
	private DataSource ds;
	GroupTabDAO() {
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/myoracle");
		}catch(NamingException ne) {
		}
	}
	ArrayList<GroupTab> groupList(){
		ArrayList<GroupTab> groupList = new ArrayList<GroupTab>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(GROUP_LIST);
			while(rs.next()) {
				long gSeq = rs.getLong(1);
				String gLoc = rs.getString(2);
				String gName = rs.getString(3);
				String gIntro = rs.getString(4);
				String interest = rs.getString(5);
				int limit = rs.getInt(6);
				Date rdate = rs.getDate(7);
				long mNum = rs.getLong(8);
				String fname = rs.getString(9);
				groupList.add(new GroupTab(gSeq, gLoc, gName, gIntro, interest, limit, rdate, mNum, fname));
			}
			return groupList;
		}catch(SQLException se) {
			return null;
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
	ArrayList<GroupTab> groupInfo(long gSeq) {
		ArrayList<GroupTab> groupInfo = new ArrayList<GroupTab>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GROUP_SELECT);
			pstmt.setLong(1, gSeq);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String gLoc = rs.getString(2);
				String gName = rs.getString(3);
				String gIntro = rs.getString(4);
				String interest = rs.getString(5);
				int limit = rs.getInt(6);
				Date rdate = rs.getDate(7);
				long mNum = rs.getLong(8);
				String fname = rs.getString(9);
				groupInfo.add(new GroupTab(gSeq, gLoc, gName, gIntro, interest, limit, rdate, mNum, fname));
			}
			return groupInfo;
		}catch(SQLException se) {
			return null;
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
	boolean groupInsert(GroupTab dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GROUP_INSERT);
			//"insert into GROUPTAB values(GROUP_SEQ.nextval, ?, ?, ?, ?, ?, SYSDATE, ?, ?)"
			pstmt.setString(1, dto.getgLoc());
			pstmt.setString(2, dto.getgName());
			pstmt.setString(3, dto.getgIntro());
			pstmt.setString(4, dto.getInterest());
			pstmt.setInt(5, dto.getLimit());
			pstmt.setLong(6, 1); //mNum session
			pstmt.setString(7, dto.getFname());
			int i = pstmt.executeUpdate();
			if(i>0) {
				return true;
			}else {
				return false;
			}		
		}catch(SQLException se) {
			System.out.println("#GroupInsert() se: " + se);
			return false;
		}finally {
			try {
				if(con != null) con.close();
				if(pstmt !=null) pstmt.close();
			}catch(SQLException se) {}
		}
	}
	ArrayList<GroupTab> groupGetUpdate(long gSeq){
		ArrayList<GroupTab> list = new ArrayList<GroupTab>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GROUP_SELECT);
			pstmt.setLong(1, gSeq);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String gLoc = rs.getString(2);
				String gName = rs.getString(3);
				String gIntro = rs.getString(4);
				String interest = rs.getString(5);
				int limit = rs.getInt(6);
				Date rdate = rs.getDate(7);
				int mNum = rs.getInt(8);
				String fname = rs.getString(9);
				 System.out.println("gLoc(DAO) groupGetUpdate: " + fname);
				list.add(new GroupTab(gSeq, gLoc, gName, gIntro, interest, limit, rdate, mNum, fname));
			}
			return list;
		}catch(SQLException se) {
			System.out.println("#GroupTabDAO groupGetUpdate() se: "+ se);
			return null;
		}finally {
			try {				
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
	void groupUpdate(GroupTab dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GROUP_UPDATE);
			//"update GROUPTAB set GLOC=?, GNAME=?, GINTRO=?, LIMIT=?, FNAME=? WHERE GSEQ=?"
			pstmt.setLong(6, dto.getgSeq());
			pstmt.setString(1, dto.getgLoc());
			pstmt.setString(2, dto.getgName());
			pstmt.setString(3, dto.getgIntro());
			pstmt.setInt(4, dto.getLimit());
			pstmt.setString(5, dto.getFname());
				System.out.println("gLoc(DAO) : "+ dto.getgLoc() + dto.getgSeq() + dto.getgName() + dto.getgIntro() + dto.getLimit() + dto.getFname());
			pstmt.executeUpdate();

		}catch(SQLException se) {
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
	void groupDelete(long gSeq) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GROUP_DELETE);
			pstmt.setLong(1, gSeq);
			System.out.println("groupDelete_gSeq: " + gSeq);
			pstmt.executeUpdate();
		}catch(SQLException se) {
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
	
	boolean gatheringInsert(Gathering dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GATHERING_INSERT);
			//insert into GATHERING values(GATHERING_SEQ.nextval, ?, ?, ?, ?, ?, ?, ?)
			pstmt.setString(1, dto.getGa_name());
			pstmt.setString(2, dto.getGa_date());
			pstmt.setString(3, dto.getTime());
			pstmt.setString(4, dto.getGa_place());
			pstmt.setString(5, dto.getPrice());
			pstmt.setInt(6, dto.getGa_limit());
			pstmt.setLong(7, dto.getgSeq()); //모임의 GSEQ를 가져와야함
			int i = pstmt.executeUpdate();
			if(i>0) {
				return true;
			}else {
				return false;
			}		
		}catch(SQLException se) {
			System.out.println("#gatheringInsert() se: " + se);
			return false;
		}finally {
			try {
				if(con != null) con.close();
				if(pstmt !=null) pstmt.close();
			}catch(SQLException se) {}
		}
	}
	ArrayList<Gathering> gatheringList(long gSeq){
		ArrayList<Gathering> gatheringList = new ArrayList<Gathering>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GATHERING_LIST);
			pstmt.setLong(1, gSeq);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				long ga_seq = rs.getLong(1);
				String ga_name = rs.getString(2);
				String ga_date = rs.getString(3);
				String time = rs.getString(4);
				String ga_place = rs.getString(5);
				String price = rs.getString(6);
				int ga_limit = rs.getInt(7);
				gatheringList.add(new Gathering(ga_seq, ga_name, ga_date, time, ga_place, price, ga_limit, gSeq));
				System.out.println("DAO_gatheringList의 gSeq: " + gSeq);
			}
			return gatheringList;
		}catch(SQLException se) {
			return null;
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
	ArrayList<Gathering> gatheringInfo(long gSeq, long ga_seq){
		ArrayList<Gathering> gatheringInfo = new ArrayList<Gathering>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GATHERING_INFO);
			//select * from GATHERING where GSEQ=? and GA_SEQ=?
			pstmt.setLong(1, gSeq);
			pstmt.setLong(2, ga_seq);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String ga_name = rs.getString(2);
				String ga_date = rs.getString(3);
				String time = rs.getString(4);
				String ga_place = rs.getString(5);
				String price = rs.getString(6);
				int ga_limit = rs.getInt(7);
				gatheringInfo.add(new Gathering(ga_seq, ga_name, ga_date, time, ga_place, price, ga_limit, gSeq));
				System.out.println("gatheringInfo_gSeq: " + gSeq + ", gatheringInfo_ga_seq: " + ga_seq);
			}
			return gatheringInfo;
		}catch(SQLException se) {
			return null;
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();				
			}catch(SQLException se) {}
		}
	}
	void gatheringDelete(long ga_seq) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GATHERING_DELETE);
			pstmt.setLong(1, ga_seq);
			System.out.println("gatheringDelete_ga_Seq: " + ga_seq);
			pstmt.executeUpdate();
		}catch(SQLException se) {
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
	ArrayList<Gathering>gatheringGetUpdate(long ga_seq) {
		ArrayList<Gathering> gatheringGetUpdate = new ArrayList<Gathering>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GATHERING_GET_UPDATE);
			//static final String GATHERING_GET_UPDATE = "select * from GATHERING where GA_SEQ=?"
			pstmt.setLong(1, ga_seq);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String ga_name = rs.getString(2);
				String ga_date = rs.getString(3);
				String time = rs.getString(4);
				String ga_place = rs.getString(5);
				String price = rs.getString(6);
				int ga_limit = rs.getInt(7);
				long gSeq = rs.getLong(8);
				gatheringGetUpdate.add(new Gathering(ga_seq, ga_name, ga_date, time, ga_place, price, ga_limit, gSeq));
			}
			return gatheringGetUpdate;
		}catch(SQLException se) {
			return null;
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
	void gatheringUpdate(Gathering dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GATHERING_UPDATE);
			//update GATHERING set GA_NAME=?, GA_PLACE=?, PRICE=?, GA_LIMIT=? where GA_SEQ=?
			pstmt.setLong(5, dto.getGa_seq());
			pstmt.setString(1, dto.getGa_name());
			pstmt.setString(2, dto.getGa_place());
			pstmt.setString(3, dto.getPrice());
			pstmt.setInt(4, dto.getGa_limit());
			pstmt.executeUpdate();
		}catch(SQLException se) {
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
}
