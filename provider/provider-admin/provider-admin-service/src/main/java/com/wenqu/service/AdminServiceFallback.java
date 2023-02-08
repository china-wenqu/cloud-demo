package com.wenqu.service;

import com.wenqu.domain.Admin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AdminServiceFallback {

    private static final Logger logger = LoggerFactory.getLogger(AdminServiceFallback.class);


    public static Admin getAdminByUsernameFallback(String username, Throwable ex) {
        logger.warn("Invoke getAdminByUsernameFallback: " + ex.getClass().getTypeName());
        ex.printStackTrace();
        return null;
    }

}
