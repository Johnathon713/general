package org.john.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Johna
 */
@Data
@Component
@ConfigurationProperties(prefix = "hadoop")
public class HadoopProperties {
    @Value("defaultFs")
    private String defaultFs;
}
