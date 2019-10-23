package com.dz.dao;


import com.dz.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {
    String INSERT_SQL = "insert into t_user(username,password) values(#{userName},#{password})";
    String SELECT_BYPAGE = "select * from t_user";


    @Insert(INSERT_SQL)
    void save(User user);

    @Select(SELECT_BYPAGE)
    List<User> findByPage();
}
