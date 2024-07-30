package com.example.loggingzi.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class LogService {
    private static final Logger logger = LoggerFactory.getLogger(LogService.class);

    public void logDifferentLevels(){
        logger.info("Info poruka ! ");
        logger.debug("Debug poruka! ");
        logger.warn("Warn poruka! ");
        logger.error("Error jebiga! ");
    }
}
