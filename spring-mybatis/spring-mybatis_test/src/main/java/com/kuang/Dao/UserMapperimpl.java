package com.kuang.Dao;

import com.kuang.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class UserMapperimpl implements UserMapper{

    //我们所有操作，都使用sqlsession来执行，现在都使用SqlsessionTemplate
    private SqlSessionTemplate sqlSession;

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    public SqlSessionTemplate getSqlSession() {
        return sqlSession;
    }

    @Override
    public List<User> selectUser() {
        UserMapper userMapper =sqlSession.getMapper(UserMapper.class);
        List<User> userList=userMapper.selectUser();
        for (User user:userList
             ) {
            System.out.println(user.getUsername());
        }
        return userList;
    }
}
