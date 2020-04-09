package com.company.Interfaces;

import com.company.Agents;

import java.util.ArrayList;

public interface GameI {
  void startGame(ArrayList<Agents> allAgents);
  void stepIn(Agents agents);

}
