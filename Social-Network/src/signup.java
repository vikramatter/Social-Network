
import java.sql.*;
import java.io.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.*;


@WebServlet("/signup")
public class signup extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		String uname=request.getParameter("uname");
		String gender=request.getParameter("gender");
		user u=new user(email,pass,uname,gender,"");
	mydata d=new mydata();
	FileInputStream fis;
	d.save(u);
	   String path = getServletContext().getRealPath("/")+"\\images\\";
	   System.out.println(path);
	    File f= new File(getServletContext().getRealPath("/")+"\\images\\"+email);
	    f.mkdir();
	    if(gender.equals("male"))
	    {
	     fis= new FileInputStream(path+"\\male.jpg"); 
	    }
	    else
	    {
	     fis= new FileInputStream(path+"\\Female.jpg");
	    }
	    FileOutputStream fos= new FileOutputStream(path+"\\"+email+"\\pp.jpg");
	    int i;
	    while((i=fis.read())!=-1)
	    {
	    	fos.write(i);
	    }
	    fis.close();
	    fos.close();
	   
	    System.out.println(path);
	
	response.sendRedirect("index.jsp");
			
		
		
	}

}
