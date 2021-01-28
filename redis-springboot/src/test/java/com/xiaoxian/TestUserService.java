package com.xiaoxian;

import com.xiaoxian.entity.User;
import com.xiaoxian.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.UUID;

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
        userService.findOne("2");
        System.out.println("====================");

        userService.findOne("2");
    }

    @Test
    public void testDelet() {
        userService.deleteById("1");
    }


    @Test
    public void testsave() {
        User user = new User();
        user.setId(UUID.randomUUID().toString()).setName("xiaoxian").setAge(18).setBir(new Date());
        userService.save(user);
    }


    @Test
    public void testupdate() {
        User user = new User();
        user.setId("2").setAge(22);
        userService.update(user);
    }

}
