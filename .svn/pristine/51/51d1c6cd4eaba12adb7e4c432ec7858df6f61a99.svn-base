package com.formssi.weekReportTool.system.xmlTool;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
/**
 * 获取项目信息
 * @author user
 *
 */
public class Dom4jToXml {
	@SuppressWarnings("rawtypes")
	public static ArrayList<ProInfo> read(){
		SAXReader saxReader = new SAXReader();
		InputStream resourceAsStream =null;
		Document document =null;
		ArrayList<ProInfo> list =null;
		Element foo;
		try {
			resourceAsStream = Dom4jToXml.class.getResourceAsStream("../xml/project.xml");
			document = saxReader.read(resourceAsStream);
			Element rootElement = document.getRootElement();
			list = new ArrayList<>();
			Iterator elementIterator = rootElement.elementIterator("proj");
			while(elementIterator.hasNext()){
				ProInfo proInfo = new ProInfo();
				foo= (Element)elementIterator.next();
				proInfo.setProjId(foo.elementText("proj-id"));
				proInfo.setProjCode(foo.elementText("proj-code"));
				proInfo.setProjName(foo.elementText("proj-name"));
				proInfo.setProjManager(foo.elementText("proj-manager"));
				list.add(proInfo);
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
}
