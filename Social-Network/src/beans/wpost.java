package beans;

public class wpost {
int id;
String sender,msg;
public wpost() {
	super();
}
public wpost(int id, String sender, String msg) {
	super();
	this.id = id;
	this.sender = sender;
	this.msg = msg;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getSender() {
	return sender;
}
public void setSender(String sender) {
	this.sender = sender;
}
public String getMsg() {
	return msg;
}
public void setMsg(String msg) {
	this.msg = msg;
}

}
