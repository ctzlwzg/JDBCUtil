package wzg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* @author  ����: ctzl
* @date ����ʱ�䣺2017��6��26�� ����9:11:19 
* @version 1.0 
* ʹ��Javabean��������װһ����¼
* ʹ��LIst<Javabean>�洢������¼
*/public class JdbcDemo3 {

	private static void test1() {
		Connection conn = JDBCUtil.getMysqlConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Teacher4 teacher4 = null;
		try {
			ps = conn.prepareStatement("select teacher_id,"
					+ "teacher_name,"
					+ "teacher_gender from teacher4 "
					+ "where teacher_id=?");
			ps.setObject(1, 1);
			rs = ps.executeQuery();
			while(rs.next()){
				teacher4 = new Teacher4(rs.getInt(1),rs.getString(2),rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.close(rs, ps, conn);
		}
		System.out.println(teacher4.getTeacher_id()+"\t"+
				teacher4.getTeaacher_name()+"\t"+
				teacher4.getTeacher_gender());
	}

	private static void test2() {
		Connection conn = JDBCUtil.getMysqlConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Teacher4> list = new ArrayList<>();
		try {
			ps = conn.prepareStatement("select teacher_id,"
					+ "teacher_name,"
					+ "teacher_gender from teacher4 "
					+ "where teacher_id>?");
			ps.setObject(1,0);
			rs = ps.executeQuery();
			while(rs.next()){
				Teacher4 teacher4 = new Teacher4(rs.getInt(1),rs.getString(2),rs.getString(3));
				list.add(teacher4);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.close(rs, ps, conn);
		}
		for (Teacher4 teacher4 : list) {
			System.out.println(teacher4.getTeacher_id()+"\t"+
					teacher4.getTeaacher_name()+"\t"+
					teacher4.getTeacher_gender());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test1();
		test2();
	}
}
