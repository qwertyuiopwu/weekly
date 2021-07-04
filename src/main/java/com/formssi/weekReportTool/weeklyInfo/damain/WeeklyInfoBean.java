package com.formssi.weekReportTool.weeklyInfo.damain;

import lombok.Data;

@Data
public class WeeklyInfoBean {
	private String projId;
	private String projName;
	private String projCode;
	private String idNo;
	private String prosonName;
	private String taskDate;
	private String normalHour;
	private String overtimeHour;
	private String proManager;
	private String startDate;
	private String endDate;
	private String fileName;
	private String selectYearAndMonth;
}
