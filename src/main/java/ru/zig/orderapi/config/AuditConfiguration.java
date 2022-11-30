package ru.zig.orderapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@Configuration
public class AuditConfiguration {

    //TODO Тут потом реализовать логику того, чтобы из SecurityContext подтягивать пользователя внёсшего изменение
//    @Bean
//    public AuditorAware<User> auditorAware {
//        return () -> Optional.of("testUser");
//    }
}
