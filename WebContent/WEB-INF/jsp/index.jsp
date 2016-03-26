<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="js/jquery-2.2.2.min.js"></script>
<script type="text/javascript">
	function test() {
		alert("hello!");		
		$("#user").html("user......");
		$.ajax({
			url:"gateway.fish",
			data:{
				cmd:"getUser",
				id:1,
				name:"aaa"
			},
			success: function(data) {
				$("#user").html(data);
			}
			
		});
	}
</script>
<body>

welcome to anyOne!
<button onclick="test()">查询</button>
<div id="user">111</div>
</body>
</html>