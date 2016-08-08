package com.hand.service;

import java.sql.Connection;

import com.hand.dao.LanguageDao;
import com.hand.dao.impl.LanguageDaoImpl;
import com.hand.entity.Film;
import com.hand.util.ConnectionFactory;

public class AddLanguageService {
	private LanguageDao ld = new LanguageDaoImpl();
	
	public boolean SaveLanguages(Film film){
		Connection conn = null;
		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);
			ld.save(conn, film);
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				System.out.println("rollback");
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			return false;
		}finally{
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return true;
	}
	
	

}
