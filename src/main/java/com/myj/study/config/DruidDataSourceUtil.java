package com.myj.study.config;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * Created by MYJ on 2018/1/17.
 */
public class DruidDataSourceUtil {

    public static DruidDataSource build(DruidDataSourceProperties dataSourceProp ){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(dataSourceProp.getDriverClass());
        dataSource.setUrl(dataSourceProp.getJdbcUrl());
        dataSource.setUsername(dataSourceProp.getUsername());
        dataSource.setPassword(dataSourceProp.getPassword());
        dataSource.setInitialSize(dataSourceProp.getInitialSize());//10
        dataSource.setMaxActive(dataSourceProp.getMaxActive());//100
        dataSource.setMinIdle(dataSourceProp.getMinIdle());//1
        dataSource.setMaxWait(dataSourceProp.getMaxWait());//60000
        dataSource.setTimeBetweenEvictionRunsMillis(dataSourceProp.getTimeBetweenEvictionRunsMillis());//60000
        dataSource.setMinEvictableIdleTimeMillis(dataSourceProp.getMinEvictableIdleTimeMillis());//300000
        dataSource.setTestWhileIdle(dataSourceProp.isTestWhileIdle());//true
        dataSource.setTestOnBorrow(dataSourceProp.isTestOnBorrow());//false
        dataSource.setTestOnReturn(dataSourceProp.isTestOnReturn());//false
        dataSource.setMaxOpenPreparedStatements(dataSourceProp.getMaxOpenPreparedStatements());//100
        dataSource.setRemoveAbandoned(dataSourceProp.isRemoveAbandoned());//true
        dataSource.setRemoveAbandonedTimeout(dataSourceProp.getRemoveAbandonedTimeout());//180
        dataSource.setLogAbandoned(dataSourceProp.isLogAbandoned());//true
        return dataSource;
    }

}
