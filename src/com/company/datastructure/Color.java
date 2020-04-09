package com.company.datastructure;

public enum Color {
  RED(-1),
  GREEN(1),
  AGENTX(55),
  AGENTY(66),
  AGENTZ(77),
  MAXSIZE(9999);


  private final int value;

  Color(final int newValue) {
    value=newValue;
  }

  public int getValue() {
    return value;
  }
}
