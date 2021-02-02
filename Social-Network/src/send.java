

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.*;


@WebServlet("/send")
public class send extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			
			HttpSession hs=request.getSession();
		
		String sender=hs.getAttribute("email").toString();
		String rec=request.getParameter("rec");
		int status=0,id=0;
		friend f=new friend(id,status,sender,rec);
		mydata m=new mydata(); 
		m.save(f);
		response.sendRedirect("welcome.jsp");
	}
	catch(Exception e)
	{
System.out.println(e);		}
		
	}

}
