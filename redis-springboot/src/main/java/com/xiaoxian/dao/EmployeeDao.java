package com.xiaoxian.dao;

import com.xiaoxian.entity.Employee;

import java.util.List;

/**
 * @author 小贤
 * @PackageName:dao
 * @ClassName:EmployeeDao
 * @Description:
 * @date 2021/1/27 14:01
 */
public interface EmployeeDao {
    List<Employee> findAll();
}
