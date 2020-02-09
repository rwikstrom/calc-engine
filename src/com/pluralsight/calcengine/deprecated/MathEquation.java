package com.pluralsight.calcengine.deprecated;

public class MathEquation {

  private double leftValue;
  private double rightValue;
  private char opCode;
  private double result;

  public double getLeftValue() {
    return this.leftValue;
  }

  public void setLeftValue(double leftValue) {
    this.leftValue = leftValue;
  }

  public double getRightValue() {
    return this.rightValue;
  }

  public void setRightValue(double rightValue) {
    this.rightValue = rightValue;
  }

  public char getOpCode() {
    return this.opCode;
  }

  public void setOpCode(char opCode) {
    this.opCode = opCode;
  }

  public double getResult() {
    return this.result;
  }

  public MathEquation() {
  }

  public MathEquation(char opCode) {
    this.opCode = opCode;
  }

  public MathEquation(char opCode, double leftValue, double rightValue) {
    this(opCode);
    this.leftValue = leftValue;
    this.rightValue = rightValue;
  }

  public void execute(double leftValue, double rightValue) {
    this.leftValue = leftValue;
    this.rightValue = rightValue;
    execute();
  }

  public void execute() {
    switch (opCode) {
      case 'a' :
        result = leftValue + rightValue;
        break;
      case 's' :
        result = leftValue - rightValue;
        break;
      case 'd' :
        result = rightValue != 0 ? leftValue / rightValue : 0.0d;
        break;
      case 'm' :
        result = leftValue * rightValue;
        break;
      default:
        System.out.println("Error, invalid operations code: " + opCode);
        result = 0.0d;
        break;
    }
  }
}