package com.hand.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hand.entity.Film;


public interface FilmDao {
//	public void save(Connection conn,User user) throws SQLException;
//	public void update(Connection conn,Long id,User user)throws SQLException;
	public boolean delete(Connection conn ,Film film) throws SQLException;
	public  ResultSet get(Connection conn) throws SQLException;
 
}
