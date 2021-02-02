import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.*;
@WebServlet("/login")
public class login extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
	String email,pass;
	email=request.getParameter("email");
	pass=request.getParameter("pass");
	user u=new user(email,pass,"","","");
	mydata d=new mydata();
if(d.isValid (u))
{
	HttpSession hs=request.getSession();
	hs.setAttribute("email",u.getEmail());
	response.sendRedirect("welcome.jsp");
}


else
{
	System.out.println("<script language='JavaScript'>alert('Are you a new user? Please Signup');</script>");

}


	}

}
