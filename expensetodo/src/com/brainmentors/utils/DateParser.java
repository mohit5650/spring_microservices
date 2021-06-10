package com.brainmentors.utils;

import java.util.Calendar;
import java.util.Date;

public class DateParser {

	public static Date parse(String date){
			String dateArray[] = date.split("-");
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.MONTH, (Integer.parseInt(dateArray[1])-1));
			calendar.set(Calendar.YEAR, Integer.parseInt(dateArray[0]));
			calendar.set(Calendar.DATE, Integer.parseInt(dateArray[2]));
			return calendar.getTime();
	}
	public static void main(String[] args) {
		System.out.println(parse("2021-01-19"));
	}
}
