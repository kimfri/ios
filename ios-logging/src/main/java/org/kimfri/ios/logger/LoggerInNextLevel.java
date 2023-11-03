package org.kimfri.ios.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerInNextLevel {
  private final Logger logger = LoggerFactory.getLogger(LoggerInNextLevel.class);

  void logInNextLevel(String message) {
    logger.error(message);
  }
}
