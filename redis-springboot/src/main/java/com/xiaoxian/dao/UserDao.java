package com.xiaoxian.dao;

import com.xiaoxian.entity.User;

import java.util.List;

/**
 * @author 小贤
 * @PackageName:dao
 * @ClassName:UserDao
 * @Description:
 * @date 2021/1/26 20:56
 */
public interface UserDao {

    List<User> findAll();

    User findOne(String id);

    int deleteById(String id);

    int save(User user);

    int update(User user);
}