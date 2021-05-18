package cn.cqswxy.sport;

import cn.cqswxy.sport.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SportJavaApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    UserMapper userMapper;

    @Test
    public int test(){
        int i = userMapper.updateState(2, true);
        System.out.println(i);
        return i;
    }

}
