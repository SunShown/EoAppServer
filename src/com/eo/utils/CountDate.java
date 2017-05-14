package com.eo.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import com.eo.conn.DBConn;

public class CountDate {

	// 变量
	private String breakRecordInnerString = null;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private List<String> breakInnerLists = new ArrayList<String>();
	private List<String> breakOuterLists = new ArrayList<String>();
	private List<String> breakDateBySettingLists = new ArrayList<String>(); // 存放沒有去除法定假期的日期(string類型)
	private List<String> lawHolidayInfoLists = new ArrayList<String>(); // 国家法定假期对应日期(string類型)
	private List<String> totalDateLists = new ArrayList<String>(); // 总共的日期
	private List<String> workDateLists = new ArrayList<String>(); // 所有工作日日期的集合

	/**
	 * 根据给出的休息日(集合)，计算出当前所剩余的日期中的休息日的日期 参数一：休息日集合，List<Integer>
	 */
	private List<String> countBreakDate(List<Integer> dayOfWeekPartialLists) {
		breakDateBySettingLists.clear();
		Calendar mCountCalendar = Calendar.getInstance();

		int dayOfYear = mCountCalendar.get(Calendar.DAY_OF_YEAR); // 当前日期是一年中的第几天
		int dayOfWeek = mCountCalendar.get(Calendar.DAY_OF_WEEK) - 1; // 当前日期是一周中的第几天
		if (dayOfWeek == 0) {
			dayOfWeek = 7;
		}
		System.out.println("周几：" + dayOfWeek);
		int totalDays = mCountCalendar.getActualMaximum(Calendar.DAY_OF_YEAR); // 获取当前年份的天数

		// 计算下一年的天数
		Calendar duplicateCountCalendar = (Calendar) mCountCalendar.clone();
		duplicateCountCalendar.set(Calendar.YEAR,
				mCountCalendar.get(Calendar.YEAR) + 1);
		int duplicateTotalDays = duplicateCountCalendar
				.getActualMaximum(Calendar.DAY_OF_YEAR);
		System.out.println("下一年的总天数：" + duplicateTotalDays);
		int remainDays = totalDays - mCountCalendar.get(Calendar.DAY_OF_YEAR); // 当前一年所剩天数
		System.out.println("当前年份加上下一年剩余天数：" + remainDays);
		mCountCalendar.add(Calendar.DAY_OF_YEAR, 8 - dayOfWeek);
		System.out.println("下周一对应的日期：" + sdf.format(mCountCalendar.getTime()));

		for (int i = 0; i < remainDays; i += 7) {
			for (int j = 0; j < dayOfWeekPartialLists.size(); j++) {
				mCountCalendar.add(Calendar.DAY_OF_YEAR,
						dayOfWeekPartialLists.get(j) - 1 + i);
				breakRecordInnerString = sdf.format(mCountCalendar.getTime());
				breakInnerLists.add(breakRecordInnerString);
				mCountCalendar.add(Calendar.DAY_OF_YEAR,
						-dayOfWeekPartialLists.get(j) + 1 - i);
			}
			breakOuterLists.addAll(breakInnerLists);
		}

		for (int i = 0; i < breakOuterLists.size(); i++) {
			if (!breakDateBySettingLists.contains(breakOuterLists.get(i))) {
				breakDateBySettingLists.add(breakOuterLists.get(i));
			}
		}
		return breakDateBySettingLists;
	}

	/**
	 * 计算出国家法定假期所对应的日期(就是从数据库中拿取法定节假日)
	 * 
	 * @param args
	 */
	private List<String> obtainLawHolidayList() {
		lawHolidayInfoLists.clear();
		Connection connection = DBConn.getConn();
		PreparedStatement pstmt = null;
		ResultSet rsResultSet = null;
		String sql = "SELECT * FROM nationholidaydate";
		try {
			pstmt = connection.prepareStatement(sql);
			rsResultSet = pstmt.executeQuery();
			while (rsResultSet.next()) {
				String lawHolidayDateInfoString = rsResultSet
						.getString("holidayDate");
				lawHolidayInfoLists.add(lawHolidayDateInfoString);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConn.close(connection, pstmt, rsResultSet);
		}

		return lawHolidayInfoLists;
	}

	/**
	 * 计算出所有日期，包括考勤和不考勤的(下周的)
	 * 
	 * @param args
	 */
	private List<String> countTotalDateLists() {
		totalDateLists.clear();
		Calendar myCalendar = Calendar.getInstance();
		int remainDays = myCalendar.getActualMaximum(Calendar.DAY_OF_YEAR)
				- myCalendar.get(Calendar.DAY_OF_YEAR); // 当前一年所剩天数
		int dayOfWeek = myCalendar.get(Calendar.DAY_OF_WEEK) - 1; // 当前日期是一周中的第几天
		if (dayOfWeek == 0) {
			dayOfWeek = 7;
		}
		System.out.println("周几：" + dayOfWeek);
		myCalendar.add(Calendar.DAY_OF_YEAR, 7 - dayOfWeek);
		for (int i = 0; i < remainDays; i++) {
			myCalendar.add(Calendar.DAY_OF_YEAR, 1);
			totalDateLists.add(sdf.format(myCalendar.getTime()));
		}
		return totalDateLists;
	}

	/**
	 * 计算出所有工作日所对应的日期 参数一：休息日集合，List<Integer>
	 * 
	 * @param args
	 */
	public List<String> countWorkDateLists(

	List<Integer> breakDateBySettingParaLists, boolean isAutoLawHoliday) {
		workDateLists.clear();
		System.out.println("一开始初始化后的workDateLists的大小：" + workDateLists.size());
		// if语句用来判断是否按国家法定节假日排休
		if (isAutoLawHoliday) {
			this.countTotalDateLists().removeAll(this.obtainLawHolidayList());
		} else {
			this.countTotalDateLists();
		}
		totalDateLists.removeAll(countBreakDate(breakDateBySettingParaLists));
		workDateLists.addAll(totalDateLists);
		// System.out.println("再次添加后workDateLists的大小："+workDateLists.size());
		// for (int i = 0; i < workDateLists.size(); i++) {
		// System.out.println("workDateLists中的日期："+workDateLists.get(i));
		// }
		return workDateLists;
	}

	public static void main(String[] args) {
		List<Integer> heheIntegers = new ArrayList<Integer>();
		List<String> returnList;
		heheIntegers.add(6);
		heheIntegers.add(7);
		CountDate cd = new CountDate();
		returnList = cd.countWorkDateLists(heheIntegers, true);
		for (int i = 0; i < returnList.size(); i++) {
			System.out.println(returnList.get(i));
		}
	}
}
