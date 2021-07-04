package com.formssi.weekReportTool.system.DB;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.system.ApplicationHome;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import com.formssi.weekReportTool.WeekReportToolApplication;

@Component
public class DataSourceMapper {

	private final ResourceLoader resourceLoader;

	public DataSourceMapper(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	public List<DataSource> findAll() throws IOException {
		List<DataSource> dataSourceList = new ArrayList<>();
		ApplicationHome h = new ApplicationHome(WeekReportToolApplication.class);
		File[] dataSourceFiles = h.getSource().getParentFile().getParentFile().listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				return pathname.getName().endsWith(".mdb");
			}
		});
		if (dataSourceFiles != null){
			for (File file : dataSourceFiles) {
				DataSource dataSource = new DataSource();
				dataSource.setId(file.getName().replace(".mdb",""));
				dataSource.setUrl("jdbc:ucanaccess://"+file.getPath());
				dataSourceList.add(dataSource);
			}
			DynamicDataSource.base = dataSourceList.get(1).getId();
		}
		return dataSourceList;
	}
}


