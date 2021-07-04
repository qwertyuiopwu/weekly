package com.formssi.weekReportTool.holiday.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.formssi.weekReportTool.holiday.domain.Holiday;
import com.formssi.weekReportTool.holiday.service.HolidayService;

@Controller
public class HolidayController {
	
	@Autowired
	private HolidayService holidayService;

	@GetMapping("/holiday")
	public String holiday(Model model) {
		model.addAttribute("welcome", "welcome to holiday");
		model.addAttribute("holiday", holidayService.getHoliday() != null ? holidayService.getHoliday(): new Holiday());
		return "/holiday/holiday";
	}
	
	@PostMapping("/holiday/saveHolidays")
	@ResponseBody
	public String saveHolidays(Holiday holiday, Model model) {
		holidayService.setHolidays(holiday);
		return "";
	}
}
