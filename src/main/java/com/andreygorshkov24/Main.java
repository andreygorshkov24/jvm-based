package com.andreygorshkov24;

import java.util.Date;

public class Main {

  public static void main(String[] args) {
    long startedAtMillis = System.currentTimeMillis();
    System.out.printf("Started at: %s%n", new Date(startedAtMillis));

    while (!Thread.interrupted()) {
      long upSeconds = (System.currentTimeMillis() - startedAtMillis) / 1000;
      System.out.printf("Up: %d seconds.%n", upSeconds);

      try {
        Thread.sleep(1000L);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }
  }
}
