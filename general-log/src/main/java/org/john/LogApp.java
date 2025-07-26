package org.john;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author llxx
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class LogApp {
    public static void main(String[] args) {
        SpringApplication.run(LogApp.class, args);
    }
}