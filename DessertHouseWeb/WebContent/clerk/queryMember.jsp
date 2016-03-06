<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../source/clerkNav.jsp"/> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dessert House</title>
<link href="<%=request.getContextPath()%>/css/queryMember.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="frame">
	<div class="queryFrame">
		<form name="modify" method="post" action="http://localhost:8080/DessertHouseWeb/QueryMemberServlet" onsubmit="return check()">
		<span class="title">会员查询</span>
		<br></br>	
		<span class="label">&nbsp;&nbsp;会员号</span> <input id="id" type="text" name="id"  />
		<br></br>	
		<input id="save" type="submit" name="save" value="查询"/>
		<%if(request.getAttribute("result")!=null){
		int result = (int)request.getAttribute("result");
			if(result==0){
	%>
		<p style= 'color: red'>不存在该会员！</p>
	<%}
	} %>
	</form>
	</div>
	<div class="informationFrame">
		<%if(request.getAttribute("member")!=null){%>
			<jsp:useBean id="member"
				type="model.Member"
			scope="request"></jsp:useBean>
		<%String sex = "男";
		if(member.getSex()==2)
		sex = "女";%>
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
		<a class="payment" href="http://localhost:8080/DessertHouseWeb/CheckPaymentRecordServlet?id=<jsp:getProperty name="member" property="id" />">缴费记录</a>
		
		<a class="consume" href="http://localhost:8080/DessertHouseWeb/CheckConsumeRecordServlet?id=<jsp:getProperty name="member" property="id" />">消费记录</a>
	<%} %>
	</div>
	</div>
	<script type="text/javascript">  
        function check(){    
            var id=window.document.getElementById("id").value; 
            if (id == "") 
            {  
                window.alert("请输入会员号！");  
                return false;  
            }
            return true;  
        }  
</script>
</body>
</html>