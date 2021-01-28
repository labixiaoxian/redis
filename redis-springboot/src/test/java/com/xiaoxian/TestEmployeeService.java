package com.xiaoxian;

import com.xiaoxian.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 小贤
 * @PackageName:com.xiaoxian
 * @ClassName:TestUserService
 * @Description:
 * @date 2021/1/26 21:01
 */
@SpringBootTest(classes = RedisSpringbootApplication.class)
@RunWith(SpringRunner.class)
public class TestEmployeeService {

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void testFindAll() {
        employeeService.findAll().forEach(employee -> System.out.println("employee = " + employee));
        System.out.println("==============================================");
        employeeService.findAll().forEach(employee -> System.out.println("employee = " + employee));
    }
}
