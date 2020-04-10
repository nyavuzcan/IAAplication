package com.company;

import com.company.datastructure.Color;
import com.company.datastructure.Location;
import com.company.datastructure.StepAndLocation;

import java.util.ArrayList;
import java.util.List;

public class BoardFeatures {

  public static List<StepAndLocation> GREENFOOD = new ArrayList<>();
  public static List<StepAndLocation> REDFOOD = new ArrayList<>();

  public BoardFeatures() {

    BoardFeatures.updateValues();
  }


  public static void updateValues() {
    getGreenFoodsFromBoard();
    getRedFoodsFromBoard();
  }


  public static void getGreenFoodsFromBoard() {
    GREENFOOD = new ArrayList<>();
    for (int i = 0; i < Board.BOARDARRAY[0].length; i++) {
      for (int j = 0; j < Board.BOARDARRAY.length; j++) {
        if (Board.BOARDARRAY[i][j] == Color.GREEN.getValue()) {

          GREENFOOD.add(new StepAndLocation(new Location(i, j)));
        }
      }
    }
  }

  public static void getRedFoodsFromBoard() {
    REDFOOD = new ArrayList<>();
    for (int i = 0; i < Board.BOARDARRAY[0].length; i++) {
      for (int j = 0; j < Board.BOARDARRAY.length; j++) {
        if (Board.BOARDARRAY[i][j] == Color.RED.getValue()) {

          REDFOOD.add(new StepAndLocation(new Location(i, j)));
        }
      }
    }
  }

}
