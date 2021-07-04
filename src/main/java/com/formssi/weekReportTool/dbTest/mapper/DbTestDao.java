package com.formssi.weekReportTool.dbTest.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.formssi.weekReportTool.dbTest.domain.PersonInfo;

@Mapper
public interface DbTestDao {
	@Select("select * from T_PersonInfo where #{idNo}")
	PersonInfo queryPersonInfoByIdNo(String idNo);
	
	@Select("select * from T_PersonInfo")
	List<PersonInfo> queryPersonInfo();
}
