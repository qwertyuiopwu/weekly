package com.formssi.weekReportTool.system.DB;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {

    public static String base = "";

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceSwitch.get();
    }
}
