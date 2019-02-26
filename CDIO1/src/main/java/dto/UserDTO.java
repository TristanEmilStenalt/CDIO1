package dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserDTO implements Serializable{

	private static final long serialVersionUID = 4545864587995944260L;
	private int	userId;                     
	private String userName;                
	private String ini;
	private int cpr;
	private String pass;
	private List<String> roles;

	public UserDTO(int userId, String userName, String ini, int cpr, String pass, List<String> roles) {
		this.userId = userId;
		this.userName = userName;
		this.ini = ini;
		this.cpr = cpr;
		this.pass = pass;
		this.roles = roles;
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getIni() {
		return ini;
	}
	public void setIni(String ini) {
		this.ini = ini;
	}
	public int getCpr() { return cpr; }
	public void setCpr(int cpr) { this.cpr = cpr; }
	public String getPass() { return pass; }
	public void setPass(String pass) { this.pass = pass; }

	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
	public void addRole(String role){
		this.roles.add(role);
	}
	/**
	 * 
	 * @param role
	 * @return true if role existed, false if not
	 */
	public boolean removeRole(String role){
		return this.roles.remove(role);
	}

	@Override
	public String toString() {
		return "UserDTO{" +
				"userId=" + userId +
				", userName='" + userName + '\'' +
				", ini='" + ini + '\'' +
				", cpr=" + cpr +
				", pass='" + pass + '\'' +
				", roles=" + roles +
				'}';
	}
}
