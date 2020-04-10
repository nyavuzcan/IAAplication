package com.company;

import com.company.datastructure.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Agents {
  private Integer agentCode;
  private Integer[][] ateFoods;
  private Integer lastScore=0;
  public Integer step;
 public Integer totalGreen=0;
 public Integer totalRed=0;
 public Integer totalFree=0;
  public Transactions transactions;
  public List<StepAndLocation> locations=new ArrayList<>();
  public StepAndLocation lastLocationEntity;
  public List<EatValueAndLocation> eatValueAndLocations = new ArrayList<>();
  public AgentAndNearestFood agentAndNearestFood;
  public Agents(Integer agentCode) {
    this.agentCode = agentCode;
    this.step=1;
    transactions=new Transactions(this);
  }

  public void addEatValueAndLocation(EatValueAndLocation eatValueAndLocation){
    this.eatValueAndLocations.add(eatValueAndLocation);
    lastScore+=eatValueAndLocation.getGreenOrRed();
    if (eatValueAndLocation.getGreenOrRed()== Color.GREEN.getValue()){
      totalGreen++;
    }else if (eatValueAndLocation.getGreenOrRed()==Color.RED.getValue()){
      totalRed++;
    }
    else {
      totalFree++;
    }
  }

  public Integer getAgentCode() {
    return agentCode;
  }

  public void setAgentCode(Integer agentCode) {
    this.agentCode = agentCode;
  }


  public Integer[][] getAteFoods() {
    return ateFoods;
  }

  public void setAteFoods(Integer[][] ateFoods) {
    this.ateFoods = ateFoods;
  }

  public Integer getLastScore() {
    return lastScore;
  }

  public void setLastScore(Integer lastScore) {
    this.lastScore = lastScore;
  }

  public StepAndLocation getLastLocation(){
    this.lastLocationEntity=this.locations.get(locations.size()-1);
    return this.locations.get(locations.size()-1);
  }

  public StepAndLocation getPenultimateLocation(){
    return this.locations.get(locations.size()-2);
  }

  public AgentAndNearestFood getAgentAndNearestFood() {
    return agentAndNearestFood;
  }

  public void setAgentAndNearestFood(AgentAndNearestFood agentAndNearestFood) {
    this.lastScore+=agentAndNearestFood.getNearestFood().getRedOrGreen();
    this.agentAndNearestFood = agentAndNearestFood;
  }
}
