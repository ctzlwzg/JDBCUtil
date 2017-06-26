package wzg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/*
* @author  ����: ctzl
* @date ����ʱ�䣺2017��6��25�� ����9:42:49 
* @version 1.0
* ʹ��Object[]����װһ����¼
* ʹ��List<Object[]>�洢������¼
*/
public class JdbcDemo {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Object[]> list =new ArrayList<>();
		try {
			//����Connection����
			conn = JDBCUtil.getMysqlConn();
			ps = conn.prepareStatement("select * from teacher4;");
			//ִ��sql��䷵��һ�����������
			rs = ps.executeQuery();
			while(rs.next()){
				Object[] obj = new Object[2];
				//��ȡ��ǰ�У�ָ���е�ֵ����ʱ��һ��Ϊint���͵����ݣ��ڶ���ΪString���͵����ݣ������1,2��ʾ��
				//System.out.println(rs.getInt(1)+"\t"+rs.getString(2));
				//�ѵ�ǰ�е�ֵ�洢��Object������
				obj[0] = rs.getObject(1);
				obj[1] = rs.getObject(2);
				//��Object������ӵ�List�б���
				list.add(obj);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.close(rs, ps, conn);
		}
		for (Object[] obj : list) {
			//toString()ת��Ϊ�ַ���
			System.out.println(obj[0].toString()+"\t"+obj[1]);
		}
	}
}
