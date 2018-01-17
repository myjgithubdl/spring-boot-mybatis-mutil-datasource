package com.myj.study.dao.postgresql.impl;

import com.myj.study.dao.postgresql.ICityDao;
import com.myj.study.entity.City;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by MYJ on 2018/1/16.
 */
@Component("cityDao")
public class CityDaoImpl implements ICityDao {

    private final String NAME_SPACE="com.myj.study.mapper.postgresql.CityMapper";


    private final SqlSessionTemplate sqlSession;

    public CityDaoImpl(@Qualifier("pgDwDompSqlSessionTemplate") SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }


    @Override
    public int save(City city) {
        return sqlSession.insert(NAME_SPACE+".save" , city);
    }

    @Override
    public int updateById(City city) {
        return sqlSession.update(NAME_SPACE+".updateById" , city);
    }

    @Override
    public int deleteById(Integer id) {
        return sqlSession.delete(NAME_SPACE+".deleteById" , id);
    }

    @Override
    public City selectById(Integer id) {
        return sqlSession.selectOne(NAME_SPACE+".selectById" , id);
    }

    @Override
    public List<City> queryAll() {
        return sqlSession.selectList(NAME_SPACE+".queryAll" );
    }

    @Override
    public List<Map<String, Object>> queryAllMap(Map<String, Object> param) {
        return sqlSession.selectList(NAME_SPACE+".queryAllMap" , param );
    }
}
