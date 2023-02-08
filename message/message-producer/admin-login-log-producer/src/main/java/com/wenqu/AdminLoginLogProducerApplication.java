package com.wenqu;

//import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import com.wenqu.message.MessageSource;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@EnableBinding({ MessageSource.class })
@EnableDubbo(scanBasePackages = "com.wenqu.message")
public class AdminLoginLogProducerApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminLoginLogProducerApplication.class,args);
    }
}
