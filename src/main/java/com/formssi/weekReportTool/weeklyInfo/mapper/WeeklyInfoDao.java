package com.formssi.weekReportTool.weeklyInfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.formssi.weekReportTool.weeklyInfo.damain.WeeklyInfoBean;

@Mapper
public interface WeeklyInfoDao {
	@Select("select p.proj_id as projId,p.proj_name as projName,tp.id_no as idNo,tp.person_name as prosonName,w.task_date as taskDate,sum(w.normal_hour)/8 as normalHour,sum(w.overtime_hour)/7.5 as overtimeHour from t_projInfo p,t_personinfo tp,t_weekreport w where w.task_date >= #{startDate} and w.task_date <= #{endDate}  and w.proj_id=p.proj_id group by w.task_date, p.proj_id,p.proj_name,tp.id_no,tp.person_name")
	public List<WeeklyInfoBean> queryWeekly(@Param("startDate") String startDate,@Param("endDate") String endDate);
}
