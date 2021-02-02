package beans;

public class user {
	String email,pass,uname,gender,pp;
	
	public String getpp() {
		return pp;
	}

	public void setpp(String pp) {
		this.pp = pp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public user()
	{
		
		
		
		super();
	}

	public user(String email, String pass, String uname, String gender,String pp) {
		super();
		this.email = email;
		this.pass = pass;
		this.uname = uname;
		this.gender = gender;
	    this.pp=pp;
	    }


}
