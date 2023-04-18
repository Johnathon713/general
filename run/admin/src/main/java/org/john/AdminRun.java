package org.john;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author johnathon
 */
@SpringBootApplication(scanBasePackages = "org.john")
public class AdminRun {
    public static void main(String[] args) {
        SpringApplication.run(AdminRun.class);
    }
}
