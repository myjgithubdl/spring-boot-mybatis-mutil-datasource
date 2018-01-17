package com.myj.study.test;

import com.myj.study.dao.mysql.IUserDao;
import com.myj.study.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by MYJ on 2018/1/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserSqlSessionTest {

    @Autowired
    private IUserDao mysqlUserDao;

    @Test
    public void testSave(){
        User user=new User("SqlSession姓名777",25,"080");
        int num=mysqlUserDao.save(user);
        System.out.println(num);
    }

    @Test
    public void testUpdateById(){
        User user=new User(5,"更新后SqlSession姓名3",25,"021");
        int num=mysqlUserDao.updateById(user);
        System.out.println(num);
    }

    @Test
    public void deleteById(){
        int num=mysqlUserDao.deleteById(5);
        System.out.println(num);
    }
    
    @Test
    public void selectById(){
        User user = mysqlUserDao.selectById(6);
        System.out.println(user.toString());
    }

    @Test
    public void queryAll(){
        List<User> listUser = mysqlUserDao.queryAll();
        for(User user : listUser){
            System.out.println(user.toString());

        }
    }

    @Test
    public void queryAllMap(){
        Map<String,Object> param=new HashMap<>();
        param.put("idGt",6);
        List<Map<String, Object>> listUser = mysqlUserDao.queryAllMap(param);
        System.out.println(listUser);
    }

}
