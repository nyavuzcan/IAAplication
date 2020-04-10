package com.company.Interfaces;

import com.company.Agents;

import java.util.ArrayList;

public interface GameI {
  ArrayList<Agents> startGame(ArrayList<Agents> allAgents);
  void stepIn(Agents agents);

}
