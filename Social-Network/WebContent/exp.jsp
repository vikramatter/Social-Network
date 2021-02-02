<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>function check1()
{if(document.getElementById("email").value.length==0)
	{
	alert("sorry..");
document.getElementById("error1").innerHTML="<font color='red'>sorry cant leave it blank</font>";
	}
}
	
	</script>
</head>
<body>
<form action="next" method="post">
<table>
<tr>
<td>enter email</td>
<td><input type="text" name="email" id="email" onblur="check1()"></td>
<td><span id="error1"></span></td>



</tr>
<tr>
<td>enter pass</td>
<td><input type="password" name="pass" id="pass"></td>
<td><span id="error2"></span></td>
</tr>
<tr>
<td>enter name</td>
<td><input type="text" name="name" id="name"></td>
<td><span id="error3"></span></td>

</tr>
<tr>
<td>pno</td>
<td><input type="text" name="pno" id="pno">
<td><span id="error4"></span></td>
</tr>
<tr>
<td></td>
<td> <input type="submit" value="signup"></td>
</tr>
</table>
</form>
</body>
</html>