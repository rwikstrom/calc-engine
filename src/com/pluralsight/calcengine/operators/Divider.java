package com.pluralsight.calcengine.operators;

import com.pluralsight.calcengine.CalculateBase;
import com.pluralsight.calcengine.MathProcessing;

public class Divider extends CalculateBase implements MathProcessing {

  public Divider() {
  }

  public Divider(double leftValue, double rightValue) {
    super(leftValue, rightValue);
  }

  @Override
  public void calculate() {
    double value = getRightValue() != 0 ? getLeftValue() / getRightValue() : 0;
    setResult(value);
  }

  @Override
  public String getKeyword() {
    return "divide";
  }

  @Override
  public char getSymbol() {
    return '/';
  }

  @Override
  public double doCalculation(double leftValue, double rightValue) {
    setLeftValue(leftValue);
    setRightValue(rightValue);
    calculate();
    return getResult();
  }
}