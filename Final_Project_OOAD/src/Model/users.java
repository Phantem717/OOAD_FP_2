package Model;

public class users {
Integer user_id;
String username;
String password;
String phoneNumber;
String Address;
String role;
public users(Integer user_id, String username, String password, String phoneNumber, String address, String role) {
	super();
	this.user_id = user_id;
	this.username = username;
	this.password = password;
	this.phoneNumber = phoneNumber;
	Address = address;
	this.role = role;
}
public Integer getUser_id() {
	return user_id;
}
public void setUser_id(Integer user_id) {
	this.user_id = user_id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}




}
