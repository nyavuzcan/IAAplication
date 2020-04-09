package com.company;

import com.company.datastructure.Color;
import com.company.datastructure.NearestFood;
import com.company.datastructure.StepAndLocation;


public class Transactions {
  Agents agent;

  public Transactions(Agents agent) {
    this.agent = agent;
  }

  public NearestFood CalculateNearestFood() {
    int tempDistance = Color.MAXSIZE.getValue();
    int i = 0;
    Integer tempI = 0;
    for (StepAndLocation stepAndLocation : BoardFeatures.GREENFOOD) {
      Integer tempX = Math.abs(stepAndLocation.getLocation().getxIndis() - agent.getLastLocation().getLocation().getxIndis());
      Integer tempY = Math.abs(stepAndLocation.getLocation().getyIndis() - agent.getLastLocation().getLocation().getyIndis());

      if (tempDistance > tempX + tempY) {
        tempDistance = tempX + tempY;
        tempI = i;
      }
      i++;
    }
    return new NearestFood(BoardFeatures.GREENFOOD.get(tempI), tempDistance);
  }

  public boolean isThereAnyRed(NearestFood nearestFood){

    for (StepAndLocation stepAndLocationRed: BoardFeatures.REDFOOD){
        if (stepAndLocationRed.getLocation().getxIndis()==agent.getLastLocation().getLocation().getxIndis()){
          if (agent.getLastLocation().getLocation().getyIndis()<stepAndLocationRed.getLocation().getyIndis() &&
              stepAndLocationRed.getLocation().getyIndis() <
          nearestFood.getLocation().getyIndis()
          ){
            return true;
          }

        }
        if (stepAndLocationRed.getLocation().getyIndis()==agent.getLastLocation().getLocation().getyIndis()){
          if (agent.getLastLocation().getLocation().getxIndis()<stepAndLocationRed.getLocation().getxIndis()&&
          stepAndLocationRed.getLocation().getxIndis()<nearestFood.getLocation().getxIndis()
          ){
            return true;
          }

        }
      }
  return false;
  }
}