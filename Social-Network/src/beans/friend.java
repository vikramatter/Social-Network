package beans;

public class friend {
int id,status;
String sender,rec;
public friend() {
	super();
}
public friend(int id, int status, String sender, String rec) {
	super();
	this.id = id;
	this.status = status;
	this.sender = sender;
	this.rec = rec;
}
public int getid() {
	return id;
}
public void setid(int id) {
	this.id = id;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public String getSender() {
	return sender;
}
public void setSender(String sender) {
	this.sender = sender;
}
public String getRec() {
	return rec;
}
public void setRec(String rec) {
	this.rec = rec;
}


}
