<%@page import="beans.mydata"%>
<%@page import="beans.friend"%>
<%@page import="beans.user"%>
<%@page import="beans.wpost"%>
<%@ page import="java.util.ArrayList"%>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FACEBOOK</title>
</head>
<body>



<%mydata my=new mydata(); %>
<table style="width:100%" border="1">
<tr>
<td width="20%">
<h3><font color="green">Welcome To Facebook!!!!<br><%=session.getAttribute("email").toString() %></font></h3>
<img src="images/<%=session.getAttribute("email").toString() %> /<%=my.getPic(session.getAttribute("email").toString())%>" height="150px"></img>
<form enctype="multipart/form-data" action="fileupload.jsp" method="post">
Upload new<br>
<input type="file" name="f1">
<br><br>
<input type="submit">
</form>
</td>














<td width="60%">
<center>

<h4>Send Request:</h4>
<form action="send" method="post">
<input type="text" name="rec"/>
<input type="submit" value="send"/>

</form>
<hr>
<h4>Say Something</h4>
<form action="savewallpost" method="post">
<textarea rows="5" cols="20" name="msg"></textarea>
<input type="submit" value="Submit"/>

</form>
</center></td>
<td width="20%">
<img src="images/default/fb-logo-animation.gif" width="200px"/>
</td>
</tr>




<tr>
<td width="20%"><h4>Pending Requests:</h4><hr>
<%
 
mydata m=new mydata();
ArrayList<friend> a1=new ArrayList<>();
a1=m.getPending(session.getAttribute("email").toString());
for(friend f:a1)
{
%>
<%=m.getName(f.getSender())%>&nbsp;&nbsp; 
<a href="Accept?id=<%=f.getid()%>">Accept</a> &nbsp;&nbsp;
<a href="Reject?id=<%=f.getid()%>">Reject</a> &nbsp;&nbsp;
<hr>
<%

}
%>
<td width="60%">
<%
ArrayList<wpost> al2=my.returnposts(session.getAttribute("email").toString());
for(wpost w:al2)
{
%>
<%=w.getMsg()%>
<h5><%=w.getSender()%></h5><hr>
<%}
%>
</td>
<td width="20%">
<h4>Your Friends:</h4><hr>
<% 
String rec1=session.getAttribute("email").toString() ;
ArrayList<String> al1=my.getFriends(rec1);
for(String f:al1)
{
%>
<%=my.getName(f)%><hr>
<%}
%>
</td>	

</tr></table>
</body>
</html>