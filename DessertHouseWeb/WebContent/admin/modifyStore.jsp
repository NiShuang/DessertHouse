<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../source/adminNav.jsp"/> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dessert House</title>
<link href="<%=request.getContextPath()%>/css/modifyStore.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<jsp:useBean id="store"
			type="model.Store"
			scope="request"></jsp:useBean>

	
	<div class="frame">
	<form name="modify" method="post" action="http://localhost:8080/DessertHouseWeb/SaveStoreServlet" onsubmit="return check()">
		<span class="title">修改店铺</span>
		<br></br>	
		<span class="label">店铺名</span> <input id="name" type="text" name="name" value="<jsp:getProperty name="store" property="name" />" />	
		<br></br>	
		<span class="label">&nbsp;&nbsp;地址</span> <input id="location" type="text" name="location" value="<jsp:getProperty name="store" property="location" />" />	
		<br></br>
		<span class="label">&nbsp;&nbsp;电话</span> <input id="telephone" type="text" name="telephone" value="<jsp:getProperty name="store" property="telephone" />" />	
		<br></br>
		<input id="id" type="hidden" name="id" value="<jsp:getProperty name="store" property="id" />"/>
		<input id="save" type="submit" name="save" value="保存"/>
	</form>
	</div>
	<script type="text/javascript">  
        function check(){    
            var name=window.document.getElementById("name").value; 
            if (name == "") 
            {  
                window.alert("请输入店铺名！");  
                return false;  
            }
            return true;  
        }  
</script>
</body>
</html>