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
* @author  作者: ctzl
* @date 创建时间：2017年6月26日 上午8:00:35 
* @version 1.0 
* 使用List<Map>
*/public class JdbcDemo2 {
	
	//使用Map封装一条记录
	public static  void test_1(){
		Connection conn = JDBCUtil.getMysqlConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Map<String, Object> map = new HashMap<>();
		try {
			ps = conn.prepareStatement("select teacher_id,"
					+ "teacher_name,"
					+ "teacher_gender from teacher4 "
					+ "where teacher_id=?");
			ps.setObject(1, 2);
			rs = ps.executeQuery();
			while(rs.next()){
				map.put("teacher_id",rs.getObject(1));
				map.put("teacher_name",rs.getObject(2));
				map.put("teacher_gender",rs.getObject(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.close(rs, ps, conn);
		}
		//遍历map
		for (String key : map.keySet()) {
			System.out.print(key+"-->"+map.get(key)+"\t");
		}
	}

	//使用Map封装多条记录
	public static  void test_2(){
		Connection conn = JDBCUtil.getMysqlConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			ps = conn.prepareStatement("select teacher_id,"
					+ "teacher_name,"
					+ "teacher_gender from teacher4 "
					+ "where teacher_id>?");
			ps.setObject(1, 0);
			rs = ps.executeQuery();
			while(rs.next()){
				Map<String, Object> map = new HashMap<>();
				map.put("teacher_id",rs.getObject(1));
				map.put("teacher_name",rs.getObject(2));
				map.put("teacher_gender",rs.getObject(3));
				list.add(map);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.close(rs, ps, conn);
		}
		//遍历map
		for (Map<String, Object> map : list) {
			for (String key : map.keySet()) {
				System.out.print(key+"-->"+map.get(key)+"\t");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test_1();
		test_2();
	}

}
