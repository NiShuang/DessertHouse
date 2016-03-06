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
	<jsp:useBean id="clerk"
			type="model.Clerk"
			scope="request"></jsp:useBean>
	
	<jsp:useBean id="storeList"
		type="action.StoreListBean"
		scope="request"></jsp:useBean>
			
	<jsp:useBean id="item" class="model.Store" 
		scope="page"></jsp:useBean>

	<%int myStore = clerk.getStore().getId(); %>
	<div class="frame">
	<form name="modify" method="post" action="http://localhost:8080/DessertHouseWeb/SaveClerkServlet" onsubmit="return check()">
		<span class="title">修改服务员</span>
		<br></br>	
		<span class="label">&nbsp;&nbsp;姓名</span> <input id="name" type="text" name="name" value="<jsp:getProperty name="clerk" property="name" />" />	
		<br></br>	
		<span class="label">&nbsp;&nbsp;电话</span> <input id="telephone" type="text" name="telephone" value="<jsp:getProperty name="clerk" property="telephone" />" />	
		<br></br>
		<span class="label">所在店</span> 
			<select id="store_select" name="store">
			    <%
    	int num = storeList.getStoreList().size();
		for (int i = 0; i < num; i++) {
			pageContext.setAttribute("item", storeList.getStoreList(i));
			int store = storeList.getStoreList(i).getId();
	%>
    <option value="<jsp:getProperty name="item" property="id" />" <%if(myStore==store){ %> selected="selected" <%}  %> ><jsp:getProperty name="item" property="name"/></option>
    <%} %> 

			</select>
		<br></br>
		<input id="id" type="hidden" name="id" value="<jsp:getProperty name="clerk" property="id" />"/>
		<input id="save" type="submit" name="save" value="保存"/>
	</form>
	</div>
	<script type="text/javascript">  
        function check(){    
            var name=window.document.getElementById("name").value; 
            if (name == "") 
            {  
                window.alert("请输入姓名！");  
                return false;  
            }
            return true;  
        }  
</script>
</body>
</html>