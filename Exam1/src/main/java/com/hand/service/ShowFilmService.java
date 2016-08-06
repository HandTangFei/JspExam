package com.hand.service;

import java.sql.Connection;
import java.sql.ResultSet;

import com.hand.dao.FilmDao;
import com.hand.dao.impl.FilmDaoImpl;
import com.hand.util.ConnectionFactory;

public class ShowFilmService {
	private FilmDao filmDao = new FilmDaoImpl();
	ResultSet  resultSet =null;
	
	public ResultSet show(){
		Connection conn = null;
		try {
			
			conn = ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);
			resultSet = filmDao.get(conn);
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
		return resultSet;
	}
}
