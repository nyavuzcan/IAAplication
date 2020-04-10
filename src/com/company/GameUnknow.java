package com.company;

import com.company.Interfaces.GameI;
import com.company.datastructure.*;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GameUnknow implements GameI {
  long start = System.currentTimeMillis();
  List<AgentAndNearestFood> agentAndNearestFoods = new ArrayList<>();
  Behavior behavior = new Behavior();
  ArrayList<Agents> rtAgent = new ArrayList<>();
  @Override
  public ArrayList<Agents> startGame(ArrayList<Agents> allAgents) {
    while (BoardFeatures.GREENFOOD.size() != 0) {
      for (Agents agent : allAgents) {
        this.stepIn(agent);

      }
      stepSetUp(agentAndNearestFoods);
      this.rtAgent = allAgents;
      agentAndNearestFoods = new ArrayList<>();
    }
    behavior.writeScoresStepsAnd(rtAgent);
    return allAgents;
  }

  @Override
  public void stepIn(Agents agent) {
    NearestFood nearestFood = agent.transactions.CalculateNearestFood();

    if (Objects.nonNull(nearestFood)) {

      agentAndNearestFoods.add(new AgentAndNearestFood(agent, nearestFood));
    } else {
      System.out.println("MISSION COMPLETED");
      long end = System.currentTimeMillis();
      NumberFormat formatter = new DecimalFormat("#0.00000");
      System.out.print("Total Run Time " + formatter.format((end - start) / 1000d) + " seconds");

      behavior.writeScoresStepsAnd(rtAgent);
      System.out.println(rtAgent);

    }

  }


  public void stepSetUp(List<AgentAndNearestFood> agentAndNearestFoods){
    if (behavior.isAllofDifferent(agentAndNearestFoods)) {
    stepOneOrTwo(agentAndNearestFoods.get(0).getAgents(), agentAndNearestFoods.get(0).getNearestFood());
    stepOneOrTwo(agentAndNearestFoods.get(1).getAgents(), agentAndNearestFoods.get(1).getNearestFood());
    stepOneOrTwo(agentAndNearestFoods.get(2).getAgents(), agentAndNearestFoods.get(2).getNearestFood());
  } else if (behavior.isLocationsEqual(agentAndNearestFoods.get(0).getNearestFood().getLocation(),
        agentAndNearestFoods.get(0).getNearestFood().getLocation()
        )){
    Integer count=  behavior.checkNeighbor(agentAndNearestFoods.get(0));
    if (count<3){
      stepOneOrTwo(agentAndNearestFoods.get(2).getAgents(), agentAndNearestFoods.get(2).getNearestFood());
      stepOneOrTwo(agentAndNearestFoods.get(0).getAgents(), agentAndNearestFoods.get(0).getAgents().transactions.CalculateNearestFood());
      stepOneOrTwo(agentAndNearestFoods.get(1).getAgents(), agentAndNearestFoods.get(1).getAgents().transactions.CalculateNearestFood());

    }else {
      stepOneOrTwo(agentAndNearestFoods.get(0).getAgents(), agentAndNearestFoods.get(0).getNearestFood());
      stepOneOrTwo(agentAndNearestFoods.get(1).getAgents(), agentAndNearestFoods.get(1).getAgents().transactions.CalculateNearestFood());
      stepOneOrTwo(agentAndNearestFoods.get(2).getAgents(), agentAndNearestFoods.get(2).getAgents().transactions.CalculateNearestFood());

    }
    }
  }

  public Agents stepOneOrTwo(Agents agents, NearestFood nearestFood) {
    try {


      Integer agentXIndids = agents.getLastLocation().getLocation().getxIndis();
      Integer agentYIndis = agents.getLastLocation().getLocation().getyIndis();
      Integer targetXIndis = nearestFood.getLocation().getxIndis();
      Integer targetYIndis = nearestFood.getLocation().getyIndis();
      if (targetXIndis < agentXIndids) {
        if ((agentXIndids - targetXIndis) >= 2) {
          agents.locations.add(new StepAndLocation(agents.step++, new Location(agentXIndids - 2, agentYIndis)));

          return ateConfigurations(agents);
        } else {
          agents.locations.add(new StepAndLocation(agents.step++, new Location(agentXIndids - 1, agentYIndis)));

          return ateConfigurations(agents);
        }

      } else if (targetXIndis > agentXIndids) {
        if ((targetXIndis - agentXIndids) >= 2) {
          agents.locations.add(new StepAndLocation(agents.step++, new Location(agentXIndids + 2, agentYIndis)));

          return ateConfigurations(agents);
        } else {
          agents.locations.add(new StepAndLocation(agents.step++, new Location(agentXIndids + 1, agentYIndis)));

          return ateConfigurations(agents);
        }
      }

      if (targetYIndis < agentYIndis) {
        if (agentYIndis - targetYIndis >= 2) {
          agents.locations.add(new StepAndLocation(agents.step++, new Location(agentXIndids, agentYIndis - 2)));

          return ateConfigurations(agents);
        } else {
          agents.locations.add(new StepAndLocation(agents.step++, new Location(agentXIndids, agentYIndis - 1)));
          return ateConfigurations(agents);
        }

      } else if (targetYIndis > agentYIndis) {
        if (targetYIndis - agentYIndis == 1) {
          agents.locations.add(new StepAndLocation(agents.step++, new Location(agentXIndids, agentYIndis + 1)));


          return ateConfigurations(agents);
        } else {
          agents.locations.add(new StepAndLocation(agents.step++, new Location(agentXIndids, agentYIndis + 2)));

          return ateConfigurations(agents);
        }
      }

      return ateConfigurations(agents);
    } catch (NullPointerException e) {
      long end = System.currentTimeMillis();
      NumberFormat formatter = new DecimalFormat("#0.00000");
      System.out.print("Total Run Time " + formatter.format((end - start) / 1000d) + " seconds"+"\n");

      behavior.writeScoresStepsAnd(rtAgent);

    }
    return agents;
  }

  public Agents ateConfigurations(Agents agent) {
    Integer xIndisAgent = agent.getLastLocation().getLocation().getxIndis();
    Integer yIndisAgent = agent.getLastLocation().getLocation().getyIndis();

    agent.addEatValueAndLocation(new EatValueAndLocation(Board.BOARDARRAY[xIndisAgent][yIndisAgent],
        new Location(xIndisAgent, yIndisAgent)));
    Board.BOARDARRAY[agent.getPenultimateLocation().getLocation().getxIndis()][agent.getPenultimateLocation().getLocation().getyIndis()] = 0;
    Board.BOARDARRAY[xIndisAgent][yIndisAgent] = agent.getAgentCode();
    BoardFeatures.updateValues();
    return agent;
  }
}
