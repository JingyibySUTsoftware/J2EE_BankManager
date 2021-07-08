package com.yy.service.Impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.yy.bean.BankCard;
import com.yy.bean.BankManager;
import com.yy.bean.BankUser;
import com.yy.dao.BankDao;
import com.yy.dao.Impl.BankDaoImpl;
import com.yy.service.BankService;
import com.yy.util.connUtil;

public class BankServiceImpl implements BankService {
	BankDao bankdao=new BankDaoImpl();
	@Override
	public List<BankUser> FindAllUser() {
		List<BankUser> list=null;
		try {
			list=bankdao.FindAllUser();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connUtil.closeConn();
		}
		return list;
	}
	@Override
	public boolean DeleteByuid(int uid) {
		Connection conn = null;
		boolean flag=false;
		try {
			conn = connUtil.getConn();
			conn.setAutoCommit(false);
			int flagbao=bankdao.DeleteUserByuid(uid);
			if(flagbao!=0) {
				flag=true;
			}
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			connUtil.closeConn();
		}
		return flag;
	}
	@Override
	public BankUser FindByuid(int uid) {
		BankUser user=null;
		try {
			user=bankdao.FindByuid(uid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connUtil.closeConn();
		}
		return user;
	}
	@Override
	public boolean UpdateUserByuid(BankUser user) {
		Connection conn = null;
		boolean flag=false;
		try {
			conn = connUtil.getConn();
			conn.setAutoCommit(false);
			int flagbao=bankdao.UpdateUserByuid(user);
			if(flagbao!=0) {
				flag=true;
			}
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			connUtil.closeConn();
		}
		return flag;
	}
	@Override
	public boolean AddUser(BankUser user) {
		Connection conn = null;
		boolean flag=false;
		try {
			conn = connUtil.getConn();
			conn.setAutoCommit(false);
			int flagbao=bankdao.AddUser(user);
			if(flagbao!=0) {
				flag=true;
			}
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			connUtil.closeConn();
		}
		return flag;
	}
	@Override
	public BankManager FindBankManager(BankManager bankManager) {
		BankManager manager = null;
		try {
			manager= bankdao.FindBankManager(bankManager);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connUtil.closeConn();
		}

		return manager;
	}
	@Override
	public List<BankCard> FindAllBankCard(){
		List<BankCard> list=null;
		try {
			list=bankdao.FindAllBankCard();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connUtil.closeConn();
		}
		return list;
	}
	@Override
	public boolean DeleteBycid(long cid) {
		Connection conn = null;
		boolean flag=false;
		try {
			conn = connUtil.getConn();
			conn.setAutoCommit(false);
			int flagbao=bankdao.DeleteBycid(cid);
			if(flagbao!=0) {
				flag=true;
			}
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			connUtil.closeConn();
		}
		return flag;
	}
	@Override
	public BankCard FindBycid(long cid) {
		BankCard card=null;
		try {
			card=bankdao.FindBycid(cid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connUtil.closeConn();
		}
		return card;
	}
	@Override
	public boolean UpdateCardBycid(BankCard card) {
		Connection conn = null;
		boolean flag=false;
		try {
			conn = connUtil.getConn();
			conn.setAutoCommit(false);
			int flagbao=bankdao.UpdateCardBycid(card);
			if(flagbao!=0) {
				flag=true;
			}
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			connUtil.closeConn();
		}
		return flag;
	}
	@Override
	public boolean AddCard(BankCard card) {
		Connection conn = null;
		boolean flag=false;
		try {
			conn = connUtil.getConn();
			conn.setAutoCommit(false);
			int flagbao=bankdao.AddCard(card);
			if(flagbao!=0) {
				flag=true;
			}
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			connUtil.closeConn();
		}
		return flag;
	}
	@Override
	public List<BankCard> SearchCardByphone(int phone) {
		List<BankCard> list=null;
		try {
			list=bankdao.SearchCardByphone(phone);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connUtil.closeConn();
		}
		return list;
	}
	@Override
	public BankCard FindCardByidAndpwd(BankCard card) {
		BankCard bankcard=null;
		try {
			bankcard=bankdao.FindCardByidAndpwd(card);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connUtil.closeConn();
		}
		return bankcard;
	}
	@Override
	public void SetMoney(double money, long cid) {
		try {
			bankdao.SetMoney(money, cid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connUtil.closeConn();
		}
		
	}
	@Override
	public boolean GetMoney(double money, long cid) {
		boolean daoflag=false;
		try {
			double omoney=bankdao.findmoney(cid);
			if((omoney-money)>0) {
				bankdao.GetMoney(money, cid);
				daoflag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connUtil.closeConn();
		}
		return daoflag;
	}
	@Override
	public boolean TransfMoney(double money, long cid,long tocid) {
		Connection conn=null;
		boolean flag=false;
		try {
			double omoney=bankdao.findmoney(cid);
			if((omoney-money)>0) {
				conn=connUtil.getConn();
				conn.setAutoCommit(false);
				bankdao.GetMoney(money, cid);
				bankdao.SetMoney(money, tocid);
				conn.commit();
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			connUtil.closeConn();
		}
		return flag;
	}
	
}

