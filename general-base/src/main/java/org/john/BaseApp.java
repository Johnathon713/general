package org.john;

import com.aizuda.snailjob.client.starter.EnableSnailJob;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author llxx
 */
@EnableSnailJob
@SpringBootApplication
@EnableDiscoveryClient
public class BaseApp {
    public static void main(String[] args) {
        SpringApplication.run(BaseApp.class, args);
    }
}