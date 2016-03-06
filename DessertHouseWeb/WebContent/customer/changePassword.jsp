<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../source/nav.jsp"/> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dessert House</title>
<link href="<%=request.getContextPath()%>/css/modifyStore.css" rel="stylesheet" type="text/css" />
</head>
<body>
	
	<div class="frame">
	<form name="modify" method="post" action="http://localhost:8080/DessertHouseWeb/ChangePasswordServlet" onsubmit="return check()">
		<span class="title">修改密码</span>
		<br></br>	
		<span class="label">&nbsp;&nbsp;原密码</span> <input id=old type="password" name="old"  />	
		<br></br>	
		<span class="label">&nbsp;&nbsp;新密码</span> <input id="new" type="password" name="new"  />	
		<br></br>
		<span class="label">确认密码</span> <input id="confirm" type="password" name="confirm" />	
		<br></br>
		<input id="save" type="submit" name="save" value="确认"/>
				<%if(request.getAttribute("result")!=null){
		int result = (int)request.getAttribute("result");
			if(result==0){
	%>
		<p style= 'color: red'>原密码错误！</p>
	<%}else if(result==1){ %>
	<p style= 'color: red'>修改密码成功！</p>
	<%} }%>
	</form>
	</div>
	<script type="text/javascript">  
        function check(){    
            var old =window.document.getElementById("old").value; 
            var newP =window.document.getElementById("new").value;
            var confirm=window.document.getElementById("confirm").value;
            if (old == ""||newP == ""||confirm == "") 
            {  
                window.alert("请输入完整！");  
                return false;  
            }
            if (newP != confirm) 
            {  
                window.alert("两次密码不一致！");  
                return false;  
            }
            return true;  
        }  
</script>
</body>
</html>