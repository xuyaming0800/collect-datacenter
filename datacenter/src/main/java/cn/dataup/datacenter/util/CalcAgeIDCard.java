package cn.dataup.datacenter.util;

import java.util.Calendar;

public class CalcAgeIDCard {
	public static int getAge(String iDCardNum) {
		int year, month, day, idLength = iDCardNum.length();
		Calendar cal1 = Calendar.getInstance();
		Calendar today = Calendar.getInstance();
		if (idLength == 18) {
			year = Integer.parseInt(iDCardNum.substring(6, 10));
			month = Integer.parseInt(iDCardNum.substring(10, 12));
			day = Integer.parseInt(iDCardNum.substring(12, 14));
		} else if (idLength == 15) {
			year = Integer.parseInt(iDCardNum.substring(6, 8)) + 1900;
			month = Integer.parseInt(iDCardNum.substring(8, 10));
			day = Integer.parseInt(iDCardNum.substring(10, 12));
		} else {
			System.out.println("This ID card number is invalid!");
			return -1;
		}
		cal1.set(year, month, day);
		return getYearDiff(today, cal1);
	}

	private static int getYearDiff(Calendar cal, Calendar cal1) {
		int m = (cal.get(cal.MONTH)) - (cal1.get(cal1.MONTH));
		int y = (cal.get(cal.YEAR)) - (cal1.get(cal1.YEAR));
		return (y * 12 + m) / 12;
	}
	public static void main(String[] args) {
		System.out.println(getAge("220283198505246524"));
	}

}
