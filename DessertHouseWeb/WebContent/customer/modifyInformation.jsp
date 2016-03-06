<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../source/nav.jsp"/> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dessert House</title>
<link href="<%=request.getContextPath()%>/css/modifyInformation.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<jsp:useBean id="member"
			type="model.Member"
			scope="session"></jsp:useBean>	
	<%int sex = member.getSex();
	  int year = member.getBirthday().getYear();
	  int month = member.getBirthday().getMonth()+1;
	  int day = member.getBirthday().getDay();
	  String place = member.getPlace();
	%>
	
	<div class="frame">
	<form name="modify" method="post" action="http://localhost:8080/DessertHouseWeb/SaveInformationServlet" onsubmit="return check()">
		<span class="title">注册信息</span>
		<br></br>	
		<span class="label">&nbsp;&nbsp;会员号</span>  <jsp:getProperty name="member" property="id" />
		<br></br>	
		<span class="label">&nbsp;&nbsp;&nbsp;&nbsp;姓名</span> <input id="name" type="text" name="name" value="<jsp:getProperty name="member" property="name" />" />	
		<br></br>
		<span class="label">&nbsp;&nbsp;&nbsp;&nbsp;性别</span> <input id="sex_select" type="radio" name="sex" value="1" <%if(sex==1){%>checked="checked"<%} %> />男<input id="sex_select" type="radio" name="sex" value="2"<%if(sex==2){%>checked="checked"<%} %> />女
		<br></br>
		<span class="label">&nbsp;&nbsp;&nbsp;&nbsp;生日</span> <select id="year_select" name="year">
		<% for(int i = 1900;i<2017;i++){ 
  
        %>
		<option value=<%=i%> <%if(i==year){ %> selected="selected" <%} %>><%=i%> </option>
		<% }%>	
			</select> 年
			<select id="month_select" name="month">
		<% for(int i = 1;i<13;i++){ 
  
        %>
		<option value=<%=i%> <%if(i==month){ %> selected="selected" <%} %>><%=i%></option>
		<% }%>	
			</select> 月
			<select id="day_select" name="day">
			<% for(int i = 1;i<32;i++){ 
  
        %>
		<option value=<%=i%> <%if(i==day){ %> selected="selected" <%} %>><%=i%></option>
		<% }%>	
			</select> 日
		<br></br>
		<span class="label">&nbsp;&nbsp;所在地</span> 			
		<select id="place_select" name="place">
				<option value="南京" <%if(place.equals("南京")){ %> selected="selected" <%} %>>南京</option>
			</select>
		<br></br>
		<span class="label">注册时间</span>  <jsp:getProperty name="member" property="create_time" />
		<br></br>
		<input id="save" type="submit" name="save" value="保存"/>
	</form>
	</div>
	<script type="text/javascript">  
        function check(){    
            var name=window.document.getElementById("name").value; 
            if (name == "") 
            {  
                window.alert("请输入姓名!");  
                return false;  
            }
            return true;  
        }  
</script>
</body>
</html>