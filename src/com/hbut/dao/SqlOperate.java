/*****************************************************************
* 文件名  :  SqlOperate.java
* 作者    :  王子豪
* 版权    :  西红柿科技（武汉）有限公司
* 日期    :  2016-08-22
* 修改历史：
* 描述     : 执行sql语句的操作方法
******************************************************************/
package com.hbut.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
//import com.zsglj.admin.actions.news.NewsOperation;
import com.hbut.util.ConnectSQL;

/*****************************************************************
* 类名    :  SqlOperate
* 修改历史：
* 功能描述: 集合了操作sql语句的方法
******************************************************************/
public class SqlOperate {
	private static Connection conn;

	/*****************************************************************
	* 方法名  :  executeData
	* 输入参数：strSQL:需要执行的数据库语句
	* 输出参数：flag,操作成功返回1，操作失败返回0.
	* 功能描述: 无数据请求的数据库操作
	* 修改历史：
	******************************************************************/
	public int executeData(String strSQL) {
		
		int flag = 0;
		if (conn != null) {
			try {
				PreparedStatement ps = conn.prepareStatement(strSQL);// 传递SQL语句
				flag = ps.executeUpdate();// 执行SQL语句
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

	/*****************************************************************
	* 方法名  :  queryDataReturnStr
	* 输入参数：strSQL:需要执行的数据库语句
	* 输出参数：str,返回查询到的数据
	* 功能描述: 请求查询数据库中的一条数据
	* 修改历史：
	******************************************************************/
	public String queryDataReturnStr(String strSQL) {
		String str=null;
		if (conn != null) {
			try {
				PreparedStatement ps = conn.prepareStatement(strSQL);// 传递SQL语句
				ResultSet result = ps.executeQuery();// 执行查询操作，返回ResultSet类型结果
				ResultSetMetaData metaData = (ResultSetMetaData) result
						.getMetaData();
				while (result.next()) {
					for (int i = 1; i <= metaData.getColumnCount(); i++) {
						String col_name = metaData.getColumnName(i);
						Object col_value = result.getObject(col_name);
						if (col_value == null) {
							col_value = "";
						}
						str = col_value.toString();
					}
				}
//				System.out.println("请求查询数据库中的一条数据:"+str);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return str;
	}
	/**
	 * 从数据库中去出一条完整记录存放在数组中
	 *
	 * @return String类型的数组
	 */
	/*public ArrayList<String> queryDataReturnString(String strSQL) {
		//String str=null;
		ArrayList<String> stringArry=null;
		if (conn != null) {
			try {
				PreparedStatement ps = conn.prepareStatement(strSQL);// 传递SQL语句
				ResultSet result = ps.executeQuery();// 执行查询操作，返回ResultSet类型结果
				ResultSetMetaData metaData = (ResultSetMetaData) result
						.getMetaData();
				//int columncount=metaData.getColumnCount();
				stringArry = new ArrayList<String>(); 
				while (result.next()) {
					for (int i = 1; i <= metaData.getColumnCount(); i++) {
						String col_name = metaData.getColumnName(i);
						String col_value=result.getString(i);
						if(col_value==""||col_value==null){
							col_value="无";
						}
						stringArry.add(col_value);
						}
					
					}
				
				//System.out.println(str);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return stringArry;
	}*/
	/*****************************************************************
	* 方法名  :  queryDataReturnRS
	* 输入参数：strSQL:需要执行的数据库语句
	* 输出参数：ResultSet,返回查询到的数据集合
	* 功能描述: 请求查询数据库中的多条数据
	* 修改历史：
	******************************************************************/
	public ResultSet queryDataReturnRS(String strSQL) {
		ResultSet result = null;
		if (conn != null) {
			try {
				PreparedStatement ps = conn.prepareStatement(strSQL);// 传递SQL语句
				result = ps.executeQuery();// 执行查询操作，返回ResultSet类型结果
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/*****************************************************************
	* 方法名  :  login
	* 输入参数：无
	* 输出参数：boolean,返回true获取数据库连接成功，返回false则失败
	* 功能描述: 获取数据库连接的全局变量
	* 修改历史：
	******************************************************************/
	public boolean login() {
		boolean flag = false;
		conn = ConnectSQL.getConnection();
		if (conn != null) {
			flag = true;
		} else {
			flag = false;
			System.err.println("数据库连接失败！");
		}
		return flag;
	}
}
