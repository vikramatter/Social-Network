import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/MyMail")
public class MyMail extends HttpServlet {
	HttpServletResponse res;
	
	protected void sendMails(String id,String sub,String msg1) throws IOException{
		PrintWriter out=res.getWriter();   
		try
	        {
	            String host = "smtp.gmail.com";
	            String to = id;
	            String from = "director.jmieti247@gmail.com";         
	            String pass ="8126188448";
	            String subject =sub;
	            Properties props = System.getProperties();
	            // -- Attaching to default Session, or we could start a new one --
	            props.put("mail.smtp.starttls.enable", "true");
	            props.put("mail.smtp.host", host);
	            props.put("mail.smtp.user", from);
	            props.put("mail.smtp.password",pass);
	            props.put("mail.transport.protocol", "smtp");
	            props.put("mail.smtp.port", "587");
	            props.put("mail.smtp.auth", "true");
	            Authenticator auth = new MyMail.SMTPAuthenticator();
	            Session session = Session.getInstance(props, auth);
	            // -- Create a new message --
	            Message msg = new MimeMessage(session);
	            // -- Set the FROM and TO fields --
	            msg.setFrom(new InternetAddress(from));
	            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
	            msg.setSubject(subject);
	            msg.setText(msg1);
	               // -- Set some other header information --
	            msg.setHeader("Password", "Password");
	            msg.setSentDate(new Date());
	            // -- Send the message --
	          System.out.println("Message sent2");
	            Transport.send(msg); 
	           System.out.println("Message sent3");
	        }
	        catch(Exception e)
	        {
	          System.out.println("Error"+e.getMessage());
	        }
	        }
	   

	    private class SMTPAuthenticator extends javax.mail.Authenticator {

	        public PasswordAuthentication getPasswordAuthentication() {
	        	  String username= "director.jmieti247@gmail.com";         
		            String password ="8126188448";
	            return new PasswordAuthentication(username, password);
	        }
	    } 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	res=response;
	String otp="";
	for(int i=1;i<=4;i++)
	{
	int s=(int)(Math.random()*10);
	otp=otp+s;
	}
	HttpSession hs=request.getSession();
	hs.setAttribute("otp", otp);
	sendMails(request.getParameter("email"), "Hello", "Your otp is "+otp);
	response.sendRedirect("verify.jsp");
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
