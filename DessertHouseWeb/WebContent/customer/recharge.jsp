<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../source/nav.jsp"/> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dessert House</title>
<link href="<%=request.getContextPath()%>/css/recharge.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="frame">
	<form name="recharge" method="post" action="http://localhost:8080/DessertHouseWeb/RechargeServlet" onsubmit="return check()">
		<br></br>	
		充值金额：<input id="money" type="text" name="money" value="200"/> 元	
		<br></br>	
		银行卡号：<input id="account" type="text" name="account" />	
		<br></br>
		银行密码：<input id="password" type="password" name="password" /> 
		<br></br>
		<input id="pay" class="pay" type="submit" name="save" value="确认支付"/>
				<%if(request.getAttribute("rechargeResult")!=null){
		int result = (int)request.getAttribute("rechargeResult");
			if(result==0){
	%>
		<p style= 'color: red'>缴费失败！</p>
	<% }}%>

	</form>
    
	</div>
		<script type="text/javascript">  
        function check(){    
            var money=window.document.getElementById("money").value; 
            var account=window.document.getElementById("account").value; 
            var password=window.document.getElementById("password").value;
            if (money == "") 
            {  
                window.alert("请输入金额!");  
                return false;  
            }
            var re = /^[1-9]+[0-9]*]*$/;  
            
            if (!re.test(money))  
           {  
               alert("请输入正整数");  
               window.document.getElementById("money").focus();  
               return false;  
            }  
            if (account == "") 
            {  
                window.alert("请输入银行卡号!");  
                return false;  
            }
            if (password == "") 
            {  
                window.alert("请输入银行卡密码！");  
                return false;  
            }
            return true;  
        }  
</script>
</body>
</html>