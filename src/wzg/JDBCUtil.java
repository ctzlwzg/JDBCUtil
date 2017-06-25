package wzg;
/*
* @author  ����: ctzl
* @date ����ʱ�䣺2017��6��25�� ����9:42:49 
* @version 1.0
* JDBC�ķ�װ������������Դ�͹ر���Դ�ļ� 
*/

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {
	
	static Properties pros = null;
	
	//��̬����飬����JDBCUtil���ʱ����ã�ֻ�����һ��
	static{
		pros = new Properties();
		//�����ļ�����������
		ClassLoader classLoader = JDBCUtil.class.getClassLoader();
		InputStream is = classLoader.getResourceAsStream("db.properties");
		try {
			pros.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//������Դ�ļ�
	public static Connection getMysqlConn(){
		try {
			Class.forName(pros.getProperty("driver"));
			return DriverManager.getConnection(pros.getProperty("url"),
					pros.getProperty("user"), 
					pros.getProperty("password"));
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	//�ر���Դ�ļ�
	public static void close(ResultSet rs,PreparedStatement ps,Connection conn){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void close(PreparedStatement ps,Connection conn){
		if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void close(Connection conn){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
