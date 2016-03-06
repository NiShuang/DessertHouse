<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../source/topNav.jsp"/> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dessert House</title>
<link href="<%=request.getContextPath()%>/css/modifyStore.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<jsp:useBean id="commodity"
			type="model.Commodity"
			scope="request"></jsp:useBean>

	
	<div class="frame">
	<form name="modify" method="post" action="http://localhost:8080/DessertHouseWeb/SaveCommodityServlet" onsubmit="return check()">
		<span class="title">修改商品</span>
		<br></br>	
		<span class="label">商品名</span> <input id="name" type="text" name="name" value="<jsp:getProperty name="commodity" property="name" />" />	
		<br></br>	
		<input id="id" type="hidden" name="id" value="<jsp:getProperty name="commodity" property="id" />"/>
		<input id="save" type="submit" name="save" value="保存"/>
	</form>
	</div>
	<script type="text/javascript">  
        function check(){    
            var name=window.document.getElementById("name").value; 
            if (name == "") 
            {  
                window.alert("请输入商品名！");  
                return false;  
            }
            return true;  
        }  
</script>
</body>
</html>