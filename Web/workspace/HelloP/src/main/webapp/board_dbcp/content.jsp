<%@ page contentType="text/html;charset=utf-8" import="javax.sql.DataSource, java.sql.*"%>
<jsp:useBean id="dbcp" class="soo.dbcp.DbcpBean" scope="application"/>

<%

        String seqStr = request.getParameter("seq");
        int seq = -1;
        if(seqStr == null){
            response.sendRedirect("list.jsp");
            return;
        }
        seqStr = seqStr.trim();
        if(seqStr.length() == 0){
            response.sendRedirect("list.jsp");
            return;
        }else{
            try{
                seq = Integer.parseInt(seqStr);
            }catch(NumberFormatException nfe){
                response.sendRedirect("list.jsp");
                return;
            }
        }
%>
<meta charset='utf-8'>
<style>
	table, th, td {
	   border: 1px solid black;
	   border-collapse: collapse;
	}
	th, td {
        padding: 5px;
	}
	a { text-decoration:none }
</style>
<center>
<hr width='600' size='2' noshade>
<h2>Simple Board with dbcp</h2>
&nbsp;&nbsp;&nbsp;
<a href='input.jsp'>글쓰기</a>
<hr width='600' size='2' noshade>
<table border='1' width='600' align='center' cellpadding='3'>

<%
ResultSet rs = null;
Connection con;
PreparedStatement pstmt;
Statement stmt;
DataSource ds;
String sql = "select * from BOARD where SEQ=?";
try{
	ds = dbcp.getDs();
	con = ds.getConnection();
	pstmt = con.prepareStatement(sql);
    pstmt.setInt(1, seq);
    rs = pstmt.executeQuery();
    while(rs.next()){
        String name = rs.getString(2);
        String email = rs.getString(3);
        String subject = rs.getString(4);
        String content = rs.getString(5);
        Date rdate = rs.getDate(6); 
%>


<tr>
<td width='100' align='center'>글번호</td>
<td><%=seq%></td>
</tr>
<tr>
<td align='center'>글쓴이</td>
<td><%=name%></td>
</tr>
<tr>
<td align='center'>이메일</td>
<td><%=email%></td>
</tr>
<tr>
<td align='center'>글제목</td>
<td><%=subject%></td>
</tr>
<tr>
<td align='center'>글내용</td>
<td><%=content%></td>
</tr>
<%
}
}catch(SQLException se){
}finally{
    try{
        if(rs != null) rs.close();
    }catch(SQLException se){}
}
%>
</table>
<hr width='600' size='2' noshade>
<b>
<a  href='update.jsp?seq=<%=seq%>'>수정</a>
 | 
<a href='delete.jsp?seq=<%=seq%>'>삭제</a>
 | 
<a href='list.jsp'>목록</a>
</b>
<hr width='600' size='2' noshade>
</center>
