package com.eo.conn;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBConn {
	// 存放配置文件
	static Properties prop = new Properties();
	// 对配置文件复制
	static {
		try {

			// InputStream is= new FileInputStream("db.properties");
			// "/":表示src目录下
			InputStream is = DBConn.class.getResourceAsStream("/database.properties");
			prop.load(is);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static String driver = prop.getProperty("dBDriver");
	// 指定连接的数据库
	static String url = prop.getProperty("url");
	static String userName = prop.getProperty("userName");
	static String password = prop.getProperty("passWord");

	// 连接数据库
	public static Connection getConn() {

		try {
			// 加载驱动
			Class.forName(driver);
			// 获取连接；
			try {
				return DriverManager.getConnection(url, userName, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	// 关闭数据库
	public static void close(Connection conn, Statement stat, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
				rs = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (stat != null) {
			try {
				stat.close();
				stat = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close();
				conn = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	// 关闭数据库
		public static void close(Connection conn, Statement stat) {
			
			if (stat != null) {
				try {
					stat.close();
					stat = null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
					conn = null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	
	

	// 关闭数据库
	public static void close(Connection conn, Statement stat1, Statement stat2,
			ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
				rs = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (stat1 != null) {
			try {
				stat1.close();
				stat1 = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (stat2 != null) {
			try {
				stat2.close();
				stat2 = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close();
				conn = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// 关闭数据库
	public static void close(Connection conn, Statement stat1, Statement stat2,
			ResultSet rs1, ResultSet rs2) {
		if (rs1 != null) {
			try {
				rs1.close();
				rs1 = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (rs2 != null) {
			try {
				rs2.close();
				rs2 = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (stat1 != null) {
			try {
				stat1.close();
				stat1 = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (stat2 != null) {
			try {
				stat2.close();
				stat2 = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close();
				conn = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// 关闭数据库
	public static void close(Connection conn, Statement stat1, Statement stat2) {

		if (stat1 != null) {
			try {
				stat1.close();
				stat1 = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (stat2 != null) {
			try {
				stat2.close();
				stat2 = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close();
				conn = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
