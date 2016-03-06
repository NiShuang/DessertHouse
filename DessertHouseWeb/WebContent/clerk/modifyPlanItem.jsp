<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../source/topNav.jsp"/> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dessert House</title>
<link href="<%=request.getContextPath()%>/css/modifyPlanItem.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<jsp:useBean id="planItem"
			type="model.PlanItem"
			scope="request"></jsp:useBean>

	<div class="frame">
	<form name="modify" method="post" action="http://localhost:8080/DessertHouseWeb/SavePlanItemServlet" onsubmit="return check()">
		<span class="title">修改计划</span>
		<br></br>	
		<span class="label">价格</span> <input id="price" type="text" name="price" value="<jsp:getProperty name="planItem" property="price"/>" /> 元	
		<br></br>	
		<span class="label">数量</span> <input id="quantity" type="text" name="quantity" value="<jsp:getProperty name="planItem" property="quantity"/>" />	
		<br></br>	
		<input id="store" type="hidden" name="id" value="<jsp:getProperty name="planItem" property="id"/>"/>
		<input id="store" type="hidden" name="store" value="<%=planItem.getStore().getId()%>"/>
		<input id="date" type="hidden" name="date" value="<jsp:getProperty name="planItem" property="date"/>"/>
		<input id="date" type="hidden" name="commodity" value="<%=planItem.getCommodity().getId()%>"/>
		<input id="save" type="submit" name="save" value="确认"/>
	</form>
	</div>
	<script type="text/javascript">  
        function check(){    
            var price = window.document.getElementById("price").value; 
            var quantity = window.document.getElementById("quantity").value; 
            if (price == "") 
            {  
                window.alert("请输入价格！");  
                return false;  
            }
            if (quantity == "") 
            {  
                window.alert("请输入数量！");  
                return false;  
            }
            var r= /^[1-9]?[0-9]*(\.[0-9]*){0,1}$/;
            if (!r.test(price))  
            {  
                alert("请正确输入价格");  
                window.document.getElementById("price").focus();  
                return false;  
             } 
            var re = /^[1-9]+[0-9]*]*$/; 
            if (!re.test(quantity))  
            {  
                alert("请正确输入数量");  
                window.document.getElementById("quantity").focus();  
                return false;  
             }  
            return true;  
        }  
</script>
</body>
</html>