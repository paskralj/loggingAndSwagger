package com.example.loggingzi.demo.loggingcontroller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

/**
 * LoggingController is a REST controller that provides endpoints for logging messages at various levels.
 */
@RestController
@RequestMapping("/api/logging")
public class LoggingController {

    private static final Logger logger = LoggerFactory.getLogger(LoggingController.class);

    /**
     * Logs messages at different levels (INFO, DEBUG, WARN, ERROR).
     *
     * @return a message indicating that logging was successful
     */
    @Operation(summary = "Log basic messages")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Logging successful")
    })
    @GetMapping("/log")
    public String logMessage(){
        logger.info("Info poruka ! ");
        logger.debug("Debug poruka! ");
        logger.warn("Warn poruka! ");
        logger.error("Error poruka ! ");
        return "Vjezbam logginge ASD ASD !!! ";
    }

    /**
     * Logs a message at the specified logging level.
     *
     * @param level the logging level (info, debug, warn, error)
     * @return a message indicating whether logging at the specified level was successful or if the level was invalid
     */
    @Operation(summary = "Log message at specified level")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Logging at specified level successful"),
            @ApiResponse(responseCode = "400", description = "Invalid logging level", content = @Content)
    })
    @GetMapping("/log/{level}")
    public String logAtLevel(@PathVariable String level){
        switch (level.toLowerCase()){
            case "info":
                logger.info("Info poruka na zahtjev");
                break;
            case "debug":
                logger.info("Debug poruka na zahtjev");
                break;
            case "warn":
                logger.info("Warn poruka na zahtjev");
                break;
            case "error":
                logger.info("Error poruka na zahtjev");
                break;
            default:
                return "Nepoznata razina logiranja";
        }
        return "Logiranje na razini " + level + " izvrseno! ";
    }

    /**
     * Logs a custom user-provided message at the INFO level.
     *
     * @param message the custom message to log
     * @return a message indicating that the custom message was logged successfully
     */
    @Operation(summary = "Log custom user message")
    @RequestBody(description = "Message to log", required = true,
            content = @Content(schema = @Schema(type = "string")))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Custom message logged successfully")
    })
    @PostMapping("/log")
    public String logCustomMessage(@RequestBody String message){
        logger.info("Korisnicka poruka: " + message);
        return "Korisnicka podrska je zabiljezena! ";
    }
}
