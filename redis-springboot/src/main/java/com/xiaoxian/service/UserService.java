package com.xiaoxian.service;

import com.xiaoxian.entity.User;

import java.util.List;

/**
 * @author 小贤
 * @PackageName:service
 * @ClassName:UserService
 * @Description:
 * @date 2021/1/26 20:58
 */
public interface UserService {
    List<User> findAll();

    User findOne(String id);

    int deleteById(String id);
}
