package com.liu.db;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.liu.util.ValueSearch;
import com.liu.xutils.pojo.User;

public class BaseDao {

	// 所有的dao 基于stmt公共的方法

	public int executeUpdate(String sql) {
		int lines = 0;

		// 2. 获得连接对象
		Connection conn = DbPool.getConnection();

		// 3. 获得处理对象
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			// 4. 执行sql executeUpdate(sql);
			lines = stmt.executeUpdate(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbPool.DBClose(conn, stmt, null);
		}
		return lines;
	}

	public int getQueryCountBySql(String sql) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int count = -1;
		try {
			conn = DbPool.getConnection();

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbPool.DBClose(conn, stmt, rs);

		}

		return count;
	}

	public List<Object> queryBySql(String sql, Class clz) {
		List<Object> objList = new ArrayList<Object>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Object obj = null;
		PreparedStatement pstmt = null;
		try {
			// 2. 获得连接对象
			conn = DbPool.getConnection();

			// 3. 获得处理对象
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);
			// 4. 执行sql executeUpdate(sql);

			Field[] fileds = clz.getDeclaredFields();
			Annotation[] a = null;
			ResultSetMetaData rsmd = rs.getMetaData();
			Method[] methods = clz.getDeclaredMethods();
			String v = "";
			String y = "";
			String str1 = "";
			String c = "";
			Timestamp d = null;
			while (rs.next()) {
				obj = clz.newInstance();
				for (Field field : fileds) {
					a = field.getAnnotations();
					String name = field.getName();

					for (Method method : methods) {

						str1 = "set"
								+ field.getName().substring(0, 1).toUpperCase()
								+ field.getName().substring(1);

						if ((method.getName()).equals(str1)) {
							Class z = field.getType();
							String type = field.getType().getName();
							for (Annotation annotation : a) {
								if (ValueSearch.class.equals(annotation
										.annotationType())) {
									v = ((ValueSearch) annotation).value();
									for (int i = 1; i <= rsmd.getColumnCount(); i++) {
										y = rsmd.getColumnName(i);

										if (v.equals(y)) {
											c = "";
											String dbName = rsmd
													.getColumnTypeName(i);

											// System.out.println(dbName);

											if ("DECIMAL"
													.equalsIgnoreCase(dbName)) {
												c = rs.getBigDecimal(i)
														.toString();

											} else if ("BIT"
													.equalsIgnoreCase(dbName)) {
												c = Byte.toString(rs.getByte(i));

											} else if ("INTEGER"
													.equalsIgnoreCase(dbName)) {
												c = String
														.valueOf(rs.getInt(i));

											} else if ("BIGINT".equals(dbName)) {
												c = String.valueOf(rs
														.getLong(i));
											} else if ("BLOB".equals(dbName)) {
												Blob blob = rs.getBlob(i);
												byte[] b = blob.getBytes(0,
														(int) blob.length());
												c = new String(b, "utf-8");

											} else if ("DATETIME"
													.equalsIgnoreCase(dbName)) {

												d = rs.getTimestamp(i);

												method.invoke(obj, d);

											} else if ("VARCHAR"
													.equalsIgnoreCase(dbName)) {
												c = rs.getString(i);

											}
											// System.out.println(y+":"+dbName+":"+c);

											if (c != null && !("".equals(c))) {
												if ("int"
														.equalsIgnoreCase(type)
														|| "java.lang.Integer"
																.equals(type)) {

													method.invoke(obj,
															new Integer(c));
												} else if ("com.liu.xutils.pojo.User"
														.equalsIgnoreCase(type)) {
													method.invoke(
															obj,
															(User) (queryBySql(
																	"select * FROM tuser where tu_id = "
																			+ c,
																	User.class)
																	.get(0)));

												} else if ("java.lang.String"
														.equalsIgnoreCase(type)) {

													method.invoke(obj, c);

												} else if ("java.lang.Long"
														.equals(type)
														|| "long".equals(type)) {
													method.invoke(obj,
															Long.parseLong(c));
												} else if ("double"
														.equalsIgnoreCase(type)) {
													method.invoke(obj,
															new Double(c));
												} else if ("boolean"
														.equalsIgnoreCase(type)
														|| "java.lang.Boolean"
																.equals(type)) {

													if ("1".equalsIgnoreCase(c)) {
														method.invoke(obj, true);
													} else if ("0"
															.equalsIgnoreCase(c)) {
														method.invoke(obj,
																false);
													}
												}

											}

										}
									}
								}

							}

						}

					}

				}

				// emp = new Emp(empId, empName, sex, salary, birthday);
				// emp.setDept(dept);

				// objList.add(emp);
				objList.add(obj);
			}

			// 5. 处理结果集

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbPool.DBClose(conn, stmt, rs);
		}
		return objList;
	}

	public int executeUpdateBypstmt(String sql, Object... params) {

		Connection conn = DbPool.getConnection();
		PreparedStatement pstmt = null;
		int lines = 0;

		try {
			// 使用?进行占位,编译时进行预编译,效率是高的
			pstmt = conn.prepareStatement(sql);
			for (int i = 1; i <= params.length; i++) {
				pstmt.setObject(i, params[i - 1]);
			}

			lines = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbPool.DBClose(conn, pstmt, null);
		}

		return lines;
	}

	public int executeUpdateGetGen(String sql, Object... params) {

		Connection conn = DbPool.getConnection();
		PreparedStatement pstmt = null;
		int lines = 0;
		ResultSet rs = null;

		try {
			// 使用?进行占位,编译时进行预编译,效率是高的
			pstmt = conn.prepareStatement(sql);
			for (int i = 1; i <= params.length; i++) {
				pstmt.setObject(i, params[i - 1]);

			}

			pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				lines = rs.getInt(1);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbPool.DBClose(conn, pstmt, rs);
		}

		return lines;
	}

}
