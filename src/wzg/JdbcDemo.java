package wzg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcDemo {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			//返回Connection对象
			conn = JDBCUtil.getMysqlConn();
			ps = conn.prepareStatement("select * from teacher4;");
			rs = ps.executeQuery();
			while(rs.next()){
				//获取当前行，指定列的值，此时第一列为int类型的数据，第二列为String类型的数据，下面的1,2表示列
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.close(rs, ps, conn);
		}	
	}
}
