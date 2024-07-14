package org.john.general;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Johnathon
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GatewayRun {
    public static void main(String[] args) {
        SpringApplication.run(GatewayRun.class, args);
    }
}