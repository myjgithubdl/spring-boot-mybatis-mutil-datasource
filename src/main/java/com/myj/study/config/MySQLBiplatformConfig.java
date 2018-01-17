package com.myj.study.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * MySQL的biplatform库
 * Created by MYJ on 2018/1/17.
 */
@Configuration
@MapperScan(basePackages = {"com.myj.study.dao.mysql","com.myj.study.mapper.mysql"},
        sqlSessionTemplateRef  = "mySQLBiplatformSqlSessionTemplate")
public class MySQLBiplatformConfig {

    /**
     * 将配置文件中以spring.datasource.mysql.biplatform开头的数学转化为一个实体bean
     * @return
     */
    @Bean(name = "mySQLBiDataSourceProp")
    @ConfigurationProperties(prefix = "spring.datasource.mysql.biplatform")
    public DruidDataSourceProperties pgDwDompDataSourceProperties(){
        DruidDataSourceProperties ds = new DruidDataSourceProperties();
        return new DruidDataSourceProperties();

    }

    @Autowired
    @Qualifier("mySQLBiDataSourceProp")
    private DruidDataSourceProperties dataSourceProp;

    @Bean(name = "mySQLBiplatformDataSource")
    @Primary
    public DataSource testDataSource() {
        // return DataSourceBuilder.create().build();
        DruidDataSource dataSource = DruidDataSourceUtil.build(dataSourceProp);
        System.out.println(dataSourceProp.toString());
        System.out.println(dataSource);
        return dataSource;
    }

    @Bean(name = "mySQLBiplatformSqlSessionFactory")
    @Primary
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("mySQLBiplatformDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mysql/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "mySQLBiplatformTransactionManager")
    @Primary
    public DataSourceTransactionManager testTransactionManager(@Qualifier("mySQLBiplatformDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "mySQLBiplatformSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("mySQLBiplatformSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


}
