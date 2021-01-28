package com.xiaoxian.service;

import com.xiaoxian.entity.Employee;

import java.util.List;

/**
 * @author 小贤
 * @PackageName:service
 * @ClassName:EmployeeService
 * @Description:
 * @date 2021/1/27 14:10
 */
public interface EmployeeService {
    List<Employee> findAll();
}
