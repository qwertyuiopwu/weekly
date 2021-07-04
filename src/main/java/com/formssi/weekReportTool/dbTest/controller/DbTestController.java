package com.formssi.weekReportTool.dbTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.formssi.weekReportTool.dbTest.service.DbTestService;
import com.formssi.weekReportTool.system.DB.DataSourceType;

@Controller
public class DbTestController {
	
	@Autowired
	private DbTestService dbTestService;

	@DataSourceType("梁教亮-0716-0731周报")
	@GetMapping("/123")
	public void getPersonInfo() throws Exception {
		dbTestService.quertyPersonInfo();
	}
	
	@GetMapping("/index")
	public String init(Model model) {
		String welcome = "Welcome to my project!! thank you very much!!!";
		model.addAttribute("welcome", welcome);
		return "index";
	}
}
