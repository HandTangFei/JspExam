package com.hand.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hand.dao.CustomerDao;
import com.hand.entity.Customer;

public class CustomerDapImpl implements CustomerDao {

	public ResultSet get(Connection conn, Customer customer)
			throws SQLException {
		String sql = "SELECT * FROM customer where first_name=? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, customer.getFirst_name());
		return ps.executeQuery();
	}
}
