package com.hand.service;

import java.sql.Connection;

import com.hand.dao.FilmDao;
import com.hand.dao.impl.FilmDaoImpl;
import com.hand.entity.Film;
import com.hand.util.ConnectionFactory;

public class CheckDeleteFilmService {
	private FilmDao filmDao = new FilmDaoImpl();
	private boolean bool;
	public boolean check(Film film){
		Connection conn = null;
		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);
		    bool = filmDao.delete(conn,film);
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
		return bool;
	}
}
