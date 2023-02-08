package com.wenqu.service;

import com.wenqu.domain.Admin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SentinelTestFallback {

    private static final Logger logger = LoggerFactory.getLogger(SentinelTestFallback.class);


    public static Admin sentinelTestFallback(String username, Throwable ex) {
        logger.warn("Invoke sentinelTestFallback: " + ex.getClass().getTypeName());
        ex.printStackTrace();
        return null;
    }

}
