package com.formssi.weekReportTool.system.DB;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Aspect
public class DataSourceAspect {

	@Before("@annotation(type)")
    public void changeDataSource(DataSourceType type) {
        String dataSourceId = type.value();
        if (DataSourceSwitch.isExist(dataSourceId)) {
            DataSourceSwitch.set(dataSourceId);
            log.info("\033[36m数据源已切换[" + dataSourceId + "] - \033[m");
        } else {
            log.info("\033[31m数据源不存在[" + dataSourceId + "] - \033[m");
        }
    }

    public void changeDataSource(String dataSourceId) {
        if (DataSourceSwitch.isExist(dataSourceId)) {
            DataSourceSwitch.set(dataSourceId);
            log.info("\033[36m数据源已切换[" + dataSourceId + "] - \033[m");
        } else {
            log.info("\033[31m数据源不存在[" + dataSourceId + "] - \033[m");
        }
    }

	@After("@annotation(type)")
    public void reset(DataSourceType type) {
        DataSourceSwitch.reset();
        log.info("\033[34m数据源已还原[" + DynamicDataSource.base + "] - \033[m");
    }
}