package com.xiaoxian.service;

import com.xiaoxian.dao.UserDao;
import com.xiaoxian.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 小贤
 * @PackageName:service
 * @ClassName:UserServiceImpl
 * @Description:
 * @date 2021/1/26 20:58
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findOne(String id) {
        return userDao.findOne(id);
    }

    @Override
    public int deleteById(String id) {
        return userDao.deleteById(id);
    }

    @Override
    public int save(User user) {
        return userDao.save(user);
    }

    @Override
    public int update(User user) {
        return userDao.update(user);
    }
}
