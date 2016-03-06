<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../source/nav.jsp"/> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dessert House</title>
<link href="<%=request.getContextPath()%>/css/information.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<jsp:useBean id="member"
			type="model.Member"
			scope="session"></jsp:useBean>
	
	<%String sex = "男";
	if(member.getSex()==2)
		sex = "女";
	   String state = "已激活";
	   int is_active = member.getIs_active();
	   if(is_active==0)
		   state="未激活 (缴费200元以上自动激活)";
	   else if(is_active==2)
		   state="暂停 (缴费200元以上自动恢复)";
	   else if(is_active==3)
		   state="停止";
		%>
	<div class="frame">
		<span class="title">会员卡信息</span>
		<br></br>	
		<span class="label">&nbsp;&nbsp;会员号</span>  <jsp:getProperty name="member" property="id" />
		<br></br>	
		<span class="label">&nbsp;&nbsp;&nbsp;&nbsp;姓名</span> <jsp:getProperty name="member" property="name" />
		<br></br>
		<span class="label">&nbsp;&nbsp;&nbsp;&nbsp;余额</span> <jsp:getProperty name="member" property="balance" /> 元
		<a class="edit" href="http://localhost:8080/DessertHouseWeb/customer/recharge.jsp">缴费</a>
		<br></br>
		<span class="label">会员等级</span> <jsp:getProperty name="member" property="level" /> 级会员
		<br></br>
		<span class="label">会员资格</span> <%=state %> 
		<%if(is_active!=3&&is_active!=0){ %>
		<a class="edit" href="http://localhost:8080/DessertHouseWeb/StopMemberServlet">取消</a> <%} %>
		<br></br>
		<span class="label">&nbsp;&nbsp;&nbsp;&nbsp;积分</span> <jsp:getProperty name="member" property="point" /> 分 
		<br></br>
		<form action="http://localhost:8080/DessertHouseWeb/ExchangeServlet" method="post" onsubmit="return check()">
		<span class="label">积分兑换 </span><input id="pointToEx" type="text" name="point" value="<jsp:getProperty name="member" property="point" />" />	
		<input id="point" type="hidden" value="<jsp:getProperty name="member" property="point" />"/>
				<input id="save" type="submit" name="save" value="兑换"/>
						<%if(request.getAttribute("point")!=null){
		int point = (int)request.getAttribute("point");
			%>
		<span style= 'color: red'>兑换成功！</span>	
	<% }%>
 </form>
		<br></br>

	</div>
			<script type="text/javascript">  
        function check(){    

            var pointToEx = window.document.getElementById("pointToEx").value; 
            var point = window.document.getElementById("point").value; 
            if (pointToEx == "") 
            {  
                window.alert("请输入想要兑换的积分！");  
                return false;  
            }

            var re = /^[1-9]+[0-9]*]*$/; 
            if (!re.test(pointToEx))  
            {  
                alert("请正确输入数量");  
                window.document.getElementById("pointToEx").focus();  
                return false;  
             }  
            if(parseInt(pointToEx)>parseInt(point)){
            	alert("积分不足");
                window.document.getElementById("pointToEx").focus();  
                return false;  
            }
            return true;  
        }  
</script>
</body>
</html>