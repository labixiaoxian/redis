package com.xiaoxian.service;

import com.xiaoxian.dao.EmployeeDao;
import com.xiaoxian.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 小贤
 * @PackageName:service
 * @ClassName:EmployeeServiceImpl
 * @Description:
 * @date 2021/1/27 14:10
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }
}
