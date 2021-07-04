package com.formssi.weekReportTool.weeklyInfo.service;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formssi.weekReportTool.system.DB.DataSourceAspect;
import com.formssi.weekReportTool.weeklyInfo.damain.WeeklyInfoBean;
import com.formssi.weekReportTool.weeklyInfo.mapper.WeeklyInfoDao;

@Service
public class WeeklyInfoService {
	@Autowired
	private WeeklyInfoDao weeklyInfoDao;

	@Autowired
	private DataSourceAspect dataSourceAspect;

	private String baseDirName = "D:/FPMSX03/weekReportTool";

	@SuppressWarnings("null")
	public List<WeeklyInfoBean> queryWeekly(WeeklyInfoBean bean) {
		List<WeeklyInfoBean> list = new ArrayList<>();
		if (bean.getFileName() != null && ("").equals(bean.getFileName())) {
			list = findFiles(bean);
		} else {
			dataSourceAspect.changeDataSource(bean.getFileName());
			List<WeeklyInfoBean> queryWeekly = weeklyInfoDao.queryWeekly(bean.getStartDate(), bean.getEndDate());
			for (WeeklyInfoBean j : queryWeekly) {
				list.add(j);
			}
		}
		return list;
	};

	public List<WeeklyInfoBean> findFilesName() {
		List<WeeklyInfoBean> list = new ArrayList<>();
		File baseDir = new File(baseDirName); // 创建一个File对象
		if (!baseDir.exists() || !baseDir.isDirectory()) { // 判断目录是否存在
			System.out.println("文件查找失败：" + baseDirName + "不是一个目录！");
		}
		// 获取指定文件夹下所有后缀为.mdb文件
		File[] files = baseDir.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				// TODO Auto-generated method stub
				return pathname.getName().endsWith(".mdb");
			}
		});
		if (files.length == 0) {// 该文件夹下没有文件，为空文件夹
			System.out.println("为空文件夹");
			return null;
		} else {
			for (File i : files) {
				WeeklyInfoBean bean = new WeeklyInfoBean();
				bean.setFileName(i.getName().substring(0, i.getName().indexOf(".")));
				list.add(bean);
			}
		}
		return list;
	}

	public List<WeeklyInfoBean> findFiles(WeeklyInfoBean bean) {
		List<WeeklyInfoBean> list=new ArrayList<>();
		List<WeeklyInfoBean> findFilesName = findFilesName();
		for(WeeklyInfoBean i:findFilesName){
			dataSourceAspect.changeDataSource(i.getFileName());
			List<WeeklyInfoBean> queryWeekly = weeklyInfoDao.queryWeekly(bean.getStartDate(), bean.getEndDate());
			for (WeeklyInfoBean j : queryWeekly) {
				list.add(j);
			}
		}
		return list;
	}

}
