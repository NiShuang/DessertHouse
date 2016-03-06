<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../source/clerkNav.jsp"/> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dessert House</title>
<link href="<%=request.getContextPath()%>/css/recharge.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="frame">
		   <div class="littleFrame"><span class="success">销售完成</span>
		   		<%if(request.getAttribute("point")!=null){
		int point = (int)request.getAttribute("point");
	%>
		<p style= 'color: black'>恭喜你获得 <%=point %> 积分</p>
	<%}%>
 			<a class="return" href="http://localhost:8080/DessertHouseWeb/ShowClerkMenuServlet">返回</a></div>

    
	</div>
		
</body>
</html>