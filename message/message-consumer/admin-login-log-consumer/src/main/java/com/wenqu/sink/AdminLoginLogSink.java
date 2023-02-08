package com.wenqu.sink;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface AdminLoginLogSink {
    @Input("admin-login-log-topic")
    SubscribableChannel adminLoginLog();
}
