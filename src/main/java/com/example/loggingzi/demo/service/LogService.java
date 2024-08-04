package com.example.loggingzi.demo.service;

import io.micrometer.core.instrument.MeterRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LogService {
    private static final Logger logger = LoggerFactory.getLogger(LogService.class);

    private final MeterRegistry meterRegistry;
    public LogService(MeterRegistry meterRegistry){
        this.meterRegistry=meterRegistry;
    }

    public void logDifferentLevels(){
        logger.info("Info poruka ! ");
        logger.debug("Debug poruka! ");
        logger.warn("Warn poruka! ");
        logger.error("Error jebiga! ");

        meterRegistry.counter("log.level.info").increment();
        meterRegistry.counter("log.level.debug").increment();
        meterRegistry.counter("log.level.warn").increment();
        meterRegistry.counter("log.level.error").increment();
    }
}
