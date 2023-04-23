package com.lhj.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DepartmentDaoTest {
    private static DepartmentDao mapper;

    @BeforeClass
    public static void setUpMybatisDatabase() {
        SqlSessionFactory builder = new SqlSessionFactoryBuilder().build(DepartmentDaoTest.class.getClassLoader().getResourceAsStream("mybatisTestConfiguration/DepartmentDaoTestConfiguration.xml"));
        //you can use builder.openSession(false) to not commit to database
        mapper = builder.getConfiguration().getMapper(DepartmentDao.class, builder.openSession(true));
    }

    @Test
    public void testFindById() {
        System.out.println(mapper.findById(1));
    }
    @Test
    public void testFindAll() {
        LocalDateTime localDate = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(localDate);
        System.out.println(timestamp);
    }
}
