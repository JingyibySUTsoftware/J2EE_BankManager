package com.yy.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.yy.bean.BankCard;
import com.yy.bean.BankManager;
import com.yy.bean.BankUser;
import com.yy.dao.BankDao;
import com.yy.util.connUtil;

public class BankDaoImpl implements BankDao {

	@Override
	public List<BankUser> FindAllUser() throws SQLException {	
		Connection conn = connUtil.getConn();
		String sql="select * from  bankuser";
		Statement statement = conn.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		List<BankUser> list =new ArrayList<BankUser>();
		while(rs.next()) {
			BankUser user = new BankUser();
			user.setUid(rs.getInt(1));
			user.setUname(rs.getString(2));
			user.setUphone(rs.getInt(3));
			user.setCompany(rs.getString(4));
			user.setHometown(rs.getString(5));
			list.add(user);
		}
		return list;
	}

	@Override
	public int DeleteUserByuid(int uid) throws SQLException {
		int flag;
		Connection conn = connUtil.getConn();
		String sql="delete from bankuser where uid=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1,uid);
		flag=ps.executeUpdate();
		return flag;
	}

	@Override
	public BankUser FindByuid(int uid) throws SQLException {
		Connection conn = connUtil.getConn();
		String sql="select *from bankuser where uid=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1,uid);
		ResultSet rs = ps.executeQuery();
		BankUser user = new BankUser();
		while(rs.next()) {
			user.setUid(rs.getInt(1));
			user.setUname(rs.getString(2));
			user.setUphone(rs.getInt(3));
			user.setCompany(rs.getString(4));
			user.setHometown(rs.getString(5));	
		}
		return user;
	}

	@Override
	public int UpdateUserByuid(BankUser user) throws SQLException {
		int flag;
		Connection conn = connUtil.getConn();
		String sql="update bankuser set uname=?,uphone=?,company=?,hometown=? where uid=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1,user.getUname());
		ps.setInt(2, user.getUphone());
		ps.setString(3, user.getCompany());
		ps.setString(4, user.getHometown());
		ps.setInt(5, user.getUid());
		flag=ps.executeUpdate();
		return flag;
	}

	@Override
	public int AddUser(BankUser user) throws SQLException {
		int flag;
		Connection conn = connUtil.getConn();
		String sql="insert into bankuser(uname,uphone,company,hometown) values (?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1,user.getUname());
		ps.setInt(2, user.getUphone());
		ps.setString(3, user.getCompany());
		ps.setString(4, user.getHometown());
		flag=ps.executeUpdate();
		return flag;
	}

	@Override
	public BankManager FindBankManager(BankManager bankManager) throws SQLException {
		Connection conn = connUtil.getConn();
		String sql="select * from bankmanager where mid=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1,bankManager.getMid());
		ResultSet rs = ps.executeQuery();
		BankManager manager = new BankManager();
		while(rs.next()) {
			manager.setMid(rs.getInt(1));
			manager.setMname(rs.getString(2));
			manager.setMpass(rs.getString(3));
		}
		return manager;		
	}

	@Override
	public List<BankCard> FindAllBankCard() throws SQLException {
		List<BankCard> list=new ArrayList<BankCard>();
		Connection conn=connUtil.getConn();
		String sql="select bc.*,bu.uname,bu.uphone,bu.company,bu.hometown from bankcard bc,bankuser bu where bc.uid=bu.uid";
		Statement stat= conn.createStatement();
		ResultSet rs=stat.executeQuery(sql);
			while(rs.next()) {
				BankCard bc=new BankCard();
				BankUser bu=new BankUser();
				bc.setBankuser(bu);
				bc.setCid(rs.getLong("cid"));
				bc.setCpssword(rs.getInt("cpassword"));
				bc.setCmoney(rs.getDouble("cmoney"));
				bc.setCtype(rs.getString("ctype"));
				bc.getBankuser().setUid(rs.getInt("uid"));
				bc.getBankuser().setUname(rs.getString("uname"));
				bc.getBankuser().setUphone(rs.getInt("uphone"));
				bc.getBankuser().setCompany(rs.getString("company"));
				bc.getBankuser().setHometown(rs.getString("hometown"));
				list.add(bc);
			}
		return list;
	}

	@Override
	public int DeleteBycid(long cid) throws SQLException {
		int count=0;
		Connection conn=connUtil.getConn();
		String sql="delete from bankcard  where cid=?";
		PreparedStatement ps  = conn.prepareStatement(sql);
		ps.setLong(1, cid);
		count=ps.executeUpdate();
		return count;
	}

	@Override
	public BankCard FindBycid(long cid) throws SQLException {
		Connection conn = connUtil.getConn();
		String sql="select *from bankcard where cid=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setLong(1,cid);
		ResultSet rs = ps.executeQuery();
		BankCard card = new BankCard();
		while(rs.next()) {
			card.setCid(rs.getLong("cid"));
			card.setCpssword(rs.getInt("cpassword"));
			card.setCtype(rs.getString("ctype"));
		}
		return card;
	}

	@Override
	public int UpdateCardBycid(BankCard card) throws SQLException {
		int flag;
		Connection conn = connUtil.getConn();
		String sql="update bankcard set cpassword=? where cid=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1,card.getCpssword());
		ps.setLong(2,card.getCid());
		flag=ps.executeUpdate();
		return flag;
	}

	@Override
	public int AddCard(BankCard card) throws SQLException {
		int flag;
		Connection conn = connUtil.getConn();
		String sql="insert into bankcard(cpassword,cmoney,ctype,uid) values (?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, card.getCpssword());
		ps.setDouble(2, card.getCmoney());
		ps.setString(3, card.getCtype());
		ps.setInt(4, card.getBankuser().getUid());
		flag=ps.executeUpdate();
		return flag;
	}

	@Override
	public List<BankCard> SearchCardByphone(int phone) throws SQLException {
		List<BankCard> list=new ArrayList<BankCard>();
		Connection conn=connUtil.getConn();	
		String sql="select bc.*,bu.uname,bu.uphone,bu.company,bu.hometown from bankcard bc,bankuser bu where bc.uid=bu.uid and bu.uphone=?";
		PreparedStatement ps= conn.prepareStatement(sql);
		ps.setInt(1, phone);
		ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				BankCard bc=new BankCard();
				BankUser bu=new BankUser();
				bc.setBankuser(bu);
				bc.setCid(rs.getLong("cid"));
				bc.setCpssword(rs.getInt("cpassword"));
				bc.setCmoney(rs.getDouble("cmoney"));
				bc.setCtype(rs.getString("ctype"));
				bc.getBankuser().setUid(rs.getInt("uid"));
				bc.getBankuser().setUname(rs.getString("uname"));
				bc.getBankuser().setUphone(rs.getInt("uphone"));
				bc.getBankuser().setCompany(rs.getString("company"));
				bc.getBankuser().setHometown(rs.getString("hometown"));
				list.add(bc);
			}
		return list;
	}

	@Override
	public BankCard FindCardByidAndpwd(BankCard card) throws SQLException {
		Connection conn=connUtil.getConn();
		String sql="select bc.*,bu.uname,bu.uphone,bu.company,bu.hometown from bankcard bc,bankuser bu where bc.uid=bu.uid and bc.cid=? and bc.cpassword=?";
		PreparedStatement ps= conn.prepareStatement(sql);
		ps.setLong(1, card.getCid());
		ps.setInt(2, card.getCpssword());
		ResultSet rs=ps.executeQuery();
		BankCard bc=new BankCard();
		BankUser bu=new BankUser();
		bc.setBankuser(bu);
			while(rs.next()) {
				bc.setCid(rs.getLong("cid"));
				bc.setCpssword(rs.getInt("cpassword"));
				bc.setCmoney(rs.getDouble("cmoney"));
				bc.setCtype(rs.getString("ctype"));
				bc.getBankuser().setUid(rs.getInt("uid"));
				bc.getBankuser().setUname(rs.getString("uname"));
				bc.getBankuser().setUphone(rs.getInt("uphone"));
				bc.getBankuser().setCompany(rs.getString("company"));
				bc.getBankuser().setHometown(rs.getString("hometown"));
			}
		return bc;
	}

	@Override
	public void SetMoney(double money, long cid) throws SQLException {
		Connection conn=connUtil.getConn();
		String sql="update bankcard set cmoney=cmoney+? where cid=?";
		PreparedStatement ps  = conn.prepareStatement(sql);
		ps.setDouble(1, money);
		ps.setLong(2, cid);
		ps.executeUpdate();
	}
	@Override
	public double findmoney(Long cardid) throws SQLException{
		double money=0;
		Connection conn=connUtil.getConn();
		String sql="select cmoney from bankcard where cid=?";
		PreparedStatement ps  = conn.prepareStatement(sql);
		ps.setLong(1, cardid);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			money=rs.getDouble(1);
		}
		return money;	
	}
	@Override
	public void GetMoney(double money, long cid) throws SQLException {
		Connection conn=connUtil.getConn();
		String sql="update bankcard set cmoney=cmoney-? where cid=?";
		PreparedStatement ps  = conn.prepareStatement(sql);
		ps.setDouble(1, money);
		ps.setLong(2, cid);
		ps.executeUpdate();
	}
}
