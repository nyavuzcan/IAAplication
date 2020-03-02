package com.company;



import java.util.Random;

public class Board {
  final static Integer[][] BOARDARRAY = new Integer[1000][1000];
  final static  Integer boardSize = BOARDARRAY.length * BOARDARRAY.length;

  public Board() {
    this.SetupGame();
  }

  public void SetupGame() {
    this.FillWithEmptyZero();
    this.FillWithGreenAndRed();
    this.WriteBoard();

  }

  public void FillWithEmptyZero() {
    for (int i = 0; i < BOARDARRAY.length; i++) {
      for (int j = 0; j < BOARDARRAY.length; j++) {
        BOARDARRAY[i][j] = 0;
      }
    }
  }

  public void FillWithGreenAndRed(){
    Green green = new Green();
    Red red = new Red();
    Random random = new Random();
    for (int i=0; i<boardSize/100*15; i++){
      int numberx = random.nextInt(1000);
      int numbery = random.nextInt(1000);
      BOARDARRAY[numberx][numbery] = green.color;
    }

    for(int i=0; i<boardSize/100*15; i++) {
      int numberx = random.nextInt(1000);
      int numbery = random.nextInt(1000);
      if(BOARDARRAY[numberx][numbery] == green.color)
        continue;
      BOARDARRAY[numberx][numbery] = red.color;
    }

  }

public void WriteBoard(){
    int size = 0;
  for (int i = 0; i < BOARDARRAY.length; i++) {
    for (int j = 0; j < BOARDARRAY.length; j++) {
      System.out.printf(""+BOARDARRAY[i][j]);
      size++;
    }
  }
  System.out.println("TOPLAM COUNT:"+size);
}

public void SetAgentsOnBoard(Agents one, Agents two, Agents three){
    Random random = new Random();

   while (true){
     int numberx = random.nextInt(1000);
     int numbery = random.nextInt(1000);
    if (BOARDARRAY[numberx][numbery]==0) {
      BOARDARRAY[numberx][numbery] = one.getAgentCode();
      break;
    } else continue;
   }


  }


}
