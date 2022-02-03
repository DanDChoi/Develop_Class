<%@ page contentType="text/html;charset=utf-8" import="java.util.ArrayList, mvc.domain.Address"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>

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
	<h1>
		Address List with JSTL + EL
	</h1>
	<a href="../">인덱스</a>
	   &nbsp;&nbsp;&nbsp;&nbsp; 
	<a href="addr.do?m=input">입력폼</a>
	<table border='1' cellpadding='7' cellspacing='2' width='50%'>
	    <tr>
		    <th>번호</th>
			<th>이름</th>
			<th>주소</th>
			<th>날짜</th>
			<th>삭제</th>
		</tr>
<c:if test="${empty list}">
             <tr>
				<td colspan="5" style="text-align:center">데이터가 하나도 없네요ㅠㅠ</td>
			 </tr>
</c:if>
<c:forEach items="${list}" var="dto">
    <tr>
		<td align='center'>${address.seq}</td>
		<td>${address.name}</td>
		<td>${address.addr}</td>
		<td>${address.rdate}</td>
		<td align='center'><a href='addr.do?m=del&seq=${address.seq}'>삭제</a></td>
	</tr>
</c:forEach>
            
	</table>
</center>