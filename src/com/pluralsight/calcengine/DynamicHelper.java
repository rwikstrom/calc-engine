package com.pluralsight.calcengine;

import com.pluralsight.calcengine.exceptions.InvalidStatementException;

public class DynamicHelper {

  private MathProcessing[] handlers;

  public DynamicHelper(MathProcessing[] handlers) {
    this.handlers = handlers;
  }

  public String process(String statement) throws InvalidStatementException {
    String[] parts = statement.split(MathProcessing.SEPARATOR);
    if(parts.length != 3) {
      throw new InvalidStatementException("Incorrect number of fields", statement);
    }

    String keyword = parts[0];
    MathProcessing theHandler = null;

      for (MathProcessing handler : handlers) {
        if (keyword.equalsIgnoreCase(handler.getKeyword()))  {
          theHandler = handler;
          break;
        }
      }

      if (theHandler == null) {
        throw new InvalidStatementException("Keyword not found: ", keyword);
    }

      try {
        double leftValue = Double.parseDouble(parts[1]);
        double rightValue = Double.parseDouble(parts[2]);
        double result = theHandler.doCalculation(leftValue, rightValue);

        StringBuilder sb = new StringBuilder(20);
        sb.append(leftValue);
        sb.append(' ');
        sb.append(theHandler.getSymbol());
        sb.append(' ');
        sb.append(rightValue);
        sb.append(" = ");
        sb.append(result);

        return sb.toString();
      } catch (NumberFormatException e) {
        throw new InvalidStatementException("Non-numeric data ", statement, e);
      }
    }
  }