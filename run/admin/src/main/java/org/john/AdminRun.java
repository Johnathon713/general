package org.john;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

/**
 * @author johnathon
 */
@EnableKafka
@MapperScan({"org.john.**.mapper","org.john.**.dao"})
@SpringBootApplication(scanBasePackages = "org.john")
public class AdminRun {

    public static void main(String[] args) {
        SpringApplication.run(AdminRun.class);
    }
}
