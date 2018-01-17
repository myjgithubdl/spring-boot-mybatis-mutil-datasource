package com.myj.study.config;


import lombok.ToString;

/**
 * Druid 数据库连接池的属性
 * Created by MYJ on 2018/1/17.
 */
public class DruidDataSourceProperties {

    /**
     * 数据库驱动类
     */
    private volatile String driverClass;

    /**
     * 数据库用户名
     */
    private volatile String username;

    /**
     * 数据库密码
     */
    private volatile String password;

    /**
     *数据库连接url
     */
    private volatile String jdbcUrl;

    /**
     * 初始化时建立物理连接的个数。初始化发生在显示调用init方法，或者第一次getConnection时
     */
    private volatile int initialSize;

    /**
     *最大连接数量
     */
    private volatile int maxActive;

    /**
     *最小连接数量
     */
    private volatile int minIdle;

    /**
     *获取连接时最大等待时间，单位毫秒。配置了maxWait之后，缺省启用公平锁，并发效率会有所下降，
     * 如果需要可以通过配置useUnfairLock属性为true使用非公平锁。
     */
    private volatile long maxWait;

    private volatile long timeBetweenEvictionRunsMillis;

    private volatile long minEvictableIdleTimeMillis;

    private volatile boolean testWhileIdle;

    private volatile boolean testOnBorrow;

    private volatile boolean testOnReturn;

    //要启用PSCache，必须配置大于0，当大于0时，poolPreparedStatements自动触发修改为true。在Druid中，不会存在Oracle下PSCache占用内存过多的问题，可以把这个数值配置大一些，比如说100
    private volatile int maxOpenPreparedStatements;

    private volatile boolean removeAbandoned;

    private volatile int removeAbandonedTimeout;

    private volatile boolean logAbandoned;


    public String getDriverClass() {
        return driverClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public int getInitialSize() {
        return initialSize < 1 ? 10 : initialSize;
    }

    public void setInitialSize(int initialSize) {
        this.initialSize = initialSize;
    }

    public int getMaxActive() {
        return maxActive < 1 ? 100 : maxActive;
    }

    public void setMaxActive(int maxActive) {
        this.maxActive = maxActive;
    }

    public int getMinIdle() {
        return minIdle < 1 ? 1 : minIdle;
    }

    public void setMinIdle(int minIdle) {
        this.minIdle = minIdle;
    }

    public long getMaxWait() {
        return maxWait < 1 ? 60000 : maxWait;
    }

    public void setMaxWait(long maxWait) {
        this.maxWait = maxWait;
    }

    public long getTimeBetweenEvictionRunsMillis() {
        return timeBetweenEvictionRunsMillis < 1 ? 60000 : timeBetweenEvictionRunsMillis;
    }

    public void setTimeBetweenEvictionRunsMillis(long timeBetweenEvictionRunsMillis) {
        this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
    }

    public long getMinEvictableIdleTimeMillis() {
        return minEvictableIdleTimeMillis <1 ? 300000 : minEvictableIdleTimeMillis;
    }

    public void setMinEvictableIdleTimeMillis(long minEvictableIdleTimeMillis) {
        this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
    }

    public boolean isTestWhileIdle() {
        return testWhileIdle;
    }

    public void setTestWhileIdle(boolean testWhileIdle) {
        this.testWhileIdle = testWhileIdle;
    }

    public boolean isTestOnBorrow() {
        return testOnBorrow;
    }

    public void setTestOnBorrow(boolean testOnBorrow) {
        this.testOnBorrow = testOnBorrow;
    }

    public boolean isTestOnReturn() {
        return testOnReturn;
    }

    public void setTestOnReturn(boolean testOnReturn) {
        this.testOnReturn = testOnReturn;
    }

    public int getMaxOpenPreparedStatements() {
        return maxOpenPreparedStatements <1 ? 100 : maxOpenPreparedStatements ;
    }

    public void setMaxOpenPreparedStatements(int maxOpenPreparedStatements) {
        this.maxOpenPreparedStatements = maxOpenPreparedStatements;
    }

    public boolean isRemoveAbandoned() {
        return removeAbandoned;
    }

    public void setRemoveAbandoned(boolean removeAbandoned) {
        this.removeAbandoned = removeAbandoned;
    }

    public int getRemoveAbandonedTimeout() {
        return removeAbandonedTimeout < 1 ? 180 : removeAbandonedTimeout;
    }

    public void setRemoveAbandonedTimeout(int removeAbandonedTimeout) {
        this.removeAbandonedTimeout = removeAbandonedTimeout;
    }

    public boolean isLogAbandoned() {
        return logAbandoned;
    }

    public void setLogAbandoned(boolean logAbandoned) {
        this.logAbandoned = logAbandoned;
    }


    @Override
    public String toString() {
        return "DruidDataSourceProperties{" +
                "driverClass='" + driverClass + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", jdbcUrl='" + jdbcUrl + '\'' +
                ", initialSize=" + initialSize +
                ", maxActive=" + maxActive +
                ", minIdle=" + minIdle +
                ", maxWait=" + maxWait +
                ", timeBetweenEvictionRunsMillis=" + timeBetweenEvictionRunsMillis +
                ", minEvictableIdleTimeMillis=" + minEvictableIdleTimeMillis +
                ", testWhileIdle=" + testWhileIdle +
                ", testOnBorrow=" + testOnBorrow +
                ", testOnReturn=" + testOnReturn +
                ", maxOpenPreparedStatements=" + maxOpenPreparedStatements +
                ", removeAbandoned=" + removeAbandoned +
                ", removeAbandonedTimeout=" + removeAbandonedTimeout +
                ", logAbandoned=" + logAbandoned +
                '}';
    }
}
