package org.john.general;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Johnathon
 */
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("org.john.general.**.mapper")
public class UserRun {
    public static void main(String[] args) {
        SpringApplication.run(UserRun.class, args);
    }
}