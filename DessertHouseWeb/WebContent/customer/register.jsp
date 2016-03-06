<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dessert House</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/register.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/placeholder.js"></script>
</head>
<body>
	<form id="slick-login" action="http://localhost:8080/DessertHouseWeb/RegisterServlet" method="post" onsubmit="return check()">
		<p class="tittle">注册</p>
		<br></br>
		<label for="姓名">&nbsp;&nbsp;&nbsp;&nbsp;姓名 </label><input type="text" id="name" name="name" class="placeholder" >
		<br></br>
		<label for="密码">&nbsp;&nbsp;&nbsp;&nbsp;密码 </label><input type="password" id="password" name="password" class="placeholder">
		<br></br>
		<label for="确认密码">确认密码 </label><input type="password" id="confirm" name="confirm" class="placeholder" >
		<br></br>
		<label for="性别">&nbsp;&nbsp;&nbsp;&nbsp;性别 </label><input id="sex_select" type="radio" name="sex" value="1" checked="checked" />男<input id="sex_select" type="radio" name="sex" value="2" />女
		<br></br>
		<label for="生日">&nbsp;&nbsp;&nbsp;&nbsp;生日 </label>
			<select id="year_select" name="year">
		<% for(int i = 1900;i<2017;i++){ 
  
        %>
		<option value=<%=i%>><%=i%></option>
		<% }%>	
			</select>年
			<select id="month_select" name="month">
		<% for(int i = 1;i<13;i++){ 
  
        %>
		<option value=<%=i%>><%=i%></option>
		<% }%>	
			</select>月
			<select id="day_select" name="day">
			<% for(int i = 1;i<32;i++){ 
  
        %>
		<option value=<%=i%>><%=i%></option>
		<% }%>	
			</select>日
		<br></br>
		<label for="所在地">&nbsp;&nbsp;所在地</label>
			<select id="place_select" name="place">
				<option value="南京">南京</option>
			</select>
		<br></br>
		<input type="submit" value="注册">

		<br></br>
		<p>已经是会员？<a href="http://localhost:8080/DessertHouseWeb/common/login.jsp">[立即登录]</a></p>
		<br>
		<br></br>
	</form>
	<script type="text/javascript">  
        function check(){    
            var name=window.document.getElementById("name").value; 
            var password=window.document.getElementById("password").value; 
            var confirm=window.document.getElementById("confirm").value; 
            if (name == ""||password == ""||confirm == "") 
            {  
                window.alert("请填写完整!");  
                return false;  
            }
            if (password!=confirm){
                window.alert("两次密码不一致!");  
                return false;  
            }
            return true;  
        }  
</script>
</body>
</html>