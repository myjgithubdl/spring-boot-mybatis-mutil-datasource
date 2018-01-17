package com.myj.study.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
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
@MapperScan(basePackages = {"com.myj.study.dao.postgresql","com.myj.study.mapper.postgresql"},
        sqlSessionTemplateRef  = "pgDwDompSqlSessionTemplate")
public class PGDwDompConfig {

    /**
     * 将配置文件中以spring.datasource.postgresql.dw.domp开头的数学转化为一个实体bean
     * @return
     */
    @Bean(name = "pgDwDompDataSourceProp")
    @ConfigurationProperties(prefix = "spring.datasource.postgresql.dw.domp")
    public DruidDataSourceProperties pgDwDompDataSourceProperties(){
        DruidDataSourceProperties ds = new DruidDataSourceProperties();
        return ds;

    }

    @Autowired
    @Qualifier("pgDwDompDataSourceProp")
    private DruidDataSourceProperties dataSourceProp;

    @Bean(name = "pgDwDompDataSource")
    public DataSource testDataSource() {
        //return DataSourceBuilder.create().build();
        DruidDataSource dataSource = DruidDataSourceUtil.build(dataSourceProp);
        System.out.println(dataSourceProp.toString());
        System.out.println(dataSource);
        return dataSource;
    }

    @Bean(name = "pgDwDompSqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("pgDwDompDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/postgresql/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "pgDwDompTransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("pgDwDompDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "pgDwDompSqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("pgDwDompSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


}
