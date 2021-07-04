package com.formssi.weekReportTool.projectInfo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formssi.weekReportTool.projectInfo.domain.ProjectInfoBean;
import com.formssi.weekReportTool.projectInfo.mapper.ProjectInfoDao;
import com.formssi.weekReportTool.system.xmlTool.Dom4jToXml;
import com.formssi.weekReportTool.system.xmlTool.ProInfo;
import com.formssi.weekReportTool.weeklyInfo.damain.PersonWeekly;
import com.formssi.weekReportTool.weeklyInfo.damain.WeeklyInfoBean;
import com.formssi.weekReportTool.weeklyInfo.mapper.WeeklyInfoDao;

@Service
public class ProjectInfoService {
	@Autowired
	private ProjectInfoDao projectInfoDao;
	@Autowired
	private WeeklyInfoDao weeklyInfoDao;
	/**
	 * 查询项目信息
	 * @return
	 */
	public List<ProjectInfoBean> queryProject(){
		return projectInfoDao.queryProject();
	}
	
	/**
	 * 获取项目编码
	 * @return
	 */
	public List<PersonWeekly> getProCode(WeeklyInfoBean bean,List<WeeklyInfoBean> queryWeekly){
		ArrayList<PersonWeekly> arrayList = new ArrayList<>();
		List<ProInfo> read = Dom4jToXml.read();
		for(WeeklyInfoBean i:queryWeekly){
			for(ProInfo j:read){
				if(j.getProjId() == null || ("").equals(j.getProjId())){
					return null;
				}
				if(j.getProjName() == null || ("").equals(j.getProjName())){
					return null;
				}
				if(i.getProjId().contains(j.getProjId())){
					PersonWeekly personWeekly = new PersonWeekly();
					personWeekly.setProjCode(j.getProjCode());
					personWeekly.setProjName(i.getProjName());
					personWeekly.setIdNo(i.getIdNo());
					personWeekly.setProsonName(i.getProsonName());
					personWeekly.setTaskDate(i.getTaskDate());;
					personWeekly.setProManager(j.getProjManager());
					personWeekly.setNormalHour(i.getNormalHour());
					personWeekly.setOvertimeHour(i.getOvertimeHour());
					arrayList.add(personWeekly);
				}
			}
		}
		return arrayList;
		
	}
}
