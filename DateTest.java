package com.example.streams;

import java.util.Calendar;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		@SuppressWarnings("deprecation")
		Date startDate = new java.util.Date(116,3,1);
		Date endDate = new java.util.Date();
		
		Calendar calendar = Calendar.getInstance();
		Date today = calendar.getTime();
		calendar.set(2016, 3, 1);
		Date backThen = calendar.getTime();
		
		System.out.println("using Date methods");
		System.out.println(startDate);
		System.out.println(endDate);
		System.out.println("using Calendar singleton");
		System.out.println(backThen);
		System.out.println(today);
		
	}

}
