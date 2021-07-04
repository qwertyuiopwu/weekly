package com.formssi.weekReportTool.system.DB;

import java.util.List;

public class DataSourceSwitch {

    private static final ThreadLocal<String> DATA_SOURCE = ThreadLocal.withInitial(() -> DynamicDataSource.base);

    private static List<String> dataSourceIds;

    public static void set(String type) {
        DATA_SOURCE.set(type);
    }

    public static String get() {
        return DATA_SOURCE.get();
    }

    public static void reset() {
        // 重设默认值 或清除数据都可以(因为已设置默认数据源)
        // DATA_SOURCE.set(DynamicDataSource.base);
        DATA_SOURCE.remove();
    }

    public static boolean isExist(String dataSourceId) {
        return DataSourceSwitch.dataSourceIds.contains(dataSourceId);
    }

    public static void setDataSource(List<String> dataSourceIds) {
        DataSourceSwitch.dataSourceIds = dataSourceIds;
    }
}
