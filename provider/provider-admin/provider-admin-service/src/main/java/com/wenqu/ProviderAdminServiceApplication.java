package com.wenqu;

import com.wenqu.config.DubboSentinelConfiguration;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication(scanBasePackageClasses = {ProviderAdminServiceApplication.class, DubboSentinelConfiguration.class})
@EnableDiscoveryClient
@EnableDubbo(scanBasePackages = "com.wenqu.service.impl")

public class ProviderAdminServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderAdminServiceApplication.class,args);
    }
}
