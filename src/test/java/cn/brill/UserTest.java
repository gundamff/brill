package cn.brill;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.brill.base.entity.User;
import cn.brill.modules.base.dao.UserDao;

/**
 * @author zhang
 * @date 2019/12/27
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BootApplication.class)
public class UserTest {
    // 注入自定义的要测试的Mapper接口
    @Autowired
    private UserDao userDao;

    // 用于声明这是一个测试方法
    @Test
    public void test() {

        System.out.println(userDao.count());
        User u = new User();
        u.setUsername("张三");
        userDao.save(u);
        System.out.println(userDao.count());

    }
}
