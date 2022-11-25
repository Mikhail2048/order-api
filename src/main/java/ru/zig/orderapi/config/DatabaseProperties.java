package ru.zig.orderapi.config;

import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Value
@ConfigurationProperties(prefix = "db")
public class DatabaseProperties {
    String username;
    String password;
    String driver;
    String url;
    String hosts;
}
