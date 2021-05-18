package cn.cqswxy.sport;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("cn.cqswxy.sport")
@SpringBootApplication
public class SportJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SportJavaApplication.class, args);
    }

}
