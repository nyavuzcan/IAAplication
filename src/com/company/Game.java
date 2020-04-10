package com.company;

import com.company.Interfaces.GameI;
import com.company.datastructure.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Game implements GameI {


  List<AgentAndNearestFood> agentAndNearestFoods = new ArrayList<>();
  Behavior behavior = new Behavior();
  ArrayList<Agents> rtAgent=new ArrayList<>();

  @Override
  public ArrayList<Agents> startGame(ArrayList<Agents> allAgents) {
    while (BoardFeatures.GREENFOOD.size() != 0) {
      for (Agents agent : allAgents) {
        this.stepIn(agent);

      }
      stepSetUp(agentAndNearestFoods);
      agentAndNearestFoods = new ArrayList<>();
    }
    rtAgent=allAgents;
   return allAgents;
  }

  @Override
  public void stepIn(Agents agent) {

    NearestFood nearestFood = agent.transactions.CalculateNearestFood();
   // agent.transactions.isThereAnyRed(nearestFood.getLocation());
    if (Objects.nonNull(nearestFood)){

      agentAndNearestFoods.add(new AgentAndNearestFood(agent, nearestFood));
    }
    else {
      System.out.println("MISSION COMPLETED");
      System.out.println(rtAgent);
    }

  }

  public void stepSetUp(List<AgentAndNearestFood> agentAndNearestFoods) {
    if (behavior.isAllofDifferent(agentAndNearestFoods)){
      stepOneOrTwo(agentAndNearestFoods.get(0).getAgents(),agentAndNearestFoods.get(0).getNearestFood());
      stepOneOrTwo(agentAndNearestFoods.get(1).getAgents(),agentAndNearestFoods.get(1).getNearestFood());
      stepOneOrTwo(agentAndNearestFoods.get(2).getAgents(),agentAndNearestFoods.get(2).getNearestFood());
    }
    else if(behavior.isAllOfSame(agentAndNearestFoods)){
      Agents tempAgent= whichOneMoreNear(agentAndNearestFoods.get(0).getAgents(),agentAndNearestFoods.get(1).getAgents());
     Agents tempWinner = whichOneMoreNear(tempAgent,agentAndNearestFoods.get(2).getAgents());
      Integer winnerIndes = behavior.whoIsTheWinner(agentAndNearestFoods,tempWinner);
      stepOneOrTwo(agentAndNearestFoods.get(winnerIndes).getAgents(),agentAndNearestFoods.get(winnerIndes).getNearestFood());
     if (2-winnerIndes==0){
        stepOneOrTwo(agentAndNearestFoods.get(0).getAgents(),agentAndNearestFoods.get(0).getAgents().transactions.CalculateNearestFood());
        stepOneOrTwo(agentAndNearestFoods.get(1).getAgents(),agentAndNearestFoods.get(1).getAgents().transactions.CalculateNearestFood());
     }
     else if(2-winnerIndes==1){
       stepOneOrTwo(agentAndNearestFoods.get(0).getAgents(),agentAndNearestFoods.get(0).getAgents().transactions.CalculateNearestFood());
       stepOneOrTwo(agentAndNearestFoods.get(2).getAgents(),agentAndNearestFoods.get(2).getAgents().transactions.CalculateNearestFood());

     }else if(2-winnerIndes==2){
       stepOneOrTwo(agentAndNearestFoods.get(1).getAgents(),agentAndNearestFoods.get(1).getAgents().transactions.CalculateNearestFood());
       stepOneOrTwo(agentAndNearestFoods.get(2).getAgents(),agentAndNearestFoods.get(2).getAgents().transactions.CalculateNearestFood());

     }
    }
    else if (behavior.isLocationsEqual(agentAndNearestFoods.get(0).getNearestFood().getLocation(),
        agentAndNearestFoods.get(1).getNearestFood().getLocation()
        )&&!(behavior.isLocationsEqual(agentAndNearestFoods.get(2).getNearestFood().getLocation(),
        agentAndNearestFoods.get(1).getNearestFood().getLocation()))&&(behavior.isLocationsEqual(agentAndNearestFoods.get(2).getNearestFood().getLocation(),
        agentAndNearestFoods.get(0).getNearestFood().getLocation()))) {
      stepOneOrTwo(agentAndNearestFoods.get(2).getAgents(), agentAndNearestFoods.get(2).getNearestFood());
      Agents tempWinner = whichOneMoreNear(agentAndNearestFoods.get(0).getAgents(), agentAndNearestFoods.get(1).getAgents());
      if (tempWinner.equals(agentAndNearestFoods.get(0).getAgents())) {
        stepOneOrTwo(agentAndNearestFoods.get(0).getAgents(), agentAndNearestFoods.get(0).getNearestFood());
        stepOneOrTwo(agentAndNearestFoods.get(1).getAgents(), agentAndNearestFoods.get(1).getAgents().transactions.CalculateNearestFood());
      } else {
        stepOneOrTwo(agentAndNearestFoods.get(1).getAgents(),agentAndNearestFoods.get(1).getNearestFood());
        stepOneOrTwo(agentAndNearestFoods.get(0).getAgents(),agentAndNearestFoods.get(0).getAgents().transactions.CalculateNearestFood());
      }

    }
    else {
      stepOneOrTwo(agentAndNearestFoods.get(0).getAgents(),agentAndNearestFoods.get(0).getNearestFood());
      stepOneOrTwo(agentAndNearestFoods.get(1).getAgents(),agentAndNearestFoods.get(1).getAgents().transactions.CalculateNearestFood());
      stepOneOrTwo(agentAndNearestFoods.get(2).getAgents(),agentAndNearestFoods.get(2).getAgents().transactions.CalculateNearestFood());

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

  public Agents stepOneOrTwo(Agents agents,NearestFood nearestFood){

     Integer agentXIndids = agents.getLastLocation().getLocation().getxIndis();
     Integer agentYIndis = agents.getLastLocation().getLocation().getyIndis();
     Integer targetXIndis= nearestFood.getLocation().getxIndis();
     Integer targetYIndis = nearestFood.getLocation().getyIndis();
       if (targetXIndis<agentXIndids){
         if ((agentXIndids-targetXIndis)>=2){
           agents.locations.add(new StepAndLocation(agents.step++,new Location(agentXIndids-2,agentYIndis)));

           return ateConfigurations(agents);
         } else {
           agents.locations.add(new StepAndLocation(agents.step++,new Location(agentXIndids-1,agentYIndis)));

          return ateConfigurations(agents);
         }

       } else if (targetXIndis>agentXIndids){
         if ((targetXIndis-agentXIndids)>=2){
           agents.locations.add(new StepAndLocation(agents.step++,new Location(agentXIndids+2,agentYIndis)));

          return ateConfigurations(agents);
         } else {
           agents.locations.add(new StepAndLocation(agents.step++,new Location(agentXIndids+1,agentYIndis)));

          return ateConfigurations(agents);
         }
       }

       if (targetYIndis<agentYIndis){
         if (agentYIndis-targetYIndis>=2){
           agents.locations.add(new StepAndLocation(agents.step++,new Location(agentXIndids,agentYIndis-2)));

           return ateConfigurations(agents);
         }else {
           agents.locations.add(new StepAndLocation(agents.step++,new Location(agentXIndids,agentYIndis-1)));
           return ateConfigurations(agents);
         }

       }else if (targetYIndis>agentYIndis){
         if (targetYIndis-agentYIndis==1){
           agents.locations.add(new StepAndLocation(agents.step++,new Location(agentXIndids,agentYIndis+1)));


           return ateConfigurations(agents);
         }else {
           agents.locations.add(new StepAndLocation(agents.step++,new Location(agentXIndids,agentYIndis+2)));

           return ateConfigurations(agents);
         }
       }

  return ateConfigurations(agents);
  }

  public Agents ateConfigurations(Agents agent){
        Integer xIndisAgent=agent.getLastLocation().getLocation().getxIndis();
    Integer yIndisAgent=agent.getLastLocation().getLocation().getyIndis();

    agent.eatValueAndLocations.add(new EatValueAndLocation(Board.BOARDARRAY[xIndisAgent][yIndisAgent],
        new Location(xIndisAgent,yIndisAgent)));
    Board.BOARDARRAY[agent.getPenultimateLocation().getLocation().getxIndis()][agent.getPenultimateLocation().getLocation().getyIndis()]=0;
    Board.BOARDARRAY[xIndisAgent][yIndisAgent]=agent.getAgentCode();
    BoardFeatures.updateValues();
    return agent;
    }

}
