package com.pluralsight.calcengine.operators;

import com.pluralsight.calcengine.CalculateBase;
import com.pluralsight.calcengine.MathProcessing;

public class Subtractor extends CalculateBase implements MathProcessing {

  public Subtractor() {
  }

  public Subtractor(double leftValue, double rightValue) {
    super(leftValue, rightValue);
  }

  @Override
  public void calculate() {
    double value = getLeftValue() - getRightValue();
    setResult(value);
  }

  @Override
  public String getKeyword() {
    return "subtract";
  }

  @Override
  public char getSymbol() {
    return '-';
  }

  @Override
  public double doCalculation(double leftValue, double rightValue) {
    setLeftValue(leftValue);
    setRightValue(rightValue);
    calculate();
    return getResult();
  }
}
