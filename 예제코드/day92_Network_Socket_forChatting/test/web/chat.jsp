<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
function sendMsg(msg){
	$.ajax({
		url:'chat', // ��ư�� ������ 'chat'�̶�� ������ �޽��� ������ ����
		data:{"msg":msg},
		sucess:function(data){
			$('#msg').val('');
		}
	});
}

function bt(){
	var msg= $('#msg').val();
	alert(msg);
	sendMsg(msg);

};

/* $('#bt').click(function(){
	var msg= $('#msg').val();
	sendMsg(msg);
}); */
</script>
</head>
<body>
<h1>Chat Web Client</h1>
<input id="msg" type="text" name="msg">
<!-- <input id="bt" type="button" value="CHAT"> -->
<button onclick="bt();">CHAT</button>

</body>
</html>