package com.kuang.Dao;



import com.kuang.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Mytest {
    @Test
    public  void test1() throws IOException {
        String resource="mybatis_config.xml";
        InputStream inputStream= Resources.getResourceAsStream(resource);
        SqlSessionFactory sessionFactory= new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession=sessionFactory.openSession(true);

        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        List<User> userList=userMapper.selectUser();
        for (User user:userList) {
            System.out.println(user.getUsername());
        }
    }

    @Test
    public void test2(){
        ApplicationContext a= new ClassPathXmlApplicationContext("application.xml");
        UserMapperimpl userMapperimpl=(UserMapperimpl )a.getBean("userMapperImpl");
        userMapperimpl.selectUser();
    }
}
