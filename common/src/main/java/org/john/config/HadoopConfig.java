package org.john.config;

import lombok.RequiredArgsConstructor;
import org.apache.hadoop.fs.FileSystem;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * @author Johna
 */
@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(HadoopProperties.class)
public class HadoopConfig {
    private final HadoopProperties hadoopProperties;

    @Bean
    public FileSystem getFileSystem() throws IOException {
        System.setProperty("HADOOP_USER_NAME", "root");
        org.apache.hadoop.conf.Configuration configuration = new org.apache.hadoop.conf.Configuration();
        configuration.set("dfs.client.use.datanode.hostname", "true");
        configuration.set("fs.defaultFS", hadoopProperties.getDefaultFs());
        configuration.setBoolean("fs.hdfs.impl.disable.cache", true);
        return FileSystem.get(configuration);
    }
}