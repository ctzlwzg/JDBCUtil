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
			
			//����Connection����
			conn = JDBCUtil.getMysqlConn();
			ps = conn.prepareStatement("select * from teacher4;");
			rs = ps.executeQuery();
			while(rs.next()){
				//��ȡ��ǰ�У�ָ���е�ֵ����ʱ��һ��Ϊint���͵����ݣ��ڶ���ΪString���͵����ݣ������1,2��ʾ��
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
