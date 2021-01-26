package com.xiaoxian;

import com.xiaoxian.service.UserService;
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
public class TestUserService {

    @Autowired
    private UserService userService;


    @Test
    public void tesFindAll() {
        userService.findAll().forEach(user -> System.out.println("user = " + user));

        System.out.println("====================");

        userService.findAll().forEach(user -> System.out.println("user = " + user));
    }

    @Test
    public void testFindOne() {
        userService.findOne("1");
        System.out.println("====================");

        userService.findOne("1");
    }

    @Test
    public void testDelet() {
        userService.deleteById("1");
    }
}
