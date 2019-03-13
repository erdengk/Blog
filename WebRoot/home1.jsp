<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>欢迎来到本网站！</h1>
	欢迎你：<%
		/* String userName = request.getParameter("userName");
		out.print(userName); */
		String userName = (String)session.getAttribute("username");
		out.print(userName);
	 %>
	  <h1>${xiaoxi}</h1>
	   <table  width="600" border="1" cellpadding="0" >
	    <tr> 
	    <th>ID</th>
	     <th>姓名</th>
	      <th>性别</th>
	       

	       </tr>
 <c:forEach var="u" items="${userBlogAll}"> 
 <form action="UpdateServlet" method="post"> 
 <tr>
  <td><input type="text" value="${u.username}" name="id" ></td> 
  <td><input type="text" value="${u.title}" name="name"></td><br/>${u.title}<br/>
  <td><input type="text" value="${u.txt}" name="sex"></td>${u.txt}
       <input type="submit" value="更新"/></td>
        </tr> 
        </form> 
        </c:forEach>
         </table>

</body>
</html>