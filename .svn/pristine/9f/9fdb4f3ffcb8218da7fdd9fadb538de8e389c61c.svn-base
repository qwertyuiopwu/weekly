package com.formssi.weekReportTool.system.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;

public class XStreamUtil {
	
	private static final String XMLHEAD="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
	private static final String FILEPATH="src/main/java/com/formssi/weekReportTool/system/";
	
	public static XStream xStream(Class<?> clazz) {
		//处理XStream会出现双下划线的bug
		XStream xstream= new XStream(new DomDriver("UTF-8",new XmlFriendlyNameCoder("-_","_")));
		//根据注解处理映射关系
		xstream.processAnnotations(clazz);
		//自动检测注解
		xstream.autodetectAnnotations(true);
		XStream.setupDefaultSecurity(xstream);
		xstream.allowTypesByWildcard(new String[]{"com.formssi.weekReportTool.**"});//xstream的安全检查
		return xstream;
	}
	
	public static Object xmlToBean(Class<?> clazz,String xml) {
		Object bean=null;
		bean=XStreamUtil.xStream(clazz).fromXML(xml);
		return bean;
	}
	
	public static String beanToXml(Class<?> clazz,Object obj) {
		String xml="";
		xml=XStreamUtil.xStream(clazz).toXML(obj);
		return xml;
	}

	
	public static Object readFileToXml(Class<?> clazz,String filePath) {
		Object bean="";
		try(FileInputStream fis= new FileInputStream(filePath)) {
			bean=XStreamUtil.xStream(clazz).fromXML(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bean;
	}
	
	public static Object readFileToXml(Object obj,Class<?> clazz,String path) {
		String filePath=FILEPATH+path;
		/* System.out.println(filePath); */
		try(FileInputStream fis = new FileInputStream(filePath)) {		
			XStreamUtil.xStream(clazz).fromXML(fis,obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
	
	public static Boolean writeFile(String xml,String path) {
		String filePath=FILEPATH+path;	
		Boolean flag=false;
		File file =new File(filePath);
		try(FileOutputStream fos = new FileOutputStream(file);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos))) {			
			bw.write(XMLHEAD+xml);
			flag=true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
}
