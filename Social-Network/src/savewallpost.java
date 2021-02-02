

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.mydata;
import beans.wpost;


@WebServlet("/savewallpost")
public class savewallpost extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String	msg=request.getParameter("msg");
	HttpSession hs=request.getSession();
	String sender=hs.getAttribute("email").toString();
	mydata m=new mydata();
	wpost w=new wpost(0,sender,msg);
	m.save(w);
	response.sendRedirect("welcome.jsp");
	
	}

}
