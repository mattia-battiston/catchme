package com.catchme;

public class FirstClass extends BaseFirstClass {

  public String sayHello(String name) {
    return super.sayHello(name) + " and hello " + name;
  }

  public static String sayHelloStaticly(String name) {
    return BaseFirstClass.baseSayHelloStaticly(name) + " and then work";
  }

}
