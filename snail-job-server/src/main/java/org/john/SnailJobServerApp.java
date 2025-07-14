package org.john;


import com.aizuda.snailjob.server.SnailJobServerApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author llxx
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SnailJobServerApp {
    public static void main(String[] args) {
        SpringApplication.run(SnailJobServerApplication.class, args);
    }
}