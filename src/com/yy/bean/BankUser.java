package com.yy.bean;

/**   
 * @ClassName:  BankUser   
 * @Description:用户实体类
 * @author: jingyi
 * @date:   2021年5月10日 下午4:18:14      
 * @Copyright:  
 */
public class BankUser {
	private int uid;
	private String uname;
	private int uphone;
	private String company;
	private String hometown;
	public String getHometown() {
		return hometown;
	}
	public void setHometown(String hometown) {
		this.hometown = hometown;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getUphone() {
		return uphone;
	}
	public void setUphone(int uphone) {
		this.uphone = uphone;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	@Override
	public String toString() {
		return  uid+"\t\t"+uname+"\t\t"+uphone+"\t\t"+company+"\t\t"+hometown;
	}
	
	
}
