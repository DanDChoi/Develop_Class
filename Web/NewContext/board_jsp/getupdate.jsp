<%@  page contentType="text/html; charset=utf-8" import="java.sql.*"%>
<%!
	Connection con;
	Statement stmt;
	 public void jspInit(){ //DB연결 
		  String url = "jdbc:oracle:thin:@127.0.0.1:1521:JAVA";
		  String usr = "servlet";
		  String pwd = "java";
		  try{
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			 con = DriverManager.getConnection(url, usr, pwd);
			 stmt = con.createStatement();
		  }catch(ClassNotFoundException cnfe){
			 System.out.println("#Oracle driver loading failed");
		  }catch(SQLException se){}
	 }
	public void jspDestroy(){
			try{
			 if(stmt != null) stmt.close();
			 if(con != null) con.close();
		  }catch(SQLException se){}
	   }
%>
<%
	  request.setCharacterEncoding("UTF-8");
	  int seq = -1;
	  String seqStr = request.getParameter("seq");
	  seqStr = seqStr.trim();
	  if(seqStr.length() != 0){
		seq = Integer.parseInt(seqStr);
	  }else{
		response.sendRedirect("list.jsp");
	  }
	  String name = request.getParameter("writer"); 
	  String email = request.getParameter("email");
	  String subject = request.getParameter("subject"); 
	  String content = request.getParameter("content");
	  String sql = "update BOARD set EMAIL='"+email+"', WRITER='"+name+"', SUBJECT='"+subject+"', CONTENT='"+content+"' where SEQ='"+seq+"'";
	  try{
		stmt.executeUpdate(sql);
	  }catch(SQLException se){
	  }
	  response.sendRedirect("list.jsp");
%>