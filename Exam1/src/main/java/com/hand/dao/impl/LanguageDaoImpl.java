package com.hand.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hand.dao.LanguageDao;
import com.hand.entity.Film;

public class LanguageDaoImpl implements LanguageDao{

	public ResultSet get(Connection conn) throws SQLException {
		String sql = "SELECT name FROM language;";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet resultSet = ps.executeQuery();
		return resultSet;
	}

	public void save(Connection conn, Film film) throws SQLException {
		String sql ="INSERT INTO film(title,description,language_id) VALUES (?,?,?)";  //问号代表具体的属性
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1,film.getTitle());
		ps.setString(2,film.getDescription());
		ps.setInt(3,film.getLanguage_id());
		ps.execute();
	}

}
