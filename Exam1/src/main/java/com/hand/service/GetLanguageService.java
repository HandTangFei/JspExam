package com.hand.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Set;
import java.util.TreeSet;

import com.hand.dao.LanguageDao;
import com.hand.dao.impl.LanguageDaoImpl;
import com.hand.util.ConnectionFactory;

public class GetLanguageService {
	private LanguageDao ld = new LanguageDaoImpl();
	private ResultSet rs = null;
	private Set<String>  ts= new TreeSet<String>();
	
	public Set<String> GetLanguages(){
		Connection conn = null;
		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);
			rs = ld.get(conn);
			
			while(rs.next()){
				ts.add(rs.getString("name"));
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
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return ts;
	}
	
	

}
