package com.hand.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hand.dao.FilmDao;

public class FilmDaoImpl implements FilmDao{

	public ResultSet get(Connection conn) throws SQLException {
		String sql = "SELECT f.film_id,f.title,f.description,l.name FROM film f,language l where f.language_id = l.language_id ";
		PreparedStatement ps = conn.prepareStatement(sql);
		return ps.executeQuery();
	}

}
