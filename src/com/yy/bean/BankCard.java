package com.yy.bean;

/**   
 * @ClassName:  BankCard   
 * @Description:银行卡实体类 
 * @author: jingyi
 * @date:   2021年5月10日 下午1:17:09      
 * @Copyright:  
 */
public class BankCard {
	private long cid;
	private int cpssword;
	private double cmoney;
	private String ctype;
	private BankUser bankuser;
	
	@Override
	public String toString() {
		return this.cid+"\t\t"+this.cpssword+"\t\t"+this.cmoney+"\t\t"+this.ctype+"\t\t"
				 +this.bankuser.getUid()+"\t\t"+this.bankuser.getUname()+"\t\t"+this.bankuser.getUphone()+"\t\t"+this.bankuser.getCompany()+"\t\t"+this.bankuser.getHometown();
	}
	public BankUser getBankuser() {
		return bankuser;
	}
	public void setBankuser(BankUser bankuser) {
		this.bankuser = bankuser;
	}
	public long getCid() {
		return cid;
	}
	public void setCid(long cid) {
		this.cid = cid;
	}
	public int getCpssword() {
		return cpssword;
	}
	public void setCpssword(int cpssword) {
		this.cpssword = cpssword;
	}
	public double getCmoney() {
		return cmoney;
	}
	public void setCmoney(double cmoney) {
		this.cmoney = cmoney;
	}
	public String getCtype() {
		return ctype;
	}
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	
	
	
	
}
