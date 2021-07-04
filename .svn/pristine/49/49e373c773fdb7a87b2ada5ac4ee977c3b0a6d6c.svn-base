package com.formssi.weekReportTool.projectInfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.formssi.weekReportTool.projectInfo.domain.ProjectInfoBean;

@Mapper
public interface ProjectInfoDao {
	/**
	 * 查询项目信息
	 * @return
	 */
	@Select("SELECT proj_id,proj_name,use_flag,start_date,start_time FROM T_projInfo")
	List<ProjectInfoBean> queryProject();
}