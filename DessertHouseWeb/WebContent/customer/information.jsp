<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../source/nav.jsp"/> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dessert House</title>
<link href="<%=request.getContextPath()%>/css/information.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<jsp:useBean id="member"
			type="model.Member"
			scope="session"></jsp:useBean>
	
	<%String sex = "男";
	if(member.getSex()==2)
		sex = "女";%>
	<div class="frame">
		<span class="title">注册信息</span>
		<br></br>	
		<span class="label">&nbsp;&nbsp;会员号</span>  <jsp:getProperty name="member" property="id" />
		<br></br>	
		<span class="label">&nbsp;&nbsp;&nbsp;&nbsp;姓名</span> <jsp:getProperty name="member" property="name" />
		<br></br>
		<span class="label">&nbsp;&nbsp;&nbsp;&nbsp;性别</span> <%=sex %>
		<br></br>
		<span class="label">&nbsp;&nbsp;&nbsp;&nbsp;生日</span> <jsp:getProperty name="member" property="birthday" />
		<br></br>
		<span class="label">&nbsp;&nbsp;所在地</span> <jsp:getProperty name="member" property="place" /> 
		<br></br>
		<span class="label">注册时间</span> <jsp:getProperty name="member" property="create_time" /> 
		<br></br>
		<a class="edit" href="http://localhost:8080/DessertHouseWeb/customer/modifyInformation.jsp">编辑</a>
	</div>
</body>
</html>