<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% 
String userid =null;
 if(session.getAttribute("userid") != null){
	 userid = (String)session.getAttribute("userid");
	 System.out.println(userid);
 }


/*if(userid==null){
	userid = "GUEST";
}*/
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Insert title here</title>
	<script language="javascript">
       function f_join()
       {
           baby_login = window.open(
           "login/join.jsp", "join_name", 
                "width=600, height=700, top=100, left=100");
       }
    </script>
    <script language="javascript">
       function f_login()
       {
           baby_login = window.open(
           "login/login.jsp", "login_name", 
                "width=500, height=300, top=100, left=100");
       }
    </script>
    <script language="javascript">
       function f_fp()
       {
           baby_login = window.open(
           "login/findpassword.jsp", "login_name", 
                "width=500, height=300, top=100, left=100");
       }
    </script>
</head>
내아이디 : ${userid}
<body>
	<center>
		<strong>Eclipse Project01</strong>
		<br><br>
		 <a href="list/list.do?m=list&userid=${userid}">답변형 게시판 0</a> |
		 <a href="rb-list.do?method=list&tn=1">답변형 게시판 1</a> |
		 <a href="rb-list.do?method=list&tn=2">답변형 게시판 2</a>
		 <br><br>
		 <a href="email/write.jsp">이메일쓰기</a>
		 <a href="file/file.do?m=list">파일리스트</a></br>
		 <br><br>
		 <a id = "join" href="javascript:f_join()">회원가입</a></br>
		 <a id = "login" href="javascript:f_login()">로그인</a>
		 <a id = "findpassword" href="javascript:f_fp()">비밀번호찾기</a>
		 <a id = "logout" href="../togather/login/sessionLogout.jsp">${userid }님 어솨~로그아웃</a>
       <br><br>
       <script>
        document.getElementById('logout').style.display = 'none';
      </script>
 <% 
        	boolean flag =false;
        	if(userid!=null) {
        		flag =true;
        	}
        	System.out.println(flag);
%>     
<script>      
           	if(<%=flag%>){
           		document.getElementById('join').style.display = 'none';
           		document.getElementById('login').style.display = 'none';   
                document.getElementById('logout').style.display = '';
           	}
</script>
	</center>
	
</body>
</html>