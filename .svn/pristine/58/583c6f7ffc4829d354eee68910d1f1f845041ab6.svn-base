package com.formssi.weekReportTool.dbTest.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formssi.weekReportTool.dbTest.domain.PersonInfo;
import com.formssi.weekReportTool.dbTest.mapper.DbTestDao;
import com.formssi.weekReportTool.system.DB.DataSourceAspect;

@Service
public class DbTestService {
	
	@Autowired
	private DbTestDao dbTestDao;

	@Autowired
	private DataSourceAspect dataSourceAspect;
	
	Logger logger = LoggerFactory.getLogger(getClass());

	public void quertyPersonInfo() throws Exception {
		List<PersonInfo> personInfos = dbTestDao.queryPersonInfo();
		if (personInfos.size() == 0) {
			logger.error("错误");
		}else {
			logger.info(personInfos.toString());		
		}

		dataSourceAspect.changeDataSource("梁教亮-0801-0815周报");

		List<PersonInfo> personInfos1 = dbTestDao.queryPersonInfo();
		if (personInfos1.size() == 0) {
			logger.error("错误");
		}else {
			logger.info(personInfos1.toString());
		}
		
//		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");// 这个驱动的地址不要改
//		// Connection
//		// con=DriverManager.getConnection("jdbc:ucanaccess://D:\\Database3.mdb","123456","123456");
//		Connection con = DriverManager.getConnection("jdbc:ucanaccess://D:\\ReportClient2\\梁教亮-0801-0815周报.mdb");
//		Statement stmt = con.createStatement();
//
//		// 查找数据
//		ResultSet rs = stmt.executeQuery("select * from T_PersonInfo");
//
//		while (rs.next()) {
//			System.out.println(rs);
//			System.out.println(rs.getString("person_name"));
////			System.out.println(rs.getString("idNo"));
//		}
//
//		File[] files = org.hsqldb.lib.FileUtil.getDatabaseFileList("D:\\ReportClient2\\梁教亮-0801-0815周报.mdb");
//
//		logger.info(files.toString());

	}
}
