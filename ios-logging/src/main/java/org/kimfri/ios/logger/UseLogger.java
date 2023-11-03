package org.kimfri.ios.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UseLogger {

  Logger logger = LoggerFactory.getLogger(UseLogger.class);

  public static void main(String[] args) {
    UseLogger useLogger = new UseLogger();
    useLogger.log("Hello World");
    new LoggerInNextLevel().logInNextLevel("WooHoo");
  }

  public void log(String message) {
    String errorMessage = "Error" + message;
    String warnMessage = "Warn" + message;
    String debugMessage = "Debug" + message;
    String infoMessage = "Info" + message;
    logger.error(errorMessage);
    logger.warn(warnMessage);
    logger.debug(debugMessage);
    logger.info(infoMessage);
  }
}