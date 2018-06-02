package com.hbut.util;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;




import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

/*****************************************************************
 * 类名 : ConnectSQL 
 * 作者 : 王子豪 
 * 日期 : 2016-08-22 
 * 修改历史： 
 * 功能描述: 连接数据库的操作
 ******************************************************************/
public class ConnectSQL {
	private static Connection conn = null;

	private static DataSource dataSource;

	/*****************************************************************
	 * 方法名 : initDataSource 
	 * 作者 : 王子豪 
	 * 日期 : 2016-10-25 
	 * 输入参数：无 
	 * 输出参数：无 
	 * 功能描述:初始化数据库连接配置 
	 * 修改历史：
	 * @throws IOException 
	 ******************************************************************/
	@SuppressWarnings("deprecation")
	public static void initDataSource(){
		Properties properties = new Properties();

		try {		 //通过mysql.properties配置文件进行修改
			properties.load(ConnectSQL.class.getResourceAsStream("/hbutclass.properties"));
			
			String driverClassName = properties.getProperty("jdbc.driverClassName");
			String url = properties.getProperty("jdbc.url");
			String username = properties.getProperty("jdbc.username");
			String password = properties.getProperty("jdbc.password");

			int maxIdle = Integer.valueOf(properties.getProperty("dataSource.maxIdle"));
			int maxWait = Integer.valueOf(properties.getProperty("dataSource.maxWait"));
			int maxActive = Integer.valueOf(properties.getProperty("dataSource.maxActive"));
			
			BasicDataSource bds = new BasicDataSource();

			bds.setUrl(url);
			bds.setDriverClassName(driverClassName);
			bds.setUsername(username);
			bds.setPassword(password);
			// 同一时间可以从池分配的最多连接数量。设置为0时表示无限制。
			bds.setMaxActive(maxActive);
			// 池里不会被释放的最多空闲连接数量。设置为0时表示无限制。
			bds.setMaxIdle(maxIdle);
			// 在抛出异常之前，池等待连接被回收的最长时间（当没有可用连接时）。设置为-1表示无限等待。
			bds.setMaxWait(maxWait);
			bds.setDefaultAutoCommit(true);
			bds.setDefaultReadOnly(false);
			// testOnBorrow的意思是从数据库连接池中取得连接时，对其的有效性进行检查。
			bds.setTestOnBorrow(true);
			// validationQuery 是用来检查的SQL语句，“select 1”执行较快，是一个不错的检测语句。
			bds.setValidationQuery("select 1");
			// 超过removeAbandonedTimeout时间后，是否进行没用连接（废弃）的回收（默认为false，调整为true)
			bds.setRemoveAbandoned(false);
			bds.setRemoveAbandonedTimeout(31104000);

			dataSource = bds;
		} catch (IOException e) {
			System.out.println("对不起连接数据库失败，请查看您的配置.......");
			e.printStackTrace();
		}
	
	}

	/*****************************************************************
	 * 方法名 : getConnection 
	 * 作者 : 王子豪 
	 * 日期 : 2016-10-25 
	 * 输入参数：无 
	 * 输出参数：数据库连接变量 
	 * 功能描述:获取数据库连接 
	 * 修改历史：
	 ******************************************************************/
	public static Connection getConnection() {
		if (conn == null) {
			if (dataSource == null) {
				initDataSource();
			}
			if (dataSource != null) {
				try {
					conn = dataSource.getConnection();  //从BasicDataSource池中获取连接
				} catch (SQLException e) {
					System.out.println("获取数据库连接失败：" + e);
				}
			}
		}
		return conn;
	}

	/*****************************************************************
	 * 方法名 : closeconn 
	 * 作者 : 王子豪 
	 * 日期 : 2016-10-25 
	 * 输入参数：数据库连接变量 
	 * 输出参数：无 
	 * 功能描述: 释放连接
	 * 修改历史：
	 ******************************************************************/
	public static void closeconn() {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.setAutoCommit(true);
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("关闭数据库连接失败：" + e);
		}
	}
}