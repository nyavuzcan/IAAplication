package com.company;

import com.company.datastructure.AgentAndNearestFood;
import com.company.datastructure.Location;

import java.util.ArrayList;
import java.util.List;

public class Behavior {
  public boolean isLocationsEqual(Location locationFirst,Location locationSecond){
    if (locationFirst.getxIndis()==locationSecond.getxIndis() && locationFirst
    .getyIndis()==locationSecond.getyIndis()) return true;
    return false;
  }

  public boolean isAllofDifferent(List<AgentAndNearestFood> agentAndNearestFood){
    if (!(isLocationsEqual(agentAndNearestFood.get(0).getNearestFood().getLocation(),
        agentAndNearestFood.get(1).getNearestFood().getLocation()
        ))

        && !(isLocationsEqual(agentAndNearestFood.get(0).getNearestFood().getLocation(),agentAndNearestFood.get(2).getNearestFood().getLocation()))
   && !(isLocationsEqual(agentAndNearestFood.get(1).getNearestFood().getLocation(),agentAndNearestFood.get(2).getNearestFood().getLocation()))
    ){
      return true;
    }else return false;
  }

  public boolean isAllOfSame(List<AgentAndNearestFood> agentAndNearestFood){
    if ((isLocationsEqual(agentAndNearestFood.get(0).getNearestFood().getLocation(),
        agentAndNearestFood.get(1).getNearestFood().getLocation()
    ))

        && (isLocationsEqual(agentAndNearestFood.get(0).getNearestFood().getLocation(),agentAndNearestFood.get(2).getNearestFood().getLocation()))
        && (isLocationsEqual(agentAndNearestFood.get(1).getNearestFood().getLocation(),agentAndNearestFood.get(2).getNearestFood().getLocation())))
    {
      return true;
    }
    else return false;
  }

  public Integer whoIsTheWinner(List<AgentAndNearestFood> agentAndNearestFoods,Agents agents){
    if (agentAndNearestFoods.get(0).equals(agents)) return 0;
    else if (agentAndNearestFoods.get(1).equals(agents)) return 1;
    else if (agentAndNearestFoods.get(2).equals(agents)) return 2;
    return 1;
  }




}
