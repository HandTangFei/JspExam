package com.hand.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hand.dao.FilmDao;
import com.hand.entity.Film;

public class FilmDaoImpl implements FilmDao{

	public ResultSet get(Connection conn) throws SQLException {
		String sql = "SELECT f.film_id,f.title,f.description,l.name FROM film f,language l where f.language_id = l.language_id ";
		PreparedStatement ps = conn.prepareStatement(sql);
		return ps.executeQuery();
	}

	public boolean delete(Connection conn, Film film) throws SQLException {
		String sql = "DELETE FROM film where film_id = ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, film.getFilm_id());
		boolean bool = ps.execute();
		return bool;
	}
}
