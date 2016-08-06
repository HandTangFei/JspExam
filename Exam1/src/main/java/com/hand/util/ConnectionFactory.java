package com.hand.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {

	private static String driver;
	private static String dburl;
	private static String user;
	private static String password;
	
	private static ConnectionFactory factory = new ConnectionFactory();
	private Connection conn = null;  //用于保存数据库连接
	static{
		Properties prop = new Properties();
		try {
			InputStream in = ConnectionFactory.class.getClassLoader()
					.getResourceAsStream("dbconfig.properties");
			prop.load(in);
		} catch (Exception e) {
			System.out.println("========配置文件读取错误========");
		}
		driver = prop.getProperty("driver");
		dburl = prop.getProperty("dburl");
		user = prop.getProperty("user");
		password = prop.getProperty("password");
	}
	public ConnectionFactory(){
	}
	//使用单例模式，保证在程序执行期间只有一个ConnectionFactory实例
	public static ConnectionFactory getInstance(){
		return factory;
	}
	public Connection makeConnection(){
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(dburl,user,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
}

