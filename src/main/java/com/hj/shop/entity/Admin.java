package main.java.com.hj.shop.entity;

/**
 * 后台管理员的实体类
 * @author Administrator
 *
 */
public class Admin {

	private Integer aid;
	private String adminname;
	private String password;
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
