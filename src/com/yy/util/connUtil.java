package com.yy.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

/**   
 * @ClassName:  connUtil   
 * @Description:获取数据库连接对象，关闭数据库连接对象   
 * @author: jingyi
 * @date:   2021年5月11日 上午11:17:08      
 * @Copyright:  
 */
public class connUtil {
	private static ThreadLocal<Connection> threadload=new ThreadLocal<>();
	private static DataSource ds;
	static {//数据源对象加载
		try {
			Properties properties = new Properties();
			InputStream ins=connUtil.class.getResourceAsStream("/mysql.properties");
			properties.load(ins);
			ds=BasicDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//获取数据库连接对象
	public static Connection getConn() throws SQLException{
		Connection conn=threadload.get();
		if(conn==null||conn.isClosed()) {
			conn=ds.getConnection();
			threadload.set(conn);
		}
		return conn;
	}
	
	//关闭数据库连接对象
	public static void closeConn() {
		Connection conn=threadload.get();
		try {
			if(conn!=null&&!conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			threadload.set(conn);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
