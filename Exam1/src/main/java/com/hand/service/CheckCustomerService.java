package com.hand.service;

import java.sql.Connection;
import java.sql.ResultSet;

import com.hand.dao.CustomerDao;
import com.hand.dao.impl.CustomerDapImpl;
import com.hand.entity.Customer;
import com.hand.util.ConnectionFactory;

public class CheckCustomerService {
	private CustomerDao customerDao = new CustomerDapImpl();
	public boolean check(Customer customer){
		Connection conn = null;
		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);
			ResultSet  resultSet = customerDao.get(conn,customer);
			while(resultSet.next()){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		
		}finally{
			try {
				conn.close();
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
		return false;
	}
}
