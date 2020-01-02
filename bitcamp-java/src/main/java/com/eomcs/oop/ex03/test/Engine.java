package com.eomcs.oop.ex03.test;

public class Engine {
  int valve;
  int sylinder;
  int cc;
  int oilState;
  
  public Engine(int sylinder, int valve, int cc) {
    this.sylinder = sylinder;
    this.valve = valve;
    this.cc = cc;
    this.oilState = 0;
  }
  
  void cleanOil() {
    this.oilState = 10;
  }
}
