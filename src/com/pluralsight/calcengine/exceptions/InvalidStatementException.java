package com.pluralsight.calcengine.exceptions;

public class InvalidStatementException extends Exception {

  public InvalidStatementException(String reason, String statement) {
    super(reason + ": " + statement);
  }
  public InvalidStatementException(String message, String statement, Throwable cause ){
    super(message + ": " + statement, cause);
  }
}
