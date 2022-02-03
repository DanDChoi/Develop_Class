/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.0.14
 * Generated at: 2022-01-25 05:48:58 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.addr_005fjsp_005fpool;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import java.sql.*;

public final class list_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("java.sql");
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');
      soo.db.ConnectionPoolBean pool = null;
      synchronized (application) {
        pool = (soo.db.ConnectionPoolBean) _jspx_page_context.getAttribute("pool", jakarta.servlet.jsp.PageContext.APPLICATION_SCOPE);
        if (pool == null){
          pool = new soo.db.ConnectionPoolBean();
          _jspx_page_context.setAttribute("pool", pool, jakarta.servlet.jsp.PageContext.APPLICATION_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("\r\n");
      out.write("<meta charset='utf-8'>\r\n");
      out.write("<style>\r\n");
      out.write("	table, th, td {\r\n");
      out.write("	   border: 1px solid black;\r\n");
      out.write("	   border-collapse: collapse;\r\n");
      out.write("	}\r\n");
      out.write("	th, td {\r\n");
      out.write("	   padding: 5px;\r\n");
      out.write("	}\r\n");
      out.write("	a { text-decoration:none }\r\n");
      out.write("</style>\r\n");
      out.write("<center>\r\n");
      out.write("	<h1>\r\n");
      out.write("		Address List JSP with Pool\r\n");
      out.write("	</h1>\r\n");
      out.write("	<a href=\"../\">인덱스</a>\r\n");
      out.write("	   &nbsp;&nbsp;&nbsp;&nbsp; \r\n");
      out.write("	<a href=\"input.jsp\">입력폼</a>\r\n");
      out.write("	<table border='1' cellpadding='7' cellspacing='2' width='50%'>\r\n");
      out.write("	    <tr>\r\n");
      out.write("		    <th>번호</th>\r\n");
      out.write("			<th>이름</th>\r\n");
      out.write("			<th>주소</th>\r\n");
      out.write("			<th>날짜</th>\r\n");
      out.write("			<th>삭제</th>\r\n");
      out.write("		</tr>\r\n");

        Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from address order by seq desc";
		try{
			con = pool.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				int seq = rs.getInt(1);
				String name = rs.getString(2);
				String addr = rs.getString(3);
				Date rdate = rs.getDate(4);

      out.write("\r\n");
      out.write("                    <tr>\r\n");
      out.write("						<td align='center'>");
      out.print(seq);
      out.write("</td>\r\n");
      out.write("						<td>");
      out.print(name);
      out.write("</td>\r\n");
      out.write("						<td>");
      out.print(addr);
      out.write("</td>\r\n");
      out.write("						<td>");
      out.print(rdate);
      out.write("</td>\r\n");
      out.write("						<td align='center'><a href='del.jsp?seq=");
      out.print(seq);
      out.write("'>삭제</a></td>\r\n");
      out.write("					</tr>\r\n");

			 }
		 }catch(SQLException se){
			 System.out.println("#service() se: " + se);
		 }finally{
			 try{
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(con != null) pool.returnConnection(con);
			 }catch(SQLException se){}
		 }

      out.write(" \r\n");
      out.write("	</table>\r\n");
      out.write("</center>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}