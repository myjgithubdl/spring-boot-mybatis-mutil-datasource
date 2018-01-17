package com.myj.study.test;

import com.myj.study.dao.postgresql.ICityDao;
import com.myj.study.entity.City;
import com.myj.study.mapper.postgresql.CityMapper;
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
public class CitySqlSessionTest {

    @Autowired
    private ICityDao cityDao;

    @Test
    public void insert(){
        City city=new City();
        city.setCityId(1292);
        city.setCityName("广州");
        city.setCityPy("guangzhou");
        city.setProvId(29);
        city.setCityState("1");
        int num=cityDao.save(city);
        System.out.println(num);
    }

    @Test
    public void update(){
        City city=new City();
        city.setCityId(1292);
        city.setCityName("广州");
        city.setCityPy("guangzhou");
        city.setProvId(29);
        city.setCityState("1");
        int num=cityDao.updateById(city);
        System.out.println(num);
    }

    @Test
    public void delete(){
        City city=new City();
        city.setCityId(1292);
        city.setCityName("广州");
        city.setCityPy("guangzhou");
        city.setProvId(29);
        city.setCityState("1");
        int num=cityDao.deleteById(1);
        System.out.println(num);
    }

    @Test
    public void findByCityId(){
        City city=cityDao.selectById(1292);
        System.out.println(city);
    }

    @Test
    public void queryAllToListMap(){
        Map<String , Object> param=new HashMap<>();
        List<Map<String, Object>> list = cityDao.queryAllMap(param);
        System.out.println(list);
    }

}
