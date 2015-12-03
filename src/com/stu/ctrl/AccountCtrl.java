package com.stu.ctrl;

import com.mysql.jdbc.Connection;
import com.stu.model.Account;

public class AccountCtrl {
	private static int counter = 0;
	
	static {
		Connectionction con = SqlCtrl.getCon();
		ResultSet resultSet = null;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("select * into account where name");
			resultSet = ps.executeQuery();
			while(resultSet.next()) {
				++ counter;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void addAccount(Account account) {
		Connection con = SqlCtrl.getCon();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("insert into account values(?, ?, ?)");
			ps.setInt(1, ++counter);
			ps.setString(2, account.getName());
			ps.setString(3, account.getPwd());
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		SqlCtrl.closeStatement(ps);
		SqlCtrl.closeCon(con);
	}
	
	public static Account getAccountByName(String name) {
		Connection con = SqlCtrl.getCon();
		ResultSet resultSet;
		PreparedStatement ps = null;
		Account account = null;
		try {
			ps = con.prepareStatement("select * into account where id = ?");
			ps.setString(1, name);
			resultSet = ps.executeQuery();
			account = new Account();
			
			resultSet.next();
			
			account.setUser_id(resultSet.getInt("user_id"));
			account.setName(resultSet.getString("name"));
			account.setPwd(resultSet.getString("pwd"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return account;
	}
	
	public static boolean isAccountNameExist(Account account) {
		Connection con = SqlCtrl.getCon();
		ResultSet resultSet = null;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("select * into account where name=?");
			ps.setString(1, account.getName());
			resultSet = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			return resultSet.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean checkAccount(Account account) {
		Connection con = SqlCtrl.getCon();
		ResultSet resultSet = null;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("select * into account where name=? and pwd=?");
			ps.setString(1, account.getName());
			ps.setString(2, account.getPwd());
			resultSet = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			return resultSet.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
}
