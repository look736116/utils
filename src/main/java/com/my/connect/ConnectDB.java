package com.my.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
/**
 * 一个非常标准的连接Mysql数据库的示例代码
 */
public class ConnectDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;// 创建一个数据库连接
		PreparedStatement pre = null;// 创建预编译语句对象，一般都是用这个而不用Statement
		ResultSet result = null;// 创建一个结果集对象
		ResultSetMetaData metaData = null;//创建一个表头信息对象
		try {
			// 加载Mysql驱动程序  ，oracle的： Class.forName("oracle.jdbc.driver.OracleDriver");
			//不知道可以打出Driver 看导入包的提示
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/studata";//localhost 为本级地址，studata为数据库名
			String userName = "root";
			String password = "root";
			con = DriverManager.getConnection(url, userName, password);// 获取连接
			
			System.out.println("数据库连接成功！");
			
			String sql = "select * from studata s where s.stuNo = ?";//预编译语句，?代表参数
			pre = con.prepareStatement(sql);// 实例化预编译语句
			pre.setInt(1, 10000);;// 设置参数，前面的1表示参数的索引，而不是表中列名的索引
			result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
			metaData  = result.getMetaData();//获取表头信息
			while (result.next()) {
				 // 当结果集不为空时
				System.out.println(metaData.getColumnName(1) + "  " + metaData.getColumnName(2));

				System.out.println(result.getString("stuNo") + "  " + result.getString("stuName"));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 逐一将上面的几个对象关闭，因为不关闭的话会影响性能、并且占用资源
			// 注意关闭的顺序，最后使用的最先关闭
			if (result != null)
				try {
					result.close();
					if (pre != null)
						pre.close();
					if (con != null)
						con.close();
					System.out.println("数据库连接已关闭！");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		}

	}

}
