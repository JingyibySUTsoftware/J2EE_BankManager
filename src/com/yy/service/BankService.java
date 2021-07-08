package com.yy.service;

import java.util.List;

import com.yy.bean.BankCard;
import com.yy.bean.BankManager;
import com.yy.bean.BankUser;

public interface BankService {
	public List<BankUser> FindAllUser();
	public boolean DeleteByuid(int uid);
	public BankUser FindByuid(int uid);
	public boolean UpdateUserByuid(BankUser user);
	public boolean AddUser(BankUser user);
	public BankManager FindBankManager(BankManager bankManager);
	public List<BankCard> FindAllBankCard();
	public boolean DeleteBycid(long cid);
	public BankCard FindBycid(long cid);
	public boolean UpdateCardBycid(BankCard card);
	public boolean AddCard(BankCard card);
	public List<BankCard> SearchCardByphone(int phone);
	public BankCard FindCardByidAndpwd(BankCard card);
	public void SetMoney(double money, long cid);
	public boolean GetMoney(double money, long cid);
	public boolean TransfMoney(double money, long cid, long tocid);
}
