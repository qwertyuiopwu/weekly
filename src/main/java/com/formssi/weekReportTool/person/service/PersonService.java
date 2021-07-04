package com.formssi.weekReportTool.person.service;

import java.io.File;

import org.springframework.stereotype.Service;

import com.formssi.weekReportTool.person.domain.PersonData;
import com.formssi.weekReportTool.system.util.XStreamUtil;

@Service
public class PersonService {
	
	
	/*
	 * 读取xml读取person数据
	 */
	public PersonData getPerson() {
		PersonData personData = new PersonData();
		personData=(PersonData)XStreamUtil.readFileToXml(personData,
				                                         PersonData.class,"/dataxml/PersonData.xml"); 
	    return personData;		
	}
	
	/*
	  *  删除和新增person数据
	 */
	public Boolean update(PersonData personData) {
		
		String xml = XStreamUtil.beanToXml(PersonData.class, personData);
		Boolean flag = XStreamUtil.writeFile(xml, "/dataxml/PersonData.xml");
		return flag;
	}
	

}
