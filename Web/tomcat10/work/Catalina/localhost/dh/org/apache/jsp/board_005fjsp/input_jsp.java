/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.0.14
 * Generated at: 2022-01-24 06:29:06 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.board_005fjsp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;

public final class input_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
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
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP?????? ?????? GET, POST ?????? HEAD ??????????????? ???????????????. Jasper??? OPTIONS ????????? ?????? ???????????????.");
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("    <title>????????? ????????? with jsp</title>\r\n");
      out.write("	<meta charset='utf-8'>\r\n");
      out.write("	<script language=\"javascript\">\r\n");
      out.write("	   function check()\r\n");
      out.write("	   {\r\n");
      out.write("	       for(var i=0; i<document.input.elements.length; i++)\r\n");
      out.write("		   {\r\n");
      out.write("		      if(document.input.elements[i].value == \"\")\r\n");
      out.write("			  {\r\n");
      out.write("			     alert(\"?????? ?????? ?????? ????????? ?????????. \");\r\n");
      out.write("				 return false;\r\n");
      out.write("			  }\r\n");
      out.write("		   }\r\n");
      out.write("		   document.input.submit();\r\n");
      out.write("       }\r\n");
      out.write("	</script>\r\n");
      out.write("	<style>\r\n");
      out.write("		table, th, td {\r\n");
      out.write("		   border: 1px solid black;\r\n");
      out.write("		   border-collapse: collapse;\r\n");
      out.write("		}\r\n");
      out.write("		th, td {\r\n");
      out.write("		   padding: 5px;\r\n");
      out.write("		}\r\n");
      out.write("		a { text-decoration:none }\r\n");
      out.write("	</style>\r\n");
      out.write("  </head>\r\n");
      out.write("  <body onload=\"input.name.focus()\">\r\n");
      out.write("    <center>\r\n");
      out.write("	   <hr width=\"600\" size=\"2\" noshade>\r\n");
      out.write("	      <h2>Simple Board with jsp</h2>\r\n");
      out.write("		  <a href='/list.jsp'>?????????</a>\r\n");
      out.write("	   <hr width=\"600\" size=\"2\" noshade>\r\n");
      out.write("	</center>\r\n");
      out.write("	<form name=\"input\" method=\"post\" action=\"insert.jsp\">\r\n");
      out.write("	   <table border=\"1\" width=\"600\" align=\"center\"  cellpadding=\"3\" cellspacing=\"1\">\r\n");
      out.write("	      <tr>\r\n");
      out.write("		     <td width=\"30%\" align=\"center\">?????????</td>\r\n");
      out.write("			 <td align=\"center\"><input type=\"text\" name=\"name\" size=\"60\"></td>\r\n");
      out.write("		  </tr>\r\n");
      out.write("		  <tr>\r\n");
      out.write("		     <td align=\"center\">?????????</td>\r\n");
      out.write("			 <td align=\"center\"><input type=\"text\" name=\"email\" size=\"60\"></td>\r\n");
      out.write("		  </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("		     <td align=\"center\">?????????</td>\r\n");
      out.write("			 <td align=\"center\"><input type=\"text\" name=\"subject\" size=\"60\"></td>\r\n");
      out.write("		  </tr>\r\n");
      out.write("		  <tr>\r\n");
      out.write("		     <td align=\"center\">?????????</td>\r\n");
      out.write("			 <td align=\"center\"><textarea name=\"content\" rows=\"5\" cols=\"53\"></textarea></td>\r\n");
      out.write("		  </tr>\r\n");
      out.write("		  <tr>\r\n");
      out.write("		     <td colspan=\"2\" align=\"center\">\r\n");
      out.write("			    <input type=\"button\" value=\"??????\" onclick=\"check()\">\r\n");
      out.write("				<input type=\"reset\" value=\"????????????\">\r\n");
      out.write("			 </td>\r\n");
      out.write("		  </tr>\r\n");
      out.write("	   </table>\r\n");
      out.write("	   <br>\r\n");
      out.write("	   <hr width=\"600\" size=\"2\" noshade>\r\n");
      out.write("	</form>\r\n");
      out.write("  </body>\r\n");
      out.write("</html>");
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
