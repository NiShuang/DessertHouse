<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../source/clerkNav.jsp"/> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dessert House</title>
<link href="<%=request.getContextPath()%>/css/reserve.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<jsp:useBean id="planItem"
			type="model.PlanItem"
			scope="request"></jsp:useBean>
	<%String store = planItem.getStore().getName();
	  String commodity = planItem.getCommodity().getName();
	  int sale = planItem.getQuantity()-planItem.getSold()-planItem.getSchedule();
	  
	%>
	<div class="frame">
		<form name="modify" method="post" action="http://localhost:8080/DessertHouseWeb/SellServlet?price=<jsp:getProperty name="planItem" property="price" />" onsubmit="return check()">
	
		<span class="title">购买</span>
		<br></br>	
		<span class="label">&nbsp;&nbsp;&nbsp;&nbsp;商品</span>  <%=commodity %>
		<br></br>	
		<span class="label">&nbsp;&nbsp;&nbsp;&nbsp;店铺</span> <%=store %>
		<br></br>
		<span class="label">&nbsp;&nbsp;&nbsp;&nbsp;价格</span> <jsp:getProperty name="planItem" property="price" /> 元
		<br></br>
		<span class="label">&nbsp;&nbsp;&nbsp;&nbsp;数量</span>   <input id="quantity" type="text" name="quantity" value="1" oninput ="quantityChange()"/> 
		<br></br>
		<span class="label">&nbsp;&nbsp;&nbsp;&nbsp;总价</span> <label id="totalPrice" style= 'font-weight:bold; font-family:SimHei;font-size:20px;' ><jsp:getProperty name="planItem" property="price" /></label> 元
		<br></br>
		<span class="label">&nbsp;&nbsp;会员号</span>   <input id="member" type="text" name="member" placeholder="若没有则无须填写" /> 
		<br></br>
		<input id="id" type="hidden" name="id" value="<jsp:getProperty name="planItem" property="id" />"/>
		<input id="max" type="hidden" name="max" value="<%=sale %>"/>
		<input id="price" type="hidden" name="max" value="<jsp:getProperty name="planItem" property="price" />"/>
		<input id="confirm" type="submit" name="confirm" value="确认"/>
		<%if(request.getAttribute("result")!=null){
		int result = (int)request.getAttribute("result");
			if(result==0){
	%>
		<p style= 'color: red'>该会员不存在！</p>
	<%}else if(result==-1){%>
		<p style= 'color: red'>余额不足！</p>	
	<% }else if(result==-2){ %>
	<p style= 'color: red'>该会员资格无效！</p>	
	<% }} %>
		</form>
	</div>
		<script type="text/javascript">  
		function quantityChange(){
			var quantity = window.document.getElementById("quantity").value; 
			var price = window.document.getElementById("price").value;
			var total = window.document.getElementById("totalPrice")
			var totalPrice = parseInt(quantity)*parseFloat(price);
			if(isNaN(totalPrice))
				totalPrice = 0;
			total.innerText=totalPrice; 
		}
		
        function check(){    

            var quantity = window.document.getElementById("quantity").value; 
            var max = window.document.getElementById("max").value; 
            if (quantity == "") 
            {  
                window.alert("请输入数量！");  
                return false;  
            }

            var re = /^[1-9]+[0-9]*]*$/; 
            if (!re.test(quantity))  
            {  
                alert("请正确输入数量");  
                window.document.getElementById("quantity").focus();  
                return false;  
             }  
            if(parseInt(quantity)>parseInt(max)){
            	alert("数量不足");
                window.document.getElementById("quantity").focus();  
                return false;  
            }
            return true;  
        }  
</script>
</body>
</html>