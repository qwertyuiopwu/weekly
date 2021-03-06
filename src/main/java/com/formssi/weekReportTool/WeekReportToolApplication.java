package com.formssi.weekReportTool;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan({"com.formssi.*.*.mapper"})
public class WeekReportToolApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeekReportToolApplication.class, args);
	}

}
