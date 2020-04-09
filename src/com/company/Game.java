package com.company;

import com.company.Interfaces.GameI;
import com.company.datastructure.*;

import java.util.ArrayList;
import java.util.List;

public class Game implements GameI {

  List<AgentAndNearestFood> agentAndNearestFoods = new ArrayList<>();
  Behavior behavior = new Behavior();
  BoardFeatures boardFeatures =new BoardFeatures();

  @Override
  public void startGame(ArrayList<Agents> allAgents) {
    while (BoardFeatures.GREENFOOD.size() != 0) {
      for (Agents agent : allAgents) {
        this.stepIn(agent);

      }
      stepSetUp(agentAndNearestFoods);
      agentAndNearestFoods = new ArrayList<>();
    }
  }

  @Override
  public void stepIn(Agents agent) {

    NearestFood nearestFood = agent.transactions.CalculateNearestFood();
    agent.transactions.isThereAnyRed(nearestFood);
    agentAndNearestFoods.add(new AgentAndNearestFood(agent, nearestFood));

  }

  public void stepSetUp(List<AgentAndNearestFood> agentAndNearestFoods) {
    for (int i = 0; i < agentAndNearestFoods.size(); i++) {
      for (int j = i + 1; j < agentAndNearestFoods.size(); j++) {
        if (behavior.isLocationsEqual(agentAndNearestFoods.get(i).getNearestFood().getLocation(),
            agentAndNearestFoods.get(j).getNearestFood().getLocation())) {
          //THOSE ARE WANT TO EAT SAME FOOD
          if (agentAndNearestFoods.get(i).equals(whichOneMoreNear(agentAndNearestFoods.get(i).getAgents(),
              agentAndNearestFoods.get(j).getAgents()))) {
            //Agent(i) ate
            agentAndNearestFoods.get(i).getAgents().setLastScore();
            agentAndNearestFoods.get(i).getAgents().step += 1;


          } else {
            //Agent(j) ate
          }

        }
      }

    }


  }

  public Agents whichOneMoreNear(Agents agentFirst, Agents agentSecond) {

    if (agentFirst.transactions.CalculateNearestFood().getDifferenceNumber() < agentSecond.transactions.CalculateNearestFood().getDifferenceNumber()) {
      return agentFirst;
    } else if (agentFirst.transactions.CalculateNearestFood().getDifferenceNumber() > agentSecond.transactions.CalculateNearestFood().getDifferenceNumber()) {
      return agentSecond;
    } else return checkClockWay(agentFirst, agentSecond);
  }

  public Agents checkClockWay(Agents agentFirst, Agents agentSecond) {
    //left one has avantage
    if (agentFirst.transactions.CalculateNearestFood().getLocation().getxIndis() == agentSecond.transactions.CalculateNearestFood().getLocation().getxIndis()) {
      Integer tempY = agentFirst.transactions.CalculateNearestFood().getLocation().getyIndis();
      if (agentFirst.getLastLocation().getLocation().getxIndis() < tempY) {
        return agentFirst;
      }
    } else {
      return agentSecond;
    }
    return agentSecond;
  }

  public Agents ateConfigurations(Agents agents, NearestFood nearestFood) {
    agents.step++;

    agents.eatValueAndLocations.add(new EatValueAndLocation(Board.BOARDARRAY[nearestFood.getLocation().getxIndis()][nearestFood.getLocation().getyIndis()]
        , nearestFood.getLocation()));
    Board.BOARDARRAY[agents.getLastLocation().getLocation().getxIndis()][agents.getLastLocation().getLocation().getyIndis()] = 0;
    agents.locations.add(new StepAndLocation(agents.step, new Location(nearestFood.getLocation().getxIndis(), nearestFood.getLocation().getyIndis())));
    Board.BOARDARRAY[nearestFood.getLocation().getxIndis()][nearestFood.getLocation().getyIndis()] = agents.getAgentCode();
    boardFeatures.updateValues();
    return agents;
  }

  public Agents stepOneOrTwo(Agents agents){


  }


}
