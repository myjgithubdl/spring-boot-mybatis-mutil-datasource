package com.myj.study.dao.mysql.impl;

import com.myj.study.dao.mysql.IUserDao;
import com.myj.study.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by MYJ on 2018/1/16.
 */
@Component("mysqlUserDao")
public class UserDaoImpl implements IUserDao {

    private final String NAME_SPACE="com.myj.study.mapper.mysql.UserMapper";

    private final SqlSessionTemplate sqlSession;

    public UserDaoImpl(@Qualifier("mySQLBiplatformSqlSessionTemplate") SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }


    @Override
    public int save(User user) {
        return sqlSession.insert(NAME_SPACE+".save" , user);
    }

    @Override
    public int updateById(User user) {
        return sqlSession.update(NAME_SPACE+".updateById" , user);
    }

    @Override
    public int deleteById(Integer id) {
        return sqlSession.delete(NAME_SPACE+".deleteById" , id);
    }

    @Override
    public User selectById(Integer id) {
        return sqlSession.selectOne(NAME_SPACE+".selectById" , id);
    }

    @Override
    public List<User> queryAll() {
        return sqlSession.selectList(NAME_SPACE+".queryAll" );
    }

    @Override
    public List<Map<String, Object>> queryAllMap(Map<String, Object> param) {
        return sqlSession.selectList(NAME_SPACE+".queryAllMap" , param );
    }
}
