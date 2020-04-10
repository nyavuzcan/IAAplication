package com.company;

import com.company.datastructure.Location;
import com.company.datastructure.StepAndLocation;

import java.util.ArrayList;
import java.util.Random;

public class Board {
  final static Integer[][] BOARDARRAY = new Integer[1000][1000];
  final static Integer boardSize = BOARDARRAY.length * BOARDARRAY.length;
  BoardFeatures boardFeatures;
  ArrayList<StepAndLocation> GREENFOODx = new ArrayList<>();

  public Board() {
    this.SetupGame();
  }

  public void SetupGame() {
    this.FillWithEmptyZero();
    this.FillWithGreenAndRed();
    this.boardFeatures = new BoardFeatures();

  }

  public void FillWithEmptyZero() {
    for (int i = 0; i < BOARDARRAY.length; i++) {
      for (int j = 0; j < BOARDARRAY.length; j++) {
        BOARDARRAY[i][j] = 0;
      }
    }
  }

  public void FillWithGreenAndRed() {
    Green green = new Green();
    Red red = new Red();
    Random random = new Random();
    Integer count = 0;
    while (count != boardSize / 100 * 15) {
      int numberx = random.nextInt(1000);
      int numbery = random.nextInt(1000);
      if (BOARDARRAY[numberx][numbery] == 0) {
        BOARDARRAY[numberx][numbery] = green.color;
        count++;
      }
    }
    Integer countRed = 0;
    while (countRed != boardSize / 100 * 15) {
      int numberx = random.nextInt(1000);
      int numbery = random.nextInt(1000);
      if (BOARDARRAY[numberx][numbery] == 0) {
        BOARDARRAY[numberx][numbery] = red.color;
        countRed++;
      }

    }

  }


  public void WriteBoard() {
    int size = 0;
    for (int i = 0; i < BOARDARRAY.length; i++) {
      for (int j = 0; j < BOARDARRAY.length; j++) {
        System.out.printf("" + BOARDARRAY[i][j]);
        size++;
      }
    }
    System.out.println("TOPLAM COUNT:" + size);
  }

  public void SetAgentOnBoard(Agents agent) {
    Random random = new Random();
    while (true) {
      int numberx = random.nextInt(1000);
      int numbery = random.nextInt(1000);
      if (BOARDARRAY[numberx][numbery] == 0) {
        BOARDARRAY[numberx][numbery] = agent.getAgentCode();
        agent.locations.add(new StepAndLocation(0, new Location(numberx, numbery)));
        break;
      } else continue;
    }

  }


}
