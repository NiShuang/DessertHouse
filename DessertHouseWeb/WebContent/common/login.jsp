<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dessert House</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/placeholder.js"></script>
</head>
<body>
<%String id = (String)request.getAttribute("id");
	if(id==null)
		id = "";
	%>
	


	<form id="slick-login" action="http://localhost:8080/DessertHouseWeb/LoginServlet" method="post" onsubmit="return check()">
		<div class="frame">
		<%if(!id.equals("")){ %>
		注册成功！你的会员号为:
		<br><br>
		<span class="number"><%=id %></span>
		<%} %>
		</div>
		<p class="tittle">登录</p>
		<label for="username">username</label><input type="text" id="username" name="username" class="placeholder" placeholder="username" value = <%=id %> >
		<label for="password">password</label><input type="password" id="password" name="password" class="placeholder" placeholder="password">
		<input type="submit" value="Log In">
		<br></br>
		<p>还不是会员？<a href="http://localhost:8080/DessertHouseWeb/customer/register.jsp">[立即注册]</a></p>
		<br></br>
		<%if(request.getAttribute("result")!=null){
		int result = (int)request.getAttribute("result");
			if(result==0){
	%>
		<p style= 'color: red'>密码错误！</p>
	<%}else if(result==-1){ %>
	<p style= 'color: red'>账号不存在！</p>
	<%} }%>
	</form>
		<script type="text/javascript">  
        function check(){    
            var name=window.document.getElementById("username").value; 
            var password=window.document.getElementById("password").value; 
            if (name == "") 
            {  
                window.alert("请输入会员号!");  
                return false;  
            }
            if (password == "") 
            {  
                window.alert("请输入密码!");  
                return false;  
            }
            return true;  
        }  
</script>
</body>
</html>