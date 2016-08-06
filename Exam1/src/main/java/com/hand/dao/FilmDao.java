package com.hand.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public interface FilmDao {
	public  ResultSet get(Connection conn) throws SQLException;
 
}
