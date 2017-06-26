package wzg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/*
* @author  作者: ctzl
* @date 创建时间：2017年6月25日 上午9:42:49 
* @version 1.0
* 使用Object[]来封装一条记录
* 使用List<Object[]>存储多条记录
*/
public class JdbcDemo {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Object[]> list =new ArrayList<>();
		try {
			//返回Connection对象
			conn = JDBCUtil.getMysqlConn();
			ps = conn.prepareStatement("select * from teacher4;");
			//执行sql语句返回一个结果集对象
			rs = ps.executeQuery();
			while(rs.next()){
				Object[] obj = new Object[2];
				//获取当前行，指定列的值，此时第一列为int类型的数据，第二列为String类型的数据，下面的1,2表示列
				//System.out.println(rs.getInt(1)+"\t"+rs.getString(2));
				//把当前行的值存储到Object数组中
				obj[0] = rs.getObject(1);
				obj[1] = rs.getObject(2);
				//把Object数组添加到List列表中
				list.add(obj);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.close(rs, ps, conn);
		}
		for (Object[] obj : list) {
			//toString()转换为字符串
			System.out.println(obj[0].toString()+"\t"+obj[1]);
		}
	}
}
