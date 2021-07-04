package com.formssi.weekReportTool.weeklyInfo.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.formssi.weekReportTool.holiday.domain.Holiday;
import com.formssi.weekReportTool.holiday.service.HolidayService;
import com.formssi.weekReportTool.projectInfo.service.ProjectInfoService;
import com.formssi.weekReportTool.system.excelTool.HuToolExcelUtil;
import com.formssi.weekReportTool.weeklyInfo.damain.PersonWeekly;
import com.formssi.weekReportTool.weeklyInfo.damain.WeeklyInfoBean;
import com.formssi.weekReportTool.weeklyInfo.service.WeeklyInfoService;

@Controller
@RequestMapping("weeklyInfo/")
public class WeeklyInfoController {
	
	@Autowired
	private WeeklyInfoService weeklyInfoService;
	@Autowired
	private HolidayService holidayService;
	@Autowired
	private ProjectInfoService projectInfoService;
	
	@GetMapping("weeklyExcel")
	public String perPerson(Model model,WeeklyInfoBean bean) {
		model.addAttribute("dateBean", bean);
		model.addAttribute("bean", weeklyInfoService.findFilesName());
		return "weeklyInfo/weeklyExcel";
	}
	
	@PostMapping("fileExcel")
	public void fileExcel(HttpServletResponse response,WeeklyInfoBean bean) {
		HuToolExcelUtil.downLoadFile(response,projectInfoService.getProCode(bean,weeklyInfoService.queryWeekly(bean)),bean.getFileName());
	}
}
