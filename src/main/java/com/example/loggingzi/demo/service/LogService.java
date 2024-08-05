package com.example.loggingzi.demo.service;

import io.micrometer.core.instrument.MeterRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * LogService is a service that provides methods for logging messages at different levels and
 * increments corresponding counters in the MeterRegistry.
 */
@Service
public class LogService {
    private static final Logger logger = LoggerFactory.getLogger(LogService.class);

    /**
     * Constructs a new LogService with the specified MeterRegistry.
     *
     * @param meterRegistry the MeterRegistry to be used for recording metrics
     */
    private final MeterRegistry meterRegistry;
    public LogService(MeterRegistry meterRegistry){
        this.meterRegistry=meterRegistry;
    }

    /**
     * Logs messages at different levels (INFO, DEBUG, WARN, ERROR) and increments the corresponding counters
     * in the MeterRegistry.
     */
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
