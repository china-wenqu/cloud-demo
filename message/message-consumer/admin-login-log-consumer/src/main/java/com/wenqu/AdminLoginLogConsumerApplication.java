package com.wenqu;

import com.wenqu.sink.AdminLoginLogSink;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@EnableBinding({AdminLoginLogSink.class})
public class AdminLoginLogConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminLoginLogConsumerApplication.class,args);
    }
}
