

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.friend;
import beans.mydata;
import beans.wpost;


@WebServlet("/savepost")
public class savepost extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession hs=request.getSession();
	String sender=hs.getAttribute("email").toString();
	String msg=request.getParameter("msg");
	wpost w=new wpost(0,sender,msg);
	
	mydata m=new mydata();
	m.save(w);
	response.sendRedirect("welcome.jsp");
	}

}
