package com.formssi.weekReportTool.system.DB;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
// springboot启动后会执行CommandLineRunner实现类的run方法
public class DataSourceRunner implements CommandLineRunner {

	private static ExecutorService executor = Executors.newFixedThreadPool(1);
    private final DynamicDataSource dynamicDataSource;
    private final DataSourceMapper dataSourceMapper;

    public DataSourceRunner(DynamicDataSource dynamicDataSource, DataSourceMapper tableMapper) {
        this.dynamicDataSource = dynamicDataSource;
        this.dataSourceMapper = tableMapper;
    }

    public boolean dataSourceTask() throws IOException {
        List<DataSource> tables = dataSourceMapper.findAll();
        DataSourceSwitch.setDataSource(tables.stream().map(DataSource::getId).collect(Collectors.toList()));
        Map<Object, Object> dataSourceMap = tables.parallelStream().collect(Collectors.toMap(
        		DataSource::getId, dbManager -> {
                    HikariDataSource hikariDataSource = new HikariDataSource();
                    hikariDataSource.setDriverClassName("net.ucanaccess.jdbc.UcanaccessDriver");
                    hikariDataSource.setJdbcUrl(dbManager.getUrl());
                    hikariDataSource.setMaximumPoolSize(12);
                    hikariDataSource.setConnectionTimeout(60000);
                    hikariDataSource.setMinimumIdle(10);
                    hikariDataSource.setIdleTimeout(500000);
                    hikariDataSource.setMaxLifetime(540000);
                    hikariDataSource.setConnectionTestQuery("SELECT 1 FROM DUAL");

                    return hikariDataSource;
                }
        ));

        dynamicDataSource.setTargetDataSources(dataSourceMap);
        dynamicDataSource.afterPropertiesSet();
        return true;
    }

    @Override
    public void run(String... args) throws Exception {
        executor.submit(this::dataSourceTask).get();
    }
}