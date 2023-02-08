package com.wenqu.message;

import com.wenqu.domain.AdminLoginLog;
import com.wenqu.service.MessageService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
@Component
@DubboService(version = "1.0.0")
public class MessageProducer implements MessageService {
    @Resource
    private MessageSource source;

    public boolean sendAdminLoginLog(AdminLoginLog dto) {
        return source.adminLoginLog().send(MessageBuilder.withPayload(dto).build());
    }
}
