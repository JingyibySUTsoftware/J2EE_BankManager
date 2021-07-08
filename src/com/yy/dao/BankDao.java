package com.yy.dao;

import java.sql.SQLException;
import java.util.List;

import com.yy.bean.BankCard;
import com.yy.bean.BankManager;
import com.yy.bean.BankUser;

public interface BankDao {
	public List<BankUser> FindAllUser() throws SQLException;
	public int DeleteUserByuid(int uid)throws SQLException;
	public BankUser FindByuid(int uid)throws SQLException;
	public int UpdateUserByuid(BankUser user)throws SQLException;
	public int AddUser(BankUser user)throws SQLException;
	public BankManager FindBankManager(BankManager bankManager)throws SQLException;
	public List<BankCard> FindAllBankCard() throws SQLException;
	public int DeleteBycid(long cid) throws SQLException;
	public BankCard FindBycid(long cid) throws SQLException;
	public int UpdateCardBycid(BankCard card)throws SQLException;
	public int AddCard(BankCard card)throws SQLException;
	public List<BankCard> SearchCardByphone(int phone)throws SQLException;
	public BankCard FindCardByidAndpwd(BankCard card)throws SQLException;
	public void SetMoney(double money, long cid)throws SQLException;
	public void GetMoney(double money, long cid)throws SQLException;
	public double findmoney(Long cardid) throws SQLException;
}
