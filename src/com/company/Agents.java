package com.company;

import com.company.datastructure.AgentAndNearestFood;
import com.company.datastructure.EatValueAndLocation;
import com.company.datastructure.Location;
import com.company.datastructure.StepAndLocation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Agents {
  private Integer agentCode;
  private Integer[][] ateFoods;
  private Integer lastScore;
  public Integer step;
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
