package com.formssi.weekReportTool.holiday.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formssi.weekReportTool.holiday.config.HolidayConfig;
import com.formssi.weekReportTool.holiday.domain.Holiday;

@Service
public class HolidayService {
	
	@Autowired
	private HolidayConfig holidayConfig;
	
	public void setHolidays(Holiday holiday) {
		holidayConfig.setHoliday(holiday);
	}
	
	public Holiday getHoliday() {
		return holidayConfig.getHoliday();
	}

}
