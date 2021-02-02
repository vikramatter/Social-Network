package beans;
import java.sql.*;

import java.util.ArrayList;




public class mydata {
String msg;
public Connection getConnection()
{
	Connection cn=null;

	try
	{
		
		Class.forName("com.mysql.jdbc.Driver");
		cn=DriverManager.getConnection("jdbc:mysql://localhost:3307/mydata?user=root&password=india@123");
		msg="Success";
		
		
	}
catch(Exception e)
	{
	msg="error"+e.getMessage();
	}
	return cn;
}


public void acceptrequest(int id)
{
	Connection cn=null;  
	try
	{
		cn=getConnection(); 

		String qr="update friends set status=1 where id=?";
        PreparedStatement smt=cn.prepareStatement(qr);
smt.setInt(1,id);
//smt.setString(2,w.getMsg());
smt.executeUpdate();


		
		msg="Success";
		
		cn.close();
	}
catch(Exception e)
	{
	msg="error"+e.getMessage();
	}




}
public void rejectrequest(int id)
{
	Connection cn=null;  
	try
	{
		cn=getConnection(); 

		String qr="delete from friends where id=?";
        PreparedStatement smt=cn.prepareStatement(qr);
smt.setInt(1,id);
//smt.setString(2,w.getMsg());
smt.executeUpdate();


		
		msg="Success";
		
		cn.close();
	}
catch(Exception e)
	{
	msg="error"+e.getMessage();
	}




}

public void save(wpost w)
{
	Connection cn=null;  
	try
	{
		cn=getConnection(); 

		String qr="insert into wposts (sender,msg) values(?,?)";
        PreparedStatement smt=cn.prepareStatement(qr);
smt.setString(1,w.getSender());
smt.setString(2,w.getMsg());
smt.executeUpdate();


		
		msg="Success";
		
		cn.close();
	}
catch(Exception e)
	{
	msg="error"+e.getMessage();
	}



}

public void save(user u)
{
	Connection cn=null;  
	try
	{
		cn=getConnection(); 

		String qr="insert into users values(?,?,?,?,?)";
        PreparedStatement smt=cn.prepareStatement(qr);
smt.setString(1,u.getEmail());
smt.setString(2,u.getPass());
smt.setString(3,u.getUname());
smt.setString(4,u.getGender());
smt.setString(5, "pp.jpg");

smt.executeUpdate();
msg="Success";

smt.executeUpdate();


		
		msg="Success";
		
		cn.close();
	}
catch(Exception e)
	{
	msg="error"+e.getMessage();
	}
}
public boolean isValid(user u)
{
	Connection cn=null;  
	try
	{
		cn=getConnection(); 

		String qr="select * from users where email=? and pass=?";
        PreparedStatement smt=cn.prepareStatement(qr);
smt.setString(1,u.getEmail());
smt.setString(2,u.getPass());
ResultSet rs=smt.executeQuery();
if(rs.next())
return true;
else 
return false;
	}
catch(Exception e)
	{
	msg="error"+e.getMessage();
	}
finally{
	
	try {
		cn.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	return false;
	
}


public ArrayList<friend> getPending(String email)
{     ArrayList<friend> a1=new ArrayList<>();

	Connection cn=null;
	
	try
	{
		cn=getConnection(); 

		String qr="select id,status,sender,rec from friends where status=0 and rec=?";
        PreparedStatement smt=cn.prepareStatement(qr);
smt.setString(1,email);
ResultSet rs=smt.executeQuery();
while(rs.next())
{
friend f=new friend(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4))	;
a1.add(f);
}
	}
catch(Exception e)
	{
	msg="error"+e.getMessage();
	}
finally{
	
	try {
		cn.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	return a1;
	
}



public ArrayList<wpost> returnposts(String email)
{     ArrayList<String> a1=getFriends(email);
a1.add(email);
ArrayList <wpost> wp=new ArrayList<>();
	Connection cn=null;
	
	try
	{
		cn=getConnection(); 

		String qr="select * from wposts order by id desc";
        PreparedStatement smt=cn.prepareStatement(qr);
ResultSet rs=smt.executeQuery();
while(rs.next())
{
wpost w=new wpost(rs.getInt(1),rs.getString(2),rs.getString(3));
if(a1.contains(w.getSender()))
{
	
wp.add(w);

}

}
	}
catch(Exception e)
	{
	msg="error"+e.getMessage();
	}
finally{
	
	try {
		cn.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	return wp;
	
}


public ArrayList<String> getFriends(String email)
{     ArrayList<String> a1=new ArrayList<>();

	Connection cn=null;
	
	try
	{
		cn=getConnection(); 

		String qr="select sender from friends where rec=? and status=1 union select rec from friends where sender=? and status=1";
        PreparedStatement smt=cn.prepareStatement(qr);
smt.setString(1,email);
smt.setString(2,email);
ResultSet rs=smt.executeQuery();
while(rs.next())
{
//friend f=new friend(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4))	;
a1.add(rs.getString(1));
}
	}
catch(Exception e)
	{
	msg="error"+e.getMessage();
	}
finally{
	
	try {
		cn.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	return a1;
	
}

public String getName(String email)
{     //ArrayList<friend> a1=new ArrayList<>();

	Connection cn=null;
	String name="";
	try
	{
		cn=getConnection(); 

		String qr="select uname from users where email=?";
        PreparedStatement smt=cn.prepareStatement(qr);
smt.setString(1,email);
ResultSet rs=smt.executeQuery();
rs.next();
name=rs.getString(1);
	}
catch(Exception e)
	{
	msg="error"+e.getMessage();
	System.out.println(msg);
	}
finally{
	
	try {
		cn.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	return name;
	
}






public void save(friend f)
{
	Connection cn=null;  
	try
	{
		cn=getConnection(); 

		String qr="insert into friends(sender,rec,status) values(?,?,?)";
        PreparedStatement smt=cn.prepareStatement(qr);
smt.setString(1,f.getSender());
smt.setString(2,f.getRec());
smt.setInt(3,f.getStatus());

smt.executeUpdate();


		
		msg="Success";
		
		cn.close();
	}
catch(Exception e)
	{
	msg="error"+e.getMessage();
	System.out.println(msg);
	}
}
public String getPic(String str)
{
	Connection cn=null;
	String name ="";
	try
	{
		cn=getConnection();
		String query="select pp from users where email=?";
		PreparedStatement st=cn.prepareStatement(query);
		st.setString(1,str);
		ResultSet rs=st.executeQuery();
		rs.next();
		name=rs.getString(1);
    }
    catch(Exception e) 
    {
	    msg="Error: "+e.getMessage();
    }
	finally
	{
		try
		{
			cn.close();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return name;
}



public void savePic(String a,String b)
{
	Connection cn=null;
	try
	{
		cn=getConnection();
		String query="update users set pp=? where email=?";
		PreparedStatement st=cn.prepareStatement(query);
		st.setString(1,a);
		st.setString(2,b);
		st.executeUpdate();
		msg="Success";
	}
    catch(Exception e) 
    {
	    msg="Error: "+e.getMessage();
    }
	finally
	{
		try
		{
			cn.close();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public void updatepass(String a,String b)
{
	Connection cn=null;  
	try
	{
		cn=getConnection(); 

		String qr=" UPDATE users set pass=? where email=?";
        PreparedStatement smt=cn.prepareStatement(qr);
smt.setString(1,a);
smt.setString(2,b);
//smt.setString(2,w.getMsg());
smt.executeUpdate();


		
		msg="Success";
		
		cn.close();
	}
catch(Exception e)
	{
	msg="error"+e.getMessage();
	}




}









}

