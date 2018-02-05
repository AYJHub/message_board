package com.lin.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lin.bean.Message;
import com.lin.bean.User;
import com.lin.utils.DBconn;
import com.mysql.jdbc.Connection;

public class LoginDao {

	Connection conn = DBconn.getConn();

	PreparedStatement pstm = null;

	//获取注册用户
	public User findUser(String username, String password) {

		String sql = "select * from users where name = ?  and password = ?";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, username);
			pstm.setString(2, password);
			ResultSet rst = pstm.executeQuery();
			if (rst.next()) {
				User user = new User();
				user.setId(rst.getInt(1));
				user.setName(rst.getString(2));
				user.setPassword(rst.getString(3));
				user.setRole(rst.getInt(4));
				return user;
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;

	}

	//获取留言板信息
	public ArrayList<Message> findInfo() {
		ArrayList<Message> messagess = new ArrayList<>();
		String sql = "select * from messagess";
		try {
			pstm = conn.prepareStatement(sql);
			ResultSet rst = pstm.executeQuery();
			while (rst.next()) {

				Message message = new Message();
				message.setId(rst.getInt(1));
				message.setUsername(rst.getString(2));
				message.setTime(rst.getDate(3));
				message.setTitle(rst.getString(4));
				message.setMessage(rst.getString(5));
				messagess.add(message);
			}
			return messagess;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//根据id获取name
	public String getName(int id) {

		String name = null;
		String sql = "select name from users where id = ?";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet rst = pstm.executeQuery();
			if (rst.next()) {
				name = rst.getString(1);
			}
			return name;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//添加留言板信息
	public boolean addInfo(Message ms) {

		String sql = "insert into messagess values(?,?,?,?,?)";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ms.getId());
			pstm.setString(2, ms.getUsername());
			pstm.setDate(3, ms.getTime());
			pstm.setString(4, ms.getTitle());
			pstm.setString(5, ms.getMessage());
			pstm.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	//添加注册用户
	public boolean insertUser(int id, String name, String password) {
		String sql = "insert into users values(?,?,?,?)";

		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.setString(2, name);
			pstm.setString(3, password);
			pstm.setInt(4, 0);
			pstm.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}
}